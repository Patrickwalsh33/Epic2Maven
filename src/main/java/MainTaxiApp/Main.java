package Block2.MainTaxiApp;

import MainTaxiApp.Classes.AppLogic;
import MainTaxiApp.Classes.Map;
import MainTaxiApp.Classes.Login;

public class Main {
    public static void main(String[] args) {
       AppLogic.clearConsole();
       Login newLogin = new Login();
       newLogin.loginOrSignUp();
       AppLogic.anythingToContinue();
       AppLogic.clearConsole();

        Map map = new Map(20,newLogin.getCurrentUser());
        map.printMap();



    }


    }