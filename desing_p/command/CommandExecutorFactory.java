package com.practice.desing_p.command;

import com.practice.desing_p.command.core.AddCommand;
import com.practice.desing_p.command.core.Command;
import com.practice.desing_p.command.core.SubCommand;

import java.util.HashMap;
import java.util.Map;

public class CommandExecutorFactory {

	private Map<String, Command> commandExecutor = new HashMap<>();

	public CommandExecutorFactory(Calculator calculator) {
		commandExecutor.put(AddCommand.COMMAND_NAME, new AddCommand(calculator));
		commandExecutor.put(SubCommand.COMMAND_NAME, new SubCommand(calculator));
	}

	public Command getCommandExecutor(String name) {
		return commandExecutor.get(name);
	}
}
