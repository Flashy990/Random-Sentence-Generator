package assignment4;

import static assignment4.Constants.CLOSE;
import static assignment4.Constants.OPEN;

/**
 * Class to represent a non-terminal symbol in grammar
 */
public class NonTerminal extends AbstractSymbol {
  private final String name;

  /**
   * Constructs a NonTerminal with the given name.
   *
   * @param name the name of the non-terminal
   */
  public NonTerminal(String name) {
    this.name = name;
  }

  /**
   * Returns the name of the non-terminal.
   *
   * @return the name of the non-terminal
   */
  @Override
  public String getValue() {
    return name;
  }

  /**
   * Checks if this non-terminal is equal to another object.
   *
   * @param o the object to compare
   * @return true if the objects are equal
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof NonTerminal)) return false;
    NonTerminal other = (NonTerminal) o;
    return name.equalsIgnoreCase(other.name);
  }

  /**
   * Returns the hash code for this non-terminal.
   *
   * @return the hash code
   */
  @Override
  public int hashCode() {
    return name.toLowerCase().hashCode();
  }

  /**
   * Returns the string representation of the non-terminal.
   *
   * @return the name of the non-terminal enclosed in angle brackets
   */
  @Override
  public String toString() {
    return OPEN + name + CLOSE;
  }
}