package command.executor;

import command.CommandType;
import people.Doctor;

import java.util.Optional;

public class DoctorDelete extends AbstractCommandExecutor{
    @Override
    public int execute(String command) {
        return deleteDoctor(command);
    }

    @Override
    public CommandType getCommandType() {
        return CommandType.DELETE_DOCTOR;
    }

    private int deleteDoctor(String command){
        var wordsArray = command.split(" ");

        var doctorNameToRemove = wordsArray[2]+" "+wordsArray[3]+" "+wordsArray[4];

        Optional<Doctor> doctorToRemove = findDoctor(doctorNameToRemove);

        if (doctorToRemove.isPresent()) {
            doctor.remove(doctorToRemove.get());

            System.out.println("doctor deleted");
        } else {
            System.out.println("doctor not found");
        }

        return 1;
    }
}
