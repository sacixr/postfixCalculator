package uk.ac.rhul.cs2800;

/**
 * Determines which calculator is used dependent on the expression. Calculates infix and postfix
 * notation in float. Contains evaluate method that decides which class to use.
 *
 * @author ZKAC176
 *
 */

public class CalcModel {
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
      RevPolishCalc rp = new RevPolishCalc();
      return rp.evaluate(expr);
    } else if (infix == true) {
      StandardCalc sc = new StandardCalc();
      return sc.evaluate(expr);
    }
    return 0;
  }
}
