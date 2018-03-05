/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team6014.robot;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team6014.robot.autonomous.commandgroups.AutoStraightTest;
import org.usfirst.frc.team6014.robot.autonomous.commandgroups.AutoTest;
import org.usfirst.frc.team6014.robot.autonomous.commandgroups.AutoTest2;
import org.usfirst.frc.team6014.robot.subsystems.Arm;
import org.usfirst.frc.team6014.robot.subsystems.Drive;
import org.usfirst.frc.team6014.robot.subsystems.Perception;
import org.usfirst.frc.team6014.robot.subsystems.MotionController;
import org.usfirst.frc.team6014.robot.subsystems.Ramp;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
public class Robot extends TimedRobot {
	public static final Drive drive = new Drive();
	public static final Arm arm = new Arm();
	//public static final Ramp ramp = new Ramp();
	public static final Perception perception = new Perception();
	public static final MotionController motionController = new MotionController();
	public static OI oi;
	public static String gameData = "";
	public static AnalogInput ultra1 = new AnalogInput(0);
	
	private double heading,angle;

	Command autonomousCommand;
	SendableChooser<Command> chooser = new SendableChooser<>();

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		oi = new OI();
		chooser.addDefault("Straight Drive Test", new AutoStraightTest());
		chooser.addObject("Test 1", new AutoTest());
		chooser.addObject("Test 2", new AutoTest2());
		SmartDashboard.putData("Auto Mode", chooser);
		//CameraServer.getInstance().startAutomaticCapture();
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * <p>You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		getGameData();
		SmartDashboard.putString("Game Data", gameData);
		autonomousCommand = chooser.getSelected();
		if (autonomousCommand != null) {
			autonomousCommand.start();
		}
	}

	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (autonomousCommand != null) {
			autonomousCommand.cancel();
		}
		Teleop.init();
	}

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() {
		Teleop.periodic();
		Scheduler.getInstance().run();
	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {
	}
	@Override
	public void robotPeriodic() {
		SmartDashboard.putNumber("Arm Angle",arm.getCurrentAngle());
		SmartDashboard.putNumber("Ultrasonic Value", ultra1.getValue());
		SmartDashboard.putNumber("Heading", motionController.getHeading());
	}
	/**
	 * This function is called to get and store the positions of allied colored switches/scale and store them
	 */
	public void getGameData() {
		//This thing gets a 3 character string with L for left and R for right. The data is given 
		//according to the robot's position and given in order of closest to farthest switch/scale
		gameData = DriverStation.getInstance().getGameSpecificMessage();
	}
}
