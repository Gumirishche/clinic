package command.executor;

import command.CommandType;
import people.Doctor;
import people.Patient;

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

    private int deletePatient(String command){
        var wordsArray = command.split(" ");

        var patientNameToRemove = wordsArray[2]+" "+wordsArray[3]+" "+wordsArray[4];

        Optional<Patient> patientToRemove = findPatient(patientNameToRemove);

        if (patientToRemove.isPresent()) {
            patient.remove(patientToRemove.get());

            System.out.println("patient deleted");
        } else {
            System.out.println("patient not found");
        }

        return 1;
    }
}
