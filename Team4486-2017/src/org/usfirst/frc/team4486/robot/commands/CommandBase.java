package org.usfirst.frc.team4486.robot.commands;


import edu.wpi.first.wpilibj.command.Command;

//Test

public abstract class CommandBase extends Command {

	
	protected double expireTime = 0;
	
	public CommandBase() {	
	}

	public static void init() {

	}
	
	/*
	 * The startTimer and isTimerExpired methods of the Command class only work for times
	 * relative to the start of the initialization. Specifically, if you call
	 * startTimer(3 seconds) 2 seconds after your command initialized, isTimerExpired
	 * becomes true 1 second later.
	 * 
	 * Because we want the ability to set a timer that expires relative to when
	 * the timer was set, the methods setTimer and isTimerExpired create that
	 * functionality.
	 */
	protected void startTimer(double seconds) {
		expireTime = timeSinceInitialized() + seconds;
	}
	
	protected boolean isTimerExpired() {
		return (timeSinceInitialized() >= expireTime);
	}
}

