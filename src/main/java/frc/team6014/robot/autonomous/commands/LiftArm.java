/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.team6014.robot.autonomous.commands;

import edu.wpi.first.wpilibj.command.TimedCommand;

import frc.team6014.robot.Robot;


public class LiftArm extends TimedCommand {
	
	public LiftArm (double duration) {
		super(duration);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		Robot.arm.setHingeSpeed(-0.5);
	}
	
	@Override
	protected void interrupted() {
		Robot.arm.setHingeSpeed(0);
		//if (Robot.arm.getCurrentAngle() < 70) { //I gave an aproximate value since ı don't know the real one
		//	LiftArm(3);
		//}
	}
	
	@Override
	protected void end() {
		Robot.arm.setHingeSpeed(0);
	}
}
