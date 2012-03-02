/* DynamicDataDemo3 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */
package demo;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CombinedDomainXYPlot;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.StandardXYItemRenderer;
import org.jfree.chart.title.LegendTitle;
import org.jfree.data.time.Millisecond;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RectangleEdge;
import org.jfree.ui.RectangleInsets;
import org.jfree.ui.RefineryUtilities;
import org.jfree.util.UnitType;

public class DynamicDataDemo3 extends ApplicationFrame
{
    /*synthetic*/ static Class class$org$jfree$data$time$Millisecond;
    
    static class DemoPanel extends JPanel implements ActionListener
    {
	public static final int SUBPLOT_COUNT = 3;
	private TimeSeriesCollection[] datasets;
	private double[] lastValue = new double[3];
	
	public DemoPanel() {
	    super(new BorderLayout());
	    CombinedDomainXYPlot combineddomainxyplot
		= new CombinedDomainXYPlot(new DateAxis("Time"));
	    datasets = new TimeSeriesCollection[3];
	    for (int i = 0; i < 3; i++) {
		lastValue[i] = 100.0;
		TimeSeries timeseries
		    = (new TimeSeries
		       ("Random " + i,
			((DynamicDataDemo3
			  .class$org$jfree$data$time$Millisecond) == null
			 ? (DynamicDataDemo3
				.class$org$jfree$data$time$Millisecond
			    = class$("org.jfree.data.time.Millisecond"))
			 : (DynamicDataDemo3
			    .class$org$jfree$data$time$Millisecond))));
		datasets[i] = new TimeSeriesCollection(timeseries);
		NumberAxis numberaxis = new NumberAxis("Y" + i);
		numberaxis.setAutoRangeIncludesZero(false);
		XYPlot xyplot = new XYPlot(datasets[i], null, numberaxis,
					   new StandardXYItemRenderer());
		xyplot.setBackgroundPaint(Color.lightGray);
		xyplot.setDomainGridlinePaint(Color.white);
		xyplot.setRangeGridlinePaint(Color.white);
		combineddomainxyplot.add(xyplot);
	    }
	    JFreeChart jfreechart
		= new JFreeChart("Dynamic Data Demo 3", combineddomainxyplot);
	    LegendTitle legendtitle = (LegendTitle) jfreechart.getSubtitle(0);
	    legendtitle.setPosition(RectangleEdge.RIGHT);
	    legendtitle.setMargin(new RectangleInsets(UnitType.ABSOLUTE, 0.0,
						      4.0, 0.0, 4.0));
	    jfreechart.setBorderPaint(Color.black);
	    jfreechart.setBorderVisible(true);
	    jfreechart.setBackgroundPaint(Color.white);
	    combineddomainxyplot.setBackgroundPaint(Color.lightGray);
	    combineddomainxyplot.setDomainGridlinePaint(Color.white);
	    combineddomainxyplot.setRangeGridlinePaint(Color.white);
	    combineddomainxyplot.setAxisOffset(new RectangleInsets(4.0, 4.0,
								   4.0, 4.0));
	    ValueAxis valueaxis = combineddomainxyplot.getDomainAxis();
	    valueaxis.setAutoRange(true);
	    valueaxis.setFixedAutoRange(60000.0);
	    ChartPanel chartpanel = new ChartPanel(jfreechart);
	    add(chartpanel);
	    JPanel jpanel = new JPanel(new FlowLayout());
	    for (int i = 0; i < 3; i++) {
		JButton jbutton = new JButton("Series " + i);
		jbutton.setActionCommand("ADD_DATA_" + i);
		jbutton.addActionListener(this);
		jpanel.add(jbutton);
	    }
	    JButton jbutton = new JButton("ALL");
	    jbutton.setActionCommand("ADD_ALL");
	    jbutton.addActionListener(this);
	    jpanel.add(jbutton);
	    add(jpanel, "South");
	    chartpanel.setPreferredSize(new Dimension(500, 470));
	    chartpanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
	}
	
	public void actionPerformed(ActionEvent actionevent) {
	    for (int i = 0; i < 3; i++) {
		if (actionevent.getActionCommand()
			.endsWith(String.valueOf(i))) {
		    Millisecond millisecond = new Millisecond();
		    System.out.println("Now = " + millisecond.toString());
		    lastValue[i] = lastValue[i] * (0.9 + 0.2 * Math.random());
		    datasets[i].getSeries(0).add(new Millisecond(),
						 lastValue[i]);
		}
	    }
	    if (actionevent.getActionCommand().equals("ADD_ALL")) {
		Millisecond millisecond = new Millisecond();
		System.out.println("Now = " + millisecond.toString());
		for (int i = 0; i < 3; i++) {
		    lastValue[i] = lastValue[i] * (0.9 + 0.2 * Math.random());
		    datasets[i].getSeries(0).add(new Millisecond(),
						 lastValue[i]);
		}
	    }
	}
    }
    
    public DynamicDataDemo3(String string) {
	super(string);
	setContentPane(new DemoPanel());
    }
    
    public static JPanel createDemoPanel() {
	return new DemoPanel();
    }
    
    public static void main(String[] strings) {
	DynamicDataDemo3 dynamicdatademo3
	    = new DynamicDataDemo3("Dynamic Data Demo 3");
	dynamicdatademo3.pack();
	RefineryUtilities.centerFrameOnScreen(dynamicdatademo3);
	dynamicdatademo3.setVisible(true);
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
