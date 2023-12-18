package MainTaxiApp;

import MainTaxiApp.Classes.*;


public class Main {
    public static void main(String[] args) {
       AppLogic.clearConsole();
       Login newLogin = new Login();
       newLogin.loginOrSignUp();
       AppLogic.anythingToContinue();
       AppLogic.clearConsole();
       AppLogic.taxiRide(newLogin);
    }
}