package uk.ac.rhul.cs2800;

/**
 * Creates a new object StrStack that extends the Stack class. Contains a push method that takes a
 * String as a parameter rather than an Entry object.
 *
 * @author ZKAC176
 *
 */
public class StrStack extends Stack {
  /**
   * Pushes the specified String object onto the stack.
   *
   * @param str the string element to be pushed onto the top of the stack
   */
  public void push(String str) {
    Entry entry = new Entry(str);
    push(entry);
  }
}
