package org.frc1721.tetris.swpfbc.commands;

import org.frc1721.tetris.swpfbc.RobotMap;
import org.frc1721.tetris.swpfbc.subsystems.Grabber;

import edu.wpi.first.wpilibj.command.Command;

/**
 * <p>IntakeStop.java</p>
 * Command to turn the intake wheels off (I.E. button isn't being held).
 * 
 * @author Brennan
 */
public class IntakeStop extends Command {

	
	private static Grabber intake;
	
	public IntakeStop() {
	}
	
	protected void initialize() {}
	
	protected void execute() {
		Grabber.stopIntakeMotors(RobotMap.intakeM);
	}
	
	protected boolean isFinished() 	{	return false;	}
	protected void end()			{					}
	protected void interrupted()	{					}
}
