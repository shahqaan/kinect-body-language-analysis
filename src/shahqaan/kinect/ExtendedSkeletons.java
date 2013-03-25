/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shahqaan.kinect;

/**
 *
 * @author Shahqaan Qasim
 */

/* ExtendedSkeletons sets up four 'observers' (listeners) so that 
 when a new user is detected in the scene, a standard pose for that 
 user is detected, the user skeleton is calibrated in the pose, and then the
 skeleton is tracked. The start of tracking adds a skeleton entry to userSkels.

 Each call to update() updates the joint positions for each user's
 skeleton.
  
 Each call to draw() draws each user's skeleton, with a rotated HEAD_FNM
 image for their head, and status text at the body's center-of-mass.
 */
import java.awt.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.OpenNI.*;

public class ExtendedSkeletons extends Skeletons {
    private AbstractDrawable drawable;
    private AbstractLoggable loggable;
    private AbstractTrackable tracker;
    
    public static int[] bodyState = new int[6];
    
    public static String MESSAGE = null;
    public static String MESSAGE_2 = null;
    public static String MESSAGE_3 = null;
    public static String MESSAGE_4 = null;
    public static String MESSAGE_5 = null;

    /**
     * TODO simulate Kinect skeleton generation
     */
    private void classify() {
        // differentiating between anger and happiness
        if (ExtendedSkeletons.bodyState[1] == 2) { // maybe angry
            if (ExtendedSkeletons.bodyState[4] == 1) {
                ExtendedSkeletons.MESSAGE = "Angry";
            }
            else {
                ExtendedSkeletons.MESSAGE = "Unknown";
            }
        }
        else if (ExtendedSkeletons.bodyState[1] == 3) { // maybe happy
            if (ExtendedSkeletons.bodyState[4] == 8) {
                ExtendedSkeletons.MESSAGE = "Happy";
            }
            else {
                ExtendedSkeletons.MESSAGE = "Unknown";
            }
        }
        else {
            ExtendedSkeletons.MESSAGE = "Unknown";
        }
    }
    public ExtendedSkeletons(AbstractDrawable drawable, AbstractLoggable loggable) {
        for (int i = 0 ; i < 6 ; i++) {
            ExtendedSkeletons.bodyState[i] = 0;
        }
        this.drawable = drawable;
        this.loggable = loggable;
        this.tracker = new TrackableSkeleton();
    }
    public void draw(Graphics2D g2d) {
        g2d.setStroke(new BasicStroke(8));
        if (ExtendedSkeletons.MESSAGE != null) {
            g2d.setColor(Color.RED);
            g2d.drawString(ExtendedSkeletons.MESSAGE, 450, 50);
        }
        if (ExtendedSkeletons.MESSAGE_2 != null) {
            g2d.setColor(Color.RED);
            g2d.drawString(ExtendedSkeletons.MESSAGE_2, 430, 390);
        }
        if (ExtendedSkeletons.MESSAGE_3 != null) {
            g2d.setColor(Color.RED);
            g2d.drawString(ExtendedSkeletons.MESSAGE_3, 430, 350);
        }
        if (ExtendedSkeletons.MESSAGE_4 != null) {
            g2d.setColor(Color.RED);
            g2d.drawString(ExtendedSkeletons.MESSAGE_4, 430, 310);
        }
        if (ExtendedSkeletons.MESSAGE_5 != null) {
            g2d.setColor(Color.RED);
            g2d.drawString(ExtendedSkeletons.MESSAGE_5, 430, 270);
        }
        try {
            if (true) {
                int[] userIDs = userGen.getUsers();
                for (int i = 0; i < userIDs.length; ++i) {
                    g2d.setColor(Color.BLACK);
                    if (skelCap.isSkeletonCalibrating(userIDs[i])) {
                    } // test to avoid occassional crashes with isSkeletonTracking()
                    else if (skelCap.isSkeletonTracking(userIDs[i])) {
                        drawable.drawSkeleton(g2d, userSkels.get(userIDs[i]), this);
                    }
                }
            }
            //else { // Draw graph of body states
                
                g2d.setColor(Color.red);
                // Draw labels
                g2d.drawString("N/A", 20, 450);
                g2d.drawString("Forward", 20, 410);
                g2d.drawString("Backward", 20, 370);
                g2d.drawString("Bent", 20, 330);
                g2d.drawString("Straight", 20, 290);
                g2d.drawString("Upward", 20, 250);
                g2d.drawString("Lifted Upward", 20, 210);
                g2d.drawString("Crossed", 20, 170);
                g2d.drawString("Open", 20, 130);
                
                g2d.drawString("Body", 50, 470);
                g2d.drawString("Head", 150, 470);
                g2d.drawString("Shoulder", 250, 470);
                g2d.drawString("Chest", 350, 470);
                g2d.drawString("Arms", 450, 470);
                g2d.drawString("Knees", 550, 470);

                
                
                g2d.setColor(Color.blue);
                // width = 550
                // height = 400
                g2d.drawLine(50, 450, 600, 450);
                g2d.drawLine(50, 450, 50, 50);
                
                int prevX = 0;
                int prevY = 0;
                g2d.setColor(Color.black);
                for (int i = 0 ; i < 6 ; i++) {
                    
                    g2d.drawLine(
                            50 + prevX, (450 - prevY), 
                            50 + (i * 100), (450 - (40 * ExtendedSkeletons.bodyState[i])));
                    prevX = 100 * i;
                    prevY = 40 * ExtendedSkeletons.bodyState[i];
                }
                
                g2d.setColor(Color.red);
                this.classify();
            //}
        } catch (StatusException e) {
            System.out.println(e);
        }
    }
    @Override
    protected void updateJoint(HashMap<SkeletonJoint, SkeletonJointPosition> skel,
            int userID, SkeletonJoint joint) {
        Thread t = null;
        if (loggable != null) { 
            final HashMap<SkeletonJoint, SkeletonJointPosition> currentSkel = new HashMap<>(skel);
            final ExtendedSkeletons context = this;
            t = new Thread(new Runnable() {
                @Override
                public void run() {
                    loggable.log(context, currentSkel);
                }
                
            });
            t.start();
        }    
        super.updateJoint(skel, userID, joint);
        this.tracker.track(this, skel);
        if (loggable != null) {
            try {
                if (t != null) {
                    t.join();
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(ExtendedSkeletons.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    } 
}