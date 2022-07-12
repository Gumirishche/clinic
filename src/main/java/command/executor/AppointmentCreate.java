package command.executor;

import command.CommandType;
import db.DB;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AppointmentCreate extends AbstractCommandExecutor {

    @Override
    public int execute(String command) throws ParseException, SQLException {
        return createAppointment(command);
    }

    @Override
    public CommandType getCommandType() {
        return CommandType.CREATE_APPOINTMENT;
    }

    private int createAppointment(String command) throws SQLException {
        String[] wordsArray = command.split(" ");

        var idDoctor = Integer.parseInt(wordsArray[2]);
        var idPatient = Integer.parseInt(wordsArray[3]);
        String dateString = wordsArray[4] + " " + wordsArray[5];
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String date = LocalDateTime.parse(dateString, formatter).toString();

            new DB().createAppointment(idDoctor,idPatient,date);

            System.out.println("new appointment created");
        return 1;
    }
}
