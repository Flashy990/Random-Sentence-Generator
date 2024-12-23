package assignment4;

/**
 * Class to represent a terminal symbol in grammar
 */
public class Terminal extends AbstractSymbol {
  private final String value;

  /**
   * Constructs a Terminal with the given value.
   *
   * @param value the string value of the terminal
   */
  public Terminal(String value) {
    this.value = value;
  }

  @Override
  public String getValue() {
    return value;
  }

  /**
   * Checks if this terminal is equal to another object.
   *
   * @param o the object to compare
   * @return true if the objects are equal
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Terminal terminal = (Terminal) o;
    return value.equalsIgnoreCase(terminal.value);
  }

  /**
   * Returns the hash code for this terminal.
   *
   * @return the hash code
   */
  @Override
  public int hashCode() {
    return value.toLowerCase().hashCode();
  }

  /**
   * Returns the string representation of the terminal.
   *
   * @return the value of the terminal
   */
  @Override
  public String toString() {
    return value;
  }
}