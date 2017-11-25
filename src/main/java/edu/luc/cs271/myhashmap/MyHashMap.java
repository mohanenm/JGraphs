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

  public MyHashMap(final int tableSize) {
    table = new ArrayList<>(tableSize);
    for (int i = 0; i < tableSize; i += 1) {
      table.add(new LinkedList<>());
    }
  }

  @Override
  public int size() {

    // Done

    int result = 0;

    for (int n = 0; n < DEFAULT_TABLE_SIZE; n++) {
      result += table.get(n).size();
    }

    return result;
  }

  @Override
  public boolean isEmpty() {

    return size() == 0;
  }

  @Override
  public boolean containsKey(final Object key) {
    // doen follow basic approach of remove below (though this will be much simpler)

    final int index = calculateIndex(key);
    final Iterator<Entry<K, V>> iter = table.get(index).iterator();
    while (iter.hasNext()) {
      final Entry<K, V> entry = iter.next();
      if (entry.getKey().equals(key)) {
        return true;
      }
    }
    return false;
  }

  @Override
  public boolean containsValue(final Object value) {
    // done follow basic approach of remove below (though this will be much simpler)

    final int index = calculateIndex(value);
    final Iterator<Entry<K, V>> iter = table.get(index).iterator();
    while (iter.hasNext()) {
      final Entry<K, V> entry = iter.next();
      if (entry.getValue().equals(value)) {
        return true;
      }
    }
    return false;
  }

  @Override
  public V get(final Object key) {
    // TODOdone follow basic approach of remove below (though this will be simpler)

    final int index = calculateIndex(key);
    final Iterator<Entry<K, V>> iter = table.get(index).iterator();
    while (iter.hasNext()) {
      final Entry<K, V> entry = iter.next();
      if (entry.getKey().equals(key)) {
        final V value = entry.getValue();
        return value;
      }
    }
    return null;
  }

  @Override
  public V put(final K key, final V value) {
    // TODodonefollow basic approach of remove below (this will be similar)

    final int index = calculateIndex(key);
    final Iterator<Entry<K, V>> iter = table.get(index).iterator();
    while (iter.hasNext()) {
      final Entry<K, V> entry = iter.next();
      if (entry.getKey().equals(key)) {
        entry.setValue(value);
        final V oldValue = entry.getValue();
        return oldValue;
      }
    }
    table.get(index).add(0, new AbstractMap.SimpleEntry<K, V>(key, value));
    return null;
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
    // doneadd each entry in m's entrySet
    for (Map.Entry<? extends K, ? extends V> entry : m.entrySet()) {
      this.put(entry.getKey(), entry.getValue());
    }
  }

  @Override
  public void clear() {
    // done clear each chain

    for (int i = 0; i < table.size(); i++) {
      table.get(i).clear();
    }
  }

  /** The resulting keySet is not "backed" by the Map, so we keep it unmodifiable. */
  @Override
  public Set<K> keySet() {
    final Set<K> result = new HashSet<>();
    // doneTODO populate the set

    for (int i = 0; i < DEFAULT_TABLE_SIZE; i++) {
      final Iterator<Entry<K, V>> iter = table.get(i).iterator();
      while (iter.hasNext()) {
        Entry<K, V> kee = iter.next();
        result.add(kee.getKey());
      }
    }

    return Collections.unmodifiableSet(result);
  }

  /** The resulting values collection is not "backed" by the Map, so we keep it unmodifiable. */
  @Override
  public Collection<V> values() {
    final List<V> result = new LinkedList<>();
    // dne populate the list

    for (int i = 0; i < table.size(); i++) {
      final Iterator<Entry<K, V>> iter = table.get(i).iterator();
      while (iter.hasNext()) {
        final Entry<K, V> vee = iter.next();
        result.add(vee.getValue());
      }
    }

    return Collections.unmodifiableCollection(result);
  }

  /** The resulting entrySet is not "backed" by the Map, so we keep it unmodifiable. */
  @Override
  public Set<Entry<K, V>> entrySet() {
    final Set<Entry<K, V>> result = new HashSet<>();
    // done/todo populate the set

    for (int n = 0; n < DEFAULT_TABLE_SIZE; n++) {
      final Iterator<Entry<K, V>> iter = table.get(n).iterator();
      while (iter.hasNext()) {
        final Entry<K, V> vee = iter.next();
        result.add(vee);
      }
    }
    return Collections.unmodifiableSet(result);
  }

  @Override
  public String toString() {

    String result = "";
    for (List<Entry<K, V>> list : table) {
      for (Entry<K, V> entry : list) {
        result += entry.toString();
      }
    }

    return result;
  }

  public boolean equals(final Object that) {
    if (this == that) {
      return true;
    } else if (!(that instanceof Map)) {
      return false;
    } else {

      return (((Map) that).entrySet()).equals(this.entrySet());
    }
  }

  private int calculateIndex(final Object key) {
    return Math.floorMod(key.hashCode(), table.size());
  }
}
