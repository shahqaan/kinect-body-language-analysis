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
import javax.swing.*;

/**
 * Extends JPanel
 * Implements Runnable
 *
 * Calls
 *  ExtendedSkeletons.draw()
 *  ExtendedSkeletons.update() in a different thread
 */
public class SkeletonPanel extends JPanel implements Runnable {

    private volatile boolean isRunning;
    private Font msgFont;
    private ExtendedSkeletons skels;   // the users' skeletons
    private AbstractLoggable loggable;

    /**
     * Configures JPanel properties
     * Assigns variables
     * Starts new thread for ExtendedSkeletons.update()
     *
     * @param skeleton
     *  ExtendedSkeletons instance passed to this class
     * @param loggableSkeleton
     *  AbstractLoggable intance passed to this class
     */
    public SkeletonPanel(
            ExtendedSkeletons skeleton,
            AbstractLoggable loggableSkeleton){

        // Set JPanel properties
        setBackground(Color.BLACK);

        // Set border color
        setBorder(BorderFactory.createLineBorder(Color.GREEN));

        // Configure variables
        this.loggable = loggableSkeleton;
        this.skels = skeleton;

        msgFont = new Font("SansSerif", Font.BOLD, 24);
        new Thread(this).start();   // start updating the panel
    } 


    @Override
    public Dimension getPreferredSize() {
        return new Dimension(skels.getXRes(), skels.getYRes());
    }

    public void closeDown() {
        isRunning = false;
    }

    /**
     * Calls ExtendedSkeletons.update()
     */
    @Override
    public void run() {
        isRunning = true;
        while (isRunning) {
            // long startTime = System.currentTimeMillis();
            skels.update();
            // imageCount++;
            // totalTime += (System.currentTimeMillis() - startTime);
            repaint();
        }
        System.exit(0);
    }

    /**
     * Calls ExtendedSkeletons.update
     *
     * @param g
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setFont(msgFont);
       
        skels.draw(g2d);
        
        /**
         * Template
         */
        /*
        g2d.drawLine(
                40, 40, 
                600, 400);
                * */
        
        
    }
} 

