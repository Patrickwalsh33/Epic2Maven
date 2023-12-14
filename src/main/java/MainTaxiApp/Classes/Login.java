package MainTaxiApp.Classes;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Login {
    private String username;
    private String password;
    private static final String OPTION_ZERO ="0";
    private static final String OPTION_ONE ="1";

    public void loginOrSignUp(){
        Scanner input = new Scanner(System.in);
        TextHandler text = new TextHandler();
        LinkedList<User> usernames =text.readUsersAndPasswords(text.getUSERS_FILE_PATH());
        System.out.println("---\nWelcome to the TaxiApp.\n Sign up [0]\n or\n Log in[1]");
        for(int i =0; i<1; i++) {
            String logInOrSignUp = input.nextLine();
            switch (logInOrSignUp) {
                case OPTION_ZERO:
                    System.out.println("\nSignUp chosen\n");
                    signUpToApp(usernames, text);
                    break;
                case OPTION_ONE:
                    System.out.println("\nLogin chosen\n");
                    loginToApp(usernames, text);
                    break;
                default:
                    System.out.println("Invalid input, please try again.");
                    i--;
            }
        }
    }
    public void loginToApp(LinkedList<User> usernames,TextHandler text){
        Scanner input = new Scanner(System.in);
        for(int i=0; i<1; i++) {
            System.out.println("---\nLogin please enter your username: ");
            String username = input.nextLine();
            String usernameLowerCase = username.toLowerCase();
            if (doesContain(usernameLowerCase, usernames) != -1) {
                int index = doesContain(usernameLowerCase, usernames);
                System.out.println("Welcome back " + username + " please enter your password.");
                usernames.moveToFirst();
                IntStream.range(0, index).forEach(p -> usernames.moveToNext());
                for (int k = 0; k < 1; k++) {
                    String password = input.nextLine();
                    String passwordLowerCase = password.toLowerCase();
                    if (passwordLowerCase.equals((usernames.getData()).getPassword())) {
                        System.out.println("Correct, you are now logged into the account " + username);
                    } else {
                        System.out.println("Incorrect password for the account " + username + " please try again.");
                        k--;
                    }this.password=passwordLowerCase;
                }this.username=usernameLowerCase;
            } else {
                System.out.println("The account " + username + " does not exist.\n Would you like to try again?[0]\n Or\n Sign up?[1]");
                for (int j = 0; j < 1; j++) {
                    String choice = input.nextLine();
                    switch (choice) {
                        case OPTION_ZERO:
                            i--;
                            System.out.println("You chose to try again.");
                            break;
                        case OPTION_ONE:
                            System.out.println("You chose Sign up.");
                            signUpToApp(usernames, text);
                            break;
                        default:
                            System.out.println("Invalid input please try again.");
                            j--;
                    }
                }

            }

        }
    }
    public void signUpToApp(LinkedList<User> usernames,TextHandler text){
        Scanner input = new Scanner(System.in);
    for(int i=0; i<1; i++){
        System.out.println("---\nSign up enter your chosen username: ");
        String username=input.nextLine();
        String usernameLowerCase = username.toLowerCase();
        if(usernameLowerCase.equals("")) {
            System.out.println("Invalid input please try again.");
            i--;
        }else if(doesContain(usernameLowerCase, usernames)!=-1) {
            System.out.println("The account "+username+" already exists.\n Would you like to log in to this account?[0]\n Or\n Input a different username?[1]\n");
            for(int j=0; j<1; j++) {
                String choice = input.nextLine();
                switch (choice) {
                    case OPTION_ZERO:
                        System.out.println("You chose to login to the account "+username);
                        loginToApp(usernames, text);
                        break;
                    case OPTION_ONE:
                        i--;
                        System.out.println("You chose to input a different username.");
                        break;
                    default:
                        System.out.println("Invalid input please try again.");
                        j--;
                }
            }
        }else{
            System.out.println("---\nWelcome "+username+" please enter your chosen password:");
            String password= input.nextLine();
            String passwordLowerCase = password.toLowerCase();
            text.writeInNewUser(usernameLowerCase,passwordLowerCase,text.getUSERS_FILE_PATH());
            System.out.println("Congratulations "+username+" you are now registered!");
            this.password=passwordLowerCase;
        }this.username=usernameLowerCase;

        }
    }
    public int doesContain(String username,LinkedList<User> usernames) {
        int result = -1;
        usernames.moveToFirst();
        for (int i = 0; i <username.length(); i++) {
            if (username.equals((usernames.getData()).getUsername())) {
                result = i;
                break;
            }
            usernames.moveToNext();
        }
        return result;
    }
    public User getCurrentUser(){
        return new User(username,password);
    }
}
