package uk.ac.rhul.cs2800;

/**
 * Contains the constructors and getters for an Entry object that is stored in a stack.
 * Contains two types of constructors, one with a float parameter, the other with a Symbol
 * parameter. Implements getters to retrieve values associated with the object.
 *
 * @author ZKAC176
 */
public class Entry {
  // number - the Float value to be given as a parameter in the constructor.
  // other - the Symbol enum to be given as a parameter in the constructor.
  // str - the String value to be given as a parameter in the constructor.
  // type - value to set the type of value an Entry is representing.
  private Float number;
  private Symbol other;
  private String str;
  private Type type;

  /**
   * Constructs an Entry object with the specified float value. Sets the type variable to Number.
   *
   * @param value float value which is to be stored
   */
  public Entry(float value) {
    number = value;
    type = Type.NUMBER;
  }

  /**
   * Constructs an Entry object with the specified Symbol enum. Sets the type variable to Symbol.
   *
   * @param which enum symbol which is to be stored
   */
  public Entry(Symbol which) {
    other = which;
    type = Type.SYMBOL;
  }

  /**
   * Constructs an Entry object with the specified String. Sets the type variable to String.
   *
   * @param string the string which is to be stored
   */
  public Entry(String string) {
    str = string;
    type = Type.STRING;
  }

  /**
   * Fetches the float associated with Entry object. Throws a BadTypeException if the method is
   * called on an Entry object that is not of type Number.
   *
   * @return the float relative to the Entry object
   * @throws BadTypeException if the type of Entry is not a Number
   */
  public float getValue() throws BadTypeException {
    if (!(type.equals(Type.NUMBER))) {
      throw new BadTypeException("Cannot retrieve a non-float variable from a float Entry.");
    }
    return (float) number;
  }

  /**
   * Fetches the symbol associated with Entry object. Throws a BadTypeException if the method is
   * called on an object that is not of type Symbol.
   *
   * @return the non-number token of the Entry object
   * @throws BadTypeException if the type of Entry is not a Symbol
   */
  public Symbol getSymbol() throws BadTypeException {
    if (!(type.equals(Type.SYMBOL))) {
      throw new BadTypeException("Cannot retrieve a non-symbol variable from a symbol Entry.");
    }
    return other;
  }

  /**
   * Fetches the type of value stored by the Entry object.
   *
   * @return the type of value of the Entry object
   */
  public Type getType() {
    return type;
  }

  /**
   * Fetches the string associated with Entry object. Throws a BadTypeException if the method is
   * called on an object that is not of type String.
   *
   * @return the string relative to the Entry object
   * @throws BadTypeException if the type of Entry is not a String
   */
  public String getString() throws BadTypeException {
    if (!(type.equals(Type.STRING))) {
      throw new BadTypeException("Cannot retrieve a non-string variable from a string Entry.");
    }
    return str;
  }

  @Override
  public String toString() {
    if (type == Type.NUMBER) {
      return String.valueOf(number);
    } else if (type == Type.SYMBOL) {
      return other.toString();
    }
    return str;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (!(o instanceof Entry)) {
      return false;
    }
    Entry o2 = (Entry) o;
    boolean theSame = (this.str != null && this.str.equals(o2.str))
        || (this.other != null && this.other.equals(o2.other))
        || (this.number != null && this.number.equals(o2.number));
    return theSame;
  }

  @Override
  public final int hashCode() {
    int hash = 8;
    if (other != null) {
      hash = 18 * hash + other.hashCode();
    }
    if (str != null) {
      hash = 18 * hash + str.hashCode();
    }
    if (number != null) {
      hash = 18 * hash + number.hashCode();
    }
    return hash;
  }

}
