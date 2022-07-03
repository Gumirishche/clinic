package command.executor;

import command.CommandType;
import models.Patient;

import java.util.Optional;

public class PatientDelete extends AbstractCommandExecutor {
    @Override
    public int execute(String command) {
        return deletePatient(command);
    }

    @Override
    public CommandType getCommandType() {
        return CommandType.DELETE_PATIENT;
    }

    private int deletePatient(String command) {
        var wordsArray = command.split(" ");

        var id = wordsArray[2];

        Optional<Patient> patientToRemove = findPatientId(Integer.parseInt(id));

        if (patientToRemove.isPresent()) {
            patient.remove(patientToRemove.get());

            System.out.println("patient deleted");
        } else {
            System.out.println("patient not found");
        }

        return 1;
    }
}
