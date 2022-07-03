package authentication;

import java.util.Scanner;

import static java.lang.System.in;

public class Authentication {
    private static final String LOGIN = "Gumir";
    private static final String PASSWORD = "123";


    public static void authentication() {
        Scanner s = new Scanner(in);
        int maxAttempts=3;
        int i=0;
        while (i<maxAttempts){
        System.out.println("Login:");
        String login = s.nextLine();
        System.out.println("Password:");
        String password= s.nextLine();
        if(login.equals(LOGIN) && password.equals(PASSWORD)){
            System.out.println("authentication success");
            i=3;
        }
        else {
            System.out.println("incorrect login or password");
            i++;
            System.out.println("there are"+ " " +(maxAttempts-i)+ " " +"attempts left");
        }
        }
    }
}
