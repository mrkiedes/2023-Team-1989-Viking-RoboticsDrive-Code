// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotContainer;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class Drivetrain extends SubsystemBase {
  /** Creates a new Drivetrain. */
  private final WPI_TalonSRX m_FrontLeft;
  private final WPI_TalonSRX m_FrontRight;
  private final WPI_TalonSRX m_BackLeft;
  private final WPI_TalonSRX m_BackRight;

  MecanumDrive mechDrive;

  public Drivetrain() {
    m_FrontLeft = new WPI_TalonSRX(1);
    m_FrontRight = new WPI_TalonSRX(2);
    m_BackLeft = new WPI_TalonSRX(3);
    m_BackRight = new WPI_TalonSRX(4);

    mechDrive = new MecanumDrive(m_FrontLeft, m_BackLeft, m_FrontRight, m_BackRight);
  }

  public void mecMove(double vertical, double horizontal, double turn){
    vertical = 0;
    horizontal = 0;
    turn = 0;
    
    vertical = RobotContainer.driveStick.getY();
    horizontal = RobotContainer.driveStick.getX();
    turn = RobotContainer.utilStick.getX();

    m_FrontLeft.set(turn + (-vertical - horizontal));
    m_FrontRight.set(-(turn + (-vertical + horizontal)));
    m_BackLeft.set(turn + (-vertical - horizontal));
    m_BackRight.set(-(turn + (-vertical + horizontal)));

  }

  public void mechDrive(double vertical, double horizontal, double turn) {
    mechDrive.driveCartesian(vertical, horizontal, turn);

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void arcadeDrive(double d, double e) {
  }
}
