/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team6014.robot;

import org.usfirst.frc.team6014.robot.utility.SpeedControllerEnum;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */

public class RobotMap {
	/* Note that IDs for CAN and PWM controllers are separate.
	 * CAN Types: VICTORSPX,TALONSRX
	 * PWM Types: VICTORSP,SPARK,PWMVICTORSPX,PWMTALONSRX
	 */
	//Drive
	public static int frontLeft = 0;
	public static SpeedControllerEnum frontLeftEnum = SpeedControllerEnum.VICTORSP;
	
	public static int rearLeft = 1;
	public static SpeedControllerEnum rearLeftEnum = SpeedControllerEnum.VICTORSP;
	
	public static int frontRight = 0;
	public static SpeedControllerEnum frontRightEnum = SpeedControllerEnum.TALONSRX;
	
	public static int rearRight = 3;
	public static SpeedControllerEnum rearRightEnum = SpeedControllerEnum.VICTORSP;
	//Arm
	//Ramp
}
