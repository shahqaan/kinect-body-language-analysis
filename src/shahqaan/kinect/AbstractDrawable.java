/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shahqaan.kinect;

import java.awt.Graphics2D;
import java.util.HashMap;
import org.OpenNI.SkeletonJoint;
import org.OpenNI.SkeletonJointPosition;

/**
 *
 * @author Shahqaan Qasim
 */
public interface AbstractDrawable {
    public void start();
    public void stop();
    /**
     *
     * @param g2d
     * @param skel
     * @param skeletons
     */
    public void drawSkeleton(Graphics2D g2d, HashMap<SkeletonJoint, SkeletonJointPosition> skel, Skeletons skeletons);
    /**
     *
     * @param g2d
     * @param skel
     * @param j1
     * @param j2
     * @param skeletons
     */
    public void drawLine(Graphics2D g2d,
            HashMap<SkeletonJoint, SkeletonJointPosition> skel,
            SkeletonJoint j1, SkeletonJoint j2,
            Skeletons skeletons);   
}
