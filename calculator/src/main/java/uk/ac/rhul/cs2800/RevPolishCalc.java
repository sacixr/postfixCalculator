package uk.ac.rhul.cs2800;

public class RevPolishCalc {
  public float evaluate(String what) {
    if (what == "") {
      return (float) 0;
    } else {
      String[] splitStr = what.split(" ");
      if (splitStr.length == 1) {
        return (float) Float.parseFloat(splitStr[0]);
      } else {
        int curr = 0;
        float result = 0;
        switch (splitStr[2]) {
          case "+":
            result = Float.parseFloat(splitStr[curr]) + Float.parseFloat(splitStr[curr + 1]);
            break;
          case "-":
            result = Float.parseFloat(splitStr[curr]) - Float.parseFloat(splitStr[curr + 1]);
            break;
          case "*":
            result = Float.parseFloat(splitStr[curr]) * Float.parseFloat(splitStr[curr + 1]);
            break;
          case "/":
            result = Float.parseFloat(splitStr[curr]) / Float.parseFloat(splitStr[curr + 1]);
            break;
          default:
            return result;
        }
        return result;
      }
    }
  }

}
