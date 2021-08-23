package com.workspace.storage;

import com.workspace.exceptions.NotFoundException;
import com.workspace.exceptions.StorageFullException;

/**
 * Description: Custom Banner for Startup.
 *
 * @author: Ashwin Padmakumar
 * @since: 2021-08-23
 * @version: 0.1
 */
public interface Storage<Key, Value> {
  void add(Key key, Value value) throws StorageFullException;

  void remove(Key key) throws NotFoundException;

  Value get(Key key) throws NotFoundException;
}
