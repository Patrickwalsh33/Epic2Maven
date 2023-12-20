package MainTaxiApp.Classes;

import MainTaxiApp.Interfaces.Observer;

import java.util.Observable;


public class User implements Observer {
    private final String username;
    private final String password;

    private Location usersLocation;

    public Location getUsersLocation() {
        return usersLocation;
    }

    public void setUsersLocation(Location usersLocation) {

        this.usersLocation = usersLocation;
    }

    public User(String username, String password){
        this.password=password;
        this.username=username;
    }

    public String getUsername() {

        return username;
    }
    public String getPassword() {

        return password;
    }
    @Override
    public void update(Observable observedTaxi, Object locationOfTaxi) {
        if (locationOfTaxi instanceof Location) {
            setUsersLocation((Location) locationOfTaxi);
        }
    }
}
