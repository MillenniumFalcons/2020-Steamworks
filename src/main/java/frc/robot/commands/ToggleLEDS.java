/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import java.util.function.BooleanSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.LEDS;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/latest/docs/software/commandbased/convenience-features.html
public class ToggleLEDS extends CommandBase {
  private final LEDS m_LEDS;
  private final BooleanSupplier m_hasGear;

  public ToggleLEDS(LEDS leds, BooleanSupplier hasGear) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_LEDS = leds;
    m_hasGear = hasGear;
    addRequirements(m_LEDS);
  }

  @Override
  public void execute() {
    m_LEDS.set(m_hasGear.getAsBoolean());
  }
}
