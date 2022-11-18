package uk.ac.rhul.cs2800;

public class RevPolishCalc {
  public float evaluate(String what) {
    // checks if string is empty, if so returns 0
    if (what == "") {
      return (float) 0;
    } else {
      // if string not empty splits into string array so that each character is stored in one space
      String[] splitStr = what.split(" ");
      // if string is only one value, returns this one value
      if (splitStr.length == 1) {
        return (float) Float.parseFloat(splitStr[0]);
      } else {
        float result = 0;
        NumStack numStack = new NumStack();
        // pushes numbers onto the stack
        for (int curr = 0; curr != splitStr.length; curr++) {
          String temp = splitStr[curr];
          if (Character.isDigit(temp.charAt(0))) {
            numStack.push(Float.parseFloat(splitStr[curr]));
          } else {
            float first = numStack.pop();
            float second = numStack.pop();
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
        return result;
      }
    }
  }
}
