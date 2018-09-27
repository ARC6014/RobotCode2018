/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.team6014.robot.autonomous.commandgroups;

import edu.wpi.first.wpilibj.command.CommandGroup;

import frc.team6014.robot.Robot;
import frc.team6014.robot.autonomous.commands.TurnToAngle;

/**
 * This commandgroup tests the robot's turning capabilities by making it turn 90 degrees.
 */
public class TurnTest extends CommandGroup {
    public TurnTest() {
        addSequential(new TurnToAngle(90,0.6,1));
    }
}

