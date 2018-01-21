package org.usfirst.frc.team6014.robot;

public class Teleop {
	public static void init() {
		
	}
	public static void periodic() {
		Robot.drive.arcadeDrive(-Robot.oi.getRawY(),Robot.oi.getRawX());
	}
}
