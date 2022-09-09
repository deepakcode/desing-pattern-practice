package com.practice.desing_p.command.mode;

import com.practice.desing_p.command.CommandExecutorFactory;
import com.practice.desing_p.command.CommandInput;
import com.practice.desing_p.command.core.Command;

public class InteractiveMode {

    CommandExecutorFactory factory;

    public InteractiveMode(CommandExecutorFactory factory) {
        this.factory = factory;
    }

    public void process() {
        //Take this input from console
        String commandtext = "addCommand KA-01-HH-1234 White";

        CommandInput commandInput = new CommandInput(commandtext);
        Command command = factory.getCommandExecutor(commandInput.getCommandName());
        command.execute(commandInput);
    }
}
