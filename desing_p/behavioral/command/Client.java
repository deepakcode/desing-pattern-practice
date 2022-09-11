package com.practice.desing_p.behavioral.command;


import com.practice.desing_p.behavioral.command.factory.CommandExecutorFactory;
import com.practice.desing_p.behavioral.command.mode.FileMode;
import com.practice.desing_p.behavioral.command.mode.InteractiveMode;

import java.io.IOException;

class Main {
    public static void main(final String[] args) throws IOException {
        //args[0]="file_input.txt";

        final GreetingService greetingService = new GreetingService();
        final CommandExecutorFactory commandExecutorFactory =
                new CommandExecutorFactory(greetingService);

        if (isInteractiveMode(args)) {
            new InteractiveMode(commandExecutorFactory).process();
        } else if (isFileInputMode(args)) {
            new FileMode(commandExecutorFactory, args[0]).process();
        } else {
            throw new RuntimeException("Invalid mode exception");
        }
    }

    private static boolean isFileInputMode(final String[] args) {
        return args.length == 1;
    }

    private static boolean isInteractiveMode(final String[] args) {
        return args.length == 0;
    }
}
