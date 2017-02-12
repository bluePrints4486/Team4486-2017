package org.usfirst.frc.team4486.robot.subsystems;

import org.usfirst.frc.team4486.robot.OI;
import org.usfirst.frc.team4486.robot.RobotMap;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class WinchSystem extends Subsystem {

	RobotDrive winchObject;
	public WinchSystem()
	{
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	VictorSP topMotor = new VictorSP(RobotMap.WINCHMOTOR_TOP);
	VictorSP bottomMotor = new VictorSP(RobotMap.WINCHMOTOR_BOTTOM);
	
	//Using the RobotDrive constructor in order to be able to exert variable control over the winch (i'll find the right way soon)
	winchObject = new RobotDrive(topMotor, bottomMotor);
	winchObject.setMaxOutput(1);
	}
	
	public void winchActuate()
	{
		winchObject.arcadeDrive(OI.manipulatorJoystick.getX(), 0);
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

