package org.frc1721.tetris.swpfbc.commands;

import org.frc1721.tetris.swpfbc.RobotMap;
import org.frc1721.tetris.swpfbc.subsystems.Climber;

import edu.wpi.first.wpilibj.command.Command;

/**
 * <p>ClimberRun.java</p>
 * Command to run the climber (climb) in a match while a
 * trigger is held. Does not stop executing until the stop
 * command is run (I.E. button is no longer being held).
 * 
 * @author Brennan
 */
public class ClimberRun extends Command {

	private static RobotMap rm;
	
	public ClimberRun() {
	}
	
	protected void initialize() {
		Climber.climb(rm.climbM);
	}
	
	protected void execute() {
		
	}
	
	protected boolean isFinished() {	return true;	}
	protected void end() {}
	protected void interrupted() {
		Climber.stopClimb(rm.climbM);
	}
}
