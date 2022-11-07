package uk.ac.rhul.cs2800;

/**
 * Thrown to indicate that a method has been called on the incorrect type of entry variable.
 *
 * @author ZKAC176
 */
public class BadTypeException extends Exception {
  private static final long serialVersionUID = 1L;

  /**
   * Constructs a BadTypeException with a modifiable string output.
   *
   * @param message the string to be returned back to the command line
   */
  public BadTypeException(String message) {
    super(message);
  }
}
