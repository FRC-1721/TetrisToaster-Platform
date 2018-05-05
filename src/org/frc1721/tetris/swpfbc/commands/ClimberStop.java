package org.frc1721.tetris.swpfbc.commands;

import org.frc1721.tetris.swpfbc.RobotMap;
import org.frc1721.tetris.swpfbc.subsystems.Climber;

import edu.wpi.first.wpilibj.command.Command;

/**
 *	<p>ClimberStop.java</p>
 *	Command to turn the climber off (I.E. button isn't being held).
 *	
 *	@author Brennan
 */
public class ClimberStop extends Command {
	
	private static Climber climber;
	private static RobotMap rm;
	
    public ClimberStop() {
    	requires(climber);
    }

    protected void initialize() {}

    protected void execute() {
    	climber.stopClimb(rm.climbM);
    }

    protected boolean isFinished() 	{	return false;	}
    protected void end() 			{					}
    protected void interrupted() 	{					}
}
