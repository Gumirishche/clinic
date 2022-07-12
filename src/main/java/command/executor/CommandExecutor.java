package command.executor;

import command.CommandType;

import java.sql.SQLException;
import java.text.ParseException;

public interface CommandExecutor {
    int execute(String command) throws ParseException, SQLException;

    CommandType getCommandType();
}