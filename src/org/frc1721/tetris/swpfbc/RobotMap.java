/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.frc1721.tetris.swpfbc;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.DoubleSolenoid;

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
	
}
