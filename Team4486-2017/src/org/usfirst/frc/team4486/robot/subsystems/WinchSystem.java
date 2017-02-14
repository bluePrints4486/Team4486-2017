package org.usfirst.frc.team4486.robot.subsystems;

import org.usfirst.frc.team4486.robot.OI;
import org.usfirst.frc.team4486.robot.RobotMap;
import org.usfirst.frc.team4486.robot.commands.WinchStop;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class WinchSystem extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	//htst
	VictorSP topMotor = new VictorSP(RobotMap.WINCHMOTOR_TOP);
	VictorSP bottomMotor = new VictorSP(RobotMap.WINCHMOTOR_BOTTOM); 
	
	//Using the RobotDrive constructor in order to be able to exert variable control over the winch (i'll find the right way soon)
	
	public void winchActuate()
	{
		topMotor.set(-1);
		bottomMotor.set(-1);
	}
	
	public void winchStop()
	{
		topMotor.set(0);
		bottomMotor.set(0);
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new WinchStop());
    }
}

