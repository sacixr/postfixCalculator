package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.EmptyStackException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestStrStack {
  private StrStack strStack;
  private String string;

  @BeforeEach
  public void create() {
    strStack = new StrStack();
    string = "Hello";
  }

  @Test
  // Test 26
  // Created class strStack and push(String str) that creates a new entry and pushes it onto a
  // stack. Created isEmpty().
  void testNewOpStack() {
    strStack.push(string);
    assertFalse(strStack.isEmpty(), "Check that an item has been pushed");
  }

  @Test
  // Test 27
  // Checking pop throws correct exception.
  void testEmptyStrStack() {
    assertThrows(EmptyStackException.class, () -> strStack.pop(),
        "There is nothing to pop from an empty stack.");
  }

  @Test
  // Test 28
  // Fixed isEmpty() to return true/false based on size of stack.
  void testIsEmptyTrue() {
    assertTrue(strStack.isEmpty(), "No item pushed so should be empty, return True");
  }

  @Test
  // Test 29
  // Changed pop() to no longer return hard-coded value but toString of Stack pop.
  void testPushPushPop() {
    strStack.push(string);
    strStack.push("World");
    assertEquals(strStack.pop(), "World", "Pushing twice should pop newest entry.");
  }
}
