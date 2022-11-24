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
        System.out.println("splitStr[curr] = " + splitStr[curr]);
        if (Character.isDigit(temp.charAt(0))) {
          System.out.println("pushed val = " + splitStr[curr]);
          numbers.push(Float.parseFloat(splitStr[curr]));
        } else {
          System.out.println("pushed op = " + splitStr[curr]);
          switch (splitStr[curr]) {
            case "+":
              values.push(Symbol.PLUS);
              break;
            default:
              // empty for now
          }
        }
      }
      String strResult = "";
      while (!(numbers.isEmpty())) {
        Float temp1 = numbers.pop();
        strResult = strResult + temp1.toString() + " ";
        System.out.println("strResult = " + strResult);
      }
      while (!(values.isEmpty())) {
        String temp2 = values.getOperator(values.pop().toString());
        strResult = strResult + temp2 + " ";
        System.out.println("strResult = " + strResult);
      }
      return (float) rpCalc.evaluate(strResult);
    }
  }
}
