
import MainTaxiApp.Classes.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MapTest {
    private static final int MAP_RADIUS = 10;
    private User testUser;
    private Map testMap;

    @BeforeEach
    public void setUp() {
        testUser = new User("TestUser", "password");
        testMap = new Map(MAP_RADIUS, testUser);
    }

    @Test
    public void testPrintMap() {
        //we used try methods at first to catch the exception but found lambdas were better
        assertDoesNotThrow(() -> testMap.printMap(null));
    }

    @Test
    public void testAddTaxisAndUsersToMap() {
        assertDoesNotThrow(() -> testMap.addTaxisAndUsersToMap(MAP_RADIUS, testUser));
    }

//   @Test
//    void testMoveTaxiToUser() {
//        // Move the taxi to the user
//        testMap.moveTaxiToUser();
//
//        // Check if the user and taxi are in the same location
//        Location userLocation = testMap.getUsersLocation();
//        Location taxiLocation = testMap.getChosenTaxi().getLocation();
//        assertEquals(userLocation, taxiLocation);
//    }

//    @Test
//    void testMoveTaxiAndUserToLocation() {
//        // Move the taxi and user to a specific location
//        testMap.moveTaxiAndUserToLocation(2, 3, testUser);
//
//        // Check if the user and taxi are in the destination location
//        Location destination = testMap.getGrid()[2][3];
//        Location userLocation = testMap.getUsersLocation();
//        Location taxiLocation = testMap.getChosenTaxi().getLocation();
//        assertEquals(destination, userLocation);
//        assertEquals(destination, taxiLocation);
//    }
//
//    @Test
//    void testMoveTaxisOnTheMap() {
//        // Choose a taxi and destination location
//        Taxi chosenTaxi = testMap.getChosenTaxi();
//        Location destination = testMap.getGrid()[2][3];
//
//        // Move the taxi to the destination location
//        testMap.moveTaxisOnTheMap(destination, chosenTaxi.getLocation(), null);
//
//        // Check if the taxi is in the destination location
//        Location taxiLocation = testMap.getChosenTaxi().getLocation();
//        assertEquals(destination, taxiLocation);
//    }
}
