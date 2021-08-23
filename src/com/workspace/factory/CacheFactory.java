package com.workspace.factory;

import com.workspace.Cache;
import com.workspace.eviction.LRUEvictionPolicy;
import com.workspace.storage.HashMapStorage;

import java.security.Key;

/**
 * Description: Custom Banner for Startup.
 *
 * @author: Ashwin Padmakumar
 * @since: 2021-08-23
 * @version: 0.1
 */
public class CacheFactory<Key, Value> {

  public Cache<Key, Value> getDefaultCache() {
    return new Cache<>(new LRUEvictionPolicy<>(), new HashMapStorage<>(3));
  }
}
