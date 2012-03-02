// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package demo;

import java.awt.Dimension;
import java.io.IOException;
import java.util.Random;
import javax.swing.JPanel;
import org.jfree.chart.*;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYBarRenderer;
import org.jfree.data.statistics.HistogramDataset;
import org.jfree.data.xy.IntervalXYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class HistogramDemo1 extends ApplicationFrame
{

    public HistogramDemo1(String s)
    {
        super(s);
        JPanel jpanel = createDemoPanel();
        jpanel.setPreferredSize(new Dimension(500, 270));
        setContentPane(jpanel);
    }

    private static IntervalXYDataset createDataset()
    {
        HistogramDataset histogramdataset = new HistogramDataset();
        double ad[] = new double[1000];
        Random random = new Random(0xbc614eL);
        for(int i = 0; i < 1000; i++)
            ad[i] = random.nextGaussian() + 5D;

        histogramdataset.addSeries("H1", ad, 100, 2D, 8D);
        ad = new double[1000];
        for(int j = 0; j < 1000; j++)
            ad[j] = random.nextGaussian() + 7D;

        histogramdataset.addSeries("H2", ad, 100, 4D, 10D);
        return histogramdataset;
    }

    private static JFreeChart createChart(IntervalXYDataset intervalxydataset)
    {
        JFreeChart jfreechart = ChartFactory.createHistogram("Histogram Demo 1", null, null, intervalxydataset, PlotOrientation.VERTICAL, true, true, false);
        XYPlot xyplot = (XYPlot)jfreechart.getPlot();
        xyplot.setForegroundAlpha(0.85F);
        XYBarRenderer xybarrenderer = (XYBarRenderer)xyplot.getRenderer();
        xybarrenderer.setDrawBarOutline(false);
        return jfreechart;
    }

    public static JPanel createDemoPanel()
    {
        JFreeChart jfreechart = createChart(createDataset());
        return new ChartPanel(jfreechart);
    }

    public static void main(String args[])
        throws IOException
    {
        HistogramDemo1 histogramdemo1 = new HistogramDemo1("JFreeChart : HistogramDemo1");
        histogramdemo1.pack();
        RefineryUtilities.centerFrameOnScreen(histogramdemo1);
        histogramdemo1.setVisible(true);
    }
}
