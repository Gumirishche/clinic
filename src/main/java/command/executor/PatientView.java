package command.executor;

import command.CommandType;
import people.Doctor;
import people.Patient;

public class PatientView extends AbstractCommandExecutor{
    @Override
    public int execute(String command) {
        return viewPatient(command);
    }

    @Override
    public CommandType getCommandType() {
        return CommandType.VIEW_PATIENT;
    }
    private int viewPatient(String command) {
        for (Patient patient1 : patient.findAll()) {
            String date=patient1.getCreationDate().toString();
            System.out.printf("Id: \"%s\". Name: \"%s\". Creation date: \"%s\"%n", patient1.getId(),patient1.getName(),date.substring(0,10));
        }
        return 1;
    }
}
