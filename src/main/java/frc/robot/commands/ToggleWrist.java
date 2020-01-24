/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.Wrist;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/latest/docs/software/commandbased/convenience-features.html
public class ToggleWrist extends InstantCommand {
  private final Wrist m_wrist;

  public ToggleWrist(Wrist wrist) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_wrist = wrist;
    addRequirements(m_wrist);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    System.out.println("wrist out: " + m_wrist.getPosition());
    if(m_wrist.getPosition()) {
      m_wrist.dropDown();
    } else {
      m_wrist.grab();
    }
  }
}
