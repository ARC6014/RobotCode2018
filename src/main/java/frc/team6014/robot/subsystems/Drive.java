/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.team6014.robot.subsystems;

import frc.team6014.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 * A subsystem for the control of the drivetrain.
 */
public class Drive extends Subsystem {
	public final double defSpeed = 0.9;
	public double maxSpeed = 0.9;
	
	/*SpeedController frontLeft = RobotMap.frontLeftEnum.generate(RobotMap.frontLeft);
	SpeedController rearLeft = RobotMap.rearLeftEnum.generate(RobotMap.rearLeft);
	SpeedControllerGroup left = new SpeedControllerGroup(frontLeft,rearLeft);
	SpeedController frontRight = RobotMap.frontRightEnum.generate(RobotMap.frontRight);
	SpeedController rearRight = RobotMap.rearRightEnum.generate(RobotMap.rearRight);
	SpeedControllerGroup right = new SpeedControllerGroup(frontRight,rearRight);
	DifferentialDrive drive = new DifferentialDrive(left,right);*/
	TalonSRX frontLeft = RobotMap.frontLeft;
	VictorSPX rearLeft = RobotMap.rearLeft;
	TalonSRX frontRight = RobotMap.frontRight;
	VictorSPX rearRight = RobotMap.rearRight;
	
	public Drive() {
		frontRight.setInverted(true);
		rearRight.setInverted(true);
		
		rearLeft.follow(frontLeft);
		rearRight.follow(frontRight);
		
		frontLeft.configNeutralDeadband(0.02, 20);
		frontRight.configNeutralDeadband(0.02, 20);

		frontLeft.setSensorPhase(true);
		frontRight.setSensorPhase(true);

		frontLeft.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 20);
		frontRight.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 20);
		
		this.setMaxOutput(maxSpeed);
	}

	@Override
	public void initDefaultCommand() {
	}
	
	public int getLeftEncoderPos() {
		return frontLeft.getSelectedSensorPosition(0);
	}
	public int getRightEncoderPos() {
		return frontRight.getSelectedSensorPosition(0);
	}
	public void resetEncoders() {
		frontLeft.setSelectedSensorPosition(0,0,20);
		frontRight.setSelectedSensorPosition(0, 0, 20);
	}
	
	public void arcadeDrive(double speed, double rotation) {
		double left,right;
		//speed = Math.copySign(speed*speed, speed);
		//rotation = Math.copySign(rotation*rotation, rotation);
		
		double maxInput = Math.copySign(Math.max(Math.abs(speed), Math.abs(rotation)), speed);
		if (speed >= 0.0) {
			// First quadrant, else second quadrant
		    if (rotation >= 0.0) {
		        left = maxInput;
		        right = speed - rotation;
		    } else {
		    	left = speed + rotation;
		        right = maxInput;
		    }
		} else {
			// Third quadrant, else fourth quadrant
			if (rotation >= 0.0) {
				left = speed + rotation;
		        right = maxInput;
			} else {
		        left = maxInput;
		        right = speed - rotation;
			}
		}
		frontLeft.set(ControlMode.PercentOutput, limit(left)*maxSpeed);
		frontRight.set(ControlMode.PercentOutput, limit(right)*maxSpeed);
	}
	public void tankDrive(double leftSpeed, double rightSpeed) {
		frontLeft.set(ControlMode.PercentOutput, limit(leftSpeed)*maxSpeed);
		frontRight.set(ControlMode.PercentOutput, limit(rightSpeed)*maxSpeed);
	}
	public void setMaxOutput(double speed) {
		maxSpeed = speed;
	}
	protected double limit(double value) {
		if (value > 1.0) {
			return 1.0;
		}
		if (value < -1.0) {
			return -1.0;
		}
		return value;
	}
}
