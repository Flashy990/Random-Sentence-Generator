package assignment4;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class RandomSentenceGeneratorTest {
    /**
     * Test generating a sentence with a simple grammar.
     */
    @Test
    public void testGenerateSentenceSimpleGrammar() throws Exception {
        Grammar grammar = new Grammar("Test Grammar", "A simple test grammar.", "start");

        // Define productions
        grammar.addProduction("start", new Production(Arrays.asList(new Terminal("hello"))));

        RandomSentenceGenerator generator = new RandomSentenceGenerator();
        String sentence = generator.generateSentence(grammar);
        assertEquals("hello", sentence);
    }

    /**
     * Test generating a sentence with non-terminals.
     */
    @Test
    public void testGenerateSentenceWithNonTerminals() throws Exception {
        Grammar grammar = new Grammar("Greeting Grammar", "A grammar with greetings.", "start");

        // Define productions
        grammar.addProduction("start", new Production(Arrays.asList(new Terminal("Hello, "), new NonTerminal("name"), new Terminal("!"))));
        grammar.addProduction("name", new Production(Arrays.asList(new Terminal("Alice"))));
        grammar.addProduction("name", new Production(Arrays.asList(new Terminal("Bob"))));

        RandomSentenceGenerator generator = new RandomSentenceGenerator();
        String sentence = generator.generateSentence(grammar);
        assertTrue(sentence.equals("Hello, Alice!") || sentence.equals("Hello, Bob!"));
    }

    /**
     * Test generating a sentence with recursion.
     */
    @Test
    public void testGenerateSentenceWithRecursion() throws Exception {
        Grammar grammar = new Grammar("Number Grammar", "A grammar with numbers.", "number");

        // Define productions
        grammar.addProduction("number", new Production(Arrays.asList(new NonTerminal("digit"), new NonTerminal("number"))));
        grammar.addProduction("number", new Production(Arrays.asList(new NonTerminal("digit"))));
        grammar.addProduction("digit", new Production(Arrays.asList(new Terminal("1"))));
        grammar.addProduction("digit", new Production(Arrays.asList(new Terminal("2"))));
        grammar.addProduction("digit", new Production(Arrays.asList(new Terminal("3"))));

        RandomSentenceGenerator generator = new RandomSentenceGenerator();
        String sentence = generator.generateSentence(grammar);
        // Since the recursion can produce varying lengths, check that the sentence contains only digits
        assertTrue(sentence.matches("[123]+"));
    }

    /**
     * Test exception when undefined non-terminal is encountered.
     */
    @Test
    public void testGenerateSentenceUndefinedNonTerminal() {
        Grammar grammar = new Grammar("Test Grammar", "A test grammar.", "start");

        // Define productions without defining the 'undefined' non-terminal
        grammar.addProduction("start", new Production(Arrays.asList(new NonTerminal("undefined"))));

        RandomSentenceGenerator generator = new RandomSentenceGenerator();
        Exception exception = assertThrows(Exception.class, () -> {
            generator.generateSentence(grammar);
        });
        assertTrue(exception.getMessage().contains("Undefined non-terminal"));
    }

    /**
     * Test exception when unknown symbol type is encountered.
     */
    @Test
    public void testExpandSymbolUnknownSymbol() throws Exception {
        Grammar grammar = new Grammar("Test Grammar", "A test grammar.", "start");

        // Create a custom symbol class to simulate an unknown symbol type
        class UnknownSymbol extends AbstractSymbol {
            @Override
            public String getValue() {
                return "unknown";
            }

            @Override
            public boolean equals(Object o) {
                return false;
            }

            @Override
            public int hashCode() {
                return 0;
            }
        }

        // Create a production that includes the unknown symbol
        Production production = new Production(Arrays.asList(new UnknownSymbol()));
        grammar.addProduction("start", production);

        RandomSentenceGenerator generator = new RandomSentenceGenerator();
        Exception exception = assertThrows(Exception.class, () -> {
            generator.generateSentence(grammar);
        });
        assertTrue(exception.getMessage().contains("Unknown symbol type"));
    }
}