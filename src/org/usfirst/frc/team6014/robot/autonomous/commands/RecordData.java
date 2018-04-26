/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team6014.robot.autonomous.commands;

import edu.wpi.first.wpilibj.command.TimedCommand;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import org.usfirst.frc.team6014.robot.Robot;

public class RecordData extends TimedCommand {
	
	BufferedWriter out;
	public RecordData(double duration) {
		super(duration);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		out = null;
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		try  
		{
		    FileWriter fstream = new FileWriter("posdata.txt", false);
		    out = new BufferedWriter(fstream);
		    out.write(Robot.perception.getLeftDistance()+" "+Robot.perception.getRightDistance()+"\n");
		}
		catch (IOException e)
		{
		    e.printStackTrace();
		}
	}
	
	@Override
	protected void interrupted() {
		end();
	}
	
	@Override
	protected void end() {
		if(out!=null) {
			try {
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
