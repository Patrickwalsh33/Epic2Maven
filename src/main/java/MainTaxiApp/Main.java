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
        User user1 = new User("Eddie","password");
        Ride ride = new Ride(1);
        ride.addObserver(user1);
        ride.startRide();
        System.out.println("Busy today mate ?");
        ride.endRide();
       AppLogic.rateTaxiDriver();
       AppLogic.printExitMessage();


    }
}