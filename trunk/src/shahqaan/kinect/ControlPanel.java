package shahqaan.kinect;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class ControlPanel extends JPanel implements ActionListener {
    private Font msgFont;
    private JButton startButton, stopButton;

    private ExtendedSkeletons skels;   // the users' skeletons
    private AbstractDrawable drawable;
    private AbstractLoggable loggable;
    private AbstractTrackable trackable;

    public ControlPanel(
            ExtendedSkeletons skeleton,
            AbstractLoggable loggable,
            AbstractDrawable drawable,
            AbstractTrackable trackable){
        // Set JPanel properties
        setBackground(Color.WHITE);

        // Configure variables
        this.skels = skeleton;
        this.drawable = drawable;
        this.loggable = loggable;
        this.trackable = trackable;

        msgFont = new Font("SansSerif", Font.BOLD, 24);

        startButton = new JButton("Start");
        stopButton = new JButton("Stop");
        this.add(startButton);
        this.add(stopButton);
        startButton.addActionListener(this);
        stopButton.addActionListener(this);

    }
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == startButton) {
            loggable.start();
        }
        if (event.getSource() == stopButton) {
            loggable.stop();
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
        g2d.setFont(msgFont);
        g2d.setColor(Color.BLACK);
        g2d.drawString("Control Panel", 50, 200);
    }
}

