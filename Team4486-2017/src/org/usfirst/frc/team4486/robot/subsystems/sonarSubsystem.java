package org.usfirst.frc.team4486.robot.subsystems;

import org.usfirst.frc.team4486.robot.RobotMap;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */

public class sonarSubsystem extends Subsystem {
 
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public static AnalogInput sonarSerial;
	double distance;
	double voltage;
	
	public sonarSubsystem()
	{
		sonarSerial = new AnalogInput(RobotMap.sonarPort);
	}
	public double getSonarDistance()
	{
		distance = (sonarSerial.getVoltage()/ 5120.0);
		return distance;
	}
	
	public double getSonarVoltage()
	{
		voltage = sonarSerial.getVoltage();
		return voltage;
	}
	
	/*
	public double getSonarDistance()
	{
		String buffer;
		double distance;
		
		
		
		try{
			if(sonarSerial.getBytesReceived() > 10){
				//sonarSerial.enableTermination();
				buffer = sonarSerial.readString();
				distance = Double.parseDouble(buffer.substring(buffer.indexOf('R')+1, buffer.indexOf('R')+5));
				lastValue = distance;
				System.out.println("-----------------------------------------------------");
				return distance;
			}
			else{
					
				return lastValue;
			}
		} catch (RuntimeException e){
			System.out.println("Serial Failure");
			return lastValue;
		}
		
		
		
	} */
	
	public void sonarSmartDashboardUpdate()
	{
		SmartDashboard.putNumber("Sonar Distance: ", getSonarDistance());
		SmartDashboard.putNumber("Raw Sonar Voltage", getSonarVoltage());
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

