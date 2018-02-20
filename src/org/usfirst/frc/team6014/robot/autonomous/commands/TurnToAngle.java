/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team6014.robot.autonomous.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team6014.robot.Robot;

public class TurnToAngle extends Command {
	
	private double angle;
	
	public TurnToAngle(double angle) {
		requires(Robot.pigeonController);
		requires(Robot.drive);
		this.angle = angle;
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		Robot.pigeonController.setAngle(angle);
		Robot.pigeonController.enable();
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		Robot.pigeonController.pidDrive(0);
	}
	
	@Override
	protected boolean isFinished() {
		return false;
	}

}
