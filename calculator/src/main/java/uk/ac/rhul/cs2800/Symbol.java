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
  LEFTBRACKET("LeftBracket", 0),
  /**
   * Right Bracket symbol.
   */
  RIGHTBRACKET("RightBracket", 0),
  /**
   * Divide symbol.
   */
  DIVIDE("Divide", 1),
  /**
   * Times symbol.
   */
  TIMES("Times", 1),
  /**
   * Divide symbol.
   */
  PLUS("Plus", 2),
  /**
   * Minus symbol.
   */
  MINUS("Minus", 2),
  /**
   * Invalid symbol.
   */
  INVALID("Invalid", 3);

  private String string;
  private int precedence;

  private Symbol(String value, int num) {
    string = value;
    precedence = num;
  }

  @Override
  public String toString() {
    return string;
  }
  
  public int getPrecedence() {
    return precedence;
  }
}
