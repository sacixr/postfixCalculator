package uk.ac.rhul.cs2800;

/**
 * Allows calculation of String Expressions.
 *
 * @author ZKAC176
 */
public interface Calculator {
  public float evaluate(String what) throws InvalidExpression;
}
