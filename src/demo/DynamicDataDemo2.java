/* DynamicDataDemo2 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */
package demo;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.DefaultXYItemRenderer;
import org.jfree.data.time.Millisecond;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RectangleInsets;
import org.jfree.ui.RefineryUtilities;

public class DynamicDataDemo2 extends ApplicationFrame
{
    /*synthetic*/ static Class class$org$jfree$data$time$Millisecond;
    
    static class DemoPanel extends JPanel implements ActionListener
    {
	private TimeSeries series1;
	private TimeSeries series2;
	private double lastValue1 = 100.0;
	private double lastValue2 = 500.0;
	
	public DemoPanel() {
	    super(new BorderLayout());
	    series1
		= (new TimeSeries
		   ("Random 1",
		    ((DynamicDataDemo2.class$org$jfree$data$time$Millisecond
		      == null)
		     ? (DynamicDataDemo2.class$org$jfree$data$time$Millisecond
			= class$("org.jfree.data.time.Millisecond"))
		     : (DynamicDataDemo2
			.class$org$jfree$data$time$Millisecond))));
	    series2
		= (new TimeSeries
		   ("Random 2",
		    ((DynamicDataDemo2.class$org$jfree$data$time$Millisecond
		      == null)
		     ? (DynamicDataDemo2.class$org$jfree$data$time$Millisecond
			= class$("org.jfree.data.time.Millisecond"))
		     : (DynamicDataDemo2
			.class$org$jfree$data$time$Millisecond))));
	    TimeSeriesCollection timeseriescollection
		= new TimeSeriesCollection(series1);
	    TimeSeriesCollection timeseriescollection_0_
		= new TimeSeriesCollection(series2);
	    JFreeChart jfreechart
		= ChartFactory.createTimeSeriesChart("Dynamic Data Demo 2",
						     "Time", "Value",
						     timeseriescollection,
						     true, true, false);
	    jfreechart.setBackgroundPaint(Color.white);
	    XYPlot xyplot = (XYPlot) jfreechart.getPlot();
	    xyplot.setBackgroundPaint(Color.lightGray);
	    xyplot.setDomainGridlinePaint(Color.white);
	    xyplot.setRangeGridlinePaint(Color.white);
	    xyplot.setAxisOffset(new RectangleInsets(4.0, 4.0, 4.0, 4.0));
	    ValueAxis valueaxis = xyplot.getDomainAxis();
	    valueaxis.setAutoRange(true);
	    valueaxis.setFixedAutoRange(10000.0);
	    xyplot.setDataset(1, timeseriescollection_0_);
	    NumberAxis numberaxis = new NumberAxis("Range Axis 2");
	    numberaxis.setAutoRangeIncludesZero(false);
	    xyplot.setRenderer(1, new DefaultXYItemRenderer());
	    xyplot.setRangeAxis(1, numberaxis);
	    xyplot.mapDatasetToRangeAxis(1, 1);
	    ChartPanel chartpanel = new ChartPanel(jfreechart);
	    add(chartpanel);
	    JButton jbutton = new JButton("Add To Series 1");
	    jbutton.setActionCommand("ADD_DATA_1");
	    jbutton.addActionListener(this);
	    JButton jbutton_1_ = new JButton("Add To Series 2");
	    jbutton_1_.setActionCommand("ADD_DATA_2");
	    jbutton_1_.addActionListener(this);
	    JButton jbutton_2_ = new JButton("Add To Both");
	    jbutton_2_.setActionCommand("ADD_BOTH");
	    jbutton_2_.addActionListener(this);
	    JPanel jpanel = new JPanel(new FlowLayout());
	    jpanel.setBackground(Color.white);
	    jpanel.add(jbutton);
	    jpanel.add(jbutton_1_);
	    jpanel.add(jbutton_2_);
	    add(jpanel, "South");
	    chartpanel.setPreferredSize(new Dimension(500, 270));
	}
	
	public void actionPerformed(ActionEvent actionevent) {
	    boolean bool = false;
	    boolean bool_3_ = false;
	    if (actionevent.getActionCommand().equals("ADD_DATA_1"))
		bool = true;
	    else if (actionevent.getActionCommand().equals("ADD_DATA_2"))
		bool_3_ = true;
	    else if (actionevent.getActionCommand().equals("ADD_BOTH")) {
		bool = true;
		bool_3_ = true;
	    }
	    if (bool) {
		double d = 0.9 + 0.2 * Math.random();
		lastValue1 = lastValue1 * d;
		Millisecond millisecond = new Millisecond();
		System.out.println("Now = " + millisecond.toString());
		series1.add(new Millisecond(), lastValue1);
	    }
	    if (bool_3_) {
		double d = 0.9 + 0.2 * Math.random();
		lastValue2 = lastValue2 * d;
		Millisecond millisecond = new Millisecond();
		System.out.println("Now = " + millisecond.toString());
		series2.add(new Millisecond(), lastValue2);
	    }
	}
    }
    
    public DynamicDataDemo2(String string) {
	super(string);
	setContentPane(new DemoPanel());
    }
    
    public static JPanel createDemoPanel() {
	return new DemoPanel();
    }
    
    public static void main(String[] strings) {
	DynamicDataDemo2 dynamicdatademo2
	    = new DynamicDataDemo2("JFreeChart: DynamicDataDemo2.java");
	dynamicdatademo2.pack();
	RefineryUtilities.centerFrameOnScreen(dynamicdatademo2);
	dynamicdatademo2.setVisible(true);
    }
    
    /*synthetic*/ static Class class$(String string) {
	Class var_class;
	try {
	    var_class = Class.forName(string);
	} catch (ClassNotFoundException classnotfoundexception) {
	    throw new NoClassDefFoundError(classnotfoundexception
					       .getMessage());
	}
	return var_class;
    }
}
