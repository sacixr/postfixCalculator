package uk.ac.rhul.cs2800;

import org.apache.commons.lang3.math.NumberUtils;

/**
 * Evaluates a Reverse Polish String expression. Implements the Calculator interface and contains
 * the necessary evaluates method.
 *
 * @author ZKAC176
 *
 */
public class RevPolishCalc implements Calculator {
  private NumStack numStack;
  private String[] splitStr;
  private String temp;
  private float first;
  private float second;
  private float result;

  /**
   * Constructs an empty RevPolishCalc object.
   */
  public RevPolishCalc() {
    numStack = new NumStack();
    splitStr = new String[30];
    temp = "";
    first = 0;
    second = 0;
    result = 0;
  }

  /**
   * Evaluates a Reverse Polish String expression and returns the result of the calculation.
   *
   * @return the result of the arithmetic operation determined from the Reverse Polish String
   *         expression
   * @throws InvalidExpression if the provided expression cannot be computed due to incorrect
   *         formatting
   */
  public float evaluate(String what) throws InvalidExpression {
    // checks if string is empty, if so returns 0
    if (what == "") {
      return (float) 0;
    } else {
      // if string not empty splits into string array so that each character is stored in one space
      splitStr = what.split(" ");
      // if string is only one value, returns this one value
      if (splitStr.length == 1) {
        return (float) Float.parseFloat(splitStr[0]);
      } else {
        result = 0;
        numStack = new NumStack();
        // pushes numbers onto the stack
        for (int curr = 0; curr != splitStr.length; curr++) {
          temp = splitStr[curr];
          if (NumberUtils.isCreatable(temp)) {
            numStack.push(Float.parseFloat(splitStr[curr]));
          } else {
            // checks if numStack is empty just in case an incorrect number of symbols is provided
            if (numStack.isEmpty()) {
              throw new InvalidExpression("Invalid expression provided.");
            }
            first = numStack.pop();
            second = numStack.pop();
            // checks which operator is upcoming and utilises this to determine which calculation is
            // being done
            switch (splitStr[curr]) {
              case "+":
                result = first + second;
                numStack.push(result);
                break;
              case "-":
                result = second - first;
                numStack.push(result);
                break;
              case "*":
                result = first * second;
                numStack.push(result);
                break;
              case "/":
                result = second / first;
                numStack.push(result);
                break;
              default:
                return result;
            }
          }
        }
        if (numStack.getSize() > 1) {
          throw new InvalidExpression("Invalid expression provided.");
        }
        return result;
      }
    }
  }
}
