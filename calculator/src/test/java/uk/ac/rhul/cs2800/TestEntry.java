package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestEntry {
  private Symbol newSymbol;
  private Entry newSymbolEntry;
  private Entry newNumberEntry;
  private Entry newStringEntry;
  private Entry sameNumberEntry;

  @BeforeEach
  // Created to reduce repeated code.
  public void create() {
    newSymbol = Symbol.LEFTBRACKET;
    newNumberEntry = new Entry((float) 5.525);
    newSymbolEntry = new Entry(newSymbol);
    newStringEntry = new Entry("Filler");
    sameNumberEntry = new Entry((float) 5.525);
  }

  @Test
  // Test 10
  // Initially threw IllegalArgumentException in getValue() but created a new BadTypeException class
  // to be thrown instead.
  void createFloatEntry() throws BadTypeException {
    assertEquals(newNumberEntry.getValue(), (float) 5.525,
        "Creating an entry of value 5.525 should return 5.525.");
  }

  @Test
  // Test 11
  // Override toString method in Symbol class.
  void createSymbolTest() {
    assertEquals(newSymbol.toString(), "LeftBracket",
        "Calling toString on LEFTBRACKET should validate.");
  }

  @Test
  // Test 12
  void testGetSymbol() throws BadTypeException {
    assertEquals(newSymbolEntry.getSymbol().toString(), "LeftBracket",
        "Calling getSymbol on newSymbolEntry should return LEFTBRACKET.");
  }

  @Test
  // Test 15
  // Now throws a BadTypeException in getSymbol().
  void testBadSymbol() {
    assertThrows(BadTypeException.class, () -> newSymbolEntry.getValue(),
        "Can't call getValue on a Entry object with only a symbol value.");
  }

  @Test
  // Test 13
  void testTypeSymbol() {
    assertEquals(newSymbolEntry.getType().toString(), "Symbol",
        "Calling getType on newType should return Symbol.");
  }

  @Test
  // Test 16
  void testBadValue() {
    assertThrows(BadTypeException.class, () -> newNumberEntry.getSymbol(),
        "Can't call getSymbol on an Entry object with only a float value.");
  }

  @Test
  // Test 14
  void testTypeNumber() {
    assertEquals(newNumberEntry.getType().toString(), "Number",
        "Calling getType on an Entry with a float value should return type number.");
  }

  @Test
  // Test 17
  // Created a new Entry constructor which takes a String as a parameter. Created a getString()
  // method which returns the string associated with the Entry object. Added throws BadTypeException
  // after Test 21.
  void createStringEntry() throws BadTypeException {
    assertEquals(newStringEntry.getString(), "Filler",
        "Creating an entry with the String: Filler, should validate.");
  }

  @Test
  // Test 18
  // Originally failed as had hard-coded value. Now update str variable in Entry(String string)
  // constructor. Added throws BadTypeException after Test 21.
  void createDiffString() throws BadTypeException {
    Entry changedStringEntry = new Entry("Change");
    assertEquals(changedStringEntry.getString(), "Change",
        "Creating an entry with the String: Changed, should validate");
  }

  @Test
  // Test 19
  // Moved newStringEntry to avoid repeated code in Test 17 and Test 19. Received
  // nullPointerException as Symbol wasn't being set in constructor. Now sets type to string
  // in constructor.
  void stringType() throws BadTypeException {
    assertEquals(newStringEntry.getType().toString(), "String",
        "Creating an entry(string) should return the Symbol String.");
  }

  @Test
  // Test 21
  // Made getString method throw a BadTypeException.
  void testBadString() {
    assertThrows(BadTypeException.class, () -> newNumberEntry.getString(),
        "Can't call getString on an Entry object with only a float value.");
  }

  @Test
  // Test 22
  // Created a toString() in Entry class to return a readable version of the Entry object created.
  void testEntryToString() {
    assertEquals(newStringEntry.toString(), "Filler",
        "Test the toString() override in Entry to return the string version of the String object.");
  }

  @Test
  // Test 23
  // Making sure that the toString() in the Entry class also works for a float value.
  void testFloatToString() {
    assertEquals(newNumberEntry.toString(), "5.525",
        "Test the toString() override in Entry to return the string version of the float object.");
  }

  @Test
  // Test 24
  // Overwritten equals method in entry class.
  void objectSame() {
    assertTrue(newNumberEntry.equals(sameNumberEntry), "Checks if the two objects are the same.");
  }

  @Test
  // Test 25
  // Overwritten hashCode method in entry class. Also changed number from a primitive type float to
  // a reference type to be able to check if it is null rather than 0
  void hashCodeSame() {
    assertEquals(newNumberEntry.hashCode(), sameNumberEntry.hashCode(),
        "Tests if the haschode of two different objects with the same attributes returns true.");
  }
}
