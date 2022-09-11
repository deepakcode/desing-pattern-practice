package com.practice.desing_p.behavioral.command.executor;

import com.practice.desing_p.behavioral.command.Command;
import com.practice.desing_p.behavioral.command.GreetingService;

public abstract class AbstractCommandExecutor {

    GreetingService greetingService;

    public abstract boolean validateCommand(Command command);
    public abstract void executeCommand(Command command);
}
