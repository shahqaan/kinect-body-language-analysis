/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shahqaan.kinect;

/**
 *
 * @author Shahqaan Qasim
 */
/* Based on the Java OpenNI UserTracker sample

 Displays a depth map where each user is coloured differently. A 2D skeleton is
 drawn over each user's depth image, which shows how the user's 
 joints move over time.

 The skeletons are maintained, updated, and drawn by the ExtendedSkeletons class.
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class ControlPanel extends JPanel implements Runnable, ActionListener {
    private volatile boolean isRunning;
    // private int imageCount = 0;
    // private long totalTime = 0;
    private Font msgFont;
    private ExtendedSkeletons skels;   // the users' skeletons
    private JButton startButton, stopButton;
    private AbstractLoggable loggable;

    public ControlPanel() {
        setBackground(Color.WHITE);
        
        startButton = new JButton("Start");
        stopButton = new JButton("Stop");
        
        this.add(startButton);
        this.add(stopButton);
        
        startButton.addActionListener(this);
        stopButton.addActionListener(this);
        
        loggable = new LoggableSkeleton();
        skels = new ExtendedSkeletons(new DrawableSkeleton(), loggable);
        msgFont = new Font("SansSerif", Font.BOLD, 24);
        new Thread(this).start();   // start updating the panel
    } 

    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == startButton) {
            loggable.start();
        }
        if (event.getSource() == stopButton) {
            loggable.stop();
        }
    }
    
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(skels.getXRes(), skels.getYRes());
    }

    public void closeDown() {
        isRunning = false;
    }

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

