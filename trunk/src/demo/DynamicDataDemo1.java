/* DynamicDataDemo1 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */
package demo;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.time.Millisecond;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class DynamicDataDemo1 extends ApplicationFrame
{
    /*synthetic*/ static Class class$org$jfree$data$time$Millisecond;
    
    static class DemoPanel extends JPanel implements ActionListener
    {
	private TimeSeries series;
	private double lastValue = 100.0;
	
	public DemoPanel() {
	    super(new BorderLayout());
	    series
		= (new TimeSeries
		   ("Random Data",
		    ((DynamicDataDemo1.class$org$jfree$data$time$Millisecond
		      == null)
		     ? (DynamicDataDemo1.class$org$jfree$data$time$Millisecond
			= class$("org.jfree.data.time.Millisecond"))
		     : (DynamicDataDemo1
			.class$org$jfree$data$time$Millisecond))));
	    TimeSeriesCollection timeseriescollection
		= new TimeSeriesCollection(series);
	    ChartPanel chartpanel
		= new ChartPanel(createChart(timeseriescollection));
	    chartpanel.setPreferredSize(new Dimension(500, 270));
	    JPanel jpanel = new JPanel();
	    jpanel.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
	    JButton jbutton = new JButton("Add New Data Item");
	    jbutton.setActionCommand("ADD_DATA");
	    jbutton.addActionListener(this);
	    jpanel.add(jbutton);
	    add(chartpanel);
	    add(jpanel, "South");
	}
	
	private JFreeChart createChart(XYDataset xydataset) {
	    JFreeChart jfreechart
		= ChartFactory.createTimeSeriesChart("Dynamic Data Demo",
						     "Time", "Value",
						     xydataset, true, true,
						     false);
	    XYPlot xyplot = (XYPlot) jfreechart.getPlot();
	    ValueAxis valueaxis = xyplot.getDomainAxis();
	    valueaxis.setAutoRange(true);
	    valueaxis.setFixedAutoRange(60000.0);
	    valueaxis = xyplot.getRangeAxis();
	    valueaxis.setRange(0.0, 200.0);
	    return jfreechart;
	}
	
	public void actionPerformed(ActionEvent actionevent) {
	    if (actionevent.getActionCommand().equals("ADD_DATA")) {
		double d = 0.9 + 0.2 * Math.random();
		lastValue = lastValue * d;
		Millisecond millisecond = new Millisecond();
		System.out.println("Now = " + millisecond.toString());
		series.add(new Millisecond(), lastValue);
	    }
	}
    }
    
    public DynamicDataDemo1(String string) {
	super(string);
	DemoPanel demopanel = new DemoPanel();
	setContentPane(demopanel);
    }
    
    public static JPanel createDemoPanel() {
	return new DemoPanel();
    }
    
    public static void main(String[] strings) {
	DynamicDataDemo1 dynamicdatademo1
	    = new DynamicDataDemo1("Dynamic Data Demo");
	dynamicdatademo1.pack();
	RefineryUtilities.centerFrameOnScreen(dynamicdatademo1);
	dynamicdatademo1.setVisible(true);
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
