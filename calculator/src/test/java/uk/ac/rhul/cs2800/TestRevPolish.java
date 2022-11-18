package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class TestRevPolish {

  @Test
  // Test 1
  // Created RevPolishCalc class
  void testEvaluate() {
    RevPolishCalc rp = new RevPolishCalc();
    assertEquals(rp.evaluate("0"), 0.0,
        "0 should return 0.0 when evaluated.");
  }
}
