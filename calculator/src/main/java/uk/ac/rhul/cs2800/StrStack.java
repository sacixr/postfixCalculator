package uk.ac.rhul.cs2800;

import java.util.EmptyStackException;

/**
 * Creates a new object StrStack that extends the Stack class. Contains a push method that takes a
 * String as a parameter rather than an Entry object.
 *
 * @author ZKAC176
 *
 */
public class StrStack {
  private Stack strStack;
  
  /**
   * Constructs an empty Stack object.
   */
  public StrStack() {
    strStack = new Stack();
  }

  /**
   * Pushes the specified String object onto the stack.
   *
   * @param str the string element to be pushed onto the top of the stack
   */
  public void push(String str) {
    Entry entry = new Entry(str);
    strStack.push(entry);
  }

  /**
   * Returns the string item on top of the stack.
   *
   * @return string object on the top of the stack
   */
  public String pop() {
    if (strStack.size() == 0) {
      throw new EmptyStackException();
    }
    return strStack.pop().toString();
  }

  /**
   * Checks if the stack is empty.
   *
   * @return the boolean result relative to size of stack
   */
  public boolean isEmpty() {
    if (strStack.size() == 0) {
      return true;
    } else {
      return false;
    }
  }
}
