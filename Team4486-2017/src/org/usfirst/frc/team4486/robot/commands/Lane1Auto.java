package org.usfirst.frc.team4486.robot.commands;


import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Lane1Auto extends CommandGroup {

    public Lane1Auto() {
    	addSequential(new AutoDrive(2.25));
    	addSequential(new Delay(1));
    	addSequential(new DriveUntillZeroYaw(45));
    	addSequential(new AutoDrive(0.2));
    }
}
