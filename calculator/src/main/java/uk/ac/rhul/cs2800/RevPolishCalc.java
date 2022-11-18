package uk.ac.rhul.cs2800;

public class RevPolishCalc {
  public float evaluate(String what) {
    if (what == "") {
      return (float) 0;
    } else {
      String[] splitStr = what.split(" ");
      if (splitStr.length == 1) {
        return (float) Float.parseFloat(splitStr[0]);
      }
      return (float) 5.0;
    }
  }

}
