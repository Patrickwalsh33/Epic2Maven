import MainTaxiApp.Classes.Location;
import MainTaxiApp.Classes.Taxi;
import MainTaxiApp.Classes.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;


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

    @Test
    void testAddDrivingTaxi() {
        Location location = new Location(5, 6);
        Taxi driver = new Taxi("08-MH-3038","Jhon Doe",4,"Toyota","medium");

        location.addDrivingTaxi(driver);

        assertEquals(driver, location.getDriver());
        assertEquals("D\t", location.getMapPoint());
    }

    @Test
    void testRemoveTaxi() {
        Location location = new Location(7, 8);
        Taxi taxi = new Taxi("08-MH-3038","Jhon Doe",4,"Toyota","medium");

        location.addTaxi(taxi);
        location.removeTaxi();

        assertNull(location.getTaxi());
        assertEquals(".\t", location.getMapPoint());
    }

    @Test
    void testRemoveDriver() {
        Location location = new Location(9, 10);
        Taxi taxi = new Taxi("08-MH-3038","Jhon Doe",4,"Toyota","medium");

        location.addTaxi(taxi);
        location.addDrivingTaxi(taxi);

        location.removeDriver();

        assertNull(location.getDriver());
        assertEquals("T\t", location.getMapPoint());
    }

    @Test
    void testChangeTaxiToDriver() {
        Location location = new Location(11, 12);

        Taxi taxi = new Taxi("08-MH-3038","Jhon Doe",4,"Toyota","medium");
        location.addTaxi(taxi);
        location.changeTaxiToDriver();

        assertNull(location.getTaxi());
        assertEquals(taxi, location.getDriver());
        assertEquals("D\t", location.getMapPoint());
    }
}
