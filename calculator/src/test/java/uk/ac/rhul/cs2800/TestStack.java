package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.EmptyStackException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

// This code was inspired by the code in Dave's TDD video.
class TestStack {
  private Stack stack;
  private Entry entryNum;
  private Entry entryNumTwo;

  @BeforeEach
  public void create() {
    stack = new Stack();
    entryNum = new Entry(5);
    entryNumTwo = new Entry(Symbol.DIVIDE);
  }

  @Test
  // Test 1
  void testNewSize() {
    assertEquals(stack.size(), 0, "Test a newly created stack to see that it has size zero.");
  }

  @Test
  // Test 2
  void testPush() {
    stack.push(entryNum);
    assertEquals(stack.size(), 1, "Test a stack to check it has size one.");
  }

  @Test
  // Test 3
  // Changed pop function to throw an exception if the size of the stack is 0.
  void testEmptyPop() {
    assertThrows(EmptyStackException.class, () -> stack.pop(),
        "There is nothing to pop from an empty stack.");
  }

  @Test
  // Test 4
  void pushPop() {
    stack.push(entryNum);
    assertEquals(stack.pop(), entryNum, "Pushing a ten then popping it should return 10.");
    assertEquals(stack.size(), 0, "Pushing a ten then popping it should give an empty stack.");
    assertThrows(EmptyStackException.class, () -> stack.pop(),
        "Push, pop, pop should throw an exception as stack is empty.");
  }

  @Test
  // Test 5
  // Changed push and pop function from returning a hard-coded value to introducing an
  // ArrayList<Integer> to represent the stack. Pushing adds an element to the Array and increases
  // size by 1. Popping reduces the size of the stack by 1, then removes and returns the element at
  // the top of the stack using ArrayList<> methods.
  void pushTwice() {
    stack.push(entryNum);
    stack.push(entryNumTwo);
    assertEquals(stack.size(), 2, "Pushing twice should give 2.");
    assertEquals(stack.pop(), entryNumTwo, "Pushing twice then popping returns the second item.");
    assertEquals(stack.pop(), entryNum,
        "Pushing twice then popping twice should return first item.");
    assertEquals(stack.size(), 0,
        "Pushing twice then popping three times should give an empty stack.");
    assertThrows(EmptyStackException.class, () -> stack.pop(),
        "Push, double pop should throw exception.");
  }

  @Test
  // Test 6
  // Overwrite entryNum each iteration to push on a different value.
  void pushLots() {
    for (int start = 0; start < 1000; start++) {
      entryNum = new Entry(start);
      stack.push(entryNum);
      assertEquals(stack.size(), start + 1, "Pushing once should increase the size to 1.");
    }
    assertEquals(stack.size(), 1000, "Pushing 1000 should increase the size to 1000.");
  }

  @Test
  // Test 7
  // Added a top function that returns a hard-coded value of 10.
  void pushTop() {
    stack.push(entryNumTwo);
    assertEquals(stack.size(), 1, "Pushing once should give 1");
    assertEquals(stack.top(), entryNumTwo,
        "Pushing a ten then calling top should return the top value.");
  }

  @Test
  // Test 8
  // Changed top function from returning a hard-coded value to returning the top value of the
  // ArrayList.
  void doublePushTopDoublePop() {
    stack.push(entryNumTwo);
    stack.push(entryNum);
    assertEquals(stack.size(), 2, "Pushing once should give 1.");
    assertEquals(stack.top(), entryNum, "Pushing a ten then calling top should return 10.");
    assertEquals(stack.pop(), entryNum, "Pushing, calling top and popping should return 10.");
    assertEquals(stack.pop(), entryNumTwo, "Should return 10 as 5 has been popped.");
  }

  @Test
  // Test 9
  // Added an EmptyStackException throw to the top function.
  void emptyTop() {
    assertThrows(EmptyStackException.class, () -> stack.top(),
        "There is nothing to pop from an empty stack.");
  }

  @Test
  // Test 20
  // Couldn't push on an entry object as the push() method only takes integers. Changed the method
  // to implement entries. Changed ArrayList<Integer> to ArrayList<Entry>. Changed pop() and top()
  // to return an Entry object. Had to refactor code by changing all above tests to no longer push
  // and pop integers but entry(float) and created one new entry(float) and one new entry(symbol)
  // object within TestStack.
  void stackEntry() {
    Entry entry = new Entry(10);
    stack.push(entry);
  }
}
