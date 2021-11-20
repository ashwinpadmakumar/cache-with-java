/**
 * Description: Custom Banner for Startup.
 *
 * @author: Ashwin Padmakumar
 * @since: 2021-08-23
 * @version: 0.1
 */

package com.workspace.eviction;

public interface EvictionPolicy<K> {

  void keyAccessed(K key);

  K evictKey();
}
