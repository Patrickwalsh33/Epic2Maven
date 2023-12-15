package Tests;

import MainTaxiApp.Classes.LinkedList;
import MainTaxiApp.Classes.Login;
import MainTaxiApp.Classes.TextHandler;
import MainTaxiApp.Classes.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class LoginTest {
    private final InputStream originalSystemIn = System.in;
    private final PrintStream originalSystemErr = System.err;

    @Before
    public void setUpStreams() {
        // Suppress System.out.println() for cleaner test output
        System.setOut(null);
    }

    @After
    public void restoreStreams() {
        System.setIn(originalSystemIn);
        System.setErr(originalSystemErr);
    }

    @Test
    public void testLoginOrSignUp_SignUp() {
        String input = "0\ntestuser\npassword\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Login login = new Login();
        login.loginOrSignUp();

        assertNotNull(login.getCurrentUser());
        assertEquals("testuser", login.getCurrentUser().getUsername());
        assertEquals("password", login.getCurrentUser().getPassword());
    }

    @Test
    public void testLoginOrSignUp_Login() {
        String input = "1\nTestUser\npassword\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Login login = new Login();
        LinkedList<User> users = new LinkedList<>();
        users.insert(new User("TestUser", "password"));
        login.loginOrSignUp();

        assertNotNull(login.getCurrentUser());
        assertEquals("testuser", login.getCurrentUser().getUsername());
        assertEquals("password", login.getCurrentUser().getPassword());
    }

    @Test
    public void testLoginToApp() {
        String input = "TestUser\npassword\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Login login = new Login();
        LinkedList<User> users = new LinkedList<>();
        TextHandler textHandler = new TextHandler();
        users.insert(new User("TestUser", "password"));
        login.loginToApp(users, textHandler);

        assertNotNull(login.getCurrentUser());
        assertEquals("testuser", login.getCurrentUser().getUsername());
        assertEquals("password", login.getCurrentUser().getPassword());
    }

    @Test
    public void testSignUpToApp() {
        String input = "testuser\npassword\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Login login = new Login();
        LinkedList<User> users = new LinkedList<>();
        TextHandler textHandler = new TextHandler();
        login.signUpToApp(users, textHandler);

        assertNotNull(login.getCurrentUser());
        assertEquals("testuser", login.getCurrentUser().getUsername());
        assertEquals("password", login.getCurrentUser().getPassword());
    }

    @Test
    public void testDoesContain() {
        Login login = new Login();
        LinkedList<User> users = new LinkedList<>();
        users.insert(new User("testuser", "password"));
        int result = login.doesContain("testuser", users);

        assertEquals(0, result);
    }
}
