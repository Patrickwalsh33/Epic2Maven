package Tests;

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
        assertDoesNotThrow(() -> testMap.printMap());
    }
    @Test
    public void testAddTaxisAndUsersToMap() {
        assertDoesNotThrow(() -> testMap.addTaxisAndUsersToMap(MAP_RADIUS, testUser));
    }
}
