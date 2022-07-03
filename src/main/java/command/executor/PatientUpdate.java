package command.executor;

import command.CommandType;
import people.Patient;

import java.util.Optional;

public class PatientUpdate extends AbstractCommandExecutor{
    @Override
    public int execute(String command) {
        return updatePatient(command);
    }

    @Override
    public CommandType getCommandType() {
        return CommandType.UPDATE_PATIENT;
    }

    private int updatePatient(String command) {
        var wordsArray = command.split(" ");

        var patientNameOld = wordsArray[2] +" "+ wordsArray[3] +" "+ wordsArray[4];

        var patientNameNew = wordsArray[5] +" "+ wordsArray[6] +" "+ wordsArray[7];

        updatePatient(patientNameOld,patientNameNew);

        System.out.println("Patient was renamed");

        return 1;
    }
}
