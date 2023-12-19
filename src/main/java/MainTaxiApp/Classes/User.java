package MainTaxiApp.Classes;

import MainTaxiApp.Interfaces.RideObserver;
import MainTaxiApp.Interfaces.RideSubject;

public class User implements RideObserver {
    private String username;
    private String password;

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

    public void setUsername(String username) {

        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public void update(RideSubject subject) {
        if (subject instanceof Ride){
            Ride ride = (Ride) subject;
            if (ride.isRideInProgress()){
                System.out.println("User " + getUsername() + ": The ride has started.");
            }else {
                System.out.println("User " + getUsername() + ": The ride has ended.");
            }
        }
    }
}
