package command.executor;

import command.CommandType;
import db.DB;

import java.sql.SQLException;

public class PatientUpdate extends AbstractCommandExecutor {
    @Override
    public int execute(String command) throws SQLException {
        return updatePatient(command);
    }

    @Override
    public CommandType getCommandType() {
        return CommandType.UPDATE_PATIENT;
    }

    private int updatePatient(String command) throws SQLException {
        var wordsArray = command.split(" ");

        var patientId = wordsArray[2];

        var patientNameNew = wordsArray[3];

        new DB().updatePatient(patientId, patientNameNew);

        System.out.println("Patient was renamed");

        return 1;
    }
}
