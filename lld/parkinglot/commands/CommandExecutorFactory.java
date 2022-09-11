package com.practice.lld.parkinglot.commands;

import com.practice.lld.parkinglot.OutputPrinter;
import com.practice.lld.parkinglot.commands.impl.*;
import com.practice.lld.parkinglot.exception.InvalidCommandException;
import com.practice.lld.parkinglot.service.ParkingLotService;
import java.util.HashMap;
import java.util.Map;

/**
 * Factory to get correct {@link CommandExecutor} from a given command.
 */
public class CommandExecutorFactory {

  private Map<String, CommandExecutor> commands = new HashMap<>();

  public CommandExecutorFactory(final ParkingLotService parkingLotService) {

    final OutputPrinter outputPrinter = new OutputPrinter();
    commands.put(
        CreateParkingLotCommandExecutorExecutor.COMMAND_NAME,
        new CreateParkingLotCommandExecutorExecutor(parkingLotService, outputPrinter));
    commands.put(
        ParkCommandExecutorExecutor.COMMAND_NAME,
        new ParkCommandExecutorExecutor(parkingLotService, outputPrinter));
    commands.put(
        UnParkCommandExecutorExecutor.COMMAND_NAME,
        new UnParkCommandExecutorExecutor(parkingLotService, outputPrinter));
    commands.put(
        StatusCommandExecutorExecutor.COMMAND_NAME,
        new StatusCommandExecutorExecutor(parkingLotService, outputPrinter));
    commands.put(
        ColorToRegNumberCommandExecutorExecutor.COMMAND_NAME,
        new ColorToRegNumberCommandExecutorExecutor(parkingLotService, outputPrinter));
    commands.put(
        ColorToSlotNumberCommandExecutorExecutor.COMMAND_NAME,
        new ColorToSlotNumberCommandExecutorExecutor(parkingLotService, outputPrinter));
    commands.put(
        SlotForRegNumberCommandExecutorExecutor.COMMAND_NAME,
        new SlotForRegNumberCommandExecutorExecutor(parkingLotService, outputPrinter));
    commands.put(
        ExitCommandExecutorExecutor.COMMAND_NAME,
        new ExitCommandExecutorExecutor(parkingLotService, outputPrinter));
  }

  /**
   * Gets {@link CommandExecutor} for a particular command. It basically uses name of command to
   * fetch its corresponding executor.
   *
   * @param command Command for which executor has to be fetched.
   * @return Command executor.
   */
  public CommandExecutor getCommandExecutor(final Command command) {
    final CommandExecutor commandExecutor = commands.get(command.getCommandName());
    if (commandExecutor == null) {
      throw new InvalidCommandException();
    }
    return commandExecutor;
  }
}
