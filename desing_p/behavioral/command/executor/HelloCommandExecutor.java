package com.practice.desing_p.behavioral.command.executor;

import com.practice.desing_p.behavioral.command.Command;
import com.practice.desing_p.behavioral.command.GreetingService;

public class HelloCommandExecutor extends AbstractCommandExecutor {

    public static String COMMAND_NAME="hello";

    public HelloCommandExecutor(GreetingService greetingService) {
       super.greetingService=greetingService;
    }


    @Override
    public boolean validateCommand(Command command) {
        System.out.println("hello validation");
        return true;
    }

    @Override
    public void executeCommand(Command command) {
        greetingService.getHello();
        System.out.println("print ~hello~");
    }
}
