package edu.luc.cs271.myhashmap;

import static org.junit.Assert.*;

import java.util.Map;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestMyHashMap {

  // TODO complete this test class

  // TODO declare a reference to the SUT (system under test), i.e., MyHashMap
  MyHashMap<String, Integer> fixture;

  @Before
  public void setUp() {
    // TODO create the SUT instance
    fixture = new MyHashMap<>();
  }

  @After
  public void tearDown() {
    // TODO set the SUT instance to null
    fixture = null;
  }

  @Test
  public void testEmpty() {
    // TODO verify that the SUT initially returns an empty map
    assertTrue(fixture.isEmpty());
    assertEquals(0, fixture.size());
    assertEquals(0, fixture.keySet().size());
    assertEquals(0, fixture.values().size());
    assertEquals(0, fixture.entrySet().size());
  }

  @Test
  public void testNonEmpty() {
    // TODO run the SUT on a specific String iterator with some repeated words,
    // then use assertions to verify the correct counts
    // do this for at least two words in the iterator and two not in the iterator
    assertNull(fixture.put("hello", 3));
    assertNull(fixture.put("world", 4));
    assertNull(fixture.put("what", 5));
    assertNull(fixture.put("up", 6));
    assertEquals(Integer.valueOf(6), fixture.put("up", 4));
    assertFalse(fixture.isEmpty());
    assertEquals(4, fixture.size());
    assertEquals(4, fixture.keySet().size());
    assertEquals(4, fixture.values().size());
    assertEquals(4, fixture.entrySet().size());
  }

  @Test
  public void testContainsKey() {
    populateFixture(fixture);
    assertTrue(fixture.containsKey("world"));
    assertFalse(fixture.containsKey("mundo"));
    assertFalse(fixture.containsKey("welt"));
  }

  @Test
  public void testContainsValue() {
    populateFixture(fixture);
    assertTrue(fixture.containsValue(3));
    assertFalse(fixture.containsValue(2));
    assertFalse(fixture.containsValue(7));
  }

  @Test
  public void testRemove() {
    populateFixture(fixture);
    assertEquals(Integer.valueOf(5), fixture.remove("what"));
    assertNull(fixture.remove("what"));
  }

  @Test
  public void testClear() {
    populateFixture(fixture);
    fixture.clear();
    assertEquals(0, fixture.size());
    assertEquals(0, fixture.keySet().size());
    assertEquals(0, fixture.values().size());
    assertEquals(0, fixture.entrySet().size());
  }

  @Test
  public void testEquals() {
    populateFixture(fixture);
    Map<String, Integer> fixture2 = new MyHashMap<>();
    populateFixture(fixture2);
    assertTrue(fixture.equals(fixture2));
  }

  @Test
  public void testPutAll() {
    populateFixture(fixture);
    Map<String, Integer> fixture2 = new MyHashMap<>();
    fixture2.putAll(fixture);
    assertEquals(fixture, fixture2);
  }

  private void populateFixture(final Map<String, Integer> fixture) {
    fixture.put("hello", 3);
    fixture.put("world", 4);
    fixture.put("what", 5);
    fixture.put("up", 6);
  }
}
