package com.practice.desing_p.behavioral.command.executor;

import com.practice.desing_p.behavioral.command.Command;
import com.practice.desing_p.behavioral.command.GreetingService;

public class ExitCommandExecutor extends AbstractCommandExecutor {

    public static final String COMMAND_NAME ="exit" ;

    public ExitCommandExecutor(GreetingService greetingService) {
        super.greetingService=greetingService;
    }


    @Override
    public boolean validateCommand(Command command) {
        System.out.println("Exit validation");
        return true;
    }

    @Override
    public void executeCommand(Command command) {
        greetingService.getHi();
        System.out.println("print ~Exit, bye!~");
    }
}
