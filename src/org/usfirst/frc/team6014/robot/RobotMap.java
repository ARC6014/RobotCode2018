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
	/* Note that IDs for CAN and PWM controllers are separate. And there are also DIOs.
	 * CAN Types: VICTORSPX,TALONSRX
	 * PWM Types: VICTORSP,SPARK,PWMVICTORSPX,PWMTALONSRX
	 * Other types are explained case-by-case.
	 */
	//Drive
	public static int frontLeft = 0;
	public static SpeedControllerEnum frontLeftEnum = SpeedControllerEnum.VICTORSP;
	
	public static int rearLeft = 1;
	public static SpeedControllerEnum rearLeftEnum = SpeedControllerEnum.VICTORSP;
	
	public static int frontRight = 1;
	public static SpeedControllerEnum frontRightEnum = SpeedControllerEnum.TALONSRX;
	
	public static int rearRight = 3;
	public static SpeedControllerEnum rearRightEnum = SpeedControllerEnum.VICTORSP;
	//Arm
	public static int leftHinge = 6;
	public static SpeedControllerEnum leftHingeEnum = SpeedControllerEnum.PWMVICTORSPX;
	
	public static int rightHinge = 5;
	public static SpeedControllerEnum rightHingeEnum = SpeedControllerEnum.PWMVICTORSPX;
	
	public static int leftHolder = 4;
	public static SpeedControllerEnum leftHolderEnum = SpeedControllerEnum.PWMVICTORSPX;
	
	public static int rightHolder = 2;
	public static SpeedControllerEnum rightHolderEnum = SpeedControllerEnum.PWMVICTORSPX;
	
	public static int encoderA = 0;//DIO
	public static int encoderB = 1;//DIO
	//Ramp
	public static int leftRamp = 8;
	public static SpeedControllerEnum leftRampEnum = SpeedControllerEnum.VICTORSPX;
	
	public static int rightRamp = 9;
	public static SpeedControllerEnum rightRampEnum = SpeedControllerEnum.VICTORSPX;
	
	public static int release = 10;
	public static SpeedControllerEnum releaseEnum = SpeedControllerEnum.VICTORSPX;
	//Perception
	public static int pigeon = 2;//CAN
}
