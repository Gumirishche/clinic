package command.executor;

import command.CommandType;
import db.DB;
import models.Doctor;

import java.sql.SQLException;

public class DoctorView extends AbstractCommandExecutor {
    @Override
    public int execute(String command) throws SQLException {
        return viewDoctor();
    }

    @Override
    public CommandType getCommandType() {
        return CommandType.VIEW_DOCTOR;
    }

    private int viewDoctor() throws SQLException {
        new DB().getDoctor();
        return 1;
    }
}
