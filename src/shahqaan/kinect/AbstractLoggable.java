/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shahqaan.kinect;

import java.util.HashMap;
import org.OpenNI.SkeletonJoint;
import org.OpenNI.SkeletonJointPosition;

/**
 *
 * @author Shahqaan Qasim
 */
public interface AbstractLoggable {
    /**
     *
     */
    public void start();
    /**
     *
     * @param skeletons
     * @param skel
     */
    public void log(Skeletons skeletons, HashMap<SkeletonJoint, SkeletonJointPosition> skel);
    /**
     *
     */
    public void stop();
}
