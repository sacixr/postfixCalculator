package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestStandardCalc {
  StandardCalc sc;

  @BeforeEach
  void create() {
    sc = new StandardCalc();
  }

  @Test
  // Test 1
  // Created StandardCalc class and evaluate method.
  void testCreate() throws InvalidExpression {
    assertEquals(sc.evaluate("0"), 0.0, "Evaluating 0 should return 0.0");
  }

  @Test
  // Test 2
  void testCreateSingle() throws InvalidExpression {
    assertEquals(sc.evaluate("1"), 1.0, "Evaluating 1 should return 1.0");
  }

  @Test
  // Test 3
  void testEmpty() throws InvalidExpression {
    assertEquals(sc.evaluate(" "), 0.0, "Evaluating nothing should return 0");
  }
  
  @Test
  // Test 4
  void testSimple() throws InvalidExpression {
    assertEquals(sc.evaluate("2 + 3"), 5.0, "2 + 3 should evaluate to 5");
  }
  
  @Test
  // Test 5
  void testSimpleExpressions() throws InvalidExpression {
    assertEquals(sc.evaluate("10 - 3"), 7.0, "10 - 3 should evaluate to 7");
    assertEquals(sc.evaluate("10 * 4"), 40.0, "10 * 4 should evaluate to 40");
    assertEquals(sc.evaluate("10 / 2"), 5.0, "10 / 2 should evaluate to 5");
  }
  
  @Test
  // Test 6
  void testNegatives() throws InvalidExpression {
    assertEquals(sc.evaluate("3 - 10"), -7.0, "3 - 10 should evaluate to -7");
  }
}
