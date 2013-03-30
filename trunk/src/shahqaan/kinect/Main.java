/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shahqaan.kinect;


/**
 *
 * @author Shahqaan Qasim
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Initializes
 *  DrawableSkeleton, LoggableSkeleton, TrackableSkeleton
 *  and ExtendedSkeletons
 *
 * Initializes
 *  SkeletonPanel, GraphPanel, ControlPanel
 *  mainPanel (JPanel) and subPanel (JPanel)
 */
public class Main extends JFrame {

    // Panels
    private SkeletonPanel skeletonPanel;
    private JPanel mainPanel = null;
    private JPanel subPanel = null;
    private GraphPanel graphPanel = null;
    private ControlPanel controlPanel = null;

    /**
     * Plugins for ExtendedSkeletons
     */
    AbstractDrawable drawableSkeleton = null;
    AbstractLoggable loggableSkeleton = null;
    AbstractTrackable trackableSkeleton = null;

    /**
     * THE object where the magic happens
     */
    ExtendedSkeletons skeleton = null;

    /**
     *
     */
    public Main() {
        super("User Tracker");

        // Apply UI Theme
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (InstantiationException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (IllegalAccessException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        // create skeleton helper objects
        this.drawableSkeleton = new DrawableSkeleton();
        this.loggableSkeleton = new LoggableSkeleton();
        this.trackableSkeleton = TrackableSkeleton.getTracker();

        // create skeleton object
        this.skeleton = ExtendedSkeletons.getInstance(
                this.drawableSkeleton,
                this.loggableSkeleton,
                this.trackableSkeleton);

        // create container inside the frame
        Container c = getContentPane();
        c.setLayout(new BorderLayout());

        // create main panel
        this.mainPanel = new JPanel();
        this.mainPanel.setLayout(new GridLayout(2, 1));

        this.subPanel = new JPanel();
        this.graphPanel = new GraphPanel(this.skeleton);

        this.skeletonPanel = new SkeletonPanel(
                this.skeleton,
                this.loggableSkeleton);

        this.controlPanel = new ControlPanel(
                this.skeleton,
                this.loggableSkeleton,
                this.drawableSkeleton,
                this.trackableSkeleton
        );

        // change layout of sub panel to grid 1 row and 2 columns
        this.subPanel.setLayout(new GridLayout(1, 2));

        // add skeletonPanel and guiPanel to subPanel
        this.subPanel.add(this.skeletonPanel);
        this.subPanel.add(this.controlPanel);

        // add subPanel to main panel
        this.mainPanel.add(this.subPanel);

        // add graph panel to main panel
        this.mainPanel.add(this.graphPanel);

        // add mainPanel to container
        c.add(this.mainPanel);


        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                skeletonPanel.closeDown();
            }
        });

        pack();
        setResizable(true);
        setLocationRelativeTo(null);
        setVisible(true);
        setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
    }

    public static void main(String args[]) {
        new Main();
    }
}
