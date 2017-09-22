package org.usfirst.frc.team4486.robot.commands;

import org.usfirst.frc.team4486.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class BackwardAutoDrive extends Command {

	private double m_timeout;
    public BackwardAutoDrive(double timeout) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	m_timeout = timeout;
    	requires(Robot.drivetrain);
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	setTimeout(m_timeout);
    	Robot.drivetrain.backwardsAutoDrive();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() 
    {
        	Robot.drivetrain.backwardsAutoDrive(); 
    }
    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.drivetrain.stopAutoDrive();
    	//Robot.drivetrain.changeToMecanum();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
