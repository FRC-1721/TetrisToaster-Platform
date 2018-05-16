/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.frc1721.tetris.swpfbc;

import org.frc1721.tetris.swpfbc.utils.TidalDrive;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Joystick;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	
	/* Motors */
	public static TalonSRX dtLeft, dtRight, elevator;	
	public static VictorSPX intakeM, intakeS, climbM, climbS;
	
	/* Drive Object */
	public static TidalDrive robotDrive;
	
	/* Motor Ports */
	public static final int dtLeftP 	=	0,
							dtRightP 	=	1,
							intakeMP 	= 	2,
							intakeSP	=	3,
							elevatorP	=	4,
							climbMP		=	5,
							climbSP		=	6;
	
	/* Pneumatics */
	public static DoubleSolenoid solenoid;
	public static final int inChannel = 0, outChannel = 1;
	
	
	/* Encoders & Switches */
	public static double kP = 0.001, kI = 0.0, kD = 0.0, kF = 0.0;
	public static final double kSensorUnitsPerRotation = 4096;
	public static int kTimeoutMS = 10;
	public static double kInchesPerTick = .00460205078;
	
	public static double kTenFeet = 26075.9458762; // Ticks in ten feet.
	
	/* Joysticks, Controllers, Etc */
	public static Joystick stick;
	public static Joystick controller;
	
	
}
