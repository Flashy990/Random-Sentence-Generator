package assignment4;

import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class GrammarLoaderTest {
    /**
     * Test loading grammars from a valid directory.
     */
    @Test
    public void testLoadGrammarsValidDirectory() throws Exception {
        // Create a temporary directory
        Path tempDir = Files.createTempDirectory("grammars");
        try {
            // Create a temporary grammar file
            String grammarContent = "{\n" +
                    "  \"grammarTitle\": \"Test Grammar\",\n" +
                    "  \"grammarDesc\": \"A test grammar.\",\n" +
                    "  \"start\": [\"hello\"]\n" +
                    "}";
            Path grammarFile = tempDir.resolve("test_grammar.json");
            Files.write(grammarFile, grammarContent.getBytes());

            List<Grammar> grammars = GrammarLoaderJSONFile.loadGrammars(tempDir.toString());
            assertEquals(1, grammars.size());
            Grammar grammar = grammars.get(0);
            assertEquals("Test Grammar", grammar.getGrammarTitle());
            assertEquals("A test grammar.", grammar.getGrammarDescription());
            assertEquals("start", grammar.getStartSymbol());
            List<Production> productions = grammar.getProductions("start");
            assertNotNull(productions);
            assertEquals(1, productions.size());
            Production production = productions.get(0);
            List<AbstractSymbol> symbols = production.getSymbols();
            assertEquals(1, symbols.size());
            assertEquals(new Terminal("hello"), symbols.get(0));
        } finally {
            // Clean up temporary files
            Files.deleteIfExists(tempDir.resolve("test_grammar.json"));
            Files.deleteIfExists(tempDir);
        }
    }

    /**
     * Test loading grammars from an invalid directory.
     */
    @Test
    public void testLoadGrammarsInvalidDirectory() {
        Exception exception = assertThrows(Exception.class, () -> {
            GrammarLoaderJSONFile.loadGrammars("non_existent_directory");
        });
        assertTrue(exception.getMessage().contains("Invalid directory or no JSON files found"));
    }

    /**
     * Test parsing a production string.
     */
    @Test
    public void testParseProduction() {
        String productionStr = "The <object> <verb> tonight.";
        List<AbstractSymbol> symbols = GrammarLoaderJSONFile.parseProduction(productionStr);
        assertEquals(5, symbols.size());
        assertEquals(new Terminal("The "), symbols.get(0));
        assertEquals(new NonTerminal("object"), symbols.get(1));
        assertEquals(new Terminal(" "), symbols.get(2));
        assertEquals(new NonTerminal("verb"), symbols.get(3));
        assertEquals(new Terminal(" tonight."), symbols.get(4));
    }

    /**
     * Test parsing a production string with adjacent non-terminals.
     */
    @Test
    public void testParseProductionAdjacentNonTerminals() {
        String productionStr = "<greeting><punctuation>";
        List<AbstractSymbol> symbols = GrammarLoaderJSONFile.parseProduction(productionStr);
        assertEquals(2, symbols.size());
        assertEquals(new NonTerminal("greeting"), symbols.get(0));
        assertEquals(new NonTerminal("punctuation"), symbols.get(1));
    }
}