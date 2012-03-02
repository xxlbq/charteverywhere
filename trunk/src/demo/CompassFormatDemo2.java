/* CompassFormatDemo2 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */
package demo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CompassFormat;
import org.jfree.chart.axis.ModuloAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.axis.TickUnits;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYAreaRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.Range;
import org.jfree.data.time.Minute;
import org.jfree.data.time.RegularTimePeriod;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class CompassFormatDemo2 extends ApplicationFrame {
	/* synthetic */static Class class$org$jfree$data$time$Minute;

	private static class DemoPanel extends JPanel implements ChangeListener {
		private JSlider directionSlider;
		private JSlider fieldSlider;
		private ModuloAxis rangeAxis;
		private double direction = 0.0;
		private double degrees = 45.0;

		public DemoPanel() {
			super(new BorderLayout());
			JPanel jpanel = new JPanel(new GridLayout(1, 2));
			fieldSlider = new JSlider(1, 10, 180, 45);
			fieldSlider.setPaintLabels(true);
			fieldSlider.setPaintTicks(true);
			fieldSlider.setMajorTickSpacing(10);
			fieldSlider.setMinorTickSpacing(5);
			fieldSlider.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
			fieldSlider.addChangeListener(this);
			directionSlider = new JSlider(1, 0, 360, 0);
			directionSlider.setMajorTickSpacing(30);
			directionSlider.setMinorTickSpacing(5);
			directionSlider.setPaintLabels(true);
			directionSlider.setPaintTicks(true);
			directionSlider.setBorder(BorderFactory.createEmptyBorder(5, 5, 5,
					5));
			directionSlider.setPaintTrack(true);
			directionSlider.addChangeListener(this);
			jpanel.add(fieldSlider);
			jpanel.add(directionSlider);
			JFreeChart jfreechart = createChart();
			ChartPanel chartpanel = new ChartPanel(jfreechart);
			chartpanel.setPreferredSize(new Dimension(500, 270));
			add(jpanel, "West");
			add(chartpanel);
		}

		private XYDataset createDirectionDataset(int i) {
			TimeSeriesCollection timeseriescollection = new TimeSeriesCollection();
			TimeSeries timeseries = (new TimeSeries(
					"Wind Direction",
					((CompassFormatDemo2.class$org$jfree$data$time$Minute == null) ? (CompassFormatDemo2.class$org$jfree$data$time$Minute = class$("org.jfree.data.time.Minute"))
							: CompassFormatDemo2.class$org$jfree$data$time$Minute)));
			RegularTimePeriod regulartimeperiod = new Minute();
			double d = 0.0;
			for (int i_0_ = 0; i_0_ < i; i_0_++) {
				timeseries.add(regulartimeperiod, d);
				regulartimeperiod = regulartimeperiod.next();
				d += (Math.random() - 0.5) * 15.0;
				if (d < 0.0)
					d += 360.0;
				else if (d > 360.0)
					d -= 360.0;
			}
			timeseriescollection.addSeries(timeseries);
			return timeseriescollection;
		}

		private XYDataset createForceDataset(int i) {
			TimeSeriesCollection timeseriescollection = new TimeSeriesCollection();
			TimeSeries timeseries = (new TimeSeries(
					"Wind Force",
					((CompassFormatDemo2.class$org$jfree$data$time$Minute == null) ? (CompassFormatDemo2.class$org$jfree$data$time$Minute = class$("org.jfree.data.time.Minute"))
							: CompassFormatDemo2.class$org$jfree$data$time$Minute)));
			RegularTimePeriod regulartimeperiod = new Minute();
			double d = 3.0;
			for (int i_1_ = 0; i_1_ < i; i_1_++) {
				timeseries.add(regulartimeperiod, d);
				regulartimeperiod = regulartimeperiod.next();
				d = Math.max(0.5, d + (Math.random() - 0.5) * 0.5);
			}
			timeseriescollection.addSeries(timeseries);
			return timeseriescollection;
		}

		private JFreeChart createChart() {
			XYDataset xydataset = createDirectionDataset(100);
			JFreeChart jfreechart = ChartFactory.createTimeSeriesChart("Time",
					"Date", "Direction", xydataset, true, true, false);
			XYPlot xyplot = (XYPlot) jfreechart.getPlot();
			xyplot.getDomainAxis().setLowerMargin(0.0);
			xyplot.getDomainAxis().setUpperMargin(0.0);
			rangeAxis = new ModuloAxis("Direction", new Range(0.0, 360.0));
			TickUnits tickunits = new TickUnits();
			tickunits.add(new NumberTickUnit(180.0, new CompassFormat()));
			tickunits.add(new NumberTickUnit(90.0, new CompassFormat()));
			tickunits.add(new NumberTickUnit(45.0, new CompassFormat()));
			tickunits.add(new NumberTickUnit(22.5, new CompassFormat()));
			rangeAxis.setStandardTickUnits(tickunits);
			XYLineAndShapeRenderer xylineandshaperenderer = new XYLineAndShapeRenderer();
			xylineandshaperenderer.setBaseLinesVisible(false);
			xylineandshaperenderer.setBaseShapesVisible(true);
			xyplot.setRenderer(xylineandshaperenderer);
			xyplot.setRangeAxis(rangeAxis);
			rangeAxis.setDisplayRange(-45.0, 45.0);
			XYAreaRenderer xyarearenderer = new XYAreaRenderer();
			NumberAxis numberaxis = new NumberAxis("Force");
			numberaxis.setRange(0.0, 12.0);
			xyarearenderer.setSeriesPaint(0, new Color(0, 0, 255, 128));
			xyplot.setDataset(1, createForceDataset(100));
			xyplot.setRenderer(1, xyarearenderer);
			xyplot.setRangeAxis(1, numberaxis);
			xyplot.mapDatasetToRangeAxis(1, 1);
			return jfreechart;
		}

		public void stateChanged(ChangeEvent changeevent) {
			if (changeevent.getSource() == directionSlider) {
				direction = (double) directionSlider.getValue();
				rangeAxis.setDisplayRange(direction - degrees, direction
						+ degrees);
			} else if (changeevent.getSource() == fieldSlider) {
				degrees = (double) fieldSlider.getValue();
				rangeAxis.setDisplayRange(direction - degrees, direction
						+ degrees);
			}
		}
	}

	public CompassFormatDemo2(String string) {
		super(string);
		setContentPane(new DemoPanel());
	}

	public static JPanel createDemoPanel() {
		return new DemoPanel();
	}

	public static void main(String[] strings) {
		CompassFormatDemo2 compassformatdemo2 = new CompassFormatDemo2(
				"Compass Format Demo 2");
		compassformatdemo2.pack();
		RefineryUtilities.centerFrameOnScreen(compassformatdemo2);
		compassformatdemo2.setVisible(true);
	}

	/* synthetic */static Class class$(String string) {
		Class var_class;
		try {
			var_class = Class.forName(string);
		} catch (ClassNotFoundException classnotfoundexception) {
			throw new NoClassDefFoundError(classnotfoundexception.getMessage());
		}
		return var_class;
	}
}
