/**
 * Description: Custom Banner for Startup.
 *
 * @author: Ashwin Padmakumar
 * @since: 2021-08-23
 * @version: 0.1
 */

package com.workspace.storage;

import java.util.HashMap;
import java.util.Map;

import com.workspace.exceptions.NotFoundException;
import com.workspace.exceptions.StorageFullException;

public class HashMapStorage<K, V> implements Storage<K, V> {

  private final Map<K, V> storage;
  private final int capacity;

  public HashMapStorage(Integer capacity) {
    this.capacity = capacity;
    storage = new HashMap<>();
  }

  @Override
  public void add(K key, V value) {
    if (storage.size() == capacity) {
      throw new StorageFullException("Cache full");
    } else {
      storage.put(key, value);
    }
  }

  @Override
  public void remove(K key) {
    if (!storage.containsKey(key)) {
      throw new NotFoundException("K does not exist");
    } else {
      storage.remove(key);
    }
  }

  @Override
  public V get(K key) {
    if (!storage.containsKey(key)) {
      throw new NotFoundException("K does not exist");
    } else {
      return storage.get(key);
    }
  }
}
