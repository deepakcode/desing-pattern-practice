package com.practice.desing_p.behavioral.command.mode;

import com.practice.desing_p.behavioral.command.Command;
import com.practice.desing_p.behavioral.command.factory.CommandExecutorFactory;

import java.io.*;

public class FileMode extends Mode {

    private String fileName;

    public FileMode(final CommandExecutorFactory commandExecutorFactory, final String fileName) {
        super(commandExecutorFactory);
        this.fileName = fileName;
    }

    @Override
    public void process() throws IOException {
        final File file = new File(fileName);
        final BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            System.err.println("Invalid file " + e.getMessage());
            return;
        }

        String input = reader.readLine();
        while (input != null) {
            final Command command = new Command(input);
            processCommand(command);
            input = reader.readLine();
        }
    }
}
