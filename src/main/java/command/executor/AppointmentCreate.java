package command.executor;

import command.CommandType;
import models.Appointment;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AppointmentCreate extends AbstractCommandExecutor {
    @Override
    public int execute(String command) throws ParseException {
        return createAppointment(command);
    }

    @Override
    public CommandType getCommandType() {
        return CommandType.CREATE_APPOINTMENT;
    }

    private int createAppointment(String command) {
        String[] wordsArray = command.split(" ");

        int idDoctor = Integer.parseInt(wordsArray[2]);
        int idPatient = Integer.parseInt(wordsArray[3]);
        String dateString = wordsArray[4] + " " + wordsArray[5];
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String date = LocalDateTime.parse(dateString, formatter).toString();

        if (findAppointment(idDoctor, idPatient).isPresent()) {
            System.out.println("Appointment already exists");
            return -1;
        }
        if (findDoctorId(idDoctor).isPresent() && findPatientId(idPatient).isPresent()) {
            var newAppointment = new Appointment(idDoctor, idPatient, date);

            appointment.save(newAppointment);
            createAppointmentNames(idDoctor, idPatient);

            System.out.println("new appointment created");
        } else {
            System.out.println("Doctor or patient is not found");
        }
        return 1;
    }
}
