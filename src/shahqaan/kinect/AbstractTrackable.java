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
public interface AbstractTrackable {

    public void start();
    public void stop();
    /**
     * 
     * @param skeletons
     * @param skel 
     */
    public void track(Skeletons skeletons, HashMap<SkeletonJoint, SkeletonJointPosition> skel);
}
