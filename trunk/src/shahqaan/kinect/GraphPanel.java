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

public class GraphPanel extends JPanel {
    private Font msgFont;
    private ExtendedSkeletons skels;   // the users' skeletons

    public GraphPanel(ExtendedSkeletons skeleton){
        // Set JPanel properties
        setBackground(Color.BLACK);

        // Configure variables
        this.skels = skeleton;

        msgFont = new Font("SansSerif", Font.BOLD, 24);
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
