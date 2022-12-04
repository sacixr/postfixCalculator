package uk.ac.rhul.cs2800;

public class CalcModel {
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
