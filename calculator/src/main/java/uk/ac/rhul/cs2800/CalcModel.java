package uk.ac.rhul.cs2800;

public class CalcModel {
  public float evaluate(String expr, boolean infix) throws InvalidExpression {
    if (infix == false) {
      RevPolishCalc rp = new RevPolishCalc();
      return rp.evaluate(expr);
    }
    return (float) 0;
  }
}
