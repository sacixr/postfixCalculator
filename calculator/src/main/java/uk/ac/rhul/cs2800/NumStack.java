package uk.ac.rhul.cs2800;

public class NumStack {
  private Stack numStack;

  public NumStack() {
    numStack = new Stack();
  }

  public void push(float i) {
    Entry entry = new Entry(i);
    numStack.push(entry);
  }

  public boolean isEmpty() {
    if (numStack.size() == 0) {
      return true;
    } else {
      return false;
    }
  }

  public float pop() {
    return Float.parseFloat(numStack.pop().toString());
  }

}
