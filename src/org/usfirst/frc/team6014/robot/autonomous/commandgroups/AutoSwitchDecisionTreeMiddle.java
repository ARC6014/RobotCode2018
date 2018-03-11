/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team6014.robot.autonomous.commandgroups;

import edu.wpi.first.wpilibj.command.CommandGroup;

import org.usfirst.frc.team6014.robot.Robot;
import org.usfirst.frc.team6014.robot.autonomous.commands.DistanceStraightDrive;
import org.usfirst.frc.team6014.robot.autonomous.commands.Launch;
import org.usfirst.frc.team6014.robot.autonomous.commands.RotateArm;
import org.usfirst.frc.team6014.robot.autonomous.commands.TimedStraightDrive;
import org.usfirst.frc.team6014.robot.autonomous.commands.TurnToAngle;

/**
 * This commandgroup is responsible for choosing a the set of behaviors of the robot according to the starting position
 */
public class AutoSwitchDecisionTreeMiddle extends CommandGroup {
	public AutoSwitchDecisionTreeMiddle() {
		String gameSwitchData = Robot.gameData.substring(0,2);
		if(gameSwitchData.length() > 0)
        {
			if(gameSwitchData.equals("RR"))
			{
				//If first switch and scale are at right side
				addSequential(new DistanceStraightDrive(2-Robot.robotLength,0.8,0));
				addSequential(new TurnToAngle(90,0.6));
				addSequential(new DistanceStraightDrive(1.4,0.8,90));
				addSequential(new TurnToAngle(0,0.6));
				addParallel(new RotateArm(40));
				addSequential(new DistanceStraightDrive(1.6,0.8,0));
				addSequential(new Launch(0.5));
				addSequential(new DistanceStraightDrive(-0.3,0.8,0));
				addParallel(new RotateArm(10));
			}
			else if(gameSwitchData.equals("LL"))
			{
				//If first switch and scale are at left side
				addSequential(new DistanceStraightDrive(2-Robot.robotLength,0.8,0));
				addSequential(new TurnToAngle(-90,0.6));
				addSequential(new DistanceStraightDrive(1.4,0.8,-90));
				addSequential(new TurnToAngle(0,0.6));
				addParallel(new RotateArm(40));
				addSequential(new DistanceStraightDrive(1.6,0.8,0));
				addSequential(new Launch(0.5));
				addSequential(new DistanceStraightDrive(-0.3,0.8,0));
				addParallel(new RotateArm(10));
			}
			else if(gameSwitchData.equals("LR"))
			{
				//If first switch is at left and the scale is at right side
				addSequential(new DistanceStraightDrive(2-Robot.robotLength,0.8,0));
				addSequential(new TurnToAngle(-90,0.6));
				addSequential(new DistanceStraightDrive(1.4,0.8,-90));
				addSequential(new TurnToAngle(0,0.6));
				addParallel(new RotateArm(40));
				addSequential(new DistanceStraightDrive(1.6,0.8,0));
				addSequential(new Launch(0.5));
				addSequential(new DistanceStraightDrive(-0.3,0.8,0));
				addParallel(new RotateArm(10));
			}
			else if(gameSwitchData.equals("RL"))
			{
				//If first switch is at right and scale is at left side
				addSequential(new DistanceStraightDrive(2-Robot.robotLength,0.8,0));
				addSequential(new TurnToAngle(90,0.6));
				addSequential(new DistanceStraightDrive(1.4,0.8,90));
				addSequential(new TurnToAngle(0,0.6));
				addParallel(new RotateArm(40));
				addSequential(new DistanceStraightDrive(1.6,0.8,0));
				addSequential(new Launch(0.5));
				addSequential(new DistanceStraightDrive(-0.3,0.8,0));
				addParallel(new RotateArm(10));
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

