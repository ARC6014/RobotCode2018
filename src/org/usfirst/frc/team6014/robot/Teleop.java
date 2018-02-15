package org.usfirst.frc.team6014.robot;

public class Teleop {
	public static void init() {
		
	}
	public static void periodic() {
		Robot.drive.arcadeDrive(-Robot.oi.getRawY()*Robot.oi.getReverseFactor(),Robot.oi.getRawX());
		//Robot.drive.setMaxOutput((-Robot.oi.getRawOtherY()+1)/2);
		Robot.arm.setHingeSpeed(-Robot.oi.getRawOtherY());
		if(Robot.oi.getLaunchButton()) {
			Robot.arm.setHolderSpeed(1.0);
		} else if(Robot.oi.getIntakeButton()) {
			Robot.arm.setHolderSpeed(-1.0);
		} else {
			Robot.arm.setHolderSpeed(0);
		}
		Robot.drive.setMaxOutput((-Robot.oi.getRawOtherY()+1)/2);
		//Robot.arm.setHingeSpeed(Robot.oi.getLeftTrigger() - Robot.oi.getRightTrigger());
	}
}