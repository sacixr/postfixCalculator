package uk.ac.rhul.cs2800;

/**
 * Stores the non-number tokens possible in an expression.
 *
 * @author ZKAC176
 */
public enum Symbol {
  /**
   * Left Bracket symbol.
   */
  LEFTBRACKET("Left Bracket"),
  /**
   * Right Bracket symbol.
   */
  RIGHTBRACKET("Right Bracket"),
  /**
   * Times symbol.
   */
  TIMES("Times"),
  /**
   * Divide symbol.
   */
  DIVIDE("Divide"),
  /**
   * Plus symbol.
   */
  PLUS("Plus"),
  /**
   * Minus symbol.
   */
  MINUS("Minus"),
  /**
   * Invalid symbol.
   */
  INVALID("Invalid");

  private String string;

  private Symbol(String value) {
    string = value;
  }

  @Override
  public String toString() {
    return string;
  }
}
