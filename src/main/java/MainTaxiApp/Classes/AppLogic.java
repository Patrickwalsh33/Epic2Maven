package MainTaxiApp.Classes;

import MainTaxiApp.Enums.Size;

import java.util.Scanner;
public class AppLogic {
    private final int ONE =1;
    private final int TWO =2;
    private final int THREE =3;

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
                case ONE:
                    System.out.println("\n---\nSmall chosen\n---\n");
                    return Size.SMALL;
                case TWO:
                    System.out.println("\n---\nMedium chosen\n---\n");
                    return Size.MEDIUM;
                case THREE:
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
        AppLogic.anythingToContinue();
        map.moveTaxiToUser();
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n---\nWhere would you like to go?\nInput 2 integers between 0 and 19.");
        int x=scanner.nextInt();
        int y=scanner.nextInt();
        map.moveTaxiAndUserToLocation(x,y);

    }

}

