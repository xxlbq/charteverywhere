/* RelativeDateFormatDemo1 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */
package demo;

import java.awt.Color;
import java.awt.Dimension;
import java.text.DecimalFormat;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.util.RelativeDateFormat;
import org.jfree.data.time.Minute;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RectangleInsets;
import org.jfree.ui.RefineryUtilities;

public class RelativeDateFormatDemo1 extends ApplicationFrame {
	/* synthetic */static Class class$org$jfree$data$time$Second;

	public RelativeDateFormatDemo1(String string) {
		super(string);
		JPanel jpanel = createDemoPanel();
		jpanel.setPreferredSize(new Dimension(500, 270));
		setContentPane(jpanel);
	}

	private static JFreeChart createChart(XYDataset xydataset) {
		JFreeChart jfreechart = ChartFactory.createTimeSeriesChart(
				"Exercise Chart", "Elapsed Time", "Beats Per Minute",
				xydataset, true, true, false);
		jfreechart.setBackgroundPaint(Color.white);
		XYPlot xyplot = (XYPlot) jfreechart.getPlot();
		xyplot.setBackgroundPaint(Color.lightGray);
		xyplot.setDomainGridlinePaint(Color.white);
		xyplot.setRangeGridlinePaint(Color.white);
		xyplot.setAxisOffset(new RectangleInsets(5.0, 5.0, 5.0, 5.0));
		xyplot.setDomainCrosshairVisible(true);
		xyplot.setRangeCrosshairVisible(true);
		org.jfree.chart.renderer.xy.XYItemRenderer xyitemrenderer = xyplot
				.getRenderer();
		if (xyitemrenderer instanceof XYLineAndShapeRenderer) {
			XYLineAndShapeRenderer xylineandshaperenderer = (XYLineAndShapeRenderer) xyitemrenderer;
			xylineandshaperenderer.setBaseShapesVisible(true);
			xylineandshaperenderer.setBaseShapesFilled(true);
		}
		DateAxis dateaxis = (DateAxis) xyplot.getDomainAxis();
		Minute minute = new Minute(0, 9, 1, 10, 2006);
		RelativeDateFormat relativedateformat = new RelativeDateFormat(minute
				.getFirstMillisecond());
		relativedateformat.setSecondFormatter(new DecimalFormat("00"));
		dateaxis.setDateFormatOverride(relativedateformat);
		return jfreechart;
	}

	private static XYDataset createDataset() {
		TimeSeries timeseries = new TimeSeries(
				"Heart Rate",
				(class$org$jfree$data$time$Second == null ? (class$org$jfree$data$time$Second = class$("org.jfree.data.time.Second"))
						: class$org$jfree$data$time$Second));
		timeseries.add(new org.jfree.data.time.Second(45, 6, 9, 1, 10, 2006),
				143.0);
		timeseries.add(new org.jfree.data.time.Second(33, 8, 9, 1, 10, 2006),
				167.0);
		timeseries.add(new org.jfree.data.time.Second(10, 10, 9, 1, 10, 2006),
				189.0);
		timeseries.add(new org.jfree.data.time.Second(19, 12, 9, 1, 10, 2006),
				156.0);
		timeseries.add(new org.jfree.data.time.Second(5, 15, 9, 1, 10, 2006),
				176.0);
		timeseries.add(new org.jfree.data.time.Second(12, 16, 9, 1, 10, 2006),
				183.0);
		timeseries.add(new org.jfree.data.time.Second(6, 18, 9, 1, 10, 2006),
				138.0);
		timeseries.add(new org.jfree.data.time.Second(11, 20, 9, 1, 10, 2006),
				102.0);
		TimeSeriesCollection timeseriescollection = new TimeSeriesCollection();
		timeseriescollection.addSeries(timeseries);
		return timeseriescollection;
	}

	public static JPanel createDemoPanel() {
		JFreeChart jfreechart = createChart(createDataset());
		return new ChartPanel(jfreechart);
	}

	public static void main(String[] strings) {
		RelativeDateFormatDemo1 relativedateformatdemo1 = (new RelativeDateFormatDemo1(
				"JFreeChart - RelativeDateFormatDemo1"));
		relativedateformatdemo1.pack();
		RefineryUtilities.centerFrameOnScreen(relativedateformatdemo1);
		relativedateformatdemo1.setVisible(true);
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
