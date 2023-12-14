package MainTaxiApp.Classes;

import java.util.Scanner;
public class AppLogic {

    static Scanner scanner = new Scanner(System.in);
    public static void clearConsole(){
        for(int i = 0; i < 100; i++)
            System.out.print("\n");
    }

    public static void anythingToContinue(){
        System.out.print("\nPress any key to continue...");
        scanner.next();
    }
}
