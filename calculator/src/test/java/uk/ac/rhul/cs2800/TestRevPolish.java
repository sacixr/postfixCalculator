package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
  void testEvaluate() {
    assertEquals(rp.evaluate("0"), 0.0, "0 should return 0.0 when evaluated.");
  }

  @Test
  // Test 2
  // RevPolishCalc returns arbitrary value dependent on what is fed.
  void testSimpleEval() {
    assertEquals(rp.evaluate("2"), 2.0, "2 should evaluate to 2.0");
  }

  @Test
  // Test 3
  // RevPolishCalc splits the string into array of strings and adds first two values together. Can
  // now do simple addition calculations.
  void testAddition() {
    assertEquals(rp.evaluate("2 4 +"), 6.0, "2 + 3 should evaluate to 5");
  }
}
