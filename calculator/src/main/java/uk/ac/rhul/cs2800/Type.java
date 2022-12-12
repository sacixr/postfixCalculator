package uk.ac.rhul.cs2800;

/**
 * Stores the types of value an Entry can represent.
 *
 * @author ZKAC176
 */
public enum Type {
  /**
   * Number type.
   */
  NUMBER("Number"),
  /**
   * Symbol type.
   */
  SYMBOL("Symbol"),
  /**
   * String type.
   */
  STRING("String");

  private String string;

  private Type(String value) {
    string = value;
  }

  @Override
  public String toString() {
    return string;
  }
}
