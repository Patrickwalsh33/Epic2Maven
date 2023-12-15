import MainTaxiApp.Classes.LinkedList;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class LinkedListTest {
    @Test
    public void testEmptyList() {
        LinkedList<String> list = new LinkedList<>();
        assertTrue(list.isEmpty());
        assertEquals(0, list.size());
        assertNull(list.getData());
    }

    @Test
    public void testInsertAndSize() {
        LinkedList<Integer> list = new LinkedList<>();
        list.insert(1);
        list.insert(2);
        list.insert(3);

        assertFalse(list.isEmpty());
        assertEquals(3, list.size());
    }

    @Test
    public void testRemove() {
        LinkedList<String> list = new LinkedList<>();
        list.insert("one");
        list.insert("two");
        list.insert("three");

        list.remove();
        assertEquals("two", list.getData());

        list.remove();
        assertEquals("one", list.getData());

        list.remove();
        assertTrue(list.isEmpty());
        assertNull(list.getData());
    }

    @Test
    public void testUpdateData() {
        LinkedList<String> list = new LinkedList<>();
        list.insert("apple");
        list.updateData("orange");
        assertEquals("orange", list.getData());
    }

    @Test
    public void testPrintAllData() {
        LinkedList<String> list = new LinkedList<>();
        list.insert("test 1");
        list.insert("test 2");
        list.insert("test 3");

        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));

        list.printAllData();

        assertEquals("test 1\ntest 2\ntest 3\n", outputStreamCaptor.toString());
    }
}