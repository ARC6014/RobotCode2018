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
	private double speed;
	
	public TurnToAngle(double angle, double rotationSpeed) {
		requires(Robot.motionController);
		requires(Robot.drive);
		this.speed = rotationSpeed;
		this.angle = angle;
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		Robot.drive.setMaxOutput(Robot.drive.maxSpeed*speed);
		Robot.motionController.setAngle(angle);
		Robot.motionController.enable();
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		Robot.drive.arcadeDrive(0, 0);
		Robot.motionController.pidDrive(0);
	}
	
	@Override
	protected boolean isFinished() {
		return Robot.motionController.onTarget();
	}
	
	@Override
	protected void interrupted() {
		Robot.motionController.disable();
		Robot.drive.arcadeDrive(0, 0);
	}
	
	@Override
	protected void end() {
		Robot.motionController.disable();
		Robot.drive.arcadeDrive(0, 0);
	}
}
