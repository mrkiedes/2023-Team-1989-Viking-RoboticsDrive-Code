// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class Drivetrain extends SubsystemBase {
  /** Creates a new Drivetrain. */
  private final WPI_TalonSRX m_FrontLeft;
  private final WPI_TalonSRX m_FrontRight;
  private final WPI_TalonSRX m_BackLeft;
  private final WPI_TalonSRX m_BackRight;

  private final MotorControllerGroup m_leftMotors;
  private final MotorControllerGroup m_rightMotors;

  DifferentialDrive diffDrive;
  MecanumDrive mechDrive;


  public Drivetrain() {
    m_FrontLeft = new WPI_TalonSRX(3);
    m_FrontRight = new WPI_TalonSRX(1);
    m_BackLeft = new WPI_TalonSRX(4);
    m_BackRight = new WPI_TalonSRX(2);

    m_leftMotors = new MotorControllerGroup(m_BackRight, m_BackLeft);
    m_rightMotors = new MotorControllerGroup(m_FrontRight, m_FrontLeft);

    diffDrive = new DifferentialDrive(m_leftMotors, m_rightMotors);
    
    mechDrive = new MecanumDrive(m_FrontLeft, m_BackLeft, m_FrontRight, m_BackRight);
  }

  public void arcadeDrive(double moveSpeed, double rotateSpeed){
    diffDrive.arcadeDrive(moveSpeed, rotateSpeed);
    
  }
  
  public void mechDrive(double y, double x, double z){
    mechDrive.driveCartesian(y,x,z);
    
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
