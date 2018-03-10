/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team6014.robot.autonomous.commandgroups;

import edu.wpi.first.wpilibj.command.CommandGroup;

import org.usfirst.frc.team6014.robot.Robot;
import org.usfirst.frc.team6014.robot.autonomous.commands.TimedStraightDrive;

/**
 * This commandgroup is responsible for choosing a the set of behaviors of the robot according to the starting position
 */
public class AutoRunDecisionTreeMiddle extends CommandGroup {
	public AutoRunDecisionTreeMiddle() {
		String gameSwitchData = Robot.gameData.substring(0,2);
		if(gameSwitchData.length() > 0)
        {
			if(gameSwitchData.equals("RR"))
			{
				//If first switch and scale are at right side
			}
			else if(gameSwitchData.equals("LL"))
			{
				//If first switch and scale are at left side
			}
			else if(gameSwitchData.equals("LR"))
			{
				//If first switch is at left and the scale is at right side
			}
			else if(gameSwitchData.equals("RL"))
			{
				//If first switch is at right and scale is at left side
			}
			else
			{
				//There's goddamn error m8
				System.out.println("NO GAME DATA");
			}
			
		}
	}
}

