/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team6014.robot.autonomous.commandgroups;

import edu.wpi.first.wpilibj.command.CommandGroup;

import org.usfirst.frc.team6014.robot.autonomous.commands.TimedDrive;

/**
 * An example command.  You can replace me with your own command.
 */
public class AutoTest extends CommandGroup {
	public AutoTest() {
		addSequential(new TimedDrive(7,0.5,0));
		addSequential(new TimedDrive(3.5,0,-0.5));
		addSequential(new TimedDrive(5,0.5,0));
		addSequential(new TimedDrive(3600,0,0));
	}
}
