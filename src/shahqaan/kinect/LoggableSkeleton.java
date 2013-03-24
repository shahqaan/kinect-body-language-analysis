/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shahqaan.kinect;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.OpenNI.Point3D;
import org.OpenNI.SkeletonJoint;
import org.OpenNI.SkeletonJointPosition;

/**
 *
 * @author Shahqaan Qasim
 */
public class LoggableSkeleton implements AbstractLoggable {
    private boolean isLogging;
    private FileOutputStream out; // declare a file output object
    private PrintStream p; // declare a print stream object
    public LoggableSkeleton() {
        isLogging = false;
    }
    @Override
    public void start() {
        try {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH.mm.ss");
            Date date = new Date();
            
            // Checking if foldeer motion-tracker-output exists
            File check = new File("motion-tracker-output");
            if (!check.isDirectory()) { // If not then create it
                check.mkdir();
            }
            out = new FileOutputStream("motion-tracker-output\\" + dateFormat.format(date) + ".csv");
            p = new PrintStream(out);
            for (SkeletonJoint j : SkeletonJoint.values()) {
                p.print(j.name() + " (x)," + j.name() + " (y)," + j.name() + " (z),,");
            }
            p.println();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LoggableSkeleton.class.getName()).log(Level.SEVERE, null, ex);
        }
        isLogging = true;
        System.out.println("Started logging");
    }

    @Override
    public void log(Skeletons skeletons, HashMap<SkeletonJoint, SkeletonJointPosition> skel) {
        if (isLogging) {
            try {
                for (SkeletonJoint j : SkeletonJoint.values()) {
                    Point3D point = skeletons.getJointPos(skel, j);
                    if (point != null) {
                        p.print(point.getX() + "," + point.getY() + "," + point.getZ() + ",,");
                    }
                }
                p.println();
            } catch (Exception e) {
                e.printStackTrace();
                System.exit(1);
            }        
        }
    }

    @Override
    public void stop() {
        isLogging = false;
        p.close();
        try {
            out.close();
        } catch (IOException ex) {
            Logger.getLogger(LoggableSkeleton.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Stopped logging");
    }
    
}
