package org.usfirst.frc.team4486.robot.subsystems;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Navigation extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public static AHRS ahrs = null;
	
	public void init()
	{
		try
		{
			ahrs = new AHRS(SPI.Port.kMXP);
		}
		catch (RuntimeException ex)
		{
			DriverStation.reportError("Error instantiating navX MXP:  " + ex.getMessage(), true);
		}
		
	}
	
	public double getYaw()
	{
		return ahrs.getYaw();
	}
	
	public double getPitch()
	{
		return ahrs.getPitch();
	}
	
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

