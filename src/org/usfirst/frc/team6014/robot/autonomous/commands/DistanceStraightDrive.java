/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team6014.robot.autonomous.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team6014.robot.Robot;

/**
 * An example command.  You can replace me with your own command.
 */
public class DistanceStraightDrive extends Command {
	private static final double linearDiff = 0.3;
	
	double speed,angle,distance,initPos;
	public DistanceStraightDrive(double distance, double speed, double angle) {
		requires(Robot.motionController);
		requires(Robot.drive);
		this.speed = speed;
		this.angle = angle;
		this.distance = distance-linearDiff;
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		Robot.motionController.setAngle(angle);
		Robot.motionController.enable();
		initPos = Robot.perception.getRightDistance();
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		Robot.motionController.pidDrive(speed);
	}
	
	@Override
	protected boolean isFinished() {
		return (Robot.perception.getRightDistance()-initPos)>distance;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		Robot.drive.arcadeDrive(0, 0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		Robot.drive.arcadeDrive(0, 0);
	}
}
