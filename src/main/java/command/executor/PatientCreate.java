package command.executor;

import command.CommandType;
import people.Doctor;
import people.Patient;

import java.time.Instant;

public class PatientCreate extends AbstractCommandExecutor{
    @Override
    public int execute(String command) {
        return createPatient(command);
    }

    @Override
    public CommandType getCommandType() {
        return CommandType.CREATE_PATIENT;
    }
    private int createPatient(String command) {
        String[] wordsArray = command.split(" ");

        String name = wordsArray[2]+" "+wordsArray[3]+" "+wordsArray[4];

        if (findPatient(name).isPresent()) {
            System.out.println("Patient already exists");
            return -1;
        }

        var newPatient = new Patient(name);

        patient.save(newPatient);

        System.out.println("new patient created");

        return 1;
    }
}
