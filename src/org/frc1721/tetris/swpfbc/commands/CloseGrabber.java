package org.frc1721.tetris.swpfbc.commands;

import org.frc1721.tetris.swpfbc.RobotMap;
import org.frc1721.tetris.swpfbc.subsystems.Grabber;

import edu.wpi.first.wpilibj.command.Command;

/**
 * <p>CloseGrabber.java</p>
 * Closes the grabber arms using a solenoid.
 * 
 * @author Brennan
 */
public class CloseGrabber extends Command {

	private static Grabber grabber;
	
	public CloseGrabber() {}
	
	protected void initialize() {}
	
	protected void execute() {
		Grabber.armsClose(RobotMap.solenoid);
	}
	
	protected boolean isFinished() {	return false;	}
	protected void end() {}
	protected void interrupted() {}
}
