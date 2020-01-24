/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivetrain extends SubsystemBase {

  private Spark leftSpark = new Spark(2);
  private Spark rightSpark = new Spark(1);
  // private Encoder leftEncoder = new Encoder(8, 9, false, Encoder.EncodingType.k4X);
  // private Encoder rightEncoder = new Encoder(6, 7, false, Encoder.EncodingType.k4X);
  private DifferentialDrive drive = new DifferentialDrive(leftSpark, rightSpark);
  // private int leftEncoderValue;
  // private int rightEncoderValue;

  /**
   * Creates a new Drivetrain.
   */
  public Drivetrain() {
    // leftEncoder.setReverseDirection(true);

  }

  @Override
  public void periodic() {
    // leftEncoderValue = leftEncoder.get();
    // rightEncoderValue = rightEncoder.get();
    // This method will be called once per scheduler run
  }

  public void setOpenLoop(double leftOut, double rightOut) {
    leftSpark.set(leftOut);
    rightSpark.set(rightOut);
  }

  public void arcadeDrive(double xSpeed, double zRotation, boolean scaleInputs) {
    if (scaleInputs) {
      xSpeed *= .8;
      zRotation *= .8;
    }
    drive.arcadeDrive(xSpeed, zRotation);
  }

  public void stop() {
    leftSpark.stopMotor();
    rightSpark.stopMotor();
  }

}
