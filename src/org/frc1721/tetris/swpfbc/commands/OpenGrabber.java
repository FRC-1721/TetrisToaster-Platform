package org.frc1721.tetris.swpfbc.commands;

import org.frc1721.tetris.swpfbc.RobotMap;
import org.frc1721.tetris.swpfbc.subsystems.Grabber;

import edu.wpi.first.wpilibj.command.Command;

public class OpenGrabber extends Command {

	private static Grabber grabber;
	
	public OpenGrabber() {
	}
	
	protected void initialize() {}
	
	protected void execute() {
		Grabber.armsOpen(RobotMap.solenoid);
	}
	
	protected boolean isFinished() {	return false;	}
	protected void end() {}
	protected void interrupted() {}
	
}
