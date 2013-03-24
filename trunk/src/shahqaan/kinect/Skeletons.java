/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shahqaan.kinect;

/**
 *
 * @author Shahqaan Qasim
 */

/* Skeletons sets up four 'observers' (listeners) so that 
 when a new user is detected in the scene, a standard pose for that 
 user is detected, the user skeleton is calibrated in the pose, and then the
 skeleton is tracked. The start of tracking adds a skeleton entry to userSkels.

 Each call to update() updates the joint positions for each user's
 skeleton.
  
 Each call to draw() draws each user's skeleton, with a rotated HEAD_FNM
 image for their head, and status text at the body's center-of-mass.
 */
import java.util.*;
import org.OpenNI.*;

public class Skeletons {

    // OpenNI
    protected UserGenerator userGen;
    protected DepthGenerator depthGen;
    // OpenNI capabilities used by UserGenerator
    protected SkeletonCapability skelCap;
    // to output skeletal data, including the location of the joints
    protected PoseDetectionCapability poseDetectionCap;
    // to recognize when the user is in a specific position
    protected String calibPoseName = null;
    protected HashMap<Integer, HashMap<SkeletonJoint, SkeletonJointPosition>> userSkels;
    protected Context context;
    protected DepthMetaData depthMD;
    protected boolean isRunning;

    public Skeletons() {
        configOpenNI();
        configure();
        userSkels = new HashMap<>();
    }
    public int getXRes() {
        return depthMD.getFullXRes();
    }
    public int getYRes() {
        return depthMD.getFullYRes();
        
    }
    private void configOpenNI() {
        try {
            context = new Context();

            License license = new License("PrimeSense", "0KOIk2JeIBYClPWVnMoRKn5cdY4=");   // vendor, key
            context.addLicense(license);

            depthGen = DepthGenerator.create(context);
            MapOutputMode mapMode = new MapOutputMode(640, 480, 30);   // xRes, yRes, FPS
            depthGen.setMapOutputMode(mapMode);

            context.setGlobalMirror(true); // set mirror mode 

            // use depth metadata to access depth info (avoids bug with DepthGenerator)
            depthMD = depthGen.getMetaData();

            userGen = UserGenerator.create(context);

            context.startGeneratingAll();
            System.out.println("Started context generating...");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
            System.exit(1);
        }
    } 
    /** 
     * Create pose and skeleton detection capabilities for the user generator, 
     * Set up observers (listeners)   
     */
    private void configure() {
        try {
            /*
             * Setup UserGenerator pose and skeleton detection capabilities
             * Should really check these using ProductionNode.isCapabilitySupported()
             * But since we are sure we are using Kinect, we know that these capabilities 
             * will be supported
             */
            poseDetectionCap = userGen.getPoseDetectionCapability();
            skelCap = userGen.getSkeletonCapability();
            /*
             * Why am I doing this?
             */
            calibPoseName = skelCap.getSkeletonCalibrationPose();  // the 'psi' pose
            skelCap.setSkeletonProfile(SkeletonProfile.ALL); // other possible values: UPPER_BODY, LOWER_BODY, HEAD_HANDS

            // set up four observers
            userGen.getNewUserEvent().addObserver(new Skeletons.NewUserObserver());   // new user found
            userGen.getLostUserEvent().addObserver(new Skeletons.LostUserObserver()); // lost a user
            poseDetectionCap.getPoseDetectedEvent().addObserver(
                    new Skeletons.PoseDetectedObserver());            // for when a pose is detected
            skelCap.getCalibrationCompleteEvent().addObserver(
                    new Skeletons.CalibrationCompleteObserver()); // for when skeleton calibration is completed, and tracking starts
        } catch (Exception e) {
            System.out.println(e);
            System.exit(1);
        }
    } 

    /**
     * Update the skeleton of each user
     * Called from run() in TrackerPanel 
     */
    public void update() {
        try {
            context.waitAnyUpdateAll();
        } catch (StatusException e) {
            System.out.println(e);
            System.exit(1);
        }
        try {
            int[] userIDs = userGen.getUsers();   // there may be many users in the scene
            for (int i = 0; i < userIDs.length; ++i) {
                int userID = userIDs[i];
                if (skelCap.isSkeletonCalibrating(userID)) {
                    continue;    // test to avoid occassional crashes with isSkeletonTracking()
                }
                if (skelCap.isSkeletonTracking(userID)) {
                    updateJoints(userID);
                }
            }
        } catch (StatusException e) {
            System.out.println(e);
        }
    }  
    /**
     * 
     * @param userID: User whose joints are to be updated
     */
    private void updateJoints(int userID) {
        HashMap<SkeletonJoint, SkeletonJointPosition> skel = userSkels.get(userID);

        updateJoint(skel, userID, SkeletonJoint.HEAD);
        updateJoint(skel, userID, SkeletonJoint.NECK);

        updateJoint(skel, userID, SkeletonJoint.LEFT_SHOULDER);
        updateJoint(skel, userID, SkeletonJoint.LEFT_ELBOW);
        updateJoint(skel, userID, SkeletonJoint.LEFT_HAND);

        updateJoint(skel, userID, SkeletonJoint.RIGHT_SHOULDER);
        updateJoint(skel, userID, SkeletonJoint.RIGHT_ELBOW);
        updateJoint(skel, userID, SkeletonJoint.RIGHT_HAND);

        updateJoint(skel, userID, SkeletonJoint.TORSO);

        updateJoint(skel, userID, SkeletonJoint.LEFT_HIP);
        updateJoint(skel, userID, SkeletonJoint.LEFT_KNEE);
        updateJoint(skel, userID, SkeletonJoint.LEFT_FOOT);

        updateJoint(skel, userID, SkeletonJoint.RIGHT_HIP);
        updateJoint(skel, userID, SkeletonJoint.RIGHT_KNEE);
        updateJoint(skel, userID, SkeletonJoint.RIGHT_FOOT);
    }  // end of updateJoints()


    /*
     private void updateJoints(int userID)   // alternative version
     // update all the joints for this userID in userSkels
     {
     HashMap<SkeletonJoint, SkeletonJointPosition> skel = userSkels.get(userID);
     for(SkeletonJoint j : SkeletonJoint.values())
     updateJoint(skel, userID, j);
     }  
     */
    protected void updateJoint(HashMap<SkeletonJoint, SkeletonJointPosition> skel,
            int userID, SkeletonJoint joint) {
        try {
            // report unavailable joints (should not happen)
            if (!skelCap.isJointAvailable(joint) || !skelCap.isJointActive(joint)) {
                System.out.println(joint + " not available for updates");
                return;
            }

            SkeletonJointPosition pos = skelCap.getSkeletonJointPosition(userID, joint);
            if (pos == null) {
                System.out.println("No update for " + joint);
                return;
            }

            /*
             // the call to getSkeletonJointOrientation() crashes Java!
             SkeletonJointOrientation ori = skelCap.getSkeletonJointOrientation(userID, joint);
             if (ori == null)
             System.out.println("No orientation for " + joint);
             else
             System.out.println("Orientation for " + joint + ": " + ori);
             */
            SkeletonJointPosition jPos = null;
            if (pos.getPosition().getZ() != 0) // has a depth position
            {
                jPos = new SkeletonJointPosition(
                        depthGen.convertRealWorldToProjective(pos.getPosition()),
                        pos.getConfidence());
            } else // no info found for that user's joint
            {
                jPos = new SkeletonJointPosition(new Point3D(), 0);
            }
            skel.put(joint, jPos);
        } catch (StatusException e) {
            System.out.println(e);
        }
    }  
    protected Point3D getJointPos(HashMap<SkeletonJoint, SkeletonJointPosition> skel,
            SkeletonJoint j) // get the (x, y, z) coordinate for the joint (or return null)
    {
        SkeletonJointPosition pos = skel.get(j);
        if (pos == null) {
            return null;
        }

        if (pos.getConfidence() == 0) {
            return null;   // don't draw a line to a joint with a zero-confidence pos
        }
        return pos.getPosition();
    }  

    // --------------------- 4 observers -----------------------
  /*   user detection --> pose detection --> skeleton calibration -->
     skeleton tracking (and creation of userSkels entry)
     + may also lose a user (and so delete its userSkels entry)
     */
    class NewUserObserver implements IObserver<UserEventArgs> {

        public void update(IObservable<UserEventArgs> observable, UserEventArgs args) {
            System.out.println("Detected new user " + args.getId());
            try {
                // try to detect a pose for the new user
                poseDetectionCap.StartPoseDetection(calibPoseName, args.getId());   // big-S ?
            } catch (StatusException e) {
                e.printStackTrace();
            }
        }
    }  // end of NewUserObserver inner class

    class LostUserObserver implements IObserver<UserEventArgs> {

        public void update(IObservable<UserEventArgs> observable, UserEventArgs args) {
            System.out.println("Lost track of user " + args.getId());
            userSkels.remove(args.getId());    // remove user from userSkels
        }
    } // end of LostUserObserver inner class

    class PoseDetectedObserver implements IObserver<PoseDetectionEventArgs> {

        public void update(IObservable<PoseDetectionEventArgs> observable,
                PoseDetectionEventArgs args) {
            int userID = args.getUser();
            System.out.println(args.getPose() + " pose detected for user " + userID);
            try {
                // finished pose detection; switch to skeleton calibration
                poseDetectionCap.StopPoseDetection(userID);    // big-S ?
                skelCap.requestSkeletonCalibration(userID, true);
            } catch (StatusException e) {
                e.printStackTrace();
            }
        }
    }  // end of PoseDetectedObserver inner class

    class CalibrationCompleteObserver implements IObserver<CalibrationProgressEventArgs> {

        @Override
        public void update(IObservable<CalibrationProgressEventArgs> observable,
                CalibrationProgressEventArgs args) {
            int userID = args.getUser();
            System.out.println("Calibration status: " + args.getStatus() + " for user " + userID);
            try {
                if (args.getStatus() == CalibrationProgressStatus.OK) {
                    // calibration succeeeded; move to skeleton tracking
                    System.out.println("Starting tracking user " + userID);
                    skelCap.startTracking(userID);
                    userSkels.put(new Integer(userID),
                            new HashMap<SkeletonJoint, SkeletonJointPosition>());
                    // create new skeleton map for the user in userSkels
                } else // calibration failed; return to pose detection
                {
                    poseDetectionCap.StartPoseDetection(calibPoseName, userID);    // big-S ?
                }
            } catch (StatusException e) {
                e.printStackTrace();
            }
        }
    } 
} 