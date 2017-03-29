package org.usfirst.frc.team4486.robot.commands;

import org.usfirst.frc.team4486.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoDriveGyro extends Command {

    public AutoDriveGyro() {
        // Use requires() here to declare subsystem dependencies 
        // eg. requires(chassis);
    	requires(Robot.drivetrain);
    	requires(Robot.driveDistancePID);
    	requires(Robot.navigation);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.navigation.resetDisplacement();
    	
    	Robot.driveDistancePID.setSetpoint(0.5);
    	Robot.driveDistancePID.enable();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.drivetrain.arcadeAutoDrive(Robot.driveDistancePID.getOutput(), 0.0);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if(Robot.driveDistancePID.onRawTarget()){
        	return true;
        }
        else{
        	return false;
        }
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.driveDistancePID.disable();
    	Robot.drivetrain.drive();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
