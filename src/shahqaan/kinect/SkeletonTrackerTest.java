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

public class SkeletonTrackerTest extends JFrame {

    private ControlPanel trackPanel;

    public SkeletonTrackerTest() {
        super("User Tracker");

        Container c = getContentPane();
        c.setLayout(new BorderLayout());

        trackPanel = new ControlPanel();
        c.add(trackPanel, BorderLayout.CENTER);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                trackPanel.closeDown();
            }
        });

        pack();
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    } // end of SkeletonTrackerTest()

    // -------------------------------------------------------
    public static void main(String args[]) {
        new SkeletonTrackerTest();
    }
} // end of SkeletonTrackerTest class
