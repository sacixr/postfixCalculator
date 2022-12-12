package uk.ac.rhul.cs2800;

import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.math.NumberUtils;

/**
 * Determines which calculator is used dependent on the expression. Calculates infix and postfix
 * notation in float. Contains evaluate method that decides which class to use.
 *
 * @author ZKAC176
 *
 */

public class CalcModel {
  private RevPolishCalc rp;
  private StandardCalc sc;
  private Map<String, Float> map;

  /**
   * Constructs an empty CalcModel object.
   */
  public CalcModel() {
    rp = new RevPolishCalc();
    sc = new StandardCalc();
    map = new HashMap<>();
  }

  /**
   * Evaluates which calculator class to use. Returns float value.
   *
   * @param expr the string expression to be evaluated, in postfix or infix notation
   * @param infix boolean value determining if whether to use infix or postfix
   * @return float value returned by class
   * @throws InvalidExpression if the provided expression cannot be computed due to incorrect
   *         formatting
   */
  public float evaluate(String expr, boolean infix) throws InvalidExpression {
    if (infix == false) {
      return rp.evaluate(expr);
    } else if (infix == true) {
      return sc.evaluate(expr);
    }
    return 0;
  }

  /**
   * Saves the float result of an expression to a String so that it can be fetched later on.
   *
   * @param result the result of the evaluated expression in infix or postfix
   * @param string the value to be stored under
   * @throws InvalidExpression if the value provided to use to store the float is of incorrect type
   */
  public void saveTo(float result, String string) throws InvalidExpression {
    if (!NumberUtils.isCreatable(string)) {
      map.put(string, result);
    } else {
      throw new InvalidExpression("Cannot store values under numbers.");
    }
  }

  /**
   * Retrieves the float value associated with a specific String.
   */
  public float getVal(String string) {
    return map.get(string);
  }
}
