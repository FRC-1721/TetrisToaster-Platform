/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.frc1721.tetris.swpfbc;

import java.util.concurrent.TimeUnit;

import org.frc1721.tetris.swpfbc.commands.Baseline;
import org.frc1721.tetris.swpfbc.commands.SwitchLeft;
import org.frc1721.tetris.swpfbc.commands.SwitchRight;
import org.frc1721.tetris.swpfbc.subsystems.Climber;
import org.frc1721.tetris.swpfbc.subsystems.DriveTrain;
import org.frc1721.tetris.swpfbc.subsystems.Elevator;
import org.frc1721.tetris.swpfbc.subsystems.Grabber;
import org.frc1721.tetris.swpfbc.utils.EncoderConversion;
import org.frc1721.tetris.swpfbc.utils.InitMotors;
import org.frc1721.tetris.swpfbc.utils.TalonConfigs;
import org.frc1721.tetris.swpfbc.utils.TidalDrive;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
public class Robot extends TimedRobot {
	/* ------- CLASSES -------- */
	public static DriveTrain drivetrain;
	public static Climber climber;
	public static Grabber grabber;
	public static Elevator elevator;
	public static OI m_oi;
	public static SendableChooser autoChooser;
	Command autoCommand;
	boolean isRunning = false;
	int counter = 0;


	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		/* Talon configs */
		InitMotors.initializeMotors();
		TalonConfigs.configTalons();
        RobotMap.stick = new Joystick(ControlsMap.joyPort);
        RobotMap.controller = new Joystick(ControlsMap.controllerPort);
        RobotMap.robotDrive = new TidalDrive(RobotMap.dtLeft, RobotMap.dtRight);
        m_oi = new OI();
        
        autoChooser = new SendableChooser();
        autoChooser.addDefault("Switch right", new SwitchRight());
        autoChooser.addObject("Switch left", new SwitchLeft());
        autoChooser.addObject("Baseline", new Baseline());
        SmartDashboard.putData("Auto chooser", autoChooser);
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * <p>You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		counter = 0;
        RobotMap.dtRight.setSelectedSensorPosition(0, 0, RobotMap.kTimeoutMS);
        RobotMap.dtLeft.setSelectedSensorPosition(0, 0, RobotMap.kTimeoutMS);
        autoCommand = (Command) autoChooser.getSelected();
	}

	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
		double targetPos = EncoderConversion.getVal(8); //Distance in feet
		
		RobotMap.dtLeft.clearStickyFaults(RobotMap.kTimeoutMS);
		RobotMap.dtRight.clearStickyFaults(RobotMap.kTimeoutMS);
		
		RobotMap.dtLeft.set(ControlMode.Position, targetPos);
		RobotMap.dtRight.set(ControlMode.Position, targetPos);
		
		SmartDashboard.putNumber("Left Error", (double) RobotMap.dtLeft.getClosedLoopError(0));
		SmartDashboard.putNumber("Right Error", (double) RobotMap.dtRight.getClosedLoopError(0));
		
		try {
			TimeUnit.MILLISECONDS.sleep(10);
			counter += 10;
		} catch (Exception e) { /* Black Magic */ }
		
		if ((counter >= 3000) && (isRunning == false)) {
			isRunning = true;
			autoCommand.start();
		}
	}

	@Override
	public void teleopInit() {
		
	}

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		DriveTrain.driveWithJoystick(RobotMap.stick, RobotMap.robotDrive);
		Elevator.moveUp(RobotMap.controller, RobotMap.elevator);
		if(RobotMap.controller.getRawAxis(ControlsMap.lowerLiftAxis) >= .2) {
			Elevator.moveDown(RobotMap.controller, RobotMap.elevator);
		}
		Grabber.moveArms(RobotMap.controller, RobotMap.grabberS);
		Grabber.cubeIn(RobotMap.controller, RobotMap.intakeM);
		Grabber.cubeOut(RobotMap.controller, RobotMap.intakeM);
	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {
	}
}
