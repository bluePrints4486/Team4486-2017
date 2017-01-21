package org.usfirst.frc.team4486.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public static int leftMotor = 1;
	// public static int rightMotor = 2;

	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
	//
	// Alan was here
	
	public static final int frontLeftChannel	= 0;	
	   public static final int rearLeftChannel	= 1;
	    public static final int frontRightChannel	= 2;
	   public static final int rearRightChannel	= 3;
	   
	   public static final int solenoidOpen = 0;
	   public static final int solenoidClose = 1;
	   public  static final int solenoidUp = 2;
	   public  static final int solenoidDown = 3;
	   
	   public static final int upButton = 7;
	   public static final int downButton = 9;
	   public static final int openButton = 8;
	   public static final int closeButton = 10;
	   
		   
	    
	    // The channel on the driver station that the joystick is connected to
	   public static final int joystickChannel	= 0;
	   public static final int manipulatorJoystick = 1;
}
