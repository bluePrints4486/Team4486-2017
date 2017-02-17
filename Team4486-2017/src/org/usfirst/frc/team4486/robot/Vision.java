package org.usfirst.frc.team4486.robot;

import org.opencv.core.Mat;
import org.usfirst.frc.team4486.robot.OI;
import edu.wpi.cscore.CvSink;
import edu.wpi.cscore.CvSource;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;

public class Vision {

	
	public static void StartVisionThread(){
		//This block of code is set up as a thread
		//Everything inside will be run constantly in the background
		Thread t = new Thread(() -> {
    		
			//Stores which camera is streaming
    		boolean cameraState = false;		
    		
    		// Setup 2 cameras servers 
    		UsbCamera camera1 = CameraServer.getInstance().startAutomaticCapture(0);
            camera1.setResolution(320, 240);
            camera1.setFPS(30);
            UsbCamera camera2 = CameraServer.getInstance().startAutomaticCapture(1);
            camera2.setResolution(320, 240);
            camera2.setFPS(30);
            
            //Create objects so we can extract images from the camera servers
            // and objects so we can have an output camera server
            CvSink cvSink1 = CameraServer.getInstance().getVideo(camera1);
            CvSink cvSink2 = CameraServer.getInstance().getVideo(camera2);
            CvSource outputStream = CameraServer.getInstance().putVideo("Switcher", 320, 240);
            
            // OpenCV Matrix object to store the camera object
            Mat image = new Mat();
            
            while(!Thread.interrupted()) {
            	
            	// Read button from OI and if true toggle state of active camera
            	if(OI.driverStick.getRawButton(RobotMap.CAMERA_SWITCH_BUTTON)) {
            		cameraState = !cameraState;
            	}
            	
            	//depending on active camera state, disabe one camera and start the other
            	// then grab the current image from that camera
                if(cameraState){
                  cvSink2.setEnabled(false);
                  cvSink1.setEnabled(true);
                  cvSink1.grabFrame(image);
                } else{
                  cvSink1.setEnabled(false);
                  cvSink2.setEnabled(true);
                  cvSink2.grabFrame(image);     
                }
                
                //Put the current image into the output camera server
                outputStream.putFrame(image);
            }
            
        });
        t.start();	//Starts the vision thread
	}
}
