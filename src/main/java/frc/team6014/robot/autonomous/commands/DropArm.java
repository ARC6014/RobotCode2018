/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.team6014.robot.autonomous.commands;

import edu.wpi.first.wpilibj.command.Command;

import frc.team6014.robot.Robot;

public class DropArm extends Command {
	
	private double angle;
	
	public DropArm() {
		requires(Robot.arm);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		Robot.arm.drop();
		Robot.arm.enable();
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		Robot.arm.hingePID();
	}
	
	@Override
	protected boolean isFinished() {
		return Robot.arm.getCurrentAngle() < 20;
	}

}
