/**
 * Description: Custom Banner for Startup.
 *
 * @author: Ashwin Padmakumar
 * @since: 2021-08-23
 * @version: 0.1
 */

package com.workspace;

import java.util.logging.Logger;

import com.workspace.eviction.EvictionPolicy;
import com.workspace.exceptions.ApplicationException;
import com.workspace.exceptions.NotFoundException;
import com.workspace.exceptions.StorageFullException;
import com.workspace.storage.Storage;

public class Cache<K, V> {

  private static final Logger LOGGER = Logger.getLogger(Cache.class.getName());
  private final EvictionPolicy<K> evictionPolicy;
  private final Storage<K, V> storage;

  public Cache(EvictionPolicy<K> evictionPolicy, Storage<K, V> storage) {
    this.evictionPolicy = evictionPolicy;
    this.storage = storage;
  }

  public void put(K key, V value) {
    try {
      this.storage.add(key, value);
      this.evictionPolicy.keyAccessed(key);
    } catch (StorageFullException exception) {
      LOGGER.info("Got storage full. Will evict some data");
      K keyToRemove = evictionPolicy.evictKey();
      if (keyToRemove == null) {
        throw new ApplicationException("Unexpected state");
      }
      this.storage.remove(keyToRemove);
      put(key, value);
      LOGGER.info("Created space by evicting key " + keyToRemove + " and added key " + key);
    }
  }

  public V get(K key) {
    try {
      V value =  this.storage.get(key);
      this.evictionPolicy.keyAccessed(key);
      return value;
    } catch (NotFoundException exception) {
      LOGGER.info("Trying to access a non-existing key");
      return null;
    }
  }
}
