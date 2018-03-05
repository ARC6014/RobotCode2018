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
		requires(Robot.motionController);
		requires(Robot.drive);
		this.angle = angle;
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		Robot.motionController.setAngle(angle);
		Robot.motionController.enable();
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		Robot.motionController.pidDrive(0);
	}
	
	@Override
	protected boolean isFinished() {
		return Robot.motionController.onTarget();
	}
	
	@Override
	protected void end() {
		Robot.motionController.disable();
		Robot.drive.arcadeDrive(0, 0);
	}
}
