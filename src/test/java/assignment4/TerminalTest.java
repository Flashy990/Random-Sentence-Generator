package assignment4;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class TerminalTest {
    /**
     * Test the getValue() method.
     */
    @Test
    public void testGetValue() {
        Terminal terminal = new Terminal("hello");
        assertEquals("hello", terminal.getValue());
    }

    /**
     * Test the hashCode() method.
     */
    @Test
    public void testHashCode() {
        Terminal terminal1 = new Terminal("hello");
        Terminal terminal2 = new Terminal("HELLO");
        assertEquals(terminal1.hashCode(), terminal2.hashCode());
    }

    /**
     * Test the equals() method for equality.
     */
    @Test
    public void testEquals() {
        Terminal terminal1 = new Terminal("hello");
        Terminal terminal2 = new Terminal("hello");
        assertTrue(terminal1.equals(terminal2));
    }

    /**
     * Test the equals() method for case insensitivity.
     */
    @Test
    public void testEqualsIgnoreCase() {
        Terminal terminal1 = new Terminal("hello");
        Terminal terminal2 = new Terminal("HELLO");
        assertTrue(terminal1.equals(terminal2));
    }

    /**
     * Test the equals() method for inequality.
     */
    @Test
    public void testNotEquals() {
        Terminal terminal1 = new Terminal("hello");
        Terminal terminal2 = new Terminal("world");
        assertFalse(terminal1.equals(terminal2));
    }

    /**
     * Test the equals() method when comparing to null.
     */
    @Test
    public void testEqualsNull() {
        Terminal terminal = new Terminal("hello");
        assertFalse(terminal.equals(null), "Comparing to null should return false");
    }

    /**
     * Test the equals() method when comparing to an object of a different class.
     */
    @Test
    public void testEqualsDifferentClass() {
        Terminal terminal = new Terminal("hello");
        String other = "hello";
        assertFalse(terminal.equals(other), "Comparing to an object of a different class should return false");
    }

    /**
     * Test the toString() method.
     */
    @Test
    public void testToString() {
        Terminal terminal = new Terminal("hello");
        assertEquals("hello", terminal.toString());
    }
}