package MainTaxiApp;
import MainTaxiApp.Classes.AppLogic;
import MainTaxiApp.Classes.Login;
import MainTaxiApp.Classes.Map;
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