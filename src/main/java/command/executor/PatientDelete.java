package command.executor;

import command.CommandType;
import db.DB;

import java.sql.SQLException;

public class PatientDelete extends AbstractCommandExecutor {
    @Override
    public int execute(String command) throws SQLException {
        return deletePatient(command);
    }

    @Override
    public CommandType getCommandType() {
        return CommandType.DELETE_PATIENT;
    }

    private int deletePatient(String command) throws SQLException {
        var wordsArray = command.split(" ");

        var id = wordsArray[2];
        new DB().deletePatient(Integer.parseInt(id));

        return 1;
    }
}
