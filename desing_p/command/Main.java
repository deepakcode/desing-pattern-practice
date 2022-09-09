package com.practice.desing_p.command;


import com.practice.desing_p.command.mode.InteractiveMode;

public class Main {

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        CommandExecutorFactory factory = new CommandExecutorFactory(calculator);
        new InteractiveMode(factory).process();
    }
}
