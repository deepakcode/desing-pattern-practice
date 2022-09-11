package com.practice.desing_p.behavioral.command.factory;

import com.practice.desing_p.behavioral.command.Command;
import com.practice.desing_p.behavioral.command.GreetingService;
import com.practice.desing_p.behavioral.command.executor.AbstractCommandExecutor;
import com.practice.desing_p.behavioral.command.executor.ExitCommandExecutor;
import com.practice.desing_p.behavioral.command.executor.HelloCommandExecutor;
import com.practice.desing_p.behavioral.command.executor.HiCommandExecutor;


import java.util.HashMap;
import java.util.Map;

public class CommandExecutorFactory {

    private Map<String, AbstractCommandExecutor> commands = new HashMap<>();

    public CommandExecutorFactory(final GreetingService greetingService) {

        commands.put(
                HelloCommandExecutor.COMMAND_NAME,
                new HelloCommandExecutor(new GreetingService()));
        commands.put(
                HiCommandExecutor.COMMAND_NAME,
                new HiCommandExecutor(new GreetingService()));
        commands.put(
                ExitCommandExecutor.COMMAND_NAME,
                new ExitCommandExecutor(new GreetingService()));

    }


    public AbstractCommandExecutor getCommandExecutor(final Command command) {
        final AbstractCommandExecutor commandExecutor = commands.get(command.getCommandName());
        if (commandExecutor == null) {
            throw new RuntimeException("Command implementation not found");
        }
        return commandExecutor;
    }

}
