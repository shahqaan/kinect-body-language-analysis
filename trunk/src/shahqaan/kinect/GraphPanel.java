package shahqaan.kinect;

/**
 * Created with IntelliJ IDEA.
 * User: Shahqaan Qasim
 * Date: 3/30/13
 * Time: 10:01 PM
 * To change this template use File | Settings | File Templates.
 */

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.DatasetRenderingOrder;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Line2D;

public class GraphPanel extends JPanel {
    private Font msgFont;
    private ExtendedSkeletons skels;   // the users' skeletons

    private DefaultCategoryDataset defaultcategorydataset = null;
    DefaultCategoryDataset bodyData = new DefaultCategoryDataset();

    public boolean selected = true;

    private AbstractTrackable trackableSkeleton = null;

    public GraphPanel(ExtendedSkeletons skeleton, AbstractTrackable trackableSkeleton){
        // Set JPanel properties
        setBackground(Color.BLACK);
        // Set border color
        setBorder(BorderFactory.createLineBorder(Color.lightGray));

        // Configure variables
        this.skels = skeleton;
        this.trackableSkeleton = trackableSkeleton;

        msgFont = new Font("SansSerif", Font.BOLD, 24);

        this.createDataset(TrackableSkeleton.emotions.getAngry());
        // creating chart
        JFreeChart chart = createChart();
        // StandardChartTheme.createDarknessTheme().apply(chart);
        ChartPanel cp = new ChartPanel(chart);

        this.add(cp);

        // start body graph update thread
        if (this.trackableSkeleton.isTracking()) {
            Thread thread = new Thread(new Runnable(){
                @Override
                public void run() {
                    //To change body of implemented methods use File | Settings | File Templates.
                    while (true) {
                        updateBodyGraph();
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                        }
                    }
                }
            });
            thread.start();
        }

        cp.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //To change body of implemented methods use File | Settings | File Templates.
                if (selected) {
                    setDataset(TrackableSkeleton.emotions.getHappy());
                    selected = false;
                }
                else {
                    setDataset(TrackableSkeleton.emotions.getAngry());
                    selected = true;
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
                //To change body of implemented methods use File | Settings | File Templates.
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                //To change body of implemented methods use File | Settings | File Templates.
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                //To change body of implemented methods use File | Settings | File Templates.
            }

            @Override
            public void mouseExited(MouseEvent e) {
                //To change body of implemented methods use File | Settings | File Templates.
            }
        });

     }
    public JFreeChart createChart() {
        JFreeChart jfreechart = ChartFactory.createStackedAreaChart("Body Language Analysis", "Category", "Value", defaultcategorydataset, PlotOrientation.VERTICAL, true, true, false);
        jfreechart.setBackgroundPaint(Color.BLACK);
        jfreechart.setAntiAlias(true);

        CategoryPlot categoryplot = (CategoryPlot)jfreechart.getPlot();
        categoryplot.setBackgroundPaint(Color.BLACK);
        categoryplot.setForegroundAlpha(1.0F);

        CategoryAxis categoryaxis = categoryplot.getDomainAxis();
        categoryaxis.setLowerMargin(0.0D);
        categoryaxis.setUpperMargin(0.0D);
        categoryaxis.setCategoryMargin(0.0D);
        NumberAxis numberaxis = (NumberAxis)categoryplot.getRangeAxis();
        numberaxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        numberaxis.setLowerBound(-5);
        numberaxis.setUpperBound(30);
        CategoryItemRenderer categoryitemrenderer = categoryplot.getRenderer();
        categoryitemrenderer.setBaseItemLabelsVisible(true);
        categoryitemrenderer.setSeriesPaint(0, new Color(0, 0, 0, 0));
        categoryitemrenderer.setSeriesPaint(1, new Color(255, 245, 253, 46));

        // create another renderer
        LineAndShapeRenderer r = new LineAndShapeRenderer();
        r.setSeriesPaint(0, new Color(159, 4, 16, 255));
        r.setSeriesShape(0, new Line2D.Double(0.0, 0.0, 0.0, 0.0));
        r.setSeriesStroke(0, new BasicStroke(4.0f));

        categoryplot.setDataset(1, bodyData);
        categoryplot.setRenderer(1, r);
        categoryplot.setDatasetRenderingOrder(DatasetRenderingOrder.FORWARD);

        return jfreechart;
    }

    public void updateBodyGraph() {

        bodyData.setValue(TrackableSkeleton.armsValues.get("forward"), "Body", "ArmsF");
        bodyData.setValue(TrackableSkeleton.armsValues.get("openness"), "Body", "ArmsO");
        bodyData.setValue(TrackableSkeleton.armsValues.get("upward"), "Body", "ArmsU");

        bodyData.setValue(TrackableSkeleton.headValues.get("forward"), "Body", "HeadF");

        bodyData.setValue(TrackableSkeleton.kneesValues.get("straight"), "Body", "KneesS");

        bodyData.setValue(TrackableSkeleton.shouldersValues.get("forward"), "Body", "ShouldersF");
        bodyData.setValue(TrackableSkeleton.shouldersValues.get("upward"), "Body", "ShouldersU");

    }

    public void setDataset(Emotion emotion) {
        defaultcategorydataset.setValue(emotion.getParts().getArms().getForward().getMin() + 10, "Min", "ArmsF");
        defaultcategorydataset.setValue(emotion.getParts().getArms().getOpenness().getMin() + 10, "Min", "ArmsO");
        defaultcategorydataset.setValue(emotion.getParts().getArms().getUpward().getMin() + 10, "Min", "ArmsU");
        defaultcategorydataset.setValue(emotion.getParts().getHead().getForward().getMin() + 10, "Min", "HeadF");
        defaultcategorydataset.setValue(emotion.getParts().getKnees().getStraight().getMin() + 10, "Min", "KneesS");
        defaultcategorydataset.setValue(emotion.getParts().getShoulders().getForward().getMin() + 10, "Min", "ShouldersF");
        defaultcategorydataset.setValue(emotion.getParts().getShoulders().getUpward().getMin() + 10, "Min", "ShouldersU");

        defaultcategorydataset.setValue(emotion.getParts().getArms().getForward().getMax() + 10, "Max", "ArmsF");
        defaultcategorydataset.setValue(emotion.getParts().getArms().getOpenness().getMax() + 10, "Max", "ArmsO");
        defaultcategorydataset.setValue(emotion.getParts().getArms().getUpward().getMax() + 10, "Max", "ArmsU");
        defaultcategorydataset.setValue(emotion.getParts().getHead().getForward().getMax() + 10, "Max", "HeadF");
        defaultcategorydataset.setValue(emotion.getParts().getKnees().getStraight().getMax() + 10, "Max", "KneesS");
        defaultcategorydataset.setValue(emotion.getParts().getShoulders().getForward().getMax() + 10, "Max", "ShouldersF");
        defaultcategorydataset.setValue(emotion.getParts().getShoulders().getUpward().getMax() + 10, "Max", "ShouldersU");
    }

    public void createDataset(Emotion emotion) {
        defaultcategorydataset = new DefaultCategoryDataset();

        defaultcategorydataset.addValue(emotion.getParts().getArms().getForward().getMin() + 10, "Min", "ArmsF");
        defaultcategorydataset.addValue(emotion.getParts().getArms().getOpenness().getMin() + 10, "Min", "ArmsO");
        defaultcategorydataset.addValue(emotion.getParts().getArms().getUpward().getMin() + 10, "Min", "ArmsU");
        defaultcategorydataset.addValue(emotion.getParts().getHead().getForward().getMin() + 10, "Min", "HeadF");
        defaultcategorydataset.addValue(emotion.getParts().getKnees().getStraight().getMin() + 10, "Min", "KneesS");
        defaultcategorydataset.addValue(emotion.getParts().getShoulders().getForward().getMin() + 10, "Min", "ShouldersF");
        defaultcategorydataset.addValue(emotion.getParts().getShoulders().getUpward().getMin() + 10, "Min", "ShouldersU");

        defaultcategorydataset.addValue(emotion.getParts().getArms().getForward().getMax() + 10, "Max", "ArmsF");
        defaultcategorydataset.addValue(emotion.getParts().getArms().getOpenness().getMax() + 10, "Max", "ArmsO");
        defaultcategorydataset.addValue(emotion.getParts().getArms().getUpward().getMax() + 10, "Max", "ArmsU");
        defaultcategorydataset.addValue(emotion.getParts().getHead().getForward().getMax() + 10, "Max", "HeadF");
        defaultcategorydataset.addValue(emotion.getParts().getKnees().getStraight().getMax() + 10, "Max", "KneesS");
        defaultcategorydataset.addValue(emotion.getParts().getShoulders().getForward().getMax() + 10, "Max", "ShouldersF");
        defaultcategorydataset.addValue(emotion.getParts().getShoulders().getUpward().getMax() + 10, "Max", "ShouldersU");
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
    }
}
