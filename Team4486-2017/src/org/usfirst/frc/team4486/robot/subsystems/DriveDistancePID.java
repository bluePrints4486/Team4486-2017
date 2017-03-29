package org.usfirst.frc.team4486.robot.subsystems;

import org.usfirst.frc.team4486.robot.Robot;

import edu.wpi.first.wpilibj.command.PIDSubsystem;


/**
 *
 */
public class DriveDistancePID extends PIDSubsystem {
	
	double output = 0.0;
	boolean outputValid = false;
	double kP = 0.7;
	double kI = 0.04;
	double kD = 5.0;
	double distanceTolerance = 0.3;
	double maxMoveSpeed = 0.6;

    // Initialize your subsystem here
    public DriveDistancePID() {
        super(0, 0, 0);
        this.setSetpoint(0.0);
        // TODO Do we need to call enable() here?
    }
    
    public void enable() {
    	this.getPIDController().setPID(
    			kP,
    			kI,
    			kD);
    	
    	setAbsoluteTolerance(distanceTolerance);
    	
    	double maxSpeed = maxMoveSpeed;
    	this.setOutputRange(-maxSpeed, maxSpeed);
    	
    	outputValid = false;
    	
    	super.enable();
    }
    
    public double returnPIDInput() {
    	return Robot.navigation.getDisplacement();  
    }

    protected void usePIDOutput(double output) {
    	this.output = output;
    	outputValid = true;
    }
    
    public double getOutput() {
    	if(this.getPIDController().isEnabled() == false || outputValid == false) {
    		return 0.0;
    	}
    	return output;
    }
    
	public boolean onRawTarget() {
		if (Math.abs(Robot.navigation.getDisplacement() - getPIDController().getSetpoint()) < distanceTolerance) {
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
