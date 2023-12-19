import MainTaxiApp.Classes.AppLogic;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppLogicTest {

    private final InputStream originalSystemIn = System.in;
    private final PrintStream originalSystemOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void tearDown() {
        System.setIn(originalSystemIn);
        System.setOut(originalSystemOut);
    }

    @Test
    public void testClearConsole() {
        AppLogic.clearConsole();
        assertEquals(repeatString(), outputStreamCaptor.toString());
    }

    @Test
    public void testAnythingToContinue() {
        provideInput();
        AppLogic.anythingToContinue();
        assertEquals("\nPress any key to continue...\n", outputStreamCaptor.toString());
    }

    private void provideInput() {
        System.setIn(new ByteArrayInputStream("test".getBytes()));
    }

    private String repeatString() {
        return "\n".repeat(Math.max(0, 100));
    }

}



