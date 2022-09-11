package com.practice.desing_p.behavioral.command.mode;


import com.practice.desing_p.behavioral.command.Command;
import com.practice.desing_p.behavioral.command.executor.ExitCommandExecutor;
import com.practice.desing_p.behavioral.command.factory.CommandExecutorFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InteractiveMode extends Mode {

    public InteractiveMode(
            final CommandExecutorFactory commandExecutorFactory) {
        super(commandExecutorFactory);
    }

    @Override
    public void process() throws IOException {
        final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {

            final String input = reader.readLine();
            final Command command = new Command(input);
            processCommand(command);
            if (command.getCommandName().equals(ExitCommandExecutor.COMMAND_NAME)) {
                break;
            }

        }
    }
}
