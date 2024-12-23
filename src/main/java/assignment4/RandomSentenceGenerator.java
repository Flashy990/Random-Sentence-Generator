package assignment4;

import java.util.List;
import java.util.Random;

import static assignment4.Constants.*;

/**
 * Class for generating random sentences from a given grammar.
 */
public class RandomSentenceGenerator {
    private final Random random;

    /**
     * Constructs a RandomSentenceGenerator with a new Random instance.
     */
    public RandomSentenceGenerator() {
        this.random = new Random();
    }

    /**
     * Constructs a RandomSentenceGenerator with the given Random instance.
     *
     * @param random the Random instance to use
     */
    public RandomSentenceGenerator(Random random) {
        this.random = random;
    }

    /**
     * Generates a random sentence from the given grammar.
     *
     * @param grammar the grammar to use
     * @return the generated sentence
     * @throws Exception if an undefined non-terminal is encountered
     */
    public String generateSentence(Grammar grammar) throws Exception {
        NonTerminal start = new NonTerminal(grammar.getStartSymbol());
        return expandSymbol(start, grammar).trim();
    }

    /**
     * Recursively expands a symbol into a string.
     *
     * @param symbol  the symbol to expand
     * @param grammar the grammar to use
     * @return the expanded string
     * @throws Exception if an undefined non-terminal is encountered
     */
    private String expandSymbol(AbstractSymbol symbol, Grammar grammar) throws Exception {
        if (symbol instanceof Terminal) {
            return symbol.getValue();
        }

        else if (symbol instanceof NonTerminal) {
            List<Production> productions = grammar.getProductions(symbol.getValue());

            if (productions == null) {
                throw new Exception(UNDEFINEDOPEN + symbol.getValue() + CLOSE);
            }

            Production production = productions.get(random.nextInt(productions.size()));
            StringBuilder sb = new StringBuilder();

            for (AbstractSymbol s : production.getSymbols()) {
                sb.append(expandSymbol(s, grammar));
            }

            return sb.toString();
        }

        else {
            throw new Exception(UNKNOWNSYMBOL);
        }
    }
}