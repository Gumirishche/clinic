package command.executor;

import command.CommandType;
import models.StatusList;

import java.util.Map;

public class AppointmentUpdate extends AbstractCommandExecutor{
    private static final Map<String,StatusList> STATUS_LIST_STRING_MAP = Map.of(
            "new",StatusList.NEW,
            "in_process",StatusList.IN_PROCESS,
            "awaiting_payment",StatusList.AWAITING_PAYMENT,
            "canceled" ,StatusList.CANCELED,
            "completed",StatusList.COMPLETED
    );
    @Override
    public int execute(String command) {
        return updateAppointment(command);
    }

    @Override
    public CommandType getCommandType() {
        return CommandType.UPDATE_APPOINTMENT;
    }

    private int updateAppointment(String command) {
        var wordsArray = command.split(" ");

        var doctorId = Integer.parseInt(wordsArray[2]);

        var patientId = Integer.parseInt(wordsArray[3]);

        var statusString=wordsArray[4];

        updateAppointment(doctorId,patientId,STATUS_LIST_STRING_MAP.get(statusString));

        System.out.println("Appointment was updated");

        return 1;
    }
}
