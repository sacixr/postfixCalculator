package uk.ac.rhul.cs2800;

public class StandardCalc implements Calculator {

  @Override
  public float evaluate(String what) throws InvalidExpression {
    OpStack values = new OpStack();
    RevPolishCalc rpCalc = new RevPolishCalc();
    NumStack numbers = new NumStack();

    if (what == "") {
      return (float) 0;
    } else {
      String[] splitStr = what.split(" ");
      if (splitStr.length == 1) {
        return (float) Float.parseFloat(splitStr[0]);
      }
      for (int curr = 0; curr != splitStr.length; curr++) {
        String temp = splitStr[curr];
        if (Character.isDigit(temp.charAt(0))) {
          numbers.push(Float.parseFloat(splitStr[curr]));
        } else {
          switch (splitStr[curr]) {
            case "+":
              values.push(Symbol.PLUS);
              break;
            case "-":
              values.push(Symbol.MINUS);
              break;
            case "*":
              values.push(Symbol.TIMES);
              break;
            case "/":
              values.push(Symbol.DIVIDE);
              break;
            default:
              // empty for now
          }
        }
      }
      String strResult = "";
      while (!(numbers.isEmpty())) {
        Float temp1 = numbers.pop();
        strResult = temp1.toString() + " " + strResult;
      }
      while (!(values.isEmpty())) {
        String temp2 = values.getOperator(values.pop().toString());
        strResult = strResult + temp2 + " ";
      }
      return (float) rpCalc.evaluate(strResult);
    }
  }
}
