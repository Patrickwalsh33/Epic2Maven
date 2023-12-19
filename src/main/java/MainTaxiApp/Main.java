package MainTaxiApp;

import MainTaxiApp.Classes.*;


public class Main {
    public static void main(String[] args) {
       AppLogic.clearConsole();
       Login newLogin = new Login();
       newLogin.loginOrSignUp();
       AppLogic.anythingToContinue();
       AppLogic.clearConsole();
       Map map = new Map(20,newLogin.getCurrentUser());
       AppLogic.taxiRide(map,newLogin);
       AppLogic.rateTaxiDriver();
       AppLogic.printExitMessage(newLogin);


    }
}