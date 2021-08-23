package com.workspace.eviction;

/**
 * Description: Custom Banner for Startup.
 *
 * @author: Ashwin Padmakumar
 * @since: 2021-08-23
 * @version: 0.1
 */
public interface EvictionPolicy<Key> {

  void keyAccessed(Key key);

  Key evictKey();
}
