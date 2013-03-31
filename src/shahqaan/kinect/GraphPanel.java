package shahqaan.kinect;

/**
 * Created with IntelliJ IDEA.
 * User: Shahqaan Qasim
 * Date: 3/30/13
 * Time: 10:01 PM
 * To change this template use File | Settings | File Templates.
 */
import java.awt.*;
import javax.swing.*;

import org.jfree.chart.*;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.CombinedDomainCategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class GraphPanel extends JPanel {
    private Font msgFont;
    private ExtendedSkeletons skels;   // the users' skeletons

    public GraphPanel(ExtendedSkeletons skeleton){
        // Set JPanel properties
        setBackground(Color.BLACK);
        // Set border color
        setBorder(BorderFactory.createLineBorder(Color.GREEN));

        // Configure variables
        this.skels = skeleton;

        msgFont = new Font("SansSerif", Font.BOLD, 24);


        /*
        // creating chart
        DefaultCategoryDataset ds = new DefaultCategoryDataset();
        ds.addValue(100, "A", "A");
        ds.addValue(200, "A", "B");
        ds.addValue(400, "A", "C");
        ds.addValue(500, "A", "D");
        ds.addValue(2000, "A", "E");


        JFreeChart bc = ChartFactory.createBarChart("My Bar Chart", "Things", "Counts",  ds, PlotOrientation.VERTICAL, true, false, false);

        CategoryPlot mainPlot = bc.getCategoryPlot();

        NumberAxis mainAxis = (NumberAxis) mainPlot.getRangeAxis();
        mainAxis.setLowerBound(0);
        mainAxis.setUpperBound(600);
        JFreeChart combinedChart = new JFreeChart("Test", mainPlot);
        combinedChart.setAntiAlias(true);

        StandardChartTheme.createDarknessTheme().apply(combinedChart);
        ChartPanel cp = new ChartPanel(combinedChart);
        this.add(cp);     */
    }

    /*
    @Override
    public Dimension getPreferredSize() {
        // return new Dimension(skels.getXRes(), skels.getYRes());
    }*/

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setFont(msgFont);
        g2d.setColor(Color.RED);
        g2d.drawString("Graph Panel", 50, 200);
    }
}
