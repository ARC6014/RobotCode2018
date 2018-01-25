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
	hingeEncoder.setMaxPeriod(0.1); //ayarlanabilir
	hingeEncoder.reset();
	
	double countsPerRevolution = 497;
	double angularRange = 180;
	boolean overrotated = false;
	
	if(!hingeEncoder.getStopped() && hingeEncoder.overrotated){
		arm.set(0); //set speed to 0
	}

	@Override
	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
	
	public static boolean overrotated(){
		int count = hingeEncoder.get();
		if(count <= 0 || count >= countsPerRevolution*angularRange/360){
			return true;
		}
		return false;
	}
}
