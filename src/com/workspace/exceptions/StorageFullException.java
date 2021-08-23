package com.workspace.exceptions;

/**
 * Description: Custom Banner for Startup.
 *
 * @author: Ashwin Padmakumar
 * @since: 2021-08-23
 * @version: 0.1
 */
public class StorageFullException extends RuntimeException {

  public StorageFullException(String message) {
    super(message);
  }
}
