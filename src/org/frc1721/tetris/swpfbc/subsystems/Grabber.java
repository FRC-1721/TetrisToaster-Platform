package org.frc1721.tetris.swpfbc.subsystems;

import java.util.concurrent.TimeUnit;

import org.frc1721.tetris.swpfbc.ControlsMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Grabber.java
 * A grabber subsystem mounted to the elevator to hold and intake cubes.
 * @author Brennan
 */
public class Grabber extends Subsystem {

	@Override
	protected void initDefaultCommand() {}

	/**
	 * Stops the intake motors from running
	 * @param master The master motor controller - when this stops,
	 * the other side will follow as it's the slave.
	 */
	public static void stopIntakeMotors(VictorSPX master) {
		master.set(ControlMode.PercentOutput, 0);
	}
	
	/**
	 * Suck a cube in to the robot
	 * @param master The master motor controller - when this runs,
	 * the other side will follow as it's the slave.
	 */
	public static void cubeIn(Joystick j, VictorSPX master) {
		master.set(ControlMode.PercentOutput, j.getRawAxis(ControlsMap.spinAxis));
	}
	
	/**
	 * Eject a cube out of the robot.
	 * @param master The master motor controller - when this runs,
	 * the other side will follow as it's the slave.
	 */
	public static void cubeOut(Joystick j, VictorSPX master) {
		master.set(ControlMode.PercentOutput, -j.getRawAxis(ControlsMap.spinAxis));
	}
	
	/**
	 * Open the intake arms
	 * @param solenoid Solenoid to use to open the piston.
	 */
	public static void armsOpen(DoubleSolenoid solenoid) {
		solenoid.set(DoubleSolenoid.Value.kForward);
	}
	
	/**
	 * Closes the intake arms
	 * @param solenoid Solenoid to use to close the piston.
	 */
	public static void armsClose(DoubleSolenoid solenoid) {
		solenoid.set(DoubleSolenoid.Value.kReverse);
	}
	
	public static void moveArms(Joystick j, VictorSPX mot) {
		mot.set(ControlMode.PercentOutput, j.getRawAxis(ControlsMap.grabberAxis));
	}
	
	/**
	 * First step in the cube collection process.
	 * <ol>
	 * <li>Open the arms wide</li>
	 * <li>Run the intake wheels</li>
	 * <li>Wait for the cube to arrive</li>
	 * <li>When the cube is in the robot, stop
	 * </ol>
	 * 
	 * @param master The master motor controller - when this runs,
	 * the other side will follow as it's the slave.
	 * 
	 * @param solenoid Solenoid to open and close while running.
	 * 
	 * @param limit A limit switch to detect if the robot has a cube.
	 */
//	@Deprecated
	/*public static void harvestCube(VictorSPX master, DoubleSolenoid solenoid, DigitalInput limit) {
		armsOpen(solenoid);
		cubeIn(master);
		while(!hasCube(limit)) {}
		armsClose(solenoid);
		stopIntakeMotors(master);
	}*/
	
	/**
	 * Determine if the robot has a cube in the intake.
	 * @param limit A limit switch to check if the robot has a cube.
	 */
	@Deprecated
	public static boolean hasCube(DigitalInput limit) {
		return limit.get();
	}
	
	public static boolean ejectCube(VictorSPX intakeM) {
		intakeM.set(ControlMode.PercentOutput, -1);
		try {
			TimeUnit.MILLISECONDS.sleep(3000);
		} catch (Exception e) {
		}
		intakeM.set(ControlMode.PercentOutput, 0);
		return true;
	}
}
