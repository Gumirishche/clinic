package command;


import command.executor.*;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.Map;
import java.util.Scanner;

public class CommandReader {
    private static final Map<CommandType, CommandExecutor> COMMAND_EXECUTORS_GROUPED_BY_COMMAND = Map.of(
            CommandType.CREATE_DOCTOR, new DoctorCreate(),
            //CommandType.DELETE_DOCTOR, new DoctorDelete(),
            CommandType.VIEW_DOCTOR, new DoctorView(),
            CommandType.CREATE_PATIENT, new PatientCreate(),
            CommandType.DELETE_PATIENT, new PatientDelete(),
            CommandType.UPDATE_PATIENT, new PatientUpdate(),
            CommandType.VIEW_PATIENT, new PatientView(),
            CommandType.CREATE_APPOINTMENT, new AppointmentCreate(),
            CommandType.DELETE_APPOINTMENT, new AppointmentDelete(),
            CommandType.UPDATE_APPOINTMENT, new AppointmentUpdate(),
            CommandType.VIEW_APPOINTMENT, new AppointmentView()
    );
    public static void startReading() throws ParseException, SQLException {
        Scanner s = new Scanner(System.in);

        int i = 1;
        while (i != 0) {
            i = readCommand(s);
        }

        s.close();
    }

    private static int readCommand(Scanner s) throws ParseException, SQLException {
        var commandString = s.nextLine();

        CommandType commandType = getCommandType(commandString);

        if (COMMAND_EXECUTORS_GROUPED_BY_COMMAND.containsKey(commandType)) {
            var commandExecutor = COMMAND_EXECUTORS_GROUPED_BY_COMMAND.get(commandType);
            return commandExecutor.execute(commandString);
        }

        if (commandType == CommandType.EXIT) {
            return 0;
        }
        if (commandType == CommandType.HELP) {
            System.out.println("""
                    create doctor name name name
                    doctors
                    create patient name
                    delete patient id
                    patients
                    update patient id newname
                    create appointment idDoctor idPatient date(yyyy-MM-dd) time(HH:mm)
                    delete appointment idDoctor idPatient
                    appointments idPatient
                    update appointment idDoctor idPatient status(new,in_process,awaiting_payment,canceled,completed)""");
        } else {
            System.out.println("Incorrect command");
        }
        return 1;
    }

    private static CommandType getCommandType(String commandString) {
        if (commandString.contains("create doctor")) {
            return CommandType.CREATE_DOCTOR;
        }

        if (commandString.contains("create patient")) {
            return CommandType.CREATE_PATIENT;
        }

        if (commandString.contains("create appointment")) {
            return CommandType.CREATE_APPOINTMENT;
        }

        if (commandString.contains("delete patient")) {
            return CommandType.DELETE_PATIENT;
        }

        if (commandString.contains("delete appointment")) {
            return CommandType.DELETE_APPOINTMENT;
        }

        if (commandString.contains("delete doctor")) {
            return CommandType.DELETE_DOCTOR;
        }

        if (commandString.contains("doctors")) {
            return CommandType.VIEW_DOCTOR;
        }

        if (commandString.contains("appointments")) {
            return CommandType.VIEW_APPOINTMENT;
        }

        if (commandString.contains("patients")) {
            return CommandType.VIEW_PATIENT;
        }

        if (commandString.contains("update patient")) {
            return CommandType.UPDATE_PATIENT;
        }

        if (commandString.contains("update appointment")) {
            return CommandType.UPDATE_APPOINTMENT;
        }

        if (commandString.contains("help")) {
            return CommandType.HELP;
        }

        if (commandString.contains("exit")) {
            return CommandType.EXIT;
        }

        return CommandType.UNDEFINED;
    }
}
