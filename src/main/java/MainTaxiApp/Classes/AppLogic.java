package MainTaxiApp.Classes;

import MainTaxiApp.Enums.Size;

import java.util.Scanner;
public class AppLogic {
    private static Map current;

    static Scanner scanner = new Scanner(System.in);


    public static void clearConsole(){
        for(int i = 0; i < 100; i++)
            System.out.print("\n");
    }

    public static void anythingToContinue(){
        System.out.print("\nPress any key to continue...\n");
        scanner.next();
    }
    public Size findSize(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("What size vehicle do you want?\n[1] Small\n[2] Medium \n[3] Large");
        int choice=scanner.nextInt();
        for(int i=0;i<1;i++) {
            switch (choice) {
                case 1:
                    System.out.println("\n---\nSmall chosen\n---\n");
                    return Size.SMALL;
                case 2:
                    System.out.println("\n---\nMedium chosen\n---\n");
                    return Size.MEDIUM;
                case 3:
                    System.out.println("\n---\nLarge chosen\n---\n");
                    return Size.LARGE;
                default:
                    System.out.println("Invalid input, please try again.");
                    i--;
            }
        }

        return null;
    }
    public static void taxiRide(Login user){
        Map map = new Map(20,user.getCurrentUser());
        current=map;
        AppLogic.anythingToContinue();
        map.moveTaxiToUser();
        Scanner scanner = new Scanner(System.in);
        for(int i=0;i<1;i++) {
            System.out.println("\n---\nWhere would you like to go?\nInput 2 integers between 0 and 19.");
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            if(x>-1&&x<20&&y>-1&&y<20){
                map.moveTaxiAndUserToLocation(x,y);
            }else {
                System.out.println("One or more integers were invalid please try again.");
                i--;
            }
        }
    }
    public static void rateTaxiDriver(){
        Taxi taxi = current.getChosenTaxi();
        Scanner scanner = new Scanner(System.in);
        TextHandler text = new TextHandler();
        for(int i=0;i<1;i++) {
            System.out.println("\n---\nDid you enjoy the ride?\n" +
                    "Give " + taxi.getName() + " a rating between 1 and 5!");
            int input = scanner.nextInt();
            if(input<=5&&input>=1) {
                System.out.println("You rated the driver "+input+" stars");
                text.writeInNewTaxiRating(taxi, input, text.getTAXIS_FILE_PATH());
                scanner.close();
            }else{
                System.out.println("Invalid input please try again.");
                i--;
            }
        }
        System.out.println("Thank you for your input!");
    }
    public static void printExitMessage(){
        System.out.println("\n---\nThank you for using the taxi app see you next time!\n---");
    }
}

