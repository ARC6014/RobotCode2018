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
 * A subsystem for sensors and vision processing.
 */
public class PigeonController extends PIDSubsystem{
	
	PigeonIMU pigeon = new PigeonIMU(RobotMap.pigeon);
	private double outPID = 0;
	public PigeonController() {
		super(0, 0, 0);
		setAbsoluteTolerance(3);
        getPIDController().setContinuous(false);
		// TODO Auto-generated constructor stub
	}
	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	public void setAngle() {
		this.setSetpoint(pigeon.getFusedHeading());
	}
	@Override
	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
		pigeon.setFusedHeading(0.0, 10);
	}

	public double[] getRawGyro() {
		double[] results = new double[3];
		pigeon.getRawGyro(results);
		return results;
	}
	public double getHeading() {
		return pigeon.getFusedHeading();
	}
	@Override
	protected double returnPIDInput() {
		// TODO Auto-generated method stub
		return pigeon.getFusedHeading();
	}
	@Override
	protected void usePIDOutput(double output) {
		// TODO Auto-generated method stub
		this.outPID = output;
	}
	public void driveStraight(double speed) {
		Robot.drive.arcadeDrive(speed, outPID);
	}
	public void rotateToAngle() {
		while(this.onTarget()) {
			Robot.drive.arcadeDrive(0, outPID);
		}
	}
	
	
	
}
