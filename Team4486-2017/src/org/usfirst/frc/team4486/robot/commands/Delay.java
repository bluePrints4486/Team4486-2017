package org.usfirst.frc.team4486.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Delay extends CommandBase{

	double timeOut;
	
    public Delay(double seconds) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	timeOut = seconds;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	this.startTimer(timeOut);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return this.isTimerExpired();
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
