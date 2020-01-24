/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class LEDS extends SubsystemBase {

  private Solenoid led = new Solenoid(Constants.ledPCMPin);
  /**
   * Creates a new LEDS.
   */
  public LEDS() {

  }

  public void turnOn() {
    led.set(true);
  }

  public void turnOff() {
    led.set(false);
  }

  public void set(boolean on) {
    led.set(on);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
