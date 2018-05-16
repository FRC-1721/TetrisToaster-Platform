package org.frc1721.tetris.swpfbc.utils;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.drive.RobotDriveBase;
import edu.wpi.first.wpilibj.hal.FRCNetComm.tInstances;
import edu.wpi.first.wpilibj.hal.FRCNetComm.tResourceType;
import edu.wpi.first.wpilibj.hal.HAL;
import edu.wpi.first.wpilibj.smartdashboard.SendableBuilder;

/**
 * A custom class written to drive the robot using TalonSRXs as-is without
 * making groups or modifying them.
 * 
 * In addition, this class by default supports the Split-Arcade style drive
 * that is preffered by rookie drivers.
 * 
 * @author Brennan
 */
public class TidalDrive extends RobotDriveBase {
  public static final double kDefaultQuickStopThreshold = 0.2;
  public static final double kDefaultQuickStopAlpha = 0.1;

  private static int instances = 0;

  private TalonSRX m_leftMotor;
  private TalonSRX m_rightMotor;

  private boolean m_reported = false;

  /**
   * Construct a TidalDrive using two TalonSRX motor controllers,
   * with any other controller in follower mode.
   */
  public TidalDrive(TalonSRX leftMotor, TalonSRX rightMotor) {
    m_leftMotor = leftMotor;
    m_rightMotor = rightMotor;
    addChild(m_leftMotor);
    addChild(m_rightMotor);
    instances++;
    setName("DifferentialDrive", instances);
  }

  /**
   * Arcade drive method for TidalDrive.
   * The calculated values will be squared to decrease sensitivity at low speeds.
   *
   * @param xSpeed    The robot's speed along the X axis [-1.0..1.0]. Forward is positive.
   * @param zRotation The robot's rotation rate around the Z axis [-1.0..1.0]. Clockwise is
   *                  positive.
   */
  public void arcadeDrive(double xSpeed, double zRotation) {
    arcadeDrive(xSpeed, zRotation, true);
  }

  /**
   * Arcade drive method for TidalDrive.
   * 
   * @param xSpeed        The robot's speed along the X axis [-1.0..1.0]. Forward is positive.
   * @param zRotation     The robot's rotation rate around the Z axis [-1.0..1.0]. Clockwise is
   *                      positive.
   * @param squaredInputs If set, decreases the input sensitivity at low speeds.
   */
  public void arcadeDrive(double xSpeed, double zRotation, boolean squaredInputs) {
    if (!m_reported) {
      HAL.report(tResourceType.kResourceType_RobotDrive, 2, tInstances.kRobotDrive_ArcadeStandard);
      m_reported = true;
    }

    xSpeed = limit(xSpeed);
    xSpeed = applyDeadband(xSpeed, m_deadband);

    zRotation = limit(zRotation);
    zRotation = applyDeadband(zRotation, m_deadband);

    // Square the inputs (while preserving the sign) to increase fine control
    // while permitting full power.
    if (squaredInputs) {
      xSpeed = Math.copySign(xSpeed * xSpeed, xSpeed);
      zRotation = Math.copySign(zRotation * zRotation, zRotation);
    }

    double leftMotorOutput;
    double rightMotorOutput;

    double maxInput = Math.copySign(Math.max(Math.abs(xSpeed), Math.abs(zRotation)), xSpeed);

    if (xSpeed >= 0.0) {
      // First quadrant, else second quadrant
      if (zRotation >= 0.0) {
        leftMotorOutput = maxInput;
        rightMotorOutput = xSpeed - zRotation;
      } else {
        leftMotorOutput = xSpeed + zRotation;
        rightMotorOutput = maxInput;
      }
    } else {
      // Third quadrant, else fourth quadrant
      if (zRotation >= 0.0) {
        leftMotorOutput = xSpeed + zRotation;
        rightMotorOutput = maxInput;
      } else {
        leftMotorOutput = maxInput;
        rightMotorOutput = xSpeed - zRotation;
      }
    }

    m_leftMotor.set(ControlMode.PercentOutput, limit(leftMotorOutput) * m_maxOutput);
    m_rightMotor.set(ControlMode.PercentOutput, -limit(rightMotorOutput) * m_maxOutput);

    m_safetyHelper.feed();
  }
  
  
  @Override
  public void stopMotor() {
    m_leftMotor.set(ControlMode.PercentOutput, 0);
    m_rightMotor.set(ControlMode.PercentOutput, 0);
    m_safetyHelper.feed();
  }

/**
 * Unimplemented.
 */
@Override
@Deprecated
public void initSendable(SendableBuilder builder) {}

@Override
@Deprecated
public String getDescription() {return null;}

}
