package command.executor;

import command.CommandType;

public class PatientUpdate extends AbstractCommandExecutor {
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

        var patientId = wordsArray[2];

        var patientNameNew = wordsArray[3] + " " + wordsArray[4] + " " + wordsArray[5];

        updatePatient(patientId, patientNameNew);

        System.out.println("Patient was renamed");

        return 1;
    }
}
