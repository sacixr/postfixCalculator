package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.EmptyStackException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestNumStack {
  private NumStack numStack;
  private float value = (float) 45.68912;

  @BeforeEach
  public void create() {
    numStack = new NumStack();
  }

  @Test
  // Test 30
  // Created class NumStack and push(float) and isEmpty() methods. Return hard-coded values.
  void testPush() {
    numStack.push(value);
    assertFalse(numStack.isEmpty(), "Pushing a float should make the stack non-empty");
  }

  @Test
  // Test 31
  // Created pop method. Pop method parses from Entry->String->Float.
  void testPop() {
    numStack.push(value);
    assertEquals(numStack.pop(), (float) 45.68912, "Pushing and popping should return top value.");
    assertTrue(numStack.isEmpty(), "Pushing and popping should leave empty stack.");
  }

  @Test
  // Test 32
  void emptyPop() {
    assertThrows(EmptyStackException.class, () -> numStack.pop(),
        "Empty stack should throw an exception.");
  }

}
