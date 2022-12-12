package uk.ac.rhul.cs2800;

/**
 * Runs the calculator main class.
 *
 * @author ZKAC176
 *
 */
public class CalcMain {
  private static AsciiView view;
  
  public static void main(String[] args) {
    view = new AsciiView();
    view.menu();
  }

}