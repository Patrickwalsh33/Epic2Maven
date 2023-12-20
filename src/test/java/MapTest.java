
import MainTaxiApp.Classes.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class MapTest {

    private Map testMap;
    private User testUser;

    @Before
    public void setUp() {

        testUser = new User("TestUser", "TestPassword");
        testMap = new Map(10, testUser);
        testMap.setSize("medium");
    }

    @Test
    public void testPrintMap() {
        testMap.printMap(null);
    }

    @Test
    public void testAddTaxisAndUsersToMap() {
        testMap.addTaxisAndUsersToMap(testMap.getMapRadius(), testUser);
    }

    @Test
    public void testSearchAlgorithm() {
        assertNotNull(testMap.searchAlgorithm());
    }
}
