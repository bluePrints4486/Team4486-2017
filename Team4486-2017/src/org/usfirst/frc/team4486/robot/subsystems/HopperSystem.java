package org.usfirst.frc.team4486.robot.subsystems;

import org.usfirst.frc.team4486.robot.RobotMap;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class HopperSystem extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	Solenoid hOpen = new Solenoid(RobotMap.HOPPER_OPEN);
	Solenoid hClose = new Solenoid(RobotMap.HOPPER_CLOSE);
	
	public void openHopper()
	{
		hOpen.set(true);
		hClose.set(false);
	}
	
	public void closeHopper()
	{
		hClose.set(true);
		hOpen.set(false);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

