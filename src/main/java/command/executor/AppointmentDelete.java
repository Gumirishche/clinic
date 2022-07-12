package command.executor;

import command.CommandType;
import db.DB;
import models.Appointment;

import java.sql.SQLException;
import java.util.Optional;

public class AppointmentDelete extends AbstractCommandExecutor {
    @Override
    public int execute(String command) throws SQLException {
        return deleteAppointment(command);
    }

    @Override
    public CommandType getCommandType() {
        return CommandType.DELETE_APPOINTMENT;
    }

    private int deleteAppointment(String command) throws SQLException {
        var wordsArray = command.split(" ");

        var idDoctor = Integer.parseInt(wordsArray[2]);
        var  idPatient =Integer.parseInt(wordsArray[3]);

        new DB().deleteAppointment(idDoctor,idPatient);


            System.out.println("appointment deleted");

        return 1;
    }
}
