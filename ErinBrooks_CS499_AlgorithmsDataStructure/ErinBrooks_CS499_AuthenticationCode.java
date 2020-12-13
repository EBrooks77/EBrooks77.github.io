//============================================================================
// Name        : AuthenticationCode.java
// Author      : Erin Brooks
// Description : Authentication Code in Java
//============================================================================

import java.io.*;
import java.util.scanner; 

public class Login {

    int totalAttempts = 3                                                           //Set universal login attempt limit

    public void run() {
        boolean login = false;

        Scanner scan = new Scanner (new File(/*credentials storage file*/));        //Designate file location for stored username and password pairs
        Scanner keyboard = new Scanner (System.in);
        String userName = scan.nextLine();                                          //Read usernames
        String passWord = scan.nextLine();                                          //Read passwords

        while (totalAttempts != 0) {
            String inpUserName = keyboard.nextLine();                               //User input for username
            String inpPassWord = keyboard.nextLine();                               //User input for password

            if (inpUserName.equals(userName) && inpPassWord.equals(passWord)) {     //Login if username and password match
                System.out.print("Welcome " + userName);
                login = true;
            } else {                                                                //If username and password dont match
                System.out.print("Username and password do not match.");
                totalAttempts --;
            }
        }

        if (totalAttempts == 0) {
            System.out.print("Maximum number of attempts exceeded")                 //Once limit is exceeded output limit exceeded message rather than taking user input
        }

        break;
    }
}
