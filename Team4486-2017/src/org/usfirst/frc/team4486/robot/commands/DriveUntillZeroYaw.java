package org.usfirst.frc.team4486.robot.commands;

import org.usfirst.frc.team4486.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveUntillZeroYaw extends Command {
	
	private int m_angle;

	// I added another constructor to this command that takes in an angle
	// as a parameter to make auto coding a bit easier. i left the old constuctor
	// for compatability
    public DriveUntillZeroYaw(int angle) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.navigationYawPID);
    	requires(Robot.drivetrain);
    	requires(Robot.navigation);
    	
    	this.m_angle = angle;
    }
    
    public DriveUntillZeroYaw() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.navigationYawPID);
    	requires(Robot.drivetrain);
    	requires(Robot.navigation);
    	
    	this.m_angle = 45;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.navigation.resetYaw();
    	Robot.navigationYawPID.enable();
    	Robot.navigationYawPID.setSetpoint(m_angle);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.drivetrain.arcadeAutoDrive(0.0, Robot.navigationYawPID.getOutput());
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if(Robot.navigationYawPID.onRawTarget()){
    		return true;
    	}
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.navigationYawPID.disable();
    	Robot.navigationYawPID.setSetpoint(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
