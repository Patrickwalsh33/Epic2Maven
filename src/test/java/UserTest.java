import MainTaxiApp.Classes.*;
import org.junit.jupiter.api.Test;
import MainTaxiApp.Interfaces.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserTest {
    @Test
    public void testGetUserDetails(){
        User test = new User("Jhon Doe","password");
        assertEquals("Jhon Doe",test.getUsername());
        assertEquals("password",test.getPassword());
    }
    @Test
    public void testSetAndGetUsersLocation() {
        User test = new User("Jhon Doe", "password");
        Location location = new Location(0, 0);

        test.setUsersLocation(location);
        assertEquals(location, test.getUsersLocation());
    }

//    @Test
//    public void testRideObserverUpdate() {
//        User test = new User("Jhon Doe", "password");
//        RideSubject ride = new Ride(2);
//
//        // Ensure that the user is initially not notified
//        assertTrue(ride.getObservers().isEmpty());
//
//        // Register the user as an observer
//        ride.registerObserver(test);
//
//        // Simulate the start of the ride
//        ride.startRide();
//        assertEquals("User Jhon Doe: The ride has started.", ride.getObserverUpdate());
//
//        // Simulate the end of the ride
//        ride.endRide();
//        assertEquals("User Jhon Doe: The ride has ended.", ride.getObserverUpdate());
//    }
}
