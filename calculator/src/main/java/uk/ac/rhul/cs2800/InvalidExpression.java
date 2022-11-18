package uk.ac.rhul.cs2800;

/**
 * Thrown to indicate that an invalid expression has been provided within the evaluate method.
 *
 * @author ZKAC176
 */
public class InvalidExpression extends Exception {
  private static final long serialVersionUID = 2L;

  /**
   * Constructs an InvalidExpression with a modifiable string output.
   *
   * @param message the string to be returned back to the command line
   */
  public InvalidExpression(String message) {
    super(message);
  }
}
