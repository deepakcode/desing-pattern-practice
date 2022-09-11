package com.practice.lld.parkinglot.commands.impl;

import com.practice.lld.parkinglot.OutputPrinter;
import com.practice.lld.parkinglot.commands.CommandExecutor;
import com.practice.lld.parkinglot.commands.Command;
import com.practice.lld.parkinglot.service.ParkingLotService;

/**
 * Executor to handle command of exiting from the parking lot service. This is used in interactive
 * mode to exit.
 */
public class ExitCommandExecutorExecutor extends CommandExecutor {
  public static String COMMAND_NAME = "exit";

  public ExitCommandExecutorExecutor(
      final ParkingLotService parkingLotService, final OutputPrinter outputPrinter) {
    super(parkingLotService, outputPrinter);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean validate(final Command command) {
    return command.getParams().isEmpty();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void execute(final Command command) {
    outputPrinter.end();
  }
}
