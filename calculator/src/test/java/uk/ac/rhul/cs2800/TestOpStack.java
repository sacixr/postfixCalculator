package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.EmptyStackException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestOpStack {
  private OpStack opStack;
  private Symbol symbol;

  @BeforeEach
  void create() {
    opStack = new OpStack();
    symbol = Symbol.DIVIDE;
  }

  @Test
  // Test 33
  // Created class opStack, push(Symbol i) method and isEmpty() method. Return hard-coded values.
  void createOpStack() {
    opStack.push(symbol);
    assertFalse(opStack.isEmpty(), "Pushing an item means stack is not empty");
  }

  @Test
  // Test 34
  // Made isEmpty() no longer hard-coded. Returns value dependent on size. Made push(Symbol i)
  // create a new entry of type symbol and push value as required.
  void testEmptyStack() {
    assertTrue(opStack.isEmpty(), "An empty stack should return nothing.");
  }

  @Test
  // Test 35
  // Created pop method. No longer returns hard-coded value but Symbol relevant to item.
  void popOpStack() {
    opStack.push(symbol);
    assertEquals(opStack.pop(), Symbol.DIVIDE, "Popping a symbol should return a symbol.");
    assertTrue(opStack.isEmpty(), "Popping only item should make stack empty.");
  }

  @Test
  // Test 38
  void popEmpty() {
    assertThrows(EmptyStackException.class, () -> opStack.pop(),
        "There is nothing to pop from an empty stack.");
  }
}
