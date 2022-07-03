package command.executor;

import command.CommandType;
import people.Doctor;
import repository.DoctorRepository;


public class DoctorCreate extends AbstractCommandExecutor{
    @Override
    public int execute(String command) {
        return createDoctor(command);
    }

    @Override
    public CommandType getCommandType() {
        return CommandType.CREATE_DOCTOR;
    }
    private int createDoctor(String command) {
        String[] wordsArray = command.split(" ");

        String name = wordsArray[2]+" "+wordsArray[3]+" "+wordsArray[4];

        if (findDoctor(name).isPresent()) {
            System.out.println("Doctor already exists");
            return -1;
        }

        var newDoctor = new Doctor(name);

        doctor.save(newDoctor);

        System.out.println("new doctor created");

        return 1;
    }
}
