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
	
    public ClimberStop() {
    }

    protected void initialize() {
    	climber.stopClimb(RobotMap.climbM);
    }

    protected void execute() {
    	
    }

    protected boolean isFinished() 	{	return true;	}
    protected void end() 			{					}
    protected void interrupted() 	{	climber.stopClimb(RobotMap.climbM);}
}
