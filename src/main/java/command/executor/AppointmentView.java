package command.executor;

import command.CommandType;
import models.Appointment;

import java.util.Optional;

public class AppointmentView extends AbstractCommandExecutor {
    @Override
    public int execute(String command) {
        return viewAppointment(command);
    }

    @Override
    public CommandType getCommandType() {
        return CommandType.VIEW_APPOINTMENT;
    }

    private int viewAppointment(String command) {
        var wordsArray = command.split(" ");
        String appointmentPatient = wordsArray[1];
        Optional<Appointment> appointments = findAppointmentPatient(appointmentPatient);
        for (Appointment appointment1 : appointment.findAll()) {
            if (appointments.isPresent()) {
                System.out.printf("NameDoctor: \"%s\". IdDoctor: \"%s\". NamePatient: \"%s\". IdPatient: \"%s\". Date: \"%s\" Status:\"%s\"%n", appointment1.getNameDoctor(), appointment1.getIdDoctor(), appointment1.getNamePatient(), appointment1.getIdPatient(), appointment1.getDate(), appointment1.getStatus());
            }
        }
        return 1;
    }
}
