package command.executor;

import command.CommandType;
import db.DB;
import models.Patient;

import java.sql.SQLException;

public class PatientView extends AbstractCommandExecutor {
    @Override
    public int execute(String command) throws SQLException {
        return viewPatient();
    }

    @Override
    public CommandType getCommandType() {
        return CommandType.VIEW_PATIENT;
    }

    private int viewPatient() throws SQLException {
        new DB().getPatient();
        return 1;
    }
}
