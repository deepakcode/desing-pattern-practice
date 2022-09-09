package com.practice.parkinglot.commands;

import com.practice.parkinglot.OutputPrinter;
import com.practice.parkinglot.commands.impl.*;
import com.practice.parkinglot.exception.InvalidCommandException;
import com.practice.parkinglot.service.ParkingLotService;
import java.util.HashMap;
import java.util.Map;

/**
 * Factory to get correct {@link ICommand} from a given command.
 */
public class CommandExecutorFactory {

  private Map<String, ICommand> commands = new HashMap<>();

  public CommandExecutorFactory(final ParkingLotService parkingLotService) {

    final OutputPrinter outputPrinter = new OutputPrinter();
    commands.put(
        CreateParkingLotCommandExecutor.COMMAND_NAME,
        new CreateParkingLotCommandExecutor(parkingLotService, outputPrinter));
    commands.put(
        ParkCommandExecutor.COMMAND_NAME,
        new ParkCommandExecutor(parkingLotService, outputPrinter));
    commands.put(
        UnParkCommandExecutor.COMMAND_NAME,
        new UnParkCommandExecutor(parkingLotService, outputPrinter));
    commands.put(
        StatusCommandExecutor.COMMAND_NAME,
        new StatusCommandExecutor(parkingLotService, outputPrinter));
    commands.put(
        ColorToRegNumberCommandExecutor.COMMAND_NAME,
        new ColorToRegNumberCommandExecutor(parkingLotService, outputPrinter));
    commands.put(
        ColorToSlotNumberCommandExecutor.COMMAND_NAME,
        new ColorToSlotNumberCommandExecutor(parkingLotService, outputPrinter));
    commands.put(
        SlotForRegNumberCommandExecutor.COMMAND_NAME,
        new SlotForRegNumberCommandExecutor(parkingLotService, outputPrinter));
    commands.put(
        ExitCommandExecutor.COMMAND_NAME,
        new ExitCommandExecutor(parkingLotService, outputPrinter));
  }

  /**
   * Gets {@link ICommand} for a particular command. It basically uses name of command to
   * fetch its corresponding executor.
   *
   * @param command Command for which executor has to be fetched.
   * @return Command executor.
   */
  public ICommand getCommandExecutor(final Command command) {
    final ICommand commandExecutor = commands.get(command.getCommandName());
    if (commandExecutor == null) {
      throw new InvalidCommandException();
    }
    return commandExecutor;
  }
}
