package org.frc1721.tetris.swpfbc.subsystems;

import org.frc1721.tetris.swpfbc.commands.ClimberStop;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Climber extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new ClimberStop());
    }
    
    /**
     * Climb up to the bar until stopped.
     * @param climber
     */
    public void climb(VictorSPX climber) {
    	climber.set(ControlMode.PercentOutput, 1);
    }
    
    /**
     * Stops the climber.
     * @param climber
     */
    public void stopClimb(VictorSPX climber) {
    	climber.set(ControlMode.PercentOutput, 0);
    }
}

