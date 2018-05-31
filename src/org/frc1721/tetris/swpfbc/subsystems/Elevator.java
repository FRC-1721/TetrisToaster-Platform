package org.frc1721.tetris.swpfbc.subsystems;

import java.util.concurrent.TimeUnit;

import org.frc1721.tetris.swpfbc.ControlsMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Elevator.java
 * The robots elevator, controlled with one motor, 
 * @author Brennan
 *
 */
public class Elevator extends Subsystem {

	@Override
	protected void initDefaultCommand() {
	}
	
	public static void moveUp(Joystick j, TalonSRX mot) {
		double in = (j.getRawAxis(ControlsMap.raiseLiftAxis));
		mot.set(ControlMode.PercentOutput, in);
	}
	
	public static void moveDown(Joystick j, TalonSRX mot) {
		double in = -(j.getRawAxis(ControlsMap.lowerLiftAxis));
		mot.set(ControlMode.PercentOutput, in);
	}
	
	public static void stopElevator(TalonSRX mot) {
		mot.set(ControlMode.PercentOutput, 0);
	}
	
	public static boolean moveMillis(TalonSRX mot, int time) {
		mot.set(ControlMode.PercentOutput, .5);
		try {
			TimeUnit.MILLISECONDS.sleep(time);
		} catch (Exception e) {
			/* nope */
		}
		mot.set(ControlMode.PercentOutput, 0);
		return true;
	}
}
