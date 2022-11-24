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
  // Created StandardCalc class and evaluate method.
  void testCreate() throws InvalidExpression {
    assertEquals(sc.evaluate("0"), 0.0, "Evaluating 0 should return 0.0");
  }

}
