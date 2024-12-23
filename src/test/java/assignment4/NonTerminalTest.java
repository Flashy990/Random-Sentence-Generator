package assignment4;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class NonTerminalTest {
    /**
     * Test the getValue() method.
     */
    @Test
    public void testGetValue() {
        NonTerminal nonTerminal = new NonTerminal("Expression");
        assertEquals("Expression", nonTerminal.getValue());
    }

    /**
     * Test the hashCode() method.
     */
    @Test
    public void testHashCode() {
        NonTerminal nonTerminal1 = new NonTerminal("Expression");
        NonTerminal nonTerminal2 = new NonTerminal("expression");
        assertEquals(nonTerminal1.hashCode(), nonTerminal2.hashCode());
    }

    /**
     * Test the equals() method for equality.
     */
    @Test
    public void testEquals() {
        NonTerminal nonTerminal1 = new NonTerminal("Expression");
        NonTerminal nonTerminal2 = new NonTerminal("Expression");
        assertTrue(nonTerminal1.equals(nonTerminal2));
    }

    /**
     * Test the equals() method for case insensitivity.
     */
    @Test
    public void testEqualsIgnoreCase() {
        NonTerminal nonTerminal1 = new NonTerminal("Expression");
        NonTerminal nonTerminal2 = new NonTerminal("expression");
        assertTrue(nonTerminal1.equals(nonTerminal2));
    }

    /**
     * Test the equals() method for inequality.
     */
    @Test
    public void testNotEquals() {
        NonTerminal nonTerminal1 = new NonTerminal("Expression");
        NonTerminal nonTerminal2 = new NonTerminal("Term");
        assertFalse(nonTerminal1.equals(nonTerminal2));
    }

    /**
     * Test the toString() method.
     */
    @Test
    public void testToString() {
        NonTerminal nonTerminal = new NonTerminal("Expression");
        assertEquals("<Expression>", nonTerminal.toString());
    }
}