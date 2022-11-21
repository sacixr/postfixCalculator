package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestRevPolish {
  RevPolishCalc rp;

  @BeforeEach
  void create() {
    rp = new RevPolishCalc();
  }

  @Test
  // Test 1
  // Created RevPolishCalc class
  void testEvaluate() throws InvalidExpression {
    assertEquals(rp.evaluate("0"), 0.0, "0 should return 0.0 when evaluated.");
  }

  @Test
  // Test 2
  // RevPolishCalc returns arbitrary value dependent on what is fed.
  void testSimpleEval() throws InvalidExpression {
    assertEquals(rp.evaluate("2"), 2.0, "2 should evaluate to 2.0");
  }

  @Test
  // Test 3
  // RevPolishCalc splits the string into array of strings and adds first two values together. Can
  // now do simple addition calculations.
  void testAddition() throws InvalidExpression {
    assertEquals(rp.evaluate("2 4 +"), 6.0, "2 + 3 should evaluate to 5");
  }

  @Test
  // Test 4
  void testSubtraction() throws InvalidExpression {
    assertEquals(rp.evaluate("3 5 -"), -2.0, "3 - 5 should evaluate to -2");
  }

  @Test
  // Test 5
  // Added all possible operators
  void testMultiplicationDivision() throws InvalidExpression {
    assertEquals(rp.evaluate("2 2 *"), 4.0, "2 * 2 should evaluate to 4.0");
    assertEquals(rp.evaluate("10 5 /"), 2.0, "10 / 5 should evaluate to 2");
  }

  @Test
  // Test 6
  void testComplex() throws InvalidExpression {
    assertEquals(rp.evaluate("2 2 + 5 *"), 20.0, "(2 + 2) + 5 should evaluate to 20.0");
  }

  @Test
  // Test 7
  void testDoubleDigits() throws InvalidExpression {
    assertEquals(rp.evaluate("22 45 * 10 +"), 1000.0, "(22 * 45 + 10 should evaluate to 1000.0");
  }

  @Test
  // Test 8
  void testDecimals() throws InvalidExpression {
    assertEquals(rp.evaluate("22.8 4.7 * 9.1 +"), 116.26, 0.1,
        "22.8 * 4.7 + 9.1 should evaluate to 116.26");
  }

  @Test
  // Test 9
  // Implemented throw exception at the end of the method by checking if the size of the stack is
  // bigger than one. Only occurs if multiple numbers are pushed
  void testInvalid() {
    assertThrows(InvalidExpression.class, () -> rp.evaluate("2 2 2 +"),
        "Invalid expression should throw exception.");
  }

  @Test
  // Test 10
  // Implemented throw exception before switch case to check if the numStack is empty, as no numbers
  // will be pushed if symbol pushed first
  void testInvalidSymbol() {
    assertThrows(InvalidExpression.class, () -> rp.evaluate("+ + +"),
        "Invalid expression should throw exception.");
  }
}
