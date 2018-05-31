package org.frc1721.tetris.swpfbc.subsystems;

import java.util.concurrent.TimeUnit;

import org.frc1721.tetris.swpfbc.RobotMap;
import org.frc1721.tetris.swpfbc.utils.EncoderConversion;
import org.frc1721.tetris.swpfbc.utils.TidalDrive;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class DriveTrain extends Subsystem {

	private static int count = 0;
	@Override
	protected void initDefaultCommand() {}
	
	/**
	 * Drive the robot using the joystick in the arcade format.
	 * @param j Joystick to use while driving
	 * @param rd A DifferentialDrive object, previously configured to
	 * drive the robot.
	 */
	public static void driveWithJoystick(Joystick j, TidalDrive rd) {
		double axis = (j.getY() * .88) * (-1);
		double turn = (j.getZ() * .95) * (-1);
		rd.arcadeDrive(axis, turn);
	}
	
	public static boolean moveToSetpoint(double feet) {
		double targ = EncoderConversion.getVal(feet);
		RobotMap.dtLeft.set(ControlMode.Position, targ);
		RobotMap.dtRight.set(ControlMode.Position, targ);
		try {
			TimeUnit.MILLISECONDS.sleep(10);
			count += 10;
		} catch (Exception e) {
			
		}
		if(count >= 3000) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Stops the robot from driving.
	 * @param rd A DifferentialDrive object, previously configured to
	 * drive the robot.
	 */
	public static void stop(DifferentialDrive rd) {
		rd.arcadeDrive(0, 0);
	}
}
