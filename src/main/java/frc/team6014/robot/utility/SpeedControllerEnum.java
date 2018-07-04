package frc.team6014.robot.utility;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.PWMTalonSRX;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.VictorSP;

public enum SpeedControllerEnum {
	VICTORSP,
	TALONSRX,
	PWMTALONSRX,
	SPARK,
	VICTORSPX,
	PWMVICTORSPX;
	public SpeedController generate(int port) {
		switch(this) {
		case VICTORSP:
			return new VictorSP(port);
		case TALONSRX:
			return new WPI_TalonSRX(port);
		case PWMTALONSRX:
			return new PWMTalonSRX(port);
		case SPARK:
			return new Spark(port);
		case VICTORSPX:
			return new WPI_VictorSPX(port);
		case PWMVICTORSPX:
			return new PWMVictorSPX(port);
		default:
			throw new IllegalArgumentException();
		}
	}
}
