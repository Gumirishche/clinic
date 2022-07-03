package command.executor;

import command.CommandType;
import models.Patient;

public class PatientView extends AbstractCommandExecutor {
    @Override
    public int execute(String command) {
        return viewPatient();
    }

    @Override
    public CommandType getCommandType() {
        return CommandType.VIEW_PATIENT;
    }

    private int viewPatient() {
        for (Patient patient1 : patient.findAll()) {
            String date = patient1.getCreationDate().toString();
            System.out.printf("Id: \"%s\". Name: \"%s\". Creation date: \"%s\"%n", patient1.getId(), patient1.getName(), date.substring(0, 10));
        }
        return 1;
    }
}
