/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team6014.robot.autonomous.commandgroups;

import edu.wpi.first.wpilibj.command.CommandGroup;

import org.usfirst.frc.team6014.robot.Robot;
import org.usfirst.frc.team6014.robot.autonomous.commands.Delay;
import org.usfirst.frc.team6014.robot.autonomous.commands.DistanceStraightDrive;
import org.usfirst.frc.team6014.robot.autonomous.commands.Launch;
import org.usfirst.frc.team6014.robot.autonomous.commands.MechanismTurn;
import org.usfirst.frc.team6014.robot.autonomous.commands.RotateArm;
import org.usfirst.frc.team6014.robot.autonomous.commands.TimedStraightDrive;
import org.usfirst.frc.team6014.robot.autonomous.commands.TurnToAngle;

/**
 * This commandgroup is responsible for choosing a the set of behaviors of the robot according to the starting position
 */
public class AutoSwitchDecisionTreeRight extends CommandGroup {
	public AutoSwitchDecisionTreeRight() {
		addSequential(new MechanismTurn(0.8, -0.4));
		String gameSwitchData = Robot.gameData.substring(0,1);
		if(gameSwitchData.length() > 0)
        {
			if(gameSwitchData.equals("R"))
			{
				//If first switch at right side
				addSequential(new DistanceStraightDrive(3.8-Robot.robotLength,0.8,0));
				addSequential(new TurnToAngle(-90,0.6,2));
				addParallel(new RotateArm(Robot.switchAngle));
				addSequential(new Delay(1.5));
				addSequential(new DistanceStraightDrive(1.2,0.6,-90));
				addSequential(new Launch(1.0));
				addSequential(new DistanceStraightDrive(-0.3,-0.6,-90));
				addParallel(new RotateArm(10));
			}
			else if(gameSwitchData.equals("L"))
			{
				//If first switch at left side
				addSequential(new DistanceStraightDrive(5.2-Robot.robotLength,0.8,0));
				addSequential(new TurnToAngle(-90,0.6,1.5));
				addSequential(new DistanceStraightDrive(4.4,0.8,-90));
				addSequential(new TurnToAngle(-180,0.6,1.5));
				addSequential(new DistanceStraightDrive(1.6,0.8,-180));
				addSequential(new TurnToAngle(90,0.6,1.5));
				addParallel(new RotateArm(Robot.switchAngle));
				addSequential(new Delay(1.5));
				addSequential(new DistanceStraightDrive(0.8,0.6,90));
				addSequential(new Launch(1.0));
				addSequential(new DistanceStraightDrive(-0.3,-0.6,90));
				addParallel(new RotateArm(Robot.switchAngle));
			}
			else
			{
				//There's goddamn error m8
				System.out.println("NO GAME DATA");
				addSequential(new DistanceStraightDrive(3-Robot.robotLength,0.8,0));
			}
		}
	}
}

