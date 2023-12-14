package Tests;

import MainTaxiApp.Classes.Taxi;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class TaxiTest {
    @Test
    public void testGetTaxiDetails(){
        Taxi test = new Taxi("08-MH-3038","Jhon Doe",4,"Toyota","medium",1);
        assertEquals("08-MH-3038",test.getRegistration());
        assertEquals("Jhon Doe",test.getName());
        assertEquals(4,test.getRating());
        assertEquals("Toyota",test.getBrand());
        assertEquals("medium",test.getSize());
        assertEquals(1,test.getSeats());
    }
}