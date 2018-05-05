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
	private static RobotMap rm;
	
	public IntakeStop() {
		requires(intake);
	}
	
	protected void initialize() {}
	
	protected void execute() {
		intake.stopIntakeMotors(rm.intakeM);
	}
	
	protected boolean isFinished() 	{	return false;	}
	protected void end()			{					}
	protected void interrupted()	{					}
}
