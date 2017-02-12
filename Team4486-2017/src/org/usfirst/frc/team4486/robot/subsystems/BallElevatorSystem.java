package org.usfirst.frc.team4486.robot.subsystems;

import org.usfirst.frc.team4486.robot.RobotMap;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class BallElevatorSystem extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	VictorSP eMotor = new VictorSP(RobotMap.ELEVATOR_MOTOR);
	
	public void actuateElevator()
	{
		eMotor.setSpeed(1);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

