package edu.luc.cs271.myhashmap;

import java.util.*;

/**
 * A generic HashMap custom implementation using chaining. Concretely, the table is an ArrayList of
 * chains represented as LinkedLists.
 *
 * @param <K> the key type
 * @param <V> the value type
 */
public class MyHashMap<K, V> implements Map<K, V> {

  private static final int DEFAULT_TABLE_SIZE = 11; // a prime

  private List<List<Entry<K, V>>> table;

  public MyHashMap() {
    this(DEFAULT_TABLE_SIZE);
  }

  public MyHashMap(final int DEFAULT_TABLE_SIZE) {
    // allocate a table of the given size
    table = new ArrayList<>(DEFAULT_TABLE_SIZE);
    // then create an empty chain at each position
    for (int i = 0; i < DEFAULT_TABLE_SIZE; i += 1) {
      table.add(new LinkedList<>());
    }
  }

  @Overrides
  public int size() {
    // TODO add the sizes of all the chains
    int result = 0;
    for (int i = 0; i < DEFAULT_TABLE_SIZE; i++) {
      int cSize = table.get(i).size();
      result = result + cSize;
    }

    return result;
  }

  @Override
  public boolean isEmpty() {
    return size() == 0;
  }

  @Override
  public boolean containsKey(final Object key) {
    // DONETODO follow basic approach of remove below (though this will be much simpler)
    final int index = calculateIndex(key);
    final Iterator<Entry<K, V>> iter = table.get(index).iterator();
    while (iter.hasNext()) {
      final Entry<K, V> entry = iter.next();
      if (entry.getKey().equals(key)) {
        return true;
      }
    }
    return value;
  }

  @Override
  public boolean containsValue(final Object value) {
    // DONETODO follow basic approach of remove below (though this will be much simpler)
    final int index = calculateIndex(key);
    final Iterator<Entry<K, V>> iter = table.get(index).iterator();
    while (iter.hasNext()) {
      final Entry<K, V> entry = iter.next();
      if (entry.getValue().equals(value)) {
        value = entry.getValue();
      }
    }
    return;
  }

  @Override
  public V get(final Object key) {
    // DONETODO follow basic approach of remove below (though this will be simpler)
    final int index = calculateIndex(key);
    final Iterator<Entry<K, V>> iter = table.get(index).iterator();
    while (iter.hasNext()) {
      final Entry<K, V> entry = iter.next();
      if (entry.getKey().equals(key)) {
        final V oldValue = entry.getValue();
        return oldValue;
      }
    }
    return null;
  }

  @Override
  public V put(final K key, final V value) {
    // TODO follow basic approach of remove below (this will be similar)
    final int index = calculateIndex(key);
    final Iterator<Entry<K, V>> iter = table.get(index).iterator();
    while (iter.hasNext()) {
      final Entry<K, V> entry = iter.next();
      if (entry.getKey().equals(key)) {
        if (entry.getValue() != null) {
          entry.setValue(value);
          value = entry.getValue();
        } else {
          entry.setValue(value);
        }
      }
      return value;
    }
  }

  @Override
  public V remove(final Object key) {
    final int index = calculateIndex(key);
    final Iterator<Entry<K, V>> iter = table.get(index).iterator();
    while (iter.hasNext()) {
      final Entry<K, V> entry = iter.next();
      if (entry.getKey().equals(key)) {
        final V oldValue = entry.getValue();
        iter.remove();
        return oldValue;
      }
    }
    return null;
  }

  @Override
  public void putAll(final Map<? extends K, ? extends V> m) {
    for (int i = 0; i < DEFAULT_TABLE_SIZE; i++) {
      final Iterator<Entry<K, V>> iter = table.get(i).iterator();
      while (iter.hasNext()) {
        Entry<K, V> entry = iter.next();
        this.put(entry.getKey(), entry.getValue());
      }
    }
  }

  @Override
  public void clear() {
    for (int i = 0; i < DEFAULT_TABLE_SIZE; i++) {
      table.set(i, new LinkedList<>());
    }
  }
  /*The resulting keySet is not "backed" by the Map, so we keep it unmodifiable. */
  @Override
  public Set<K> key;
    final Set<K> result = new HashSet<>();
    // DONETODO populate the set
    result.add(entry);
    return Collections.unmodifiableSet(result);
  

  /** The resulting values collection is not "backed" by the Map, so we keep it unmodifiable. */
  @Override
  public Collection<V> values() {
    final List<V> result = new LinkedList<>();
    // DONETODO populate the list
    result.add(entry);

    return Collections.unmodifiableCollection(result);
  }

  /** The resulting entrySet is not "backed" by the Map, so we keep it unmodifiable. */
  @Override
  public Set<Entry<K, V>> entrySet() {
    final Set<Entry<K, V>> result = new HashSet<>();
    // DONETODO populate the set
    result.add(entry);

    return Collections.unmodifiableSet(result);
  }

  @Override
  public String toString() {
    for (Map.Entry<String, String> entry : myhashmap.entrySet()) {
      String key = entry.getKey();
      String value = entry.getValue();
      System.out.println("Key: " + key + " Value: " + value);
    }
  }

  public boolean equals(final Object that) {
    if (this == that) {
      return true;
    } else if (!(that instanceof Map)) {
      return false;
    } else {
      // DONE?????????TODO sim ply compare the entry sets
      if (!entrySetcontainsAll(result)) {
        return true;
      }
      return false;
    }
  }

  private int calculateIndex(final Object key) {
    return Math.floorMod(key.hashCode(), table.size());
  }
}
