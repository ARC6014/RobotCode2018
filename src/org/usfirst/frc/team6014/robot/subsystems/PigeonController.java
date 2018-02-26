/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team6014.robot.subsystems;

import edu.wpi.first.wpilibj.command.PIDSubsystem;

import org.usfirst.frc.team6014.robot.Robot;
import org.usfirst.frc.team6014.robot.RobotMap;

import com.ctre.phoenix.sensors.PigeonIMU;

/**
 * A subsystem for the Pigeon IMU.
 */
public class PigeonController extends PIDSubsystem {
	
	PigeonIMU pigeon = new PigeonIMU(RobotMap.pigeon);
	private double outPID = 0;
	public PigeonController() {
		super(0.27, 0.2778, 0.0694);
		setAbsoluteTolerance(0.5);
        getPIDController().setContinuous(false);
        pigeon.setFusedHeading(0.0, 10);
	}
	
	public void setAngle(double angle) {
		this.setSetpoint(angle);
	}
	
	@Override
	public void initDefaultCommand() {
	}
	
	public double[] getRawGyro() {
		double[] results = new double[3];
		pigeon.getRawGyro(results);
		return results;
	}
	public double getHeading() {
		return pigeon.getFusedHeading() % 360;
	}
	@Override
	protected double returnPIDInput() {
		if((pigeon.getFusedHeading() - this.getSetpoint()) % 360 > 180) {
			return (pigeon.getFusedHeading() % 360) - 360;
		}
		return pigeon.getFusedHeading() % 360;
	}
	@Override
	protected void usePIDOutput(double output) {
		this.outPID = output;
	}
	public void pidDrive(double speed) {
			Robot.drive.arcadeDrive(speed, -outPID);
	}
}