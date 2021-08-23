package com.workspace.eviction;

import com.workspace.algorithm.DoublyLinkedList;
import com.workspace.algorithm.DoublyLinkedListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: Custom Banner for Startup.
 *
 * @author: Ashwin Padmakumar
 * @since: 2021-08-23
 * @version: 0.1
 */
public class LRUEvictionPolicy<Key> implements EvictionPolicy<Key> {

  private final DoublyLinkedList<Key> doublyLinkedList;
  private final Map<Key, DoublyLinkedListNode<Key>> mapper;

  public LRUEvictionPolicy() {
    this.doublyLinkedList = new DoublyLinkedList<>();
    this.mapper = new HashMap<>();
  }


  @Override
  public void keyAccessed(Key key) {
    if (mapper.containsKey(key)) {
      doublyLinkedList.detach(mapper.get(key));
      doublyLinkedList.addLast(mapper.get(key));
    } else {
      DoublyLinkedListNode<Key> node = doublyLinkedList.addLast(key);
      mapper.put(key, node);
    }
  }

  @Override
  public Key evictKey() {
    if (doublyLinkedList.isEmpty()) {
      throw new RuntimeException("Cache is empty");
    } else {
      DoublyLinkedListNode<Key> first = doublyLinkedList.getFirst();
      doublyLinkedList.detach(first);
      return first.getElement();
    }
  }
}
