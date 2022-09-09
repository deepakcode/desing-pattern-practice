package com.practice.desing_p.command.core;

import com.practice.desing_p.command.Calculator;
import com.practice.desing_p.command.CommandInput;

public class AddCommand extends Command {

	public static final String COMMAND_NAME = "addCommand";

	public AddCommand(Calculator calculator) {
		super(calculator);
	}

	@Override
	public void validate(CommandInput command) {
	}

	@Override
	public void execute(CommandInput command) {
		calculator.sum(5,5);
	}

}
