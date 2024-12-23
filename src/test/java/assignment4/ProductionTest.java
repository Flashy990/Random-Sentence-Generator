package assignment4;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class ProductionTest {

    /**
     * Test the getSymbols() method.
     */
    @Test
    public void testGetSymbols() {
        AbstractSymbol symbol1 = new Terminal("a");
        AbstractSymbol symbol2 = new NonTerminal("B");
        Production production = new Production(Arrays.asList(symbol1, symbol2));
        List<AbstractSymbol> symbols = production.getSymbols();
        assertEquals(2, symbols.size());
        assertEquals(symbol1, symbols.get(0));
        assertEquals(symbol2, symbols.get(1));
    }

    /**
     * Test the hashCode() method.
     */
    @Test
    public void testHashCode() {
        AbstractSymbol symbol1 = new Terminal("a");
        AbstractSymbol symbol2 = new NonTerminal("B");
        Production production1 = new Production(Arrays.asList(symbol1, symbol2));
        Production production2 = new Production(Arrays.asList(symbol1, symbol2));
        assertEquals(production1.hashCode(), production2.hashCode());
    }

    /**
     * Test the equals() method for equality.
     */
    @Test
    public void testEquals() {
        AbstractSymbol symbol1 = new Terminal("a");
        AbstractSymbol symbol2 = new NonTerminal("B");
        Production production1 = new Production(Arrays.asList(symbol1, symbol2));
        Production production2 = new Production(Arrays.asList(symbol1, symbol2));
        assertTrue(production1.equals(production2));
    }

    /**
     * Test the equals() method for inequality.
     */
    @Test
    public void testNotEquals() {
        AbstractSymbol symbol1 = new Terminal("a");
        AbstractSymbol symbol2 = new NonTerminal("B");
        AbstractSymbol symbol3 = new Terminal("c");
        Production production1 = new Production(Arrays.asList(symbol1, symbol2));
        Production production2 = new Production(Arrays.asList(symbol1, symbol3));
        assertFalse(production1.equals(production2));
    }

    /**
     * Test the toString() method.
     */
    @Test
    public void testToString() {
        AbstractSymbol symbol1 = new Terminal("a");
        AbstractSymbol symbol2 = new NonTerminal("B");
        Production production = new Production(Arrays.asList(symbol1, symbol2));
        assertEquals("a <B>", production.toString());
    }
}