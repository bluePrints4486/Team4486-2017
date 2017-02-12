package org.usfirst.frc.team4486.robot.subsystems;

import org.usfirst.frc.team4486.robot.RobotMap;
import org.usfirst.frc.team4486.robot.commands.IntakeStop;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class IntakeSystem extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	VictorSP leftIntake = new VictorSP(RobotMap.INTAKE_LEFT);
	VictorSP rightIntake = new VictorSP(RobotMap.INTAKE_RIGHT);
	
	
	public void intakeGo()
	{
		leftIntake.set(1);
		rightIntake.set(-1);
	}
	
	public void intakeStop()
	{
		leftIntake.set(0);
		rightIntake.set(0);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new IntakeStop());
    }
}

