package com.practice.desing_p.behavioral.command.mode;

import com.practice.desing_p.behavioral.command.Command;
import com.practice.desing_p.behavioral.command.executor.AbstractCommandExecutor;
import com.practice.desing_p.behavioral.command.factory.CommandExecutorFactory;

import java.io.IOException;


public abstract class Mode {

  private CommandExecutorFactory commandExecutorFactory;

  public Mode(CommandExecutorFactory commandExecutorFactory){
      this.commandExecutorFactory = commandExecutorFactory;
  }

  protected void processCommand(final Command command) {
    final AbstractCommandExecutor commandExecutor = commandExecutorFactory.getCommandExecutor(command);
    if (commandExecutor.validateCommand(command)) {
      commandExecutor.executeCommand(command);
    } else {
      throw new RuntimeException("Command validation failed");
    }
  }

  public abstract void process() throws IOException;
}
