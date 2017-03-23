package org.usfirst.frc.team4486.robot.subsystems;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
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
import org.usfirst.frc.team4486.robot.Robot;
import org.usfirst.frc.team4486.robot.RobotMap;

import com.ctre.CANTalon;
/**
 *
 */
public class Drivetrain extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	RobotDrive robotDrive;
	CANTalon midTake;
	PIDController gyroPID;
	PIDOutput gyroOutput;
	double kP = 0.06;
	double kI = 0.002;
	double kD = 0.2;
	double kF = 0;
	double setPoint;
	double yawTolerance = 2.0;
	
	public Drivetrain(){
		//Gyro initialization
		
		VictorSP fLeftChannel = new VictorSP(RobotMap.frontLeftChannel);
		VictorSP rLeftChannel = new VictorSP(RobotMap.rearLeftChannel);
		VictorSP fRightChannel = new VictorSP(RobotMap.frontRightChannel);
		VictorSP rRightChannel = new VictorSP(RobotMap.rearRightChannel);
		midTake = new CANTalon(RobotMap.CONTINUOUS_MOTOR);
		
		robotDrive = new RobotDrive(fLeftChannel, rLeftChannel, fRightChannel, rRightChannel);
		
		robotDrive.setInvertedMotor(MotorType.kFrontRight, true);	// invert the left side motors //originally true
		robotDrive.setInvertedMotor(MotorType.kRearRight, true); //Originally true
		//robotDrive.setInvertedMotor(MotorType.kFrontLeft, true);
		//robotDrive.setInvertedMotor(MotorType.kRearRight, true); // you may need to change or remove this to match your robot
		robotDrive.setMaxOutput(0.5);
		gyroPID = new PIDController(kP, kI, kD, 500, Robot.navigation.ahrs, gyroOutput);
		gyroPID.setAbsoluteTolerance(yawTolerance);
		
	}
	
	public void drive(){
		//if (Math.abs(OI.driverStick.getY()) < 0.1 || Math.abs(OI.driverStick.getX()) < 0.1 || Math.abs(OI.driverStick.getZ())< 0.1)
		//{
			//robotDrive.mecanumDrive_Cartesian(0, 0, 0, 0);
		//}
		//else 
		//{
			if(OI.turboButton.get())
			{
				robotDrive.setMaxOutput(1);
			}
			else{
			robotDrive.mecanumDrive_Cartesian(OI.driverStick.getX(), OI.driverStick.getY(), OI.driverStick.getZ(), 0);
			}
		}
 
	
	public void driveStop(){
		robotDrive.setMaxOutput(0);
	}
	
	public void autoDrive(){
		robotDrive.setInvertedMotor(MotorType.kFrontLeft, false);
		robotDrive.setInvertedMotor(MotorType.kRearLeft, false);
		robotDrive.setInvertedMotor(MotorType.kFrontRight, false);
		robotDrive.setInvertedMotor(MotorType.kRearRight, false);
		robotDrive.setMaxOutput(1);
		robotDrive.setLeftRightMotorOutputs(-1, -1);
		//robotDrive.stopMotor();
	}
	
	public void stopAutoDrive(){
		robotDrive.stopMotor();
	}
	
	public void sweeperRun()
	{
		midTake.set(1);
	}
	
	public void arcadeAutoDrive(double driveSpeed, double angle)
	{
		robotDrive.setInvertedMotor(MotorType.kFrontLeft, false);
		robotDrive.setInvertedMotor(MotorType.kRearLeft, false);
		robotDrive.setInvertedMotor(MotorType.kFrontRight, false);
		robotDrive.setInvertedMotor(MotorType.kRearRight, false);
		robotDrive.arcadeDrive(driveSpeed, angle);
	}
	
	public void beginYawPID(){
		gyroPID.enable();
		
	}


    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new Drive());
    	
    }
}

