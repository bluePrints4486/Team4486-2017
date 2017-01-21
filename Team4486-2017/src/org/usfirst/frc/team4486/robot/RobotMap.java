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
	public final int frontLeftChannel	= 0;	
	   public final int rearLeftChannel	= 1;
	    public final int frontRightChannel	= 2;
	   public final int rearRightChannel	= 3;
	    
	    // The channel on the driver station that the joystick is connected to
	   public final int joystickChannel	= 0;
}
