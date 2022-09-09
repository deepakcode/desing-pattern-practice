package com.practice.desing_p.command;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CommandInput {

    String commandName;
    List<String> param;

    public List<String> getParam() {
        return param;
    }

    public String getCommandName() {
        return commandName;
    }

    public CommandInput(String comandText){
        List<String> tokens =
                Arrays.stream(comandText.split(" ")).map(s->s.trim()).collect(Collectors.toList());
        commandName= tokens.get(0);
        param=tokens;
    }

}
