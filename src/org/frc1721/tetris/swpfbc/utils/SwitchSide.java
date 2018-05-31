package org.frc1721.tetris.swpfbc.utils;

import org.frc1721.tetris.swpfbc.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.DriverStation;

public class SwitchSide {
	
	public static boolean shouldDump(Sides s) {
		
		String gameData = DriverStation.getInstance().getGameSpecificMessage();
		if (gameData.length() > 0) {
			if (s == Sides.Left) {
				if (gameData.charAt(0) == 'L') {
					
					return true;
				}else {
					return false;
				}
			}else {
				if (gameData.charAt(0) == 'R') {
					return true;
				}else {
					return false;
				}
			}
		}else {
			return false;
		}
	}
}
