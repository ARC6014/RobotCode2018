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
	
	double countsPerRevolution = 497;
	double angularRange = 90;

	@Override
	public void initDefaultCommand() {
		hingeEncoder.reset();
	}
	
	public void setHingeSpeed(double speed) {
		if(overRotated()){
			hinge.set(-speed);
		} else {
			hinge.set(speed);
		}
	}
	
	public void resetHingeEncoder() {
		hingeEncoder.reset();
	}
	
	public double getCurrentAngle() {
		int count = hingeEncoder.get();
		return count*360/countsPerRevolution;
	}
	
	public boolean overRotated(){
		double angle = getCurrentAngle();
		if((angle<=0 && !hingeEncoder.getDirection()) || (angle>=angularRange && hingeEncoder.getDirection())){
			return true;
		}
		return false;
	}
}