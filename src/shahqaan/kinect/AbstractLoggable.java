/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shahqaan.kinect;

import org.OpenNI.SkeletonJoint;
import org.OpenNI.SkeletonJointPosition;

import java.util.HashMap;

/**
 *
 * @author Shahqaan Qasim
 */
public interface AbstractLoggable {
    public boolean isLogging();
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
