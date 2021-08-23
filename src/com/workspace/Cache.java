package com.workspace;

import com.workspace.eviction.EvictionPolicy;
import com.workspace.exceptions.NotFoundException;
import com.workspace.exceptions.StorageFullException;
import com.workspace.storage.Storage;

/**
 * Description: Custom Banner for Startup.
 *
 * @author: Ashwin Padmakumar
 * @since: 2021-08-23
 * @version: 0.1
 */
public class Cache<Key, Value> {

  private final EvictionPolicy<Key> evictionPolicy;
  private final Storage<Key, Value> storage;

  public Cache(EvictionPolicy<Key> evictionPolicy, Storage<Key, Value> storage) {
    this.evictionPolicy = evictionPolicy;
    this.storage = storage;
  }

  public void put(Key key, Value value) {
    try {
      this.storage.add(key, value);
      this.evictionPolicy.keyAccessed(key);
    } catch (StorageFullException exception) {
      System.out.println("Got storage full. Will evict some data");
      Key keyToRemove = evictionPolicy.evictKey();
      if (keyToRemove == null) {
        throw new RuntimeException("Unexpected state");
      }
      this.storage.remove(keyToRemove);
      put(key, value);
      System.out.println("Created space by evicting key " + keyToRemove + " and added key " + key);
    }
  }

  public Value get(Key key) {
    try {
      Value value =  this.storage.get(key);
      this.evictionPolicy.keyAccessed(key);
      return value;
    } catch (NotFoundException exception) {
      System.out.println("Trying to access a non-existing key");
      return null;
    }
  }
}
