package org.usfirst.frc.team4486.robot.subsystems;

import org.usfirst.frc.team4486.robot.RobotMap;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class GearPickUp extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	Solenoid openSolenoid = new Solenoid(RobotMap.solenoidOpen);
	Solenoid closeSolenoid = new Solenoid(RobotMap.solenoidClose);
	Solenoid upSolenoid = new Solenoid(RobotMap.solenoidUp);
	Solenoid downSolenoid = new Solenoid(RobotMap.solenoidDown);
	
	public void up(){
		upSolenoid.set(true);
		downSolenoid.set(false);
		
	}
	
	
	public void down(){
	downSolenoid.set(true);
	upSolenoid.set(false);
	
	}
	
	public void open(){
		openSolenoid.set(true);
		closeSolenoid.set(false);
		

	}
	
	public void close(){
		closeSolenoid.set(true);
		openSolenoid.set(false);
	
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	
    }
}

