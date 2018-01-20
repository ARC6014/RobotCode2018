/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team6014.robot.subsystems;

import org.usfirst.frc.team6014.robot.Robot;
import org.usfirst.frc.team6014.robot.RobotMap;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 * A subsystem for the control of the drivetrain.
 */
public class Drive extends Subsystem {
	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	
	SpeedController frontLeft = new VictorSP(RobotMap.frontLeft);
	SpeedController rearLeft = new VictorSP(RobotMap.rearLeft);
	SpeedControllerGroup left = new SpeedControllerGroup(frontLeft,rearLeft);
	SpeedController frontRight = new Spark(RobotMap.frontRight);
	SpeedController rearRight = new VictorSP(RobotMap.rearRight);
	SpeedControllerGroup right = new SpeedControllerGroup(frontRight,rearRight);
	DifferentialDrive drive = new DifferentialDrive(left,right);
	
	@Override
	public void initDefaultCommand() {
		drive.setMaxOutput(0.7);
	}
	public void arcadeDrive(double speed, double rotation) {
		drive.arcadeDrive(speed,rotation);
	}
}
