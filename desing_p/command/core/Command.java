package com.practice.desing_p.command.core;

import com.practice.desing_p.command.Calculator;
import com.practice.desing_p.command.CommandInput;

public abstract class Command {
	public Calculator calculator;
	public Command(Calculator calculator) {
		this.calculator = calculator;
	}
	public abstract void validate(CommandInput command);
	public abstract void execute(CommandInput command);
}
