package assignment4;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GrammarTest {

    /**
     * Test the getTitle() method.
     */
    @Test
    public void testGetTitle() {
        Grammar grammar = new Grammar("Test Grammar", "Description", "start");
        assertEquals("Test Grammar", grammar.getGrammarTitle());
    }

    /**
     * Test the getDescription() method.
     */
    @Test
    public void testGetDescription() {
        Grammar grammar = new Grammar("Test Grammar", "Description", "start");
        assertEquals("Description", grammar.getGrammarDescription());
    }

    /**
     * Test the getStartSymbol() method.
     */
    @Test
    public void testGetStartSymbol() {
        Grammar grammar = new Grammar("Test Grammar", "Description", "start");
        assertEquals("start", grammar.getStartSymbol());
    }

    /**
     * Test the addProduction() and getProductions() methods.
     */
    @Test
    public void testAddAndGetProductions() {
        Grammar grammar = new Grammar("Test Grammar", "Description", "start");
        Production production = new Production(Arrays.asList(new Terminal("hello")));
        grammar.addProduction("start", production);

        List<Production> productions = grammar.getProductions("start");
        assertNotNull(productions);
        assertEquals(1, productions.size());
        assertEquals(production, productions.get(0));
    }

    /**
     * Test getProductions() with case insensitivity.
     */
    @Test
    public void testGetProductionsCaseInsensitive() {
        Grammar grammar = new Grammar("Test Grammar", "Description", "start");
        Production production = new Production(Arrays.asList(new Terminal("hello")));
        grammar.addProduction("Start", production);

        List<Production> productions = grammar.getProductions("start");
        assertNotNull(productions);
        assertEquals(1, productions.size());
        assertEquals(production, productions.get(0));
    }

    /**
     * Test the hashCode() method.
     */
    @Test
    public void testHashCode() {
        Grammar grammar1 = new Grammar("Test Grammar", "Description", "start");
        Grammar grammar2 = new Grammar("Test Grammar", "Description", "start");
        assertEquals(grammar1.hashCode(), grammar2.hashCode());
    }

    /**
     * Test the equals() method for equality.
     */
    @Test
    public void testEquals() {
        Grammar grammar1 = new Grammar("Test Grammar", "Description", "start");
        Grammar grammar2 = new Grammar("Test Grammar", "Description", "start");
        assertTrue(grammar1.equals(grammar2));
    }

    /**
     * Test the equals() method for inequality.
     */
    @Test
    public void testNotEquals() {
        Grammar grammar1 = new Grammar("Test Grammar", "Description", "start");
        Grammar grammar2 = new Grammar("Another Grammar", "Description", "start");
        assertFalse(grammar1.equals(grammar2));
    }

    @Test
    public void testEqualsSameObject() {
        Grammar grammar = new Grammar("Test Grammar", "Description", "start");
        assertTrue(grammar.equals(grammar));
    }

    /**
     * Test equals() method when obj is null.
     */
    @Test
    public void testEqualsNull() {
        Grammar grammar = new Grammar("Test Grammar", "Description", "start");
        assertFalse(grammar.equals(null));
    }

    @Test
    public void testEqualsDifferentClass() {
        Grammar grammar = new Grammar("Test Grammar", "Description", "start");
        String other = "Not a Grammar";
        assertFalse(grammar.equals(other));
    }

    /**
     * Test the toString() method.
     */
    @Test
    public void testToString() {
        Grammar grammar = new Grammar("Test Grammar", "Description", "start");
        assertEquals("Grammar Title: Test Grammar\n" +
                "Grammar Description: Description\n" +
                "Start Symbol: start\n", grammar.toString());
    }

    /**
     * Test the toString() method with productions.
     */
    @Test
    public void testToStringWithProductions() {
        Grammar grammar = new Grammar("Test Grammar", "Description", "start");
        Production production = new Production(Arrays.asList(new Terminal("hello")));
        grammar.addProduction("start", production);

        String output = grammar.toString();
        assertNotNull(output);
        assertTrue(output.contains("Test Grammar"));
    }
}