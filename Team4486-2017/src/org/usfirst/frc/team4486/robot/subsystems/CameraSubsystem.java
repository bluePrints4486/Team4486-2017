package org.usfirst.frc.team4486.robot.subsystems;

import org.usfirst.frc.team4486.robot.Robot;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class CameraSubsystem extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    public void changeCameraSession(){
    		if (Robot.currSession.equals("cam0")){
    			Robot.currSession.startAutomaticCapture("cam0");
    		}

    	}
    }


}

