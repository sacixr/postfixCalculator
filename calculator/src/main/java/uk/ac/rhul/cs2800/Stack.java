package uk.ac.rhul.cs2800;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.function.BooleanSupplier;

/**
 * Manipulates an ArrayList to create a stack of Entry objects using the Last-In First-Out method.
 * Utilises four functions: size, push, pop and top to operate pushing and popping Entry objects
 * onto the stack, returning only the top value, with a size function to return size of the stack.
 * This code was inspired by the code in Dave's TDD video.
 *
 * @author ZKAC176
 */

public class Stack {
  // size - Sets the initial size of the stack to 0.
  // ArrayList<Entry> - Instantiates a new ArrayList value that takes Entries for items.
  private int size;
  private ArrayList<Entry> value;

  /**
   * Constructs an empty Stack object. Sets the initial size to 0.
   *
   */
  public Stack() {
    size = 0;
    value = new ArrayList<Entry>();
  }

  /**
   * Returns the number of elements in the stack.
   *
   * @return the size of the stack
   */
  public int size() {
    return size;
  }

  /**
   * Pushes the specified Entry object onto the stack, incrementing the size of the stack by 1.
   *
   * @param entry the element to be pushed onto the top of the stack
   */
  public void push(Entry entry) {
    value.add(entry);
    size = size + 1;
  }

  /**
   * Returns and removes the top Entry from the stack. Throws an exception if the stack is empty.
   *
   * @return the element at the top of the stack
   * @throws EmptyStackException if the specified size of the stack is 0
   */
  public Entry pop() {
    checkSize();
    size = size - 1;
    Entry poppedVal = value.get(size);
    value.remove(size);
    return poppedVal;
  }

  /**
   * Returns the top value from the stack. Throws an exception if the stack is empty.
   *
   * @return the element at the top of the stack
   * @throws EmptyStackException if the specified size of the stack is 0
   */
  public Entry top() {
    checkSize();
    return value.get(size - 1);
  }

  // Checks the size of the ArrayList. If 0 throws an EmptyStackException.
  private void checkSize() {
    if (size == 0) {
      throw new EmptyStackException();
    }
  }
}
