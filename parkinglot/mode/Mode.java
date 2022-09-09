package com.practice.parkinglot.mode;

import com.practice.parkinglot.OutputPrinter;
import com.practice.parkinglot.commands.ICommand;
import com.practice.parkinglot.commands.CommandExecutorFactory;
import com.practice.parkinglot.exception.InvalidCommandException;
import com.practice.parkinglot.commands.Command;
import java.io.IOException;

/**
 * Interface for mode of the program in which it can be run.
 */
public abstract class Mode {

  private CommandExecutorFactory commandExecutorFactory;
  protected OutputPrinter outputPrinter;

  public Mode(
      final CommandExecutorFactory commandExecutorFactory, final OutputPrinter outputPrinter) {
    this.commandExecutorFactory = commandExecutorFactory;
    this.outputPrinter = outputPrinter;
  }

  /**
   * Helper method to process a command. It basically uses {@link ICommand} to run the given
   * command.
   *
   * @param command Command to be processed.
   */
  protected void processCommand(final Command command) {
    final ICommand commandExecutor = commandExecutorFactory.getCommandExecutor(command);
    if (commandExecutor.validate(command)) {
      commandExecutor.execute(command);
    } else {
      throw new InvalidCommandException();
    }
  }

  /**
   * Abstract method to process the mode. Each mode will process in its own way.
   *
   * @throws IOException
   */
  public abstract void process() throws IOException;
}
