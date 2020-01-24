/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Wrist extends SubsystemBase {
  private DoubleSolenoid wristPiston = new DoubleSolenoid(Constants.wristPistonForward, Constants.wristPistonBackward);

  /**
   * Creates a new Wrist.
   */
  public Wrist() {

  }

  public void dropDown() {
    wristPiston.set(Value.kForward);
  }

  public void grab() {
    wristPiston.set(Value.kReverse);
  }

  public boolean getPosition() {
    return wristPiston.get() != Value.kForward;
  }

}
