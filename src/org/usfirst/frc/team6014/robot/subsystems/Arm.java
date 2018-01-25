/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team6014.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * A subsystem for controlling the arm and its components.
 */
public class Arm extends Subsystem {
	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	
	SpeedController leftHinge = RobotMap.leftHingeEnum.generate(RobotMap.leftHinge);
	SpeedController rightHinge = RobotMap.rightHingeEnum.generate(RobotMap.rightHinge);	
	SpeedControllerGroup hinge = new SpeedControllerGroup(leftHinge,rightHinge);
	
	SpeedController leftArm = RobotMap.leftArmEnum.generate(RobotMap.leftArm);
	SpeedController rightArm = RobotMap.rightArmEnum.generate(RobotMap.rightArm);	
	SpeedControllerGroup arm = new SpeedControllerGroup(leftArm,rightArm);
	
	double pulsesPerRevolution = 7.0;
	double distancePerPulse = 2*Math.PI/pulsesPerRevolution;
	leftHingeEncoder.setDistancePerPulse(distancePerPulse);

	@Override
	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
}
