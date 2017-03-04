package org.usfirst.frc.team4486.robot.subsystems;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.RobotDrive.MotorType;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.interfaces.Gyro;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.RobotDrive;

import org.usfirst.frc.team4486.robot.commands.*;
import org.usfirst.frc.team4486.robot.OI;
import org.usfirst.frc.team4486.robot.RobotMap;

import com.ctre.CANTalon;
/**
 *
 */
public class Drivetrain extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	RobotDrive robotDrive;
	private Gyro robotGyro;
	double Kp = 0.03;
	
	public Drivetrain(){
		//Gyro initialization
		robotGyro = new ADXRS450_Gyro();
		
		VictorSP fLeftChannel = new VictorSP(RobotMap.frontLeftChannel);
		VictorSP rLeftChannel = new VictorSP(RobotMap.rearLeftChannel);
		VictorSP fRightChannel = new VictorSP(RobotMap.frontRightChannel);
		VictorSP rRightChannel = new VictorSP(RobotMap.rearRightChannel);
		CANTalon midTake = new CANTalon(RobotMap.CONTINUOUS_MOTOR);
		
		robotDrive = new RobotDrive(fLeftChannel, rLeftChannel, fRightChannel, rRightChannel);
		
		robotDrive.setInvertedMotor(MotorType.kFrontRight, true);	// invert the left side motors
		robotDrive.setInvertedMotor(MotorType.kRearRight, true); 		// you may need to change or remove this to match your robot
		robotDrive.setMaxOutput(0.5);
		
	}
	
	public void drive(){
		robotDrive.mecanumDrive_Cartesian(OI.driverStick.getX(), OI.driverStick.getY(), OI.driverStick.getZ(), 0);
	/*if (robotDrive.isAlive())
		{
			
		} */
	} 
	public void driveStop(){
		robotDrive.setMaxOutput(0);
	}
	
	public void gyroAuto()
	{
		robotGyro.reset();
        double angle = robotGyro.getAngle(); // get current heading
        robotDrive.drive(-1.0, -angle*Kp); // drive towards heading 0
        Timer.delay(0.004);
	}
	
	public void autoDrive(double time){
		robotDrive.setMaxOutput(1);
		robotDrive.setLeftRightMotorOutputs(-1, -1);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new Drive());
    	
    }
}

