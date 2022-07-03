package command.executor;

import command.CommandType;

import java.text.ParseException;

public interface CommandExecutor {
    int execute(String command) throws ParseException;

    CommandType getCommandType();
}