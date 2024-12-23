package assignment4;

import java.util.*;

import static assignment4.Constants.*;

/**
 * Class representing a grammar.
 * Contains the title, description, start symbol, and production rules.
 */
public class Grammar {
  private final String grammarTitle;
  private final String grammarDescription;
  private final String startSymbol;
  private final Map<String, List<Production>> nonTerminalSymbolProductions;

  /**
   * Constructs a Grammar with the given parameters.
   *
   * @param grammarTitle       the title of the grammar
   * @param grammarDescription the description of the grammar
   * @param startSymbol the start symbol of the grammar
   */
  public Grammar(String grammarTitle, String grammarDescription, String startSymbol) {
    this.grammarTitle = grammarTitle;
    this.grammarDescription = grammarDescription;
    this.startSymbol = startSymbol;
    this.nonTerminalSymbolProductions = new HashMap<>();
  }

  /**
   * Returns the title of the grammar.
   *
   * @return the title
   */
  public String getGrammarTitle() {
    return this.grammarTitle;
  }

  /**
   * Returns the description of the grammar.
   *
   * @return the description
   */
  public String getGrammarDescription() {
    return this.grammarDescription;
  }

  /**
   * Returns the start symbol of the grammar.
   *
   * @return the start symbol
   */
  public String getStartSymbol() {
    return startSymbol;
  }

  /**
   * Returns the productions for a given non-terminal.
   *
   * @param nonTerminalSymbol the non-terminal name
   * @return the list of productions, or null if not found
   */
  public List<Production> getProductions(String nonTerminalSymbol) {
    return nonTerminalSymbolProductions.get(nonTerminalSymbol.toLowerCase());
  }

  /**
   * Adds a production to the grammar for a given non-terminal.
   *
   * @param nonTerminalSymbol the non-terminal name
   * @param production  the production to add
   */
  public void addProduction(String nonTerminalSymbol, Production production) {
    nonTerminalSymbolProductions.computeIfAbsent(nonTerminalSymbol.toLowerCase(), k -> new ArrayList<>()).add(production);
  }

  /**
   * Returns the string representation of the grammar.
   *
   * @return a string built to represent all details of the grammar
   */
  @Override
  public String toString() {
    StringBuilder toStringBuilder = new StringBuilder();
    toStringBuilder.append(GRAMMARTITLESTRING).append(grammarTitle).append(NEWLINE);
    toStringBuilder.append(GRAMMARDESCRIPTIONSTRING).append(grammarDescription).append(NEWLINE);
    toStringBuilder.append(STARTSYMBOLSTRING).append(startSymbol).append(NEWLINE);

    for (Map.Entry<String, List<Production>> entry : nonTerminalSymbolProductions.entrySet()) {
      toStringBuilder.append(STARTPRODUCTIONSTRING)
              .append(GRAMMARNONTERMINAL)
              .append(entry.getKey())
              .append(NEWLINE)
              .append(GRAMMARPRODUCTIONS)
              .append(NEWLINE);

      for (Production production : entry.getValue()) {
        toStringBuilder.append(PRODUCTIONSPLITTER).append(production.toString()).append(NEWLINE);
      }

      toStringBuilder.append(ENDPRODUCTIONSTRING);
    }

    return toStringBuilder.toString();
  }

  /**
   * Returns the hash code for this grammar.
   *
   * @return the hash code
   */
  @Override
  public int hashCode() {
    return Objects.hash(grammarTitle, grammarDescription, nonTerminalSymbolProductions);
  }

  /**
   * Checks if this grammar is equal to another object.
   *
   * @param o the object to compare
   * @return true if the objects are equal
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Grammar that = (Grammar) o;
    return grammarTitle.equals(that.grammarTitle) &&
        grammarDescription.equals(that.grammarDescription) &&
        nonTerminalSymbolProductions.equals(that.nonTerminalSymbolProductions);
  }
}