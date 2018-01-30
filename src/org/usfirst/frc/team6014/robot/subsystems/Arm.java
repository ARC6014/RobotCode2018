/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team6014.robot.subsystems;

import org.usfirst.frc.team6014.robot.RobotMap;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
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
	
	SpeedController leftHolder = RobotMap.leftHolderEnum.generate(RobotMap.leftHolder);
	SpeedController rightHolder = RobotMap.rightHolderEnum.generate(RobotMap.rightHolder);	
	SpeedControllerGroup arm = new SpeedControllerGroup(leftHolder,rightHolder);
	
	Encoder hingeEncoder = new Encoder(RobotMap.encoderA, RobotMap.encoderB, false, Encoder.EncodingType.k4X);
	
	static double countsPerRevolution = 497;
	static double angularRange = 90;

	@Override
	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
	
	public void setHingeSpeed(double speed) {
		if(overRotated()){
			hinge.set(0);
		}else{
			hinge.set(speed);
		}
	}
	
	public boolean overRotated(){
		int count = hingeEncoder.get();
		if(count <= 0 || count >= countsPerRevolution*angularRange/360){
			return true;
		}
		return false;
	}
}