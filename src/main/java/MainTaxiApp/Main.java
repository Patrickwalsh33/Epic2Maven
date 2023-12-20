package MainTaxiApp;

import MainTaxiApp.Classes.*;


public class Main {
    public static void main(String[] args) {
       AppLogic.clearConsole();
       AppLogic.login();
       AppLogic.anythingToContinue();
       AppLogic.clearConsole();
       AppLogic.makeMap();
       AppLogic.taxiRide();
       AppLogic.rateTaxiDriver();
       AppLogic.printExitMessage();

    }
}