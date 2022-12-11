package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.EmptyStackException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestCalcModel {
  CalcModel model;
  float result;
  float result2;

  @BeforeEach
  void create() throws InvalidExpression {
    model = new CalcModel();
    result = model.evaluate("2 + 5", true);
    result2 = model.evaluate("5 5 +", false);
  }

  @Test
  // Test 1
  void testEmpty() throws InvalidExpression {
    assertEquals(model.evaluate("0", false), 0.0,
        "0 should evaluate to 0.0 no matter if infix or not");
    assertEquals(model.evaluate("0", true), 0.0,
        "0 should evaluate to 0.0 no matter if infix or not");
  }
  
  @Test
  // Test 2
  void testRevPolish() throws InvalidExpression {
    assertEquals(model.evaluate("2 5 +", false), 7.0, "2 + 5 should evaluate to 7.0");
    assertEquals(model.evaluate("2 2 + 5 *", false), 20.0, "2 + 2 * 5 should evaluate to 20.0");
  }
  
  @Test
  // Test 3
  void testStandardCalc() throws InvalidExpression {
    assertEquals(model.evaluate("2 + 5", true), 7.0, "2 + 5 should evaluate to 7.0");
  }
  
  @Test
  // Test 4
  void testCompelxStandarc() throws InvalidExpression {
    assertEquals(model.evaluate("2 + 6 - 5", true), 3.0, "2 + 6 - 5 should evaluate to 3.0");
  }
  
  @Test
  // Test 5
  void testSaveValue() throws InvalidExpression {
    assertEquals(result, 7.0, "2 + 7 evaluates to 7.0");
    model.saveTo(result, "A");
    model.saveTo(result2, "first");
    assertEquals(model.getVal("A"), 7.0, "A should return 7.0");
    assertEquals(model.getVal("first"), 10.0, "first should return 10.0");
  }
  
  @Test
  // Test 6
  void invalidSave() throws InvalidExpression {
    assertEquals(result, 7.0, "2 + 7 evaluates to 7.0");
    assertThrows(InvalidExpression.class, () -> model.saveTo(result, "1"),
        "Invalid store value should return InvalidExpression error.");
  }
}
