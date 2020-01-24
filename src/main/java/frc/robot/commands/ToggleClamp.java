/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.Clamp;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/latest/docs/software/commandbased/convenience-features.html
public class ToggleClamp extends InstantCommand {
  private final Clamp m_clamp;

  public ToggleClamp(Clamp clamp) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_clamp = clamp;
    addRequirements(m_clamp);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    if(m_clamp.getPosition()) {
      m_clamp.unClamp();
    } else {
      m_clamp.clamp();
    }
  }
}
