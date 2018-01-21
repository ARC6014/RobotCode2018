package org.usfirst.frc.team6014.robot.utility;

import edu.wpi.first.wpilibj.PWMTalonSRX;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.VictorSP;

public enum SpeedControllerEnum {
	VICTORSP,
	TALONSRX,
	SPARK,
	VICTORSPX;
	public SpeedController generate(int port) {
		switch(this) {
		case VICTORSP:
			return new VictorSP(port);
		case TALONSRX:
			//TODO: Add CAN TALON SUPPORT 
			return new PWMTalonSRX(port);
		case SPARK:
			return new Spark(port);
		case VICTORSPX:
			//TODO: ADD CAN VICTOR SUPPORT
			return new PWMVictorSPX(port);
		default:
			throw new IllegalArgumentException();
		}
	}
}
