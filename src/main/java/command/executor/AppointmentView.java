package command.executor;

import command.CommandType;
import db.DB;

import java.sql.SQLException;

public class AppointmentView extends AbstractCommandExecutor {
    @Override
    public int execute(String command) throws SQLException {
        return viewAppointment(command);
    }

    @Override
    public CommandType getCommandType() {
        return CommandType.VIEW_APPOINTMENT;
    }

    private int viewAppointment(String command) throws SQLException {
        var wordsArray = command.split(" ");
        int appointmentPatient = Integer.parseInt(wordsArray[1]);
        new DB().getAppointment(appointmentPatient);
        return 1;
    }
}
