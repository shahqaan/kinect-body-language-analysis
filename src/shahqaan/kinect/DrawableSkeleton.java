/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shahqaan.kinect;

import java.awt.Graphics2D;
import java.util.HashMap;
import org.OpenNI.Point3D;
import org.OpenNI.SkeletonJoint;
import org.OpenNI.SkeletonJointPosition;

/**
 *
 * @author Shahqaan Qasim
 */
public class DrawableSkeleton implements AbstractDrawable {

    @Override
    public void drawSkeleton(Graphics2D g2d,
            HashMap<SkeletonJoint, SkeletonJointPosition> skel, Skeletons skeletons) {
        drawLine(g2d, skel, SkeletonJoint.HEAD, SkeletonJoint.NECK, skeletons);

        drawLine(g2d, skel, SkeletonJoint.LEFT_SHOULDER, SkeletonJoint.TORSO, skeletons);
        drawLine(g2d, skel, SkeletonJoint.RIGHT_SHOULDER, SkeletonJoint.TORSO, skeletons);

        drawLine(g2d, skel, SkeletonJoint.NECK, SkeletonJoint.LEFT_SHOULDER, skeletons);
        drawLine(g2d, skel, SkeletonJoint.LEFT_SHOULDER, SkeletonJoint.LEFT_ELBOW, skeletons);
        drawLine(g2d, skel, SkeletonJoint.LEFT_ELBOW, SkeletonJoint.LEFT_HAND, skeletons);

        drawLine(g2d, skel, SkeletonJoint.NECK, SkeletonJoint.RIGHT_SHOULDER, skeletons);
        drawLine(g2d, skel, SkeletonJoint.RIGHT_SHOULDER, SkeletonJoint.RIGHT_ELBOW, skeletons);
        drawLine(g2d, skel, SkeletonJoint.RIGHT_ELBOW, SkeletonJoint.RIGHT_HAND, skeletons);

        drawLine(g2d, skel, SkeletonJoint.LEFT_HIP, SkeletonJoint.TORSO, skeletons);
        drawLine(g2d, skel, SkeletonJoint.RIGHT_HIP, SkeletonJoint.TORSO, skeletons);
        drawLine(g2d, skel, SkeletonJoint.LEFT_HIP, SkeletonJoint.RIGHT_HIP, skeletons);

        drawLine(g2d, skel, SkeletonJoint.LEFT_HIP, SkeletonJoint.LEFT_KNEE, skeletons);
        drawLine(g2d, skel, SkeletonJoint.LEFT_KNEE, SkeletonJoint.LEFT_FOOT, skeletons);

        drawLine(g2d, skel, SkeletonJoint.RIGHT_HIP, SkeletonJoint.RIGHT_KNEE, skeletons);
        drawLine(g2d, skel, SkeletonJoint.RIGHT_KNEE, SkeletonJoint.RIGHT_FOOT, skeletons);
    }  // end of drawSkeleton()

    @Override
    public void drawLine(Graphics2D g2d,
            HashMap<SkeletonJoint, SkeletonJointPosition> skel,
            SkeletonJoint j1, SkeletonJoint j2, Skeletons skeletons) // draw a line (limb) between the two joints (if they have positions)
    {
        Point3D p1 = skeletons.getJointPos(skel, j1);
        Point3D p2 = skeletons.getJointPos(skel, j2);
        if ((p1 != null) && (p2 != null)) {
            g2d.drawLine((int) p1.getX(), (int) p1.getY(),
                    (int) p2.getX(), (int) p2.getY());
        }
    }  // end of drawLine()
}
