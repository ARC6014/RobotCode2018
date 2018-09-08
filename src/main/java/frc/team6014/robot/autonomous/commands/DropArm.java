/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.team6014.robot.autonomous.commands;

import edu.wpi.first.wpilibj.command.TimedCommand;

import frc.team6014.robot.Robot;

public class DropArm extends TimedCommand {

	public DropArm(double duration) {
		super(duration);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		Robot.arm.setHingeSpeed(0.5);
	}

	@Override
	protected void interrupted() {
		Robot.arm.setHingeSpeed(0);
	}

	@Override
	protected void end() {
		Robot.arm.setHingeSpeed(0);
	}
}
