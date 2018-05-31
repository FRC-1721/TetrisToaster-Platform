package org.frc1721.tetris.swpfbc.commands;

import org.frc1721.tetris.swpfbc.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveToPoint extends Command {

	
	private boolean done = false;
    public DriveToPoint() {
    }

    protected void initialize() {
    	
    }

    protected void execute() {
    	done = DriveTrain.moveToSetpoint(8);
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
