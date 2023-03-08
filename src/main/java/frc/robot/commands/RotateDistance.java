// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.Timer;
import frc.robot.RobotContainer;

public class RotateDistance extends CommandBase {
  /** Creates a new RotateDistance. */
  double runTime;
  Timer stopwatch;
  public RotateDistance(double seconds) {
    // Use addRequirements() here to declare subsystem dependencies.
    runTime = seconds;
    stopwatch = new Timer();
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    stopwatch.restart();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    RobotContainer.m_drivetrain.arcadeDrive(0.0, 0.5);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    stopwatch.stop();
    stopwatch.reset();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return stopwatch.get() >= runTime;
  }
}
