package uk.ac.rhul.cs2800;

public class StandardCalc implements Calculator {

  @Override
  public float evaluate(String what) throws InvalidExpression {
    if (what == "") {
      return (float) 0;
    } else {
      String[] splitStr = what.split(" ");
      if (splitStr.length == 1) {
        return (float) Float.parseFloat(splitStr[0]);
      }
    } 
    return (float) 0;
  }
}
