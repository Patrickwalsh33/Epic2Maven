package MainTaxiApp.Classes;

import java.util.Scanner;
public class AppLogic {

    static Scanner scanner = new Scanner(System.in);
    public static void clearConsole(){
        for(int i = 0; i < 100; i++)
            System.out.println();
        //System.out.print("\033[H\033[2J");
        //System.out.flush();
    }

    public static void anythingToContinue(){
        System.out.println("\nPress any key to continue...");
        scanner.next();
    }
}
