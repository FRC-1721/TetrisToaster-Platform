package org.frc1721.tetris.swpfbc.utils;

import org.frc1721.tetris.swpfbc.RobotMap;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.DoubleSolenoid;

public class InitMotors {

	
	public static void initializeMotors() {
		RobotMap.dtLeft = new TalonSRX(RobotMap.dtLeftP);
		RobotMap.dtRight = new TalonSRX(RobotMap.dtRightP);
		RobotMap.climbM = new VictorSPX(RobotMap.climbMP);
		RobotMap.climbS = new VictorSPX(RobotMap.climbSP);
		RobotMap.climbS.follow(RobotMap.climbM);
		RobotMap.intakeM = new VictorSPX(RobotMap.intakeMP);
		RobotMap.intakeS = new VictorSPX(RobotMap.intakeSP);
		RobotMap.intakeS.follow(RobotMap.intakeM);
		RobotMap.grabberS = new VictorSPX(RobotMap.armLiftP);
		RobotMap.elevator = new TalonSRX(RobotMap.elevatorP);
		
		RobotMap.solenoid = new DoubleSolenoid(RobotMap.inChannel, RobotMap.outChannel);
	}
}
