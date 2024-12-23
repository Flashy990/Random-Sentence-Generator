package assignment4;

import java.util.List;
import java.util.Objects;

import static assignment4.Constants.PRODUCTIONSPLITTER2;

/**
 * Class representing a production rule in the grammar.
 * Consists of a sequence of symbols (terminals and non-terminals).
 */
public class Production {
  private final List<AbstractSymbol> symbols;

  /**
   * Constructs a Production with the given list of symbols.
   *
   * @param symbols the list of symbols in the production
   */
  public Production(List<AbstractSymbol> symbols) {
    this.symbols = symbols;
  }

  /**
   * Returns the list of symbols in the production.
   *
   * @return the list of symbols
   */
  public List<AbstractSymbol> getSymbols() {
    return this.symbols;
  }

  /**
   * Checks if this production is equal to another object.
   *
   * @param o the object to compare
   * @return true if the objects are equal
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Production that = (Production) o;
    return this.symbols.equals(that.symbols);
  }

  /**
   * Returns the hash code for this production.
   *
   * @return the hash code
   */
  @Override
  public int hashCode() {
    return Objects.hash(symbols);
  }

  /**
   * Returns the string representation of the production.
   *
   * @return the symbols concatenated into a string
   */
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    for (AbstractSymbol symbol : symbols) {
      sb.append(symbol.toString()).append(PRODUCTIONSPLITTER2);
    }
    return sb.toString().trim();
  }
}