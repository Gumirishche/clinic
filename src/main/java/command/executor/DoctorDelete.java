package command.executor;

import command.CommandType;
import db.DB;

import java.sql.SQLException;

public class DoctorDelete extends AbstractCommandExecutor {
    @Override
    public int execute(String command) throws SQLException {
        return deleteDoctor(command);
    }

    @Override
    public CommandType getCommandType() {
        return CommandType.DELETE_DOCTOR;
    }

    private int deleteDoctor(String command) throws SQLException {
        var wordsArray = command.split(" ");

        var doctorIdToRemove = wordsArray[2];

        new DB().deleteDoctor(Integer.parseInt(doctorIdToRemove));


        return 1;
    }
}
