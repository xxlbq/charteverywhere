// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package demo;

import java.awt.Dimension;
import javax.swing.JPanel;
import org.jfree.chart.*;
import org.jfree.chart.axis.LogAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.util.LogFormat;
import org.jfree.data.xy.*;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class LogAxisDemo1 extends ApplicationFrame
{

    public LogAxisDemo1(String s)
    {
        super(s);
        JPanel jpanel = createDemoPanel();
        jpanel.setPreferredSize(new Dimension(500, 270));
        setContentPane(jpanel);
    }

    private static JFreeChart createChart(XYDataset xydataset)
    {
        JFreeChart jfreechart = ChartFactory.createScatterPlot("Log Axis Demo 1", "X", "Y", xydataset, PlotOrientation.VERTICAL, true, true, false);
        XYPlot xyplot = (XYPlot)jfreechart.getPlot();
        LogAxis logaxis = new LogAxis("X");
        logaxis.setNumberFormatOverride(new LogFormat(10D, "10", true));
        LogAxis logaxis1 = new LogAxis("Y");
        logaxis1.setNumberFormatOverride(new LogFormat(10D, "10", true));
        xyplot.setDomainAxis(logaxis);
        xyplot.setRangeAxis(logaxis1);
        return jfreechart;
    }

    private static XYDataset createDataset()
    {
        XYSeries xyseries = new XYSeries("Random Data");
        xyseries.add(1.0D, 500.19999999999999D);
        xyseries.add(5D, 694.10000000000002D);
        xyseries.add(4D, 100D);
        xyseries.add(12.5D, 734.39999999999998D);
        xyseries.add(17.300000000000001D, 453.19999999999999D);
        xyseries.add(21.199999999999999D, 500.19999999999999D);
        xyseries.add(21.899999999999999D, 9005.5D);
        xyseries.add(25.600000000000001D, 734.39999999999998D);
        xyseries.add(6663000D, 6453.1999999999998D);
        return new XYSeriesCollection(xyseries);
    }

    public static JPanel createDemoPanel()
    {
        JFreeChart jfreechart = createChart(createDataset());
        return new ChartPanel(jfreechart);
    }

    public static void main(String args[])
    {
        LogAxisDemo1 logaxisdemo1 = new LogAxisDemo1("Log Axis Demo 1");
        logaxisdemo1.pack();
        RefineryUtilities.centerFrameOnScreen(logaxisdemo1);
        logaxisdemo1.setVisible(true);
    }
}
