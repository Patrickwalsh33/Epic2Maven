package Tests;

import MainTaxiApp.Classes.User;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class UserTest {
    @Test
    public void testGetUserDetails(){
        User test = new User("Jhon Doe","password");
        assertEquals("Jhon Doe",test.getUsername());
        assertEquals("password",test.getPassword());
    }
}
