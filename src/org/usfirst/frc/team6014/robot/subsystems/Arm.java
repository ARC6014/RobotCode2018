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
	
	Encoder hingeEncoder = new Encoder(4, 5, false, Encoder.EncodingType.k4X);
	hingeEncoder.reset();
	
	double countsPerRevolution = 497;
	hingeEncoder.setMaxPeriod(0.1); //duruma göre ayarlanmalı
	
	if(!hingeEncoder.getStopped()){
		int count = hingeEncoder.get();
		if(count <= -countsPerRevolution/2 || count >= countsPerRevolution/2){
			arm.stopMotor();
		}
			
	}
	
	
	
	
	@Override
	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
}
