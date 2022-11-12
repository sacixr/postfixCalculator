package uk.ac.rhul.cs2800;

/**
 * Creates a new object NumStack. Contains a push method that takes a float as a parameter rather
 * than an Entry object. Contains an isEmpty method that checks if the stack is empty using size
 * method from Stack class.
 *
 * @author ZKAC176
 */
public class NumStack {
  private Stack numStack;

  /**
   * Constructs an empty numStack object.
   */
  public NumStack() {
    numStack = new Stack();
  }

  /**
   * Pushes the specified float object onto the stack.
   *
   * @param i the float element to be pushed onto the top of the stack
   */
  // Creates a new entry with the same variable 'i' in it and pushes utilising Stack push() method.
  public void push(float i) {
    Entry entry = new Entry(i);
    numStack.push(entry);
  }

  /**
   * Returns the float object on top of the stack.
   *
   * @return float object on the top of the stack
   */
  // Utilises pop() method from Stack class to pop the top entry. Returns string representation of
  // the object and then parses into a float value.
  public float pop() {
    return Float.parseFloat(numStack.pop().toString());
  }
  
  /**
   * Checks if the stack is empty.
   *
   * @return the boolean result relative to size of stack
   */
  // Returns true if numStack is empty. Checks size of stack to confirm this.
  public boolean isEmpty() {
    if (numStack.size() == 0) {
      return true;
    } else {
      return false;
    }
  }

}
