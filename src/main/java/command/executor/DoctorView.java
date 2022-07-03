package command.executor;

import command.CommandType;
import models.Doctor;

public class DoctorView extends AbstractCommandExecutor {
    @Override
    public int execute(String command) {
        return viewDoctor();
    }

    @Override
    public CommandType getCommandType() {
        return CommandType.VIEW_DOCTOR;
    }

    private int viewDoctor() {
        for (Doctor doctor1 : doctor.findAll()) {
            System.out.printf("Id: \"%s\". Name: \"%s\"%n", doctor1.getId(), doctor1.getName());
        }
        return 1;
    }
}
