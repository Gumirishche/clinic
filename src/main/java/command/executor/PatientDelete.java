package command.executor;

import command.CommandType;
import db.DB;
import models.Patient;

import java.sql.SQLException;
import java.util.Optional;

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
