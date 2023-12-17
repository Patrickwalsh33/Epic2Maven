import MainTaxiApp.Classes.Location;
import MainTaxiApp.Classes.Taxi;
import MainTaxiApp.Classes.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LocationTest {

    @Test
    public void testLocationInitialization() {
        Location location = new Location(1, 2);
        assertEquals(1, location.getX());
        assertEquals(2, location.getY());
        assertEquals(".\t", location.getMapPoint());
    }

    @Test
    public void testAddUser() {
        Location location = new Location(3, 4);
        User user = new User("testUser", "password");
        location.addUser(user);
        assertEquals("U\t", location.getMapPoint());
    }

    @Test
    public void testAddTaxi() {
        Location location = new Location(5, 6);
        Taxi taxi = new Taxi("08-MH-3038","Jhon Doe",4,"Toyota","medium");
        location.addTaxi(taxi);
        assertEquals("T\t", location.getMapPoint());
    }
}
