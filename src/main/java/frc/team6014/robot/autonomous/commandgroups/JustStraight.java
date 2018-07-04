/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.team6014.robot.autonomous.commandgroups;

import edu.wpi.first.wpilibj.command.CommandGroup;

import frc.team6014.robot.Robot;
import frc.team6014.robot.autonomous.commands.*;

/**
 * An example command.  You can replace me with your own command.
 */
public class JustStraight extends CommandGroup {
	public JustStraight() {
		addSequential(new TimedStraightDrive(1.6,0.8,0));
	}
}
