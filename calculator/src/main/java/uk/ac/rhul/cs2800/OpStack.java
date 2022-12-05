package uk.ac.rhul.cs2800;

/**
 * Creates a new object OpStack. Contains a push method that takes a Symbol enum as a parameter
 * rather than an Entry object. Contain an isEmpty method that checks if the stack is empty using
 * size method from Stack class. Contains a pop method that returns the Symbol at the top of the
 * stack.
 *
 * @author ZKAC176
 */
public class OpStack {
  private Stack opStack;

  /**
   * Constructs an empty opStack object.
   */
  public OpStack() {
    opStack = new Stack();
  }

  /**
   * Pushed the specified Symbol object onto the stack.
   *
   * @param i the Symbol object to be pushed onto the top of the stack
   */
  public void push(Symbol i) {
    Entry entry = new Entry(i);
    opStack.push(entry);
  }

  /**
   * Returns the symbol enum on top of the stack.
   *
   * @return symbol enum on the top of the stack
   */
  // Utilises pop() method from Stack class to get the top entry. Returns string representation,
  // which is then placed in uppercase to find in the enum class (lower case is not detected by
  // Java as enum written in full caps).
  public Symbol pop() {
    String original = opStack.pop().toString();
    String newO = original.toUpperCase();
    return Symbol.valueOf(newO);
  }


  /**
   * Checks if the stack is empty.
   *
   * @return the boolean result relative to size of stack
   */
  // Returns true if opStack is empty. Checks size of stack to confirm this.
  public boolean isEmpty() {
    if (opStack.size() == 0) {
      return true;
    } else {
      return false;
    }
  }
  
  /**
   * Retrieves the associated operator from a string.
   *
   * @param type possible string operator fed by method
   * @return associated operator as a string symbol
   */
  public String getOperator(String type) {
    switch (type) {
      case "Plus":
        return "+";
      case "Minus":
        return "-";
      case "Times":
        return "*";
      case "Divide":
        return "/";
      default:
        return null;
    }
  }
}
