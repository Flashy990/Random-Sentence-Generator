package assignment4;

/**
 * Abstract class representing a symbol in the grammar.
 * A symbol can either be a Terminal or a NonTerminal.
 */
public abstract class AbstractSymbol {
  /**
   * Returns the string value of the symbol.
   *
   * @return the value of the symbol
   */
  public abstract String getValue();

  @Override
  public abstract boolean equals(Object o);

  @Override
  public abstract int hashCode();
}