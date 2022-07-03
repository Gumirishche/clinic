package command.executor;

import command.CommandType;
import people.Doctor;

import java.util.Set;

public class DoctorView extends AbstractCommandExecutor{
    @Override
    public int execute(String command) {
        return viewDoctor(command);
    }

    @Override
    public CommandType getCommandType() {
        return CommandType.VIEW_DOCTOR;
    }
    private int viewDoctor(String command) {
        for (Doctor doctor1 : doctor.findAll()) {
//            System.out.println(String.format("Title: \"%s\". Text: \"%s\"", note.getTitle(), note.getText()));
            System.out.printf("Id: \"%s\". Name: \"%s\"%n", doctor1.getId(),doctor1.getName());
        }
        return 1;
    }
}
