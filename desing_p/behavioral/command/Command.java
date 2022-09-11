package com.practice.desing_p.behavioral.command;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Command {

    String commandName;
    List<String> params;

    public Command(String commandString) {
        List<String> list = Arrays.stream(commandString.trim().split(" ")).map(String::trim).collect(Collectors.toList());
        if (list.size() == 0)
            throw new RuntimeException("Invalid command string");
        commandName = list.remove(0);
        params = list;
    }

    public String getCommandName() {
        return commandName;
    }

    public List<String> getParams() {
        return params;
    }
}
