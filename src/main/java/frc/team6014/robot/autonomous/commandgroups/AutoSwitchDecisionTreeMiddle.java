/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.team6014.robot.autonomous.commandgroups;

import edu.wpi.first.wpilibj.command.CommandGroup;

import frc.team6014.robot.Robot;
import frc.team6014.robot.autonomous.commands.Delay;
import frc.team6014.robot.autonomous.commands.DistanceStraightDrive;
import frc.team6014.robot.autonomous.commands.Launch;
import frc.team6014.robot.autonomous.commands.RotateArm;
import frc.team6014.robot.autonomous.commands.TimedStraightDrive;
import frc.team6014.robot.autonomous.commands.TurnToAngle;

/**
 * This commandgroup is responsible for choosing a the set of behaviors of the robot according to the starting position
 */
public class AutoSwitchDecisionTreeMiddle extends CommandGroup {
	public AutoSwitchDecisionTreeMiddle() {
		String gameSwitchData = Robot.gameData.substring(0,1);
		if(gameSwitchData.length() > 0)
        {
			if(gameSwitchData.equals("R"))
			{
				//If first switch and scale are at right side
				addSequential(new DistanceStraightDrive(2-Robot.robotLength,0.8,0));
				addSequential(new TurnToAngle(90,0.6,2));
				addSequential(new DistanceStraightDrive(1.4,0.8,90));
			}
				else if(gameSwitchData.equals("L"))
			{
				//If first switch and scale are at left side
				addSequential(new DistanceStraightDrive(2-Robot.robotLength,0.8,0));
				addSequential(new TurnToAngle(-90,0.6,2));
				addSequential(new DistanceStraightDrive(1.4,0.8,-90));
			}
			else
			{
				//There's goddamn error m8
				addSequential(new DistanceStraightDrive(3-Robot.robotLength,0.8,0));
				System.out.println("NO GAME DATA");
			}
			
		}
	}
}

