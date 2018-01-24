/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team6014.robot.subsystems;

import org.usfirst.frc.team6014.robot.RobotMap;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * A subsystem for controlling the ramp/lifters of the robot.
 */
public class Ramp extends Subsystem {
	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	
	SpeedController leftRamp = RobotMap.leftRampEnum.generate(RobotMap.leftRamp);
	SpeedController rightRamp = RobotMap.rightRampEnum.generate(RobotMap.rightRamp);
	SpeedController release = RobotMap.releaseEnum.generate(RobotMap.release);	
	SpeedControllerGroup ramp = new SpeedControllerGroup(leftRamp,rightRamp);

	@Override
	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
}
