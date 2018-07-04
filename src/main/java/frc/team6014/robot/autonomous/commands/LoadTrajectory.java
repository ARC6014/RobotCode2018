/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.team6014.robot.autonomous.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.TimedCommand;

import frc.team6014.robot.Robot;

public class LoadTrajectory extends Command {
	//Trajectory.Config config = new Trajectory.Config(Trajectory.FitMethod.HERMITE_CUBIC, Trajectory.Config.SAMPLES_HIGH, 0.05, 1.7,2.0,60.0);
	boolean isFinished = false;
	public LoadTrajectory(double duration) {
		super(duration);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
	}
	
	@Override
	protected boolean isFinished() {
		return isFinished;
	}
	
	@Override
	protected void interrupted() {
	}
	
	@Override
	protected void end() {
	}
}
