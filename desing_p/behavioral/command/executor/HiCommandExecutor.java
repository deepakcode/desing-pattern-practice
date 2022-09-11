package com.practice.desing_p.behavioral.command.executor;

import com.practice.desing_p.behavioral.command.Command;
import com.practice.desing_p.behavioral.command.GreetingService;

public class HiCommandExecutor extends AbstractCommandExecutor {

    public static final String COMMAND_NAME ="hi" ;

    public HiCommandExecutor(GreetingService greetingService) {
        super.greetingService=greetingService;
    }


    @Override
    public boolean validateCommand(Command command) {
        System.out.println("hi validation");
        return true;
    }

    @Override
    public void executeCommand(Command command) {
        greetingService.getHi();
        System.out.println("print ~hi~");
    }
}
