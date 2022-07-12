package command.executor;

import command.CommandType;
import db.DB;
import models.Doctor;

import java.sql.SQLException;


public class DoctorCreate extends AbstractCommandExecutor {
    @Override
    public int execute(String command) throws SQLException {
        return createDoctor(command);
    }

    @Override
    public CommandType getCommandType() {
        return CommandType.CREATE_DOCTOR;
    }

    private int createDoctor(String command) throws SQLException {
        String[] wordsArray = command.split(" ");

        String name = wordsArray[2] + " " + wordsArray[3] + " " + wordsArray[4];

        new DB().createDoctor(name);

        return 1;
    }
}
