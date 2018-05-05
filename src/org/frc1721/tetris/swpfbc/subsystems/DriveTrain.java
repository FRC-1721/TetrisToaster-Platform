package org.frc1721.tetris.swpfbc.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class DriveTrain extends Subsystem {

	@Override
	protected void initDefaultCommand() {}
	
	/**
	 * Drive the robot using the joystick in the arcade format.
	 * @param j Joystick to use while driving
	 * @param rd A DifferentialDrive object, previously configured to
	 * drive the robot.
	 */
	public static void driveWithJoystick(Joystick j, DifferentialDrive rd) {
		double axis = j.getY() * .88;
		double turn = j.getZ() * .95;
		rd.arcadeDrive(axis, turn);
	}
	
	/**
	 * Stops the robot from driving.
	 * @param rd A DifferentialDrive object, previously configured to
	 * drive the robot.
	 */
	public static void stop(DifferentialDrive rd) {
		rd.arcadeDrive(0, 0);
	}
	
	/**
	 * 
	 */
	public static void setMode(ControlMode mode) {
		
	}
}
