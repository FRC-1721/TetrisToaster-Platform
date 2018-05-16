/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.frc1721.tetris.swpfbc;

import org.frc1721.tetris.swpfbc.subsystems.Climber;
import org.frc1721.tetris.swpfbc.subsystems.DriveTrain;
import org.frc1721.tetris.swpfbc.subsystems.Elevator;
import org.frc1721.tetris.swpfbc.subsystems.Grabber;
import org.frc1721.tetris.swpfbc.utils.TidalDrive;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;

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


	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		m_oi = new OI();

		RobotMap.dtLeft = new TalonSRX(RobotMap.dtLeftP);
		RobotMap.dtRight = new TalonSRX(RobotMap.dtRightP);
		
        RobotMap.dtLeft.config_kF(0, RobotMap.kF, RobotMap.kTimeoutMS);
        RobotMap.dtLeft.config_kP(0, RobotMap.kP, RobotMap.kTimeoutMS);
        RobotMap.dtLeft.config_kI(0, RobotMap.kI, RobotMap.kTimeoutMS);
        RobotMap.dtLeft.config_kD(0, RobotMap.kD, RobotMap.kTimeoutMS);
        
        RobotMap.dtRight.config_kF(0, RobotMap.kF, RobotMap.kTimeoutMS);
        RobotMap.dtRight.config_kP(0, RobotMap.kP, RobotMap.kTimeoutMS);
        RobotMap.dtRight.config_kI(0, RobotMap.kI, RobotMap.kTimeoutMS);
        RobotMap.dtRight.config_kD(0, RobotMap.kD, RobotMap.kTimeoutMS);
        RobotMap.robotDrive = new TidalDrive(RobotMap.dtLeft, RobotMap.dtRight);
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
	}

	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		
	}

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() {
		DriveTrain.driveWithJoystick(RobotMap.stick, RobotMap.robotDrive);
		Scheduler.getInstance().run();
	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {
	}
}
