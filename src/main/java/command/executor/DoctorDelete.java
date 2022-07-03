package command.executor;

import command.CommandType;
import models.Doctor;

import java.util.Optional;

public class DoctorDelete extends AbstractCommandExecutor {
    @Override
    public int execute(String command) {
        return deleteDoctor(command);
    }

    @Override
    public CommandType getCommandType() {
        return CommandType.DELETE_DOCTOR;
    }

    private int deleteDoctor(String command) {
        var wordsArray = command.split(" ");

        var doctorIdToRemove = wordsArray[2];

        Optional<Doctor> doctorToRemove = findDoctorId(Integer.parseInt(doctorIdToRemove));

        if (doctorToRemove.isPresent()) {
            doctor.remove(doctorToRemove.get());

            System.out.println("doctor deleted");
        } else {
            System.out.println("doctor not found");
        }

        return 1;
    }
}
