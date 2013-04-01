/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shahqaan.kinect;

import org.OpenNI.Point3D;
import org.OpenNI.SkeletonJoint;
import org.OpenNI.SkeletonJointPosition;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.HashMap;

/**
 *
 * @author Shahqaan Qasim
 */
public class TrackableSkeleton implements AbstractTrackable {
    private boolean isTracking = true;

    private static int count = 0;

    private final static String CONFIGURATION_DIRECTORY_PATH = "D:\\Documents\\Projects\\FYP - Computer Generated Art\\Development\\kinect-body-language-analysis\\";
    private final static String PARTS_FILE = CONFIGURATION_DIRECTORY_PATH + "Parts Configurations.xml";
    private final static String PARTS_VALUES_FILE = CONFIGURATION_DIRECTORY_PATH + "Parts Values Configurations.xml";
    private final static String EMOTIONS_FILE = CONFIGURATION_DIRECTORY_PATH + "Emotions Configurations.xml";

    public static Parts parts = null;
    public static Parts partsValues = null;
    public static Emotions emotions = null;

    public static HashMap<String, Float> headValues = new HashMap<>();
    public static HashMap<String, Float> armsValues = new HashMap<>();
    public static HashMap<String, Float> kneesValues = new HashMap<>();
    public static HashMap<String, Float> shouldersValues = new HashMap<>();

    /**
     * Variables for arm and hands
     */
    private double armAllowedAngle = 0.35; 
    private double armSlightExtension = 150.0;
    private double armFullExtension = 200.0;
    private double armForwardThreshold = -250.0;
    private double armBackwardThreshold = 150.0;
    
    
    private double kneeBendThreshold = -70.0;
    
    private double headBendThreshold = -35.0;
    private double headBackThreshold = 50.0;
    
    private double chestBendThreshold = -30.0;
    private double chestBackThreshold = 40.0;


    public static TrackableSkeleton getTracker() {
        if (TrackableSkeleton.count <= 0) {
            TrackableSkeleton.count++;
            return new TrackableSkeleton();

        }
        else {
            return null;
        }
    }

    @Override
    protected void finalize() {
        TrackableSkeleton.count--;
    }

    private TrackableSkeleton() {
        this.buildPartsFromXml(TrackableSkeleton.PARTS_FILE);
        this.buildPartsValuesFromXml(TrackableSkeleton.PARTS_VALUES_FILE);
        this.buildEmotionsFromXml(TrackableSkeleton.EMOTIONS_FILE);

        TrackableSkeleton.armsValues.put("forward", 0f);
        TrackableSkeleton.armsValues.put("openness", 0f);
        TrackableSkeleton.armsValues.put("upward", 0f);

        TrackableSkeleton.headValues.put("forward", 0f);

        TrackableSkeleton.kneesValues.put("straight", 0f);

        TrackableSkeleton.shouldersValues.put("forward", 0f);
        TrackableSkeleton.shouldersValues.put("upward", 0f);

    }
    @Override
    public void start() {
        this.isTracking = true;
    }
    @Override
    public void stop() {
        this.isTracking = false;
    }
    @Override
    public boolean isTracking() {
        return this.isTracking;
    }

    private void buildPartsFromXml(String path) {
        try {

            File file = new File(path);
            JAXBContext jaxbContext = JAXBContext.newInstance(Parts.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            this.parts = (Parts) jaxbUnmarshaller.unmarshal(file);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
    private void buildPartsValuesFromXml(String path) {
        try {

            File file = new File(path);
            JAXBContext jaxbContext = JAXBContext.newInstance(Parts.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            this.partsValues = (Parts) jaxbUnmarshaller.unmarshal(file);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
    private void buildEmotionsFromXml(String path) {
        try {

            File file = new File(path);
            JAXBContext jaxbContext = JAXBContext.newInstance(Emotions.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            this.emotions = (Emotions) jaxbUnmarshaller.unmarshal(file);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    /**
     * 
     * @param x
     * @param y
     * @param z
     * @param a
     * @param b
     * @param c
     * @param p
     * @param q
     * @param r
     * @return
     *      angle in radians
     */
    private double findAngle(
            float x, float y, float z,
            float a, float b, float c,
            float p, float q, float r) {
        
        float i, j, k;
        i = ((y - b) * (r - z)) - ((z - c) * (q - y));
        j = ((x - a) * (r - z)) - ((z - c) * (p - x));
        k = ((x - a) * (q - y)) - ((y - b) * (p - x));

        i = i * i;
        j = j * j;
        k = k * k;

        double numerator = Math.sqrt(i + j + k);

        float v1 = (x-a)*(x-a);
        float v2 = (y-b)*(y-b);
        float v3 = (z-c)*(z-c);

        float u1 = (p-x)*(p-x);
        float u2 = (q-y)*(q-y);
        float u3 = (r-z)*(r-z);

        double denom1 = Math.sqrt(v1 + v2 + v3);
        double denom2 = Math.sqrt(u1 + u2 + u3);

        double finalV = denom1 * denom2;
        finalV = numerator / finalV;

        double angle = Math.sinh(finalV);
        
        return angle;

    }
    
    private float xFromTorso(Skeletons skeletons, HashMap<SkeletonJoint, SkeletonJointPosition> skel, float x) {
        Point3D point = skeletons.getJointPos(skel, SkeletonJoint.TORSO);
        if (point != null) {
            return (x - point.getX());
        }
        else {
            return 0;
        }
    }
    private float yFromTorso(Skeletons skeletons, HashMap<SkeletonJoint, SkeletonJointPosition> skel, float y) {
        Point3D point = skeletons.getJointPos(skel, SkeletonJoint.TORSO);
        if (point != null) {
            return (y - point.getX());
        }
        else {
            return 0;
        }
    }
    private float zFromTorso(Skeletons skeletons, HashMap<SkeletonJoint, SkeletonJointPosition> skel, float z) {
        Point3D point = skeletons.getJointPos(skel, SkeletonJoint.TORSO);
        if (point != null) {
            return (z - point.getZ());
        }
        else {
            return 0;
        }
    }

    private float yFromNeck(Skeletons skeletons, HashMap<SkeletonJoint, SkeletonJointPosition> skel, float y) {
        Point3D point = skeletons.getJointPos(skel, SkeletonJoint.NECK);
        if (point != null) {
            return (y - point.getY());
        }
        else {
            return 0;
        }
    }
    private float zFromNeck(Skeletons skeletons, HashMap<SkeletonJoint, SkeletonJointPosition> skel, float z) {
        Point3D point = skeletons.getJointPos(skel, SkeletonJoint.NECK);
        if (point != null) {
            return (z - point.getZ());
        }
        else {
            return 0;
        }
    }

    
    private void testRightKnee(Skeletons skeletons, HashMap<SkeletonJoint, SkeletonJointPosition> skel) {
        float x = 0, y = 0, z = 0;
        float a = 0, b = 0, c = 0;
        float p = 0, q = 0, r = 0;
        float u = 0, v = 0, w = 0;
        
         
        try {
            /*
            Point3D point = skeletons.getJointPos(skel, SkeletonJoint.RIGHT_HIP);
            if (point == null) {
            }
            else {
                a = point.getX();
                b = point.getY();
                c = point.getZ();
            }
            * */
            Point3D point = skeletons.getJointPos(skel, SkeletonJoint.RIGHT_KNEE);
            if (point == null) {
            }
            else {
                x = point.getX();
                y = point.getY();
                z = point.getZ();
            }

            // Angle will tell whether the arm is straight or not
            // double angle = this.findAngle(x, y, z, a, b, c, p, q, r);
       
            // since it's a right hand, more positive value means
            // it is extending outwards
            // and more negative value means it is crossed inwards
            // float xFromTorso = this.xFromTorso(skeletons, skel, p);
            
            // if negative then arm is forward
            // float zFromTorso = this.zFromTorso(skeletons, skel, r);
            
            float zFromTorso = this.zFromTorso(skeletons, skel, z);

            int actualSpan = this.partsValues.getKnees().getStraight().getSpan();
            int mappedSpan = this.parts.getKnees().getStraight().getSpan();

            float mappedPositionStraight = (zFromTorso / (float) actualSpan) * (float) mappedSpan;

            this.kneesValues.put("straight", mappedPositionStraight);

        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }        
        
        
    }

    /**
     * TODO implement "upward" check
     *
     * @param skeletons
     * @param skel
     */
    private void testRightArm(Skeletons skeletons, HashMap<SkeletonJoint, SkeletonJointPosition> skel) {
        float x = 0, y = 0, z = 0;
        float a = 0, b = 0, c = 0;
        float p = 0, q = 0, r = 0;
        float u = 0, v = 0, w = 0;
         
        try {
            Point3D point = skeletons.getJointPos(skel, SkeletonJoint.RIGHT_SHOULDER);
            if (point == null) {
            }
            else {
                a = point.getX();
                b = point.getY();
                c = point.getZ();
            }
            point = skeletons.getJointPos(skel, SkeletonJoint.RIGHT_ELBOW);
            if (point == null) {
            }
            else {
                x = point.getX();
                y = point.getY();
                z = point.getZ();
            }
            point = skeletons.getJointPos(skel, SkeletonJoint.RIGHT_HAND);
            if (point == null) {
            }
            else {
                p = point.getX();
                q = point.getY();
                r = point.getZ();
            }


            // Determine openness

            // Angle will tell whether the arm is straight or not
            // double angle = this.findAngle(x, y, z, a, b, c, p, q, r);

            // since it's a right hand, more positive value means
            // it is extending outwards
            // and more negative value means it is crossed inwards
            float xFromTorso = this.xFromTorso(skeletons, skel, p);
            int actualSpan = (this.partsValues.getArms().getOpenness().getSpan());
            int mappedSpan = (this.parts.getArms().getOpenness().getSpan());
            float mappedPositionOpenness = (xFromTorso / (float) actualSpan) * (float) mappedSpan;

            // Determine forward

            // if negative then arm is forward
            float zFromTorso = this.zFromTorso(skeletons, skel, r);
            actualSpan = (this.partsValues.getArms().getForward().getSpan());
            mappedSpan = (this.parts.getArms().getForward().getSpan());
            float mappedPositionForward = (zFromTorso / (float) actualSpan) * (float) mappedSpan;

            this.armsValues.put("forward", mappedPositionForward);
            this.armsValues.put("openness", mappedPositionOpenness);

        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }        
        
    }
    private void testLeftArm(Skeletons skeletons, HashMap<SkeletonJoint, SkeletonJointPosition> skel) {
        float x = 0, y = 0, z = 0;
        float a = 0, b = 0, c = 0;
        float p = 0, q = 0, r = 0;
        float u = 0, v = 0, w = 0;
         
        try {
            Point3D point = skeletons.getJointPos(skel, SkeletonJoint.LEFT_SHOULDER);
            if (point == null) {
            }
            else {
                a = point.getX();
                b = point.getY();
                c = point.getZ();
            }
            point = skeletons.getJointPos(skel, SkeletonJoint.LEFT_ELBOW);
            if (point == null) {
            }
            else {
                x = point.getX();
                y = point.getY();
                z = point.getZ();
            }
            point = skeletons.getJointPos(skel, SkeletonJoint.LEFT_HAND);
            if (point == null) {
            }
            else {
                p = point.getX();
                q = point.getY();
                r = point.getZ();
            }
            
            double angle = this.findAngle(x, y, z, a, b, c, p, q, r);

            // find the x, y and z distances between body and arm
            point = skeletons.getJointPos(skel, SkeletonJoint.TORSO);
            if (point != null) {
                u = point.getX();
                v = point.getY();
                w = point.getZ();
            }
            // x increases if i move right
            // z increases if i move back backwards
            System.out.println("X = " + (p - u) + " Y = " + (q - v) + " Z = " + (r - w));
        
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }        
        
    }

    private void testChest(Skeletons skeletons, HashMap<SkeletonJoint, SkeletonJointPosition> skel) {
        float x = 0, y = 0, z = 0;
        Point3D point = skeletons.getJointPos(skel, SkeletonJoint.NECK);
        if (point != null) {
            x = point.getX();
            y = point.getY();
            z = point.getZ();
        }
        float zFromTorso = this.zFromTorso(skeletons, skel, 0);
        if (zFromTorso < this.chestBendThreshold) {

        }
        else {
            if (zFromTorso > this.chestBackThreshold) {

            }
            else {

            }
        }
    }

    private void testShoulders(Skeletons skeletons, HashMap<SkeletonJoint, SkeletonJointPosition> skel) {
        float x = 0, y = 0, z = 0;
        Point3D point = skeletons.getJointPos(skel, SkeletonJoint.RIGHT_SHOULDER);
        if (point != null) {
            x = point.getX();
            y = point.getY();
            z = point.getZ();
        }
        // float zFromTorso = this.zFromTorso(skeletons, skel, 0);
        float shoulderYFromNeck = this.yFromNeck(skeletons, skel, y);
        float shoulderZFromNeck = this.zFromNeck(skeletons, skel, z);

        // float shoulderYFromNeck = this.yFromTorso(skeletons, skel, y);
        // float shoulderZFromNeck = this.zFromTorso(skeletons, skel, z);

        int actualSpan = this.partsValues.getShoulders().getUpward().getSpan();
        int mappedSpan = this.parts.getShoulders().getUpward().getSpan();



        float mappedPositionY = (shoulderYFromNeck / (float) actualSpan) * (float) mappedSpan;
        float mappedPositionZ = (shoulderZFromNeck / (float) actualSpan) * (float) mappedSpan;

        ControlPanel.MESSAGE = "SF: " + shoulderYFromNeck;

        this.shouldersValues.put("upward", mappedPositionY);
        this.shouldersValues.put("forward", mappedPositionZ);
    }
   
    private void testHead(Skeletons skeletons, HashMap<SkeletonJoint, SkeletonJointPosition> skel) {
        float x = 0, y = 0, z = 0;
        Point3D point = skeletons.getJointPos(skel, SkeletonJoint.HEAD);
        if (point != null) {
            x = point.getX();
            y = point.getY();
            z = point.getZ();
        }
        float headFromTorso = this.zFromTorso(skeletons, skel, z);

        int actualSpan = (this.partsValues.getHead().getForward().getSpan());
        int mappedSpan = (this.parts.getHead().getForward().getSpan());

        float mappedPosition = (headFromTorso / (float) actualSpan) * (float) mappedSpan;

        this.headValues.put("forward", mappedPosition);
    }

    private void determineEmotions() {
        if (this.headValues != null) {

        }
        if (this.shouldersValues != null) {

        }
    }

    @Override
    public void track(Skeletons skeletons, HashMap<SkeletonJoint, SkeletonJointPosition> skel) {
        if (this.isTracking) {
            this.testRightArm(skeletons, skel);
            this.testRightKnee(skeletons, skel);
            // this.testChest(skeletons, skel);
            this.testHead(skeletons, skel);
            this.testShoulders(skeletons, skel);
            this.determineEmotions();
         }
    }


}
