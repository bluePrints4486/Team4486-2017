package org.usfirst.frc.team4486.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import org.usfirst.frc.team4486.robot.commands.*;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	//// CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	//// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	//// TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());
	
	public static Joystick driverStick = new Joystick(RobotMap.joystickChannel);
	public static Joystick manipulatorJoystick = new Joystick(RobotMap.manipulatorJoystick);
	
	Button openButton = new JoystickButton(manipulatorJoystick, RobotMap.openButton);
	Button closeButton = new JoystickButton(manipulatorJoystick,RobotMap.closeButton);
	Button upButton = new JoystickButton(manipulatorJoystick,RobotMap.upButton);
	Button downButton = new JoystickButton(manipulatorJoystick,RobotMap.downButton);
	Button intakeStartButton = new JoystickButton(manipulatorJoystick, RobotMap.INTAKE_BUTTON);
	Button elevatorButton = new JoystickButton(manipulatorJoystick ,RobotMap.ELEVATOR_BUTTON);
	Button openHopperButton = new JoystickButton(manipulatorJoystick, RobotMap.H_OPEN);
	Button closeHopperButton = new JoystickButton(manipulatorJoystick, RobotMap.H_CLOSE);
	Button winchButton = new JoystickButton(manipulatorJoystick, RobotMap.WINCH_BUTTON);
	
public OI(){
	upButton.whenPressed(new PickupUp());
	downButton.whenPressed(new PickupDown());
	openButton.whenPressed(new PickupOpen());
	closeButton.whenPressed(new PickupClose());
	intakeStartButton.whileHeld(new IntakeActuate()); 
	elevatorButton.whileHeld(new ElevatorActuate());
	openHopperButton.whenPressed(new HopperOpen());
	closeHopperButton.whenPressed(new HopperClose());
	winchButton.whileHeld(new WinchActuate());
}
	
}
