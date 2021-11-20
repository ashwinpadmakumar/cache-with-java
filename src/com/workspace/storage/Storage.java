/**
 * Description: Custom Banner for Startup.
 *
 * @author: Ashwin Padmakumar
 * @since: 2021-08-23
 * @version: 0.1
 */

package com.workspace.storage;

import com.workspace.exceptions.NotFoundException;
import com.workspace.exceptions.StorageFullException;


public interface Storage<K, V> {
  void add(K key, V value) throws StorageFullException;

  void remove(K key) throws NotFoundException;

  V get(K key) throws NotFoundException;
}
