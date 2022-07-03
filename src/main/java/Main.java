import authentication.Authentication;
import command.CommandReader;

import java.text.ParseException;

public class Main {
    public static void main(String[] args) throws ParseException {
        Authentication.authentication();
        CommandReader.startReading();
    }
}
