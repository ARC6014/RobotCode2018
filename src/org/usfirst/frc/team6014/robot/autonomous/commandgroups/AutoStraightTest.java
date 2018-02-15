/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team6014.robot.autonomous.commandgroups;

import edu.wpi.first.wpilibj.command.CommandGroup;

import org.usfirst.frc.team6014.robot.autonomous.commands.*;

/**
 * An example command.  You can replace me with your own command.
 */
public class AutoStraightTest extends CommandGroup {
	public AutoStraightTest() {
		addSequential(new TimedStraightDrive(5.0,0.8,0));
		addSequential(new TurnToAngle(90));
		addSequential(new TimedStraightDrive(3.0,0.8,90));
		addSequential(new TurnToAngle(180));
		addSequential(new TimedStraightDrive(3.0,0.8,180));
		addSequential(new TurnToAngle(270));
		addSequential(new TimedStraightDrive(3.0,0.8,270));
		addSequential(new TurnToAngle(0));
	}
}
