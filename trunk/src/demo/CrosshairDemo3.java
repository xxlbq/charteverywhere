/* CrosshairDemo3 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */
package demo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.text.SimpleDateFormat;

import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.Range;
import org.jfree.data.time.Month;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RectangleInsets;
import org.jfree.ui.RefineryUtilities;

public class CrosshairDemo3 extends ApplicationFrame {
	/* synthetic */static Class class$org$jfree$data$time$Month;

	static class DemoPanel extends JPanel implements ChangeListener {
		private JFreeChart chart;
		private JSlider slider;

		public DemoPanel() {
			super(new BorderLayout());
			XYDataset xydataset = createDataset();
			chart = createChart(xydataset);
			ChartPanel chartpanel = new ChartPanel(chart);
			chartpanel.setPreferredSize(new Dimension(500, 270));
			chartpanel.setMouseZoomable(true, false);
			JPanel jpanel = new JPanel(new BorderLayout());
			slider = new JSlider(0, 100, 50);
			slider.addChangeListener(this);
			jpanel.add(slider);
			add(chartpanel);
			add(jpanel, "South");
		}

		private JFreeChart createChart(XYDataset xydataset) {
			JFreeChart jfreechart = (ChartFactory.createTimeSeriesChart(
					"Legal & General Unit Trust Prices", "Date",
					"Price Per Unit", xydataset, true, true, false));
			jfreechart.setBackgroundPaint(Color.white);
			XYPlot xyplot = (XYPlot) jfreechart.getPlot();
			xyplot.setBackgroundPaint(Color.lightGray);
			xyplot.setDomainGridlinePaint(Color.white);
			xyplot.setRangeGridlinePaint(Color.white);
			xyplot.setAxisOffset(new RectangleInsets(5.0, 5.0, 5.0, 5.0));
			xyplot.setDomainCrosshairVisible(true);
			xyplot.setDomainCrosshairLockedOnData(false);
			xyplot.setRangeCrosshairVisible(true);
			xyplot.setRangeCrosshairLockedOnData(true);
			org.jfree.chart.renderer.xy.XYItemRenderer xyitemrenderer = xyplot
					.getRenderer();
			if (xyitemrenderer instanceof XYLineAndShapeRenderer) {
				XYLineAndShapeRenderer xylineandshaperenderer = (XYLineAndShapeRenderer) xyitemrenderer;
				xylineandshaperenderer.setBaseShapesVisible(true);
				xylineandshaperenderer.setBaseShapesFilled(true);
			}
			DateAxis dateaxis = (DateAxis) xyplot.getDomainAxis();
			dateaxis.setDateFormatOverride(new SimpleDateFormat("MMM-yyyy"));
			return jfreechart;
		}

		private XYDataset createDataset() {
			TimeSeries timeseries = (new TimeSeries(
					"L&G European Index Trust",
					(CrosshairDemo3.class$org$jfree$data$time$Month == null ? (CrosshairDemo3.class$org$jfree$data$time$Month = class$("org.jfree.data.time.Month"))
							: CrosshairDemo3.class$org$jfree$data$time$Month)));
			timeseries.add(new Month(2, 2001), 181.8);
			timeseries.add(new Month(3, 2001), 167.3);
			timeseries.add(new Month(4, 2001), 153.8);
			timeseries.add(new Month(5, 2001), 167.6);
			timeseries.add(new Month(6, 2001), 158.8);
			timeseries.add(new Month(7, 2001), 148.3);
			timeseries.add(new Month(8, 2001), 153.9);
			timeseries.add(new Month(9, 2001), 142.7);
			timeseries.add(new Month(10, 2001), 123.2);
			timeseries.add(new Month(11, 2001), 131.8);
			timeseries.add(new Month(12, 2001), 139.6);
			timeseries.add(new Month(1, 2002), 142.9);
			timeseries.add(new Month(2, 2002), 138.7);
			timeseries.add(new Month(3, 2002), 137.3);
			timeseries.add(new Month(4, 2002), 143.9);
			timeseries.add(new Month(5, 2002), 139.8);
			timeseries.add(new Month(6, 2002), 137.0);
			timeseries.add(new Month(7, 2002), 132.8);
			TimeSeries timeseries_0_ = (new TimeSeries(
					"L&G UK Index Trust",
					(CrosshairDemo3.class$org$jfree$data$time$Month == null ? (CrosshairDemo3.class$org$jfree$data$time$Month = class$("org.jfree.data.time.Month"))
							: CrosshairDemo3.class$org$jfree$data$time$Month)));
			timeseries_0_.add(new Month(2, 2001), 129.6);
			timeseries_0_.add(new Month(3, 2001), 123.2);
			timeseries_0_.add(new Month(4, 2001), 117.2);
			timeseries_0_.add(new Month(5, 2001), 124.1);
			timeseries_0_.add(new Month(6, 2001), 122.6);
			timeseries_0_.add(new Month(7, 2001), 119.2);
			timeseries_0_.add(new Month(8, 2001), 116.5);
			timeseries_0_.add(new Month(9, 2001), 112.7);
			timeseries_0_.add(new Month(10, 2001), 101.5);
			timeseries_0_.add(new Month(11, 2001), 106.1);
			timeseries_0_.add(new Month(12, 2001), 110.3);
			timeseries_0_.add(new Month(1, 2002), 111.7);
			timeseries_0_.add(new Month(2, 2002), 111.0);
			timeseries_0_.add(new Month(3, 2002), 109.6);
			timeseries_0_.add(new Month(4, 2002), 113.2);
			timeseries_0_.add(new Month(5, 2002), 111.6);
			timeseries_0_.add(new Month(6, 2002), 108.8);
			timeseries_0_.add(new Month(7, 2002), 101.6);
			TimeSeriesCollection timeseriescollection = new TimeSeriesCollection();
			timeseriescollection.addSeries(timeseries);
			timeseriescollection.addSeries(timeseries_0_);
			return timeseriescollection;
		}

		public void stateChanged(ChangeEvent changeevent) {
			int i = slider.getValue();
			XYPlot xyplot = (XYPlot) chart.getPlot();
			ValueAxis valueaxis = xyplot.getDomainAxis();
			Range range = valueaxis.getRange();
			double d = (valueaxis.getLowerBound() + (double) i / 100.0
					* range.getLength());
			xyplot.setDomainCrosshairValue(d);
		}
	}

	public CrosshairDemo3(String string) {
		super(string);
		setContentPane(new DemoPanel());
	}

	public static JPanel createDemoPanel() {
		return new DemoPanel();
	}

	public static void main(String[] strings) {
		CrosshairDemo3 crosshairdemo3 = new CrosshairDemo3("Crosshair Demo 3");
		crosshairdemo3.pack();
		RefineryUtilities.centerFrameOnScreen(crosshairdemo3);
		crosshairdemo3.setVisible(true);
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
