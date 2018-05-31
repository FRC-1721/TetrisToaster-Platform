package org.frc1721.tetris.swpfbc.utils;

import org.frc1721.tetris.swpfbc.RobotMap;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.StatusFrameEnhanced;

public class TalonConfigs {

	public static void configTalons() {
		RobotMap.dtLeft.setSensorPhase(true);
		RobotMap.dtLeft.setInverted(true);
		RobotMap.dtRight.setSensorPhase(true);
		RobotMap.dtRight.setInverted(false);
		
        RobotMap.dtLeft.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 10);
        RobotMap.dtRight.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 10);
		
        RobotMap.dtLeft.setStatusFramePeriod(StatusFrameEnhanced.Status_13_Base_PIDF0, 10, RobotMap.kTimeoutMS);
        RobotMap.dtLeft.setStatusFramePeriod(StatusFrameEnhanced.Status_10_MotionMagic, 10, RobotMap.kTimeoutMS);
        RobotMap.dtRight.setStatusFramePeriod(StatusFrameEnhanced.Status_13_Base_PIDF0, 10, RobotMap.kTimeoutMS);
        RobotMap.dtRight.setStatusFramePeriod(StatusFrameEnhanced.Status_10_MotionMagic, 10, RobotMap.kTimeoutMS);
        
		RobotMap.dtLeft.selectProfileSlot(0, 0);
		RobotMap.dtRight.selectProfileSlot(0, 0);
		
		RobotMap.dtLeft.configNominalOutputForward(0, RobotMap.kTimeoutMS);
		RobotMap.dtRight.configNominalOutputForward(0, RobotMap.kTimeoutMS);
		RobotMap.dtLeft.configNominalOutputReverse(0, RobotMap.kTimeoutMS);
		RobotMap.dtRight.configNominalOutputReverse(0, RobotMap.kTimeoutMS);
		RobotMap.dtLeft.configPeakOutputForward(1, RobotMap.kTimeoutMS);
		RobotMap.dtRight.configPeakOutputForward(1, RobotMap.kTimeoutMS);
		RobotMap.dtLeft.configPeakOutputReverse(-1, RobotMap.kTimeoutMS);
		RobotMap.dtRight.configPeakOutputReverse(-1, RobotMap.kTimeoutMS);
		
        RobotMap.dtLeft.config_kF(0, RobotMap.kF, RobotMap.kTimeoutMS);
        RobotMap.dtLeft.config_kP(0, RobotMap.kP, RobotMap.kTimeoutMS);
        RobotMap.dtLeft.config_kI(0, RobotMap.kI, RobotMap.kTimeoutMS);
        RobotMap.dtLeft.config_kD(0, RobotMap.kD, RobotMap.kTimeoutMS);
        
        RobotMap.dtRight.config_kF(0, RobotMap.kF, RobotMap.kTimeoutMS);
        RobotMap.dtRight.config_kP(0, RobotMap.kP, RobotMap.kTimeoutMS);
        RobotMap.dtRight.config_kI(0, RobotMap.kI, RobotMap.kTimeoutMS);
        RobotMap.dtRight.config_kD(0, RobotMap.kD, RobotMap.kTimeoutMS);
        
        RobotMap.dtLeft.configAllowableClosedloopError(0, 2000, RobotMap.kTimeoutMS);
        RobotMap.dtRight.configAllowableClosedloopError(0, 2000, RobotMap.kTimeoutMS);
        
        RobotMap.dtLeft.configMotionCruiseVelocity(8000, RobotMap.kTimeoutMS);
        RobotMap.dtLeft.configMotionCruiseVelocity(8000, RobotMap.kTimeoutMS);
        RobotMap.dtLeft.configMotionAcceleration(3000, RobotMap.kTimeoutMS);
        RobotMap.dtRight.configMotionAcceleration(3000, RobotMap.kTimeoutMS);
	}
	
}
