package com.workspace.storage;

import com.workspace.exceptions.NotFoundException;
import com.workspace.exceptions.StorageFullException;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: Custom Banner for Startup.
 *
 * @author: Ashwin Padmakumar
 * @since: 2021-08-23
 * @version: 0.1
 */
public class HashMapStorage<Key, Value> implements Storage<Key, Value> {

  Map<Key, Value> storage;
  int capacity;

  public HashMapStorage(Integer capacity) {
    this.capacity = capacity;
    storage = new HashMap<>();
  }

  @Override
  public void add(Key key, Value value) {
    if (storage.size() == capacity) {
      throw new StorageFullException("Cache full");
    } else {
      storage.put(key, value);
    }
  }

  @Override
  public void remove(Key key) {
    if (!storage.containsKey(key)) {
      throw new NotFoundException("Key does not exist");
    } else {
      storage.remove(key);
    }
  }

  @Override
  public Value get(Key key) {
    if (!storage.containsKey(key)) {
      throw new NotFoundException("Key does not exist");
    } else {
      return storage.get(key);
    }
  }
}
