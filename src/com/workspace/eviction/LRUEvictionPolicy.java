/**
 * Description: Custom Banner for Startup.
 *
 * @author: Ashwin Padmakumar
 * @since: 2021-08-23
 * @version: 0.1
 */

package com.workspace.eviction;

import java.util.HashMap;
import java.util.Map;

import com.workspace.algorithm.DoublyLinkedList;
import com.workspace.algorithm.DoublyLinkedListNode;
import com.workspace.exceptions.ApplicationException;

public class LRUEvictionPolicy<K> implements EvictionPolicy<K> {

  private final DoublyLinkedList<K> doublyLinkedList;
  private final Map<K, DoublyLinkedListNode<K>> mapper;

  public LRUEvictionPolicy() {
    this.doublyLinkedList = new DoublyLinkedList<>();
    this.mapper = new HashMap<>();
  }


  @Override
  public void keyAccessed(K key) {
    if (mapper.containsKey(key)) {
      doublyLinkedList.detach(mapper.get(key));
      doublyLinkedList.addLast(mapper.get(key));
    } else {
      DoublyLinkedListNode<K> node = doublyLinkedList.addLast(key);
      mapper.put(key, node);
    }
  }

  @Override
  public K evictKey() {
    if (doublyLinkedList.isEmpty()) {
      throw new ApplicationException("Cache is empty");
    } else {
      DoublyLinkedListNode<K> first = doublyLinkedList.getFirst();
      doublyLinkedList.detach(first);
      return first.getElement();
    }
  }
}
