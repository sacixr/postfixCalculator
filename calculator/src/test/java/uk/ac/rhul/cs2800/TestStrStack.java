package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
  // stack.
  void testNewOpStack() {
    strStack.push(string);
    assertEquals(strStack.size(), 1, "Push an item of type STRING onto the Stack.");
  }

  @Test
  // Test 27
  // Checking that StrStack inherits from Stack correctly.
  // Currently does not pop correctly.
  void testPopOpStack() {
    strStack.push(string);
    assertEquals(strStack.pop().toString(), "Hello", "Pushing 'Hello' should retun 'Hello'.");
  }

  @Test
  // Test 28
  //
  void testEmptyStrStack() {
    assertThrows(EmptyStackException.class, () -> strStack.pop(),
        "There is nothing to pop from an empty stack.");
  }

}
