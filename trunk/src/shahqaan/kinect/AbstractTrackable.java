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
public interface AbstractTrackable {

    public void start();
    public void stop();
    public boolean isTracking();
    /**
     * 
     * @param skeletons
     * @param skel 
     */
    public void track(Skeletons skeletons, HashMap<SkeletonJoint, SkeletonJointPosition> skel);
}
