
package org.usfirst.frc.team4486.robot;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.vision.VisionThread;

import org.opencv.core.Rect;
import org.opencv.imgproc.Imgproc;
import org.usfirst.frc.team4486.robot.commands.Lane1And3Auto;
import org.usfirst.frc.team4486.robot.commands.Lane2Auto;
import org.usfirst.frc.team4486.robot.commands.Lane3Auto;
import org.usfirst.frc.team4486.robot.commands.Lane1Auto;
import org.usfirst.frc.team4486.robot.subsystems.*;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static GearPickUp gearPickUp = new GearPickUp();
	public static Drivetrain drivetrain = new Drivetrain();	
	public static WinchSystem winchSystem = new WinchSystem();
	public static IntakeSystem intakeSystem = new IntakeSystem();
	public static BallElevatorSystem ballElevatorSystem = new BallElevatorSystem();
	public static HopperSystem hopperSystem = new HopperSystem();
	public static Navigation navigation = new Navigation();
	public static NavigationYawPID navigationYawPID = new NavigationYawPID();
	public static sonarSubsystem sonarsubsystem = new sonarSubsystem();
	public static DriveDistancePID driveDistancePID = new DriveDistancePID();
	
	public static CameraServer currSession;
	


	public static OI oi; 




	
	Command autonomousCommand = new Lane2Auto();
	
	private VisionThread visionThread;
	private static final int IMG_WIDTH = 320;
	private static final int IMG_HEIGHT = 240;
	private double centerX = 0.0;
	private final Object imgLock = new Object();

	//SendableChooser<Command> chooser = new SendableChooser<>();

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		oi = new OI();
		Vision.StartVisionThread(); // Camera switcher thread
		
		autonomousCommand = new Lane2Auto();
	    UsbCamera camera = CameraServer.getInstance().startAutomaticCapture();
	    camera.setResolution(IMG_WIDTH, IMG_HEIGHT);
	    
	    visionThread = new VisionThread(camera, new GripPipeline(), pipeline -> {
	        if (!pipeline.filterContoursOutput().isEmpty()) {
	            Rect r = Imgproc.boundingRect(pipeline.filterContoursOutput().get(0));
	            synchronized (imgLock) {
	                centerX = r.x + (r.width / 2);
	            }
	        }
	    });
	    visionThread.start();
	        
	    //drive = new RobotDrive(1, 2);
		
		
		//Testing using the autonomous chooser. Avoid smart dashboard.
		//chooser.addDefault("Middle Timed Drive", new GyroEnabledAuto());
		//chooser.addObject("Test Auto (GYRO)", new Auto2());
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {
		

	}

	@Override
	public void disabledPeriodic() {
		
		if(OI.lane1_autobutton.get()){
			autonomousCommand = new Lane1Auto();
		}
		
		if(OI.lane2_autobutton.get()){
			autonomousCommand = new Lane2Auto();
		}
		
		if(OI.lane3_autobutton.get()){
			autonomousCommand = new Lane3Auto();
		}
		
		
		
		Scheduler.getInstance().run();
		
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		//autonomousCommand = chooser.getSelected();

		/*
		 * String autoSelected = SmartDashboard.getString("Auto Selector",
		 * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
		 * = new MyAutoCommand(); break; case "Default Auto": default:
		 * autonomousCommand = new ExampleCommand(); break; }
		 */

		// schedule the autonomous command (example)
		if (autonomousCommand != null)
			autonomousCommand.start();
	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
		double centerX;
		synchronized (imgLock) {
			centerX = this.centerX;
		}
		double turn = centerX - (IMG_WIDTH / 2);
		drivetrain.arcadeAutoDrive(-0.6, turn * 0.005);
	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (autonomousCommand != null)
			autonomousCommand.cancel();
	}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		navigation.navXSmartDashboardUpdates();
		sonarsubsystem.sonarSmartDashboardUpdate();
		 
	}

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
}
