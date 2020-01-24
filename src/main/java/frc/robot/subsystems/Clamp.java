/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Clamp extends SubsystemBase {
  // private Solenoid clamp = new Solenoid(2);
  // private Solenoid clampOff = new Solenoid(3);
  private DoubleSolenoid clamp = new DoubleSolenoid(Constants.clampPistonForward, Constants.clampPistonBackward);
  private DigitalInput gearSensor = new DigitalInput(Constants.gearSensorPin);
  private Spark clampMotor = new Spark(Constants.clampMotorPin);

  /**
   * Creates a new Clamp.
   */
  public Clamp() {

  }

  public void clamp() {
    clamp.set(Value.kForward);
  }

  public void unClamp() {
    clamp.set(Value.kReverse);
  }

  public void setOpenLoop(double demand) {
    clampMotor.set(demand);
  }

  public boolean getPosition() {
    return clamp.get() == Value.kForward;
  }

  public void intake(double demand) {
    setOpenLoop(-demand);
  }

  public void spitOut(double demand) {
    setOpenLoop(demand);
  }

  public boolean hasGear() {
    return gearSensor.get();
    // return false;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
