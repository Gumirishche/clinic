package command.executor;

import command.CommandType;
import models.Appointment;

import java.util.Optional;

public class AppointmentDelete extends AbstractCommandExecutor {
    @Override
    public int execute(String command) {
        return deleteAppointment(command);
    }

    @Override
    public CommandType getCommandType() {
        return CommandType.DELETE_APPOINTMENT;
    }

    private int deleteAppointment(String command) {
        var wordsArray = command.split(" ");

        int idDoctor = Integer.parseInt(wordsArray[2]);
        int idPatient = Integer.parseInt(wordsArray[3]);

        Optional<Appointment> appointmentToRemove = findAppointment(idDoctor, idPatient);

        if (appointmentToRemove.isPresent()) {
            appointment.remove(appointmentToRemove.get());

            System.out.println("appointment deleted");
        } else {
            System.out.println("appointment not found");
        }

        return 1;
    }
}
