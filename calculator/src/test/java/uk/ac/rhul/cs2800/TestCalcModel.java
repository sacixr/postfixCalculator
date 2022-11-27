package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestCalcModel {
  CalcModel model;

  @BeforeEach
  void create() {
    model = new CalcModel();
  }

  @Test
  // Test 1
  void testEmpty() {
    assertEquals(model.evaluate("0", false), 0.0,
        "0 should evaluate to 0.0 no matter if infix or not");
    assertEquals(model.evaluate("0", true), 0.0,
        "0 should evaluate to 0.0 no matter if infix or not");
  }
}
