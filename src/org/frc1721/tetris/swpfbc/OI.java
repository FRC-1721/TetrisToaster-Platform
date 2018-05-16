/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.frc1721.tetris.swpfbc;

import org.frc1721.tetris.swpfbc.commands.ClimberStop;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	public Button closeButton = new JoystickButton(RobotMap.controller, ControlsMap.closeBtn);
	public Button openButton = new JoystickButton(RobotMap.controller, ControlsMap.openBtn);
	public Button climbButton = new JoystickButton(RobotMap.controller, ControlsMap.climbBtn);
	
	public OI() {
		closeButton.whileHeld(new CloseGrabber());
		openButton.whileHeld(new OpenGrabber());
		climbButton.whileHeld(new Climb());
		climbButton.whenReleased(new ClimberStop());
	}
}
