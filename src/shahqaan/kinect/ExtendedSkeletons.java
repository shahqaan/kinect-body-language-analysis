package shahqaan.kinect;

/**
 *
 * @author Shahqaan Qasim
 */

import java.awt.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.OpenNI.*;

public class ExtendedSkeletons extends Skeletons {

    /**
     * ExtendedSkeletons' objects count for Sigleton
     * implementation
     */
    private static int count = 0;

    private AbstractDrawable drawable;
    private AbstractLoggable loggable;
    private AbstractTrackable tracker;

    /**
     * @param drawable
     *  AbstractDrawable instance passed to this class
     * @param loggable
     *  AbstractLoggable instance passed to this class
     * @param tracker
     *  AbstractTracker instance passed to this class
     * @return ExtendedSkeletons instance if none
     *  exists already
     */
    public static ExtendedSkeletons getInstance(
            AbstractDrawable drawable,
            AbstractLoggable loggable,
            AbstractTrackable tracker) {

        if (ExtendedSkeletons.count <= 0) {
            ExtendedSkeletons.count++;
            return new ExtendedSkeletons(drawable, loggable, tracker);
        }
        else {
            return null;
        }

    }

    /**
     *
     * @param drawable
     *  assigns to local copy of AbstractDrawable
     * @param loggable
     *  assigns to local copy of AbstractLoggable
     * @param tracker
     *  assigns to local copy of AbstractTrackable
     */
    private ExtendedSkeletons(
            AbstractDrawable drawable,
            AbstractLoggable loggable,
            AbstractTrackable tracker) {

        this.drawable = drawable;
        this.loggable = loggable;
        this.tracker = tracker;
    }

    /**
     * Subtracts 1 from count
     */
    @Override
    protected void finalize() {
        ExtendedSkeletons.count--;
    }

    /**
     * Calls AbstractDrawable.drawSkeleton()
     * Draws on g2d
     *
     * @param g2d
     *  Graphics2D instance received from paint
     */
    public void draw(Graphics2D g2d) {
        try {
            if (true) {
                int[] userIDs = userGen.getUsers();
                for (int i = 0; i < userIDs.length; ++i) {
                    g2d.setColor(Color.GREEN);
                    if (skelCap.isSkeletonCalibrating(userIDs[i])) {
                        // test to avoid occasional crashes with isSkeletonTracking()
                    }
                    else if (skelCap.isSkeletonTracking(userIDs[i])) {
                        drawable.drawSkeleton(g2d, userSkels.get(userIDs[i]), this);
                    }
                }
            }
            //else { // Draw graph of body states
            /*
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
                g2d.setColor(Color.black); */
            /*
                for (int i = 0 ; i < 6 ; i++) {
                    
                    g2d.drawLine(
                            50 + prevX, (450 - prevY), 
                            50 + (i * 100), (450 - (40 * ExtendedSkeletons.bodyState[i])));
                    prevX = 100 * i;
                    prevY = 40 * ExtendedSkeletons.bodyState[i];
                }
                
                g2d.setColor(Color.red);
                this.classify();
                */
            //}
        } catch (StatusException e) {
            System.out.println(e);
        }
    }

    /**
     * Logs in another thread
     * Calls updateJoint() of Skeletons
     * Calls tracker.track()
     *
     * @param skel
     *  HashMap<SkeletonJoint, SkeletonJointPosition>
     * @param userID
     *  int current user id
     * @param joint
     *  SkeletonJoint
     */
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