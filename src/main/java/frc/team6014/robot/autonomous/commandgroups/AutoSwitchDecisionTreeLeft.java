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
import frc.team6014.robot.autonomous.commands.DropArm;
import frc.team6014.robot.autonomous.commands.Intake;
import frc.team6014.robot.autonomous.commands.LiftArm;

/**
 * This commandgroup is responsible for choosing a the set of behaviors of the robot according to the starting position
 */
public class AutoSwitchDecisionTreeLeft extends CommandGroup {
	public AutoSwitchDecisionTreeLeft() {
		addSequential(new TimedStraightDrive(1.7,-0.8,0));
		String gameSwitchData = Robot.gameData.substring(0,1);
		if(gameSwitchData.length() > 0)
		{
			if(gameSwitchData.equals("R"))
			{
				//If first switch and scale are at right side

				//-90 sağ mı sol mu?
				//Tan ilk otonom denemesinde değere ne vermişti?


				addSequential(new TimedStraightDrive(0.7,-0.8,0));
				addSequential(new TurnToAngle(-90,-0.6,2));
				addSequential(new TimedStraightDrive(1.6,-0.8,0));
				addSequential(new TurnToAngle(-90,-0.6,2));
				addSequential(new TimedStraightDrive(0.15,-0.4,0));
				addSequential(new Launch(0.7));
				//Test First Do the Adjustments


				//Take an other cube
				/*
				addSequential(new TimedStraightDrive(0.15,0.4,0));
				addSequential(new DropArm(0.5));

				//Other Option	//addSequential(new DropArm(0.5,0.5));

				addSequential(new TurnToAngle(-45,-0.6,2));
				addSequential(new TimedStraightDrive(0.3,-0.4,0));
				addSequential(new Intake(0.6));
				 */


				//Bringing the cube to portal
				/*
				addSequential(new LiftArm(3));
				addSequential(new TimedStraightDrive(0.3,0.4,0));
				addSequential(new TurnToAngle(90,-0.6,3));
				addSequential(new Intake(0.1));
				addSequential(new TimedStraightDrive(1.6,-0.8,0));
				addSequential(new TurnToAngle(180,-0.6,2));
				addSequential(new Intake(0.1));
				addSequential(new TimedStraightDrive(1.7,-0.8,0));
				addSequential(new TurnToAngle(90,-0.6,2));
				addSequential(new TimedStraightDrive(0.7,-0.8,0));
				addSequential(new TurnToAngle(-90,-0.6,2));
				//When it is done robot should be facing the portal
				 */


			}
			else if(gameSwitchData.equals("L"))
			{
				//If first switch and scale are at left side
				addSequential(new TurnToAngle(-90,-0.6,2));
				addSequential(new TimedStraightDrive(0.2,-0.4,0));
				addSequential(new Launch(0.7));


				//Take an other cube
				/*
				addSequential(new TimedStraightDrive(0.2,0.4,0));
				addSequential(new TurnToAngle(-90,0.6,2));
				addSequential(new DropArm(0.5));

				//Other Option	//addSequential(new DropArm(0.5,0.5));

				addSequential(new TimedStraightDrive(0.7,-0.8,0));
				addSequential(new TurnToAngle(-90,-0.6,2));
				addSequential(new TimedStraightDrive(0.4,-0.8,0));
				addSequential(new TurnToAngle(-90,-0.6,2));
				addSequential(new TimedStraightDrive(0.4,-0.4,0));
				addSequential(new Intake(0.6));
				addSequential(new LiftArm(3));
				 */


				//Throw the other cube
				/*
				addSequential(new TimedStraightDrive(0.2,0.4,0));
				addSequential(new TimedStraightDrive(0.3,-0.4,30));
				addSequential(new Launch(0.6));
				*/


			}
			else
			{
				//There's goddamn error m8
				System.out.println("NO GAME DATA");
				addSequential(new TimedStraightDrive(2,0.8,0));
			}
		}
	}
}

