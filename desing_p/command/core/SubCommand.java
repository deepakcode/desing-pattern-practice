package com.practice.desing_p.command.core;

import com.practice.desing_p.command.Calculator;
import com.practice.desing_p.command.CommandInput;

public class SubCommand extends Command {

	public static final String COMMAND_NAME = "subCommand";

	public SubCommand(Calculator calculator) {
		super(calculator);
	}

	@Override
	public void validate(CommandInput command) {

	}

	@Override
	public void execute(CommandInput command) {
		calculator.sub(5,5);
	}
}
