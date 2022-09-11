package com.practice.lld.parkinglot.mode;

import com.practice.lld.parkinglot.OutputPrinter;
import com.practice.lld.parkinglot.commands.CommandExecutorFactory;
import com.practice.lld.parkinglot.commands.impl.ExitCommandExecutorExecutor;
import com.practice.lld.parkinglot.commands.Command;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Mode running in which input commands are given from an interactive shell.
 */
public class InteractiveMode extends Mode {

  public InteractiveMode(
      final CommandExecutorFactory commandExecutorFactory, final OutputPrinter outputPrinter) {
    super(commandExecutorFactory, outputPrinter);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void process() throws IOException {
    outputPrinter.welcome();
    final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    while (true) {

      final String input = reader.readLine();
      final Command command = new Command(input);
      processCommand(command);
      if (command.getCommandName().equals(ExitCommandExecutorExecutor.COMMAND_NAME)) {
        break;
      }

    }
  }
}
