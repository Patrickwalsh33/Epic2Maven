package Tests;
import MainTaxiApp.Classes.LinkedList;
import MainTaxiApp.Classes.TextHandler;
import MainTaxiApp.Classes.User;
import MainTaxiApp.Classes.Taxi;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TextHandlerTest {

    @Test
    void testReadUsersAndPasswords() throws IOException {
        // Create a temporary file for testing
        Path tempFile = Files.createTempFile("testUsers", ".csv");
        Files.write(tempFile, "user1,password1\nuser2,password2\n".getBytes(), StandardOpenOption.WRITE);

        // Create an instance of TextHandler
        TextHandler textHandler = new TextHandler();

        // Call the method to read users and passwords from the temporary file
        LinkedList<User> usersAndPasswords = textHandler.readUsersAndPasswords(tempFile.toString());

        // Verify the results
        assertEquals(2, usersAndPasswords.size());
        usersAndPasswords.moveToFirst();
        User user1 = usersAndPasswords.getData();
        assertEquals("user1", user1.getUsername());
        assertEquals("password1", user1.getPassword());
        usersAndPasswords.moveToNext();
        User user2 = usersAndPasswords.getData();
        assertEquals("user2", user2.getUsername());
        assertEquals("password2", user2.getPassword());

        // Clean up: delete the temporary file
        Files.delete(tempFile);
    }
    @Test
    void testReadTaxiData() throws IOException {
        // Create a temporary file for testing
        Path tempFile = Files.createTempFile("testTaxis", ".csv");
        Files.write(tempFile, "08-MH-3038,Jhon Doe,4,Toyota,medium,1\n11-D-1234,Jane Smith,3,Ford,small,4".getBytes(), StandardOpenOption.WRITE);
        TextHandler textHandler = new TextHandler();

        LinkedList<Taxi> testTaxis = textHandler.readTaxiData(tempFile.toString());

        testTaxis.moveToFirst();
        Taxi taxi1 = testTaxis.getData();
        assertEquals("08-MH-3038", taxi1.getRegistration());
        assertEquals("Jhon Doe", taxi1.getName());
        assertEquals(4, taxi1.getRating());
        assertEquals("Toyota", taxi1.getBrand());
        assertEquals("medium", taxi1.getSize());
        assertEquals(1, taxi1.getSeats());
        testTaxis.moveToNext();
        Taxi taxi2 = testTaxis.getData();
        assertEquals("11-D-1234", taxi2.getRegistration());
        assertEquals("Jane Smith", taxi2.getName());
        assertEquals(3, taxi2.getRating());
        assertEquals("Ford", taxi2.getBrand());
        assertEquals("small", taxi2.getSize());
        assertEquals(4, taxi2.getSeats());

        Files.delete(tempFile);
    }
    @Test
    void testWriteInNewUser() throws IOException {
        Path tempFile = Files.createTempFile("testUsers", ".csv");

        TextHandler textHandler = new TextHandler();

        textHandler.writeInNewUser("testUser", "testPassword", tempFile.toString());

        try (BufferedReader reader = new BufferedReader(new FileReader(tempFile.toString()))) {
            String line = reader.readLine();
            assertEquals("testUser,testPassword", line);
        }

        Files.delete(tempFile);
    }
}

