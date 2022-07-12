package command.executor;

import command.CommandType;
import db.DB;

import java.sql.SQLException;

public class PatientCreate extends AbstractCommandExecutor {
    @Override
    public int execute(String command) throws SQLException {
        return createPatient(command);
    }

    @Override
    public CommandType getCommandType() {
        return CommandType.CREATE_PATIENT;
    }

    private int createPatient(String command) throws SQLException {
        String[] wordsArray = command.split(" ");

        String name = wordsArray[2];

        new DB().createPatient(name);

        return 1;
    }
}
