package shahqaan.kinect;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.*;

public class ControlPanel extends JPanel implements ActionListener {
    private Font msgFont;
    private JCheckBox loggingCheckBox, drawingCheckbox, trackingCheckbox;

    public static String MESSAGE = null;

    private ExtendedSkeletons skels;   // the users' skeletons
    private AbstractDrawable drawable;
    private AbstractLoggable loggable;
    private AbstractTrackable trackable;

    private ArrayList<String> status = new ArrayList<>();

    public void setStatus(String status) {
        this.status.add(status);
    }
    public void removeStatus(String status) {
        this.status.remove(status);
    }
    public ControlPanel(
            ExtendedSkeletons skeleton,
            AbstractLoggable loggable,
            AbstractDrawable drawable,
            AbstractTrackable trackable){

        // Set JPanel properties
        setBackground(Color.BLACK);
        // Set border color
        setBorder(BorderFactory.createLineBorder(Color.GREEN));

        // Configure variables
        this.skels = skeleton;
        this.drawable = drawable;
        this.loggable = loggable;
        this.trackable = trackable;

        msgFont = new Font("SansSerif", Font.BOLD, 24);

        // initialize checkboxes
        loggingCheckBox = new JCheckBox("Log", false);
        drawingCheckbox = new JCheckBox("Draw", true);
        trackingCheckbox = new JCheckBox("Track", true);

        // set colors for checkboxes
        loggingCheckBox.setForeground(Color.WHITE);
        loggingCheckBox.setBackground(Color.BLACK);
        drawingCheckbox.setForeground(Color.WHITE);
        drawingCheckbox.setBackground(Color.BLACK);
        trackingCheckbox.setForeground(Color.WHITE);
        trackingCheckbox.setBackground(Color.BLACK);

        // add checkboxes to control panel
        this.add(loggingCheckBox);
        this.add(drawingCheckbox);
        this.add(trackingCheckbox);

        // add action listeners
        loggingCheckBox.addActionListener(this);
        drawingCheckbox.addActionListener(this);
        trackingCheckbox.addActionListener(this);
    }
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == loggingCheckBox) {
            // loggable.start();
            if (loggingCheckBox.isSelected()) {
                loggable.start();
                this.setStatus("Logging");
            }
            else {
                loggable.stop();
                this.removeStatus("Logging");
            }
        }
        if (event.getSource() == drawingCheckbox) {
            if (drawingCheckbox.isSelected()) {
                drawable.start();
                this.setStatus("Drawing");
                ControlPanel.MESSAGE = "Drawing";
            }
            else {
                drawable.stop();
                this.removeStatus("Drawing");
            }
        }
        if (event.getSource() == trackingCheckbox) {
            if (trackingCheckbox.isSelected()) {
                trackable.start();
                this.setStatus("Tracking");
            }
            else {
                trackable.stop();
                this.removeStatus("Tracking");
            }
        }
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

        // print status
        g2d.setFont(new Font("SansSerif", Font.PLAIN, 12));
        g2d.setColor(Color.LIGHT_GRAY);
        String printStatus = "";
        for(String s : this.status) {
            printStatus += "" + s + "  |  ";
        }
        g2d.drawString(printStatus, 30, 415);


        // print message
        if (ControlPanel.MESSAGE != null) {
            g2d.setFont(new Font("SansSerif", Font.BOLD, 75));
            g2d.setColor(Color.RED);
            g2d.drawString(ControlPanel.MESSAGE, 300, 413);
        }



        repaint();
    }
}

