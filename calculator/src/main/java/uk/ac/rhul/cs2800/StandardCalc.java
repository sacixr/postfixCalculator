package uk.ac.rhul.cs2800;

import org.apache.commons.lang3.math.NumberUtils;

/**
 * Evaluates a Standard String expression. Implements the Calculator interface and contains the
 * necessary evaluates method.
 *
 * @author ZKAC176
 *
 */
public class StandardCalc implements Calculator {
  private OpStack values;
  private RevPolishCalc rpCalc;
  String operator = "";
  String strResult = "";

  /**
   * Constructs an empty StandardCalc object.
   */
  public StandardCalc() {
    values = new OpStack();
    rpCalc = new RevPolishCalc();
  }

  @Override
  public float evaluate(String what) throws InvalidExpression {
    strResult = "";
    // if the string is empty, return 0
    if (what == " ") {
      return (float) 0;
    }
    // else, split the string up by whitespace
    String[] splitStr = what.split(" ");
    // if its only one digit, return that float
    if (splitStr.length == 1) {
      return Float.parseFloat(splitStr[0]);
    }
    // until there is no more data to be pushed
    for (int curr = 0; curr != splitStr.length; curr++) {
      // get the current value
      String currString = splitStr[curr];
      // if its a number, instantly insert directly to string, utilises NumberUtils
      if (NumberUtils.isCreatable(currString)) {
        strResult = strResult + currString + " ";
      } else {
        // store the current and top precedence of the values
        int currPrec = getImport(currString);
        int topPrec = 0;
        // if the opStack values is empty, push the operator directly onto stack
        if (values.isEmpty()) {
          Symbol entry = Symbol.valueOf(values.getOperator(currString));
          values.push(entry);
        } else {
          // get top precedence
          topPrec = values.top().getPrecedence();
          // check which operator is to be pushed
          switch (currString) {
            case "/":
              swapOp(currPrec, topPrec);
              values.push(Symbol.DIVIDE);
              break;
            case "*":
              swapOp(currPrec, topPrec);
              values.push(Symbol.TIMES);
              break;
            case "+":
              swapOp(currPrec, topPrec);
              values.push(Symbol.PLUS);
              break;
            case "-":
              swapOp(currPrec, topPrec);
              values.push(Symbol.MINUS);
              break;
            default:
              break;
          }
        }
      }
    }
    while (!(values.isEmpty())) {
      operator = values.getOperator(values.pop().toString());
      strResult = strResult + operator + " ";
    }
    return (float) rpCalc.evaluate(strResult);
  }

  // gets the precedence of an operator
  private int getImport(String string) {
    switch (string) {
      case "/":
        return 1;
      case "*":
        return 1;
      case "+":
        return 2;
      case "-":
        return 2;
      default:
        return 0;
    }
  }

  // checks if the operators have to be swapped due to precedence
  private void swapOp(int current, int top) {
    if (current >= top) {
      operator = values.getOperator(values.pop().toString());
      strResult = strResult + operator + " ";
    }
  }
}
