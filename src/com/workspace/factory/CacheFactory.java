/**
 * Description: Custom Banner for Startup.
 *
 * @author: Ashwin Padmakumar
 * @since: 2021-08-23
 * @version: 0.1
 */

package com.workspace.factory;

import com.workspace.Cache;
import com.workspace.eviction.LRUEvictionPolicy;
import com.workspace.storage.HashMapStorage;


public class CacheFactory<K, V> {

  public Cache<K, V> getDefaultCache() {
    return new Cache<>(new LRUEvictionPolicy<>(), new HashMapStorage<>(3));
  }
}
