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
public class AutoScaleDecisionTreeLeft extends CommandGroup {
	public AutoScaleDecisionTreeLeft() {
		addSequential(new MechanismTurn(0.8, -0.4));
		String gameSwitchData = Robot.gameData.substring(1,2);
		if(gameSwitchData.length() > 0)
        {
			if(gameSwitchData.equals("R"))
			{
				addSequential(new DistanceStraightDrive(6.3,0.8,0));
				addSequential(new TurnToAngle(90,0.7,1.5));
				addSequential(new DistanceStraightDrive(6.3,0.8,90));
				addSequential(new TurnToAngle(0,0.7,1.5));
				addSequential(new DistanceStraightDrive(1.6,0.8,0));
				addSequential(new TurnToAngle(-90,0.7,1.5));
				addParallel(new RotateArm(180));
				addSequential(new Delay(2.0));
				addSequential(new Launch(0.5));
				addParallel(new RotateArm(110));
				addSequential(new Delay(1.0));
				addParallel(new RotateArm(60));
				addSequential(new Delay(1.0));
				addParallel(new RotateArm(10));
				addSequential(new Delay(1.0));
			}
			else if(gameSwitchData.equals("L"))
			{
				addSequential(new DistanceStraightDrive(8.20,0.8,0));
				addSequential(new TurnToAngle(90,0.7,1.5));
				addParallel(new RotateArm(180));
				addSequential(new Delay(2.0));
				addSequential(new Launch(0.5));
				addParallel(new RotateArm(110));
				addSequential(new Delay(1.0));
				addParallel(new RotateArm(60));
				addSequential(new Delay(1.0));
				addParallel(new RotateArm(10));
				addSequential(new Delay(1.0));
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

