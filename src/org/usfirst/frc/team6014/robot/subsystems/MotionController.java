/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team6014.robot.subsystems;

import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

import org.usfirst.frc.team6014.robot.Robot;
import org.usfirst.frc.team6014.robot.RobotMap;

import com.kauailabs.navx.frc.AHRS;

/**
 * A subsystem for the NavX-MXP IMU.
 */
public class MotionController extends PIDSubsystem {
	
	AHRS mxp = new AHRS(SPI.Port.kMXP);
	private double outPID = 0;
	private boolean reset = true;
	public MotionController() {
		super(0.5,0.1,0.5);
		setAbsoluteTolerance(0.1);
		getPIDController().setInputRange(-180.0,180.0);
		getPIDController().setOutputRange(-1.0,1.0);
        getPIDController().setContinuous(true);
	}
	
	public void setAngle(double angle) {
		this.setSetpoint(angle);
	}
	
	@Override
	public void initDefaultCommand() {
	}
	
	public double getHeading() {
		if(reset) {
			mxp.reset();
			reset=false;
		}
		System.out.println(mxp.getYaw());
		return mxp.getYaw();
	}
	@Override
	protected double returnPIDInput() {
		return getHeading();
	}
	@Override
	protected void usePIDOutput(double output) {
		this.outPID = output;
	}
	public void pidDrive(double speed) {
			Robot.drive.arcadeDrive(speed, outPID);
	}
}