import MainTaxiApp.Classes.*;
import MainTaxiApp.Classes.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
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




}
