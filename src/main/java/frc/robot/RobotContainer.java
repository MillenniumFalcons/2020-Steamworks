/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.commands.ArcadeDrive;
import frc.robot.commands.ClampIntake;
import frc.robot.commands.ToggleLEDS;
import frc.robot.subsystems.Clamp;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.LEDS;
import frc.robot.subsystems.Wrist;

/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a "declarative" paradigm, very little robot logic should
 * actually be handled in the {@link Robot} periodic methods (other than the
 * scheduler calls). Instead, the structure of the robot (including subsystems,
 * commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...

  private Joysticks mainController = new Joysticks(0);

  private final Drivetrain m_drivetrain;
  private final Clamp m_clamp;
  private final Wrist m_wrist;
  private final LEDS m_leds;

  /**
   * The container for the robot. Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    m_drivetrain = new Drivetrain();
    m_clamp = new Clamp();
    m_wrist = new Wrist();
    m_leds = new LEDS();

    CommandScheduler.getInstance().setDefaultCommand(m_drivetrain, new ArcadeDrive(m_drivetrain,
        mainController::getLeftStickY, mainController::getRightStickX, mainController.rightJoyStickPress::get));

    CommandScheduler.getInstance().setDefaultCommand(m_leds, new
    ToggleLEDS(m_leds, m_clamp::hasGear));
    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be
   * created by instantiating a {@link GenericHID} or one of its subclasses
   * ({@link edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then
   * passing it to a {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {

    mainController.leftTrigger.whenActive(new InstantCommand(m_wrist::dropDown, m_wrist));

    mainController.leftTrigger.whenInactive(new InstantCommand(m_wrist::grab, m_wrist));

    mainController.rightTrigger.whenActive(new ClampIntake(m_clamp, mainController.rightTrigger::getTriggerValue));

    mainController.buttonA.whenActive(new InstantCommand(m_clamp::unClamp, m_clamp));
    mainController.buttonA.whenInactive(new InstantCommand(m_clamp::clamp, m_clamp));

  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return null;
  }
}
