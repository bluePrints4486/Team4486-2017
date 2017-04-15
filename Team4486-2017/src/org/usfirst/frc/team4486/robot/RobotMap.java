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
	
	   //PWM ports
	   public static final int frontLeftChannel	= 2;	
	   public static final int rearLeftChannel = 3; //Zeroith PWM Port
	   public static final int frontRightChannel = 0;
	   public static final int rearRightChannel	= 1;
	   public static final int ELEVATOR_MOTOR = 5;
	   public static final int WINCHMOTOR_TOP = 4;
	   public static final int WINCHMOTOR_BOTTOM = 6; 
	   public static final int INTAKE_LEFT = 7; //Using right and left relative to looking at the robot from the ball pick up side
	   public static final int INTAKE_RIGHT = 8;
	   
	   //CAN Inputs
	   public static final int CONTINUOUS_MOTOR = 2;
	   
	   
	   
	   //Pneumatics PCM ports
	   public static final int solenoidOpen = 0;
	   public static final int solenoidClose = 1;
	   public static final int solenoidUp = 2;
	   public static final int solenoidDown = 3;
	   public static final int HOPPER_OPEN = 4;
	   public static final int HOPPER_CLOSE = 5;
	   
	   //Manipulator joystick buttons
	   public static final int upButton = 7;
	   public static final int downButton = 9;
	   public static final int openButton = 4; //Down
	   public static final int closeButton = 6; //Up
	   public static final int INTAKE_BUTTON = 3; //Intaking the gear
	   public static final int REMOVE_GEAR_BUTTON = 5; //Remove gear
	   public static final int ELEVATOR_BUTTON = 1; 
	   public static final int H_OPEN = 8;
	   public static final int H_CLOSE = 10;
	   public static final int WINCH_BUTTON = 2;
	   public static final int SWEEPER_RUN = 11;
	   
	   //Driver joystick buttons
	   public static final int CAMERA_SWITCH_BUTTON = 1;
	   public static final int TURBO_BUTTON = 2;
	   public static final int DRIVE_SIDEWAYS = 5; //For driving sideways where we climb
	   public static final int BACKWARDS_BUTTON = 6;
	   public static final int LANE_1AUTOBUTTON = 7;
	    public static final int LANE_2AUTOBUTTON = 9;
	    public static final int LANE_3AUTOBUTTON = 11;
	    
	    //Joystick ports
	   public static final int joystickChannel	= 0;
	   public static final int manipulatorJoystick = 1;
	   
	   //Analog Ports
	   public static final int sonarPort = 0;
	   
	   
}
