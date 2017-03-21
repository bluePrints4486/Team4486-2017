package org.usfirst.frc.team4486.robot.subsystems;

import org.usfirst.frc.team4486.robot.Robot;

import edu.wpi.first.wpilibj.command.PIDSubsystem;


/**
 *
 */
public class NavigationYawPID extends PIDSubsystem {

	double output = 0.0;
	boolean outputValid = false;
	double kP = 0.06;
	double kI = 0;
	double kD = 0;
	int yawTolerance = 2;
	double maxYawSpeed = 0.6;
	
    // Initialize your subsystem here
    public NavigationYawPID() {
        // Use these to get going:
        // setSetpoint() -  Sets where the PID controller should move the system
        //                  to
        // enable() - Enables the PID controller.
    	super(0,0,0);
    	this.setSetpoint(0.0);
    }

    public void enable()
    {
    	this.getPIDController().setPID(kP, kI, kD);
    	setAbsoluteTolerance(yawTolerance);
    	double maxSpeed = maxYawSpeed;
    	this.setOutputRange(-maxYawSpeed, maxYawSpeed);
    	outputValid = false;
    	
    	super.enable();
    	
    }
    
    

    protected double returnPIDInput() {
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
        // yourPot.getAverageVoltage() / kYourMaxVoltage;
    	return Robot.navigation.getYaw();
    }

    protected void usePIDOutput(double output) {
        // Use output to drive your system, like a motor
        // e.g. yourMotor.set(output);
    	this.output = -output;
    	outputValid = true;
    }
    
    public double getOutput() {
    	if(this.getPIDController().isEnabled() == false || outputValid == false) {
    		return 0.0;
    	}
    	return output;
    }
    //Currently this function only gets the raw error whether it be off.
    //We want the negative error in order to determine direction to which we want the 
    //z-axis to turn
	public boolean onRawTarget() {
		if (Math.abs(Robot.navigation.getYaw() - getPIDController().getSetpoint()) < yawTolerance) {
			return true;
		}
		else {
			return false;
		}
	}
    
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }   
    
}
