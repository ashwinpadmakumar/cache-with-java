/**
 * Description: Custom Banner for Startup.
 *
 * @author: Ashwin Padmakumar
 * @since: 2021-08-23
 * @version: 0.1
 */

package com.workspace.algorithm;

import com.workspace.exceptions.ApplicationException;

public class DoublyLinkedList<E> {

  DoublyLinkedListNode<E> dummyHead;
  DoublyLinkedListNode<E> dummyTail;

  public DoublyLinkedList() {
    dummyHead = new DoublyLinkedListNode<>(null);
    dummyTail = new DoublyLinkedListNode<>(null);
    dummyHead.next = dummyTail;
    dummyTail.prev = dummyHead;
  }

  public void addFirst(DoublyLinkedListNode<E> node) {
    DoublyLinkedListNode<E> dummyHeadNext = dummyHead.next;
    dummyHeadNext.prev = node;
    node.prev = dummyHead;
    dummyHead.next = node;
    node.next = dummyHeadNext;
  }

  public DoublyLinkedListNode<E> addFirst(E element) {
    if (element == null) {
      throw new ApplicationException("Invalid element exception");
    }
    DoublyLinkedListNode<E> node = new DoublyLinkedListNode<>(element);
    addFirst(node);
    return node;
  }

  public void addLast(DoublyLinkedListNode<E> node) {
    DoublyLinkedListNode<E> dummyTailPrev = dummyTail.prev;
    dummyTailPrev.next = node;
    node.next = dummyTail;
    dummyTail.prev = node;
    node.prev = dummyTailPrev;
  }

  public DoublyLinkedListNode<E> addLast(E element) {
    if (element == null) {
      throw new ApplicationException("Invalid element exception");
    }
    DoublyLinkedListNode<E> node = new DoublyLinkedListNode<>(element);
    addLast(node);
    return node;
  }

  public void detach(DoublyLinkedListNode<E> node) {
    if (node != null) {
      node.prev.next = node.next;
      node.next.prev = node.prev;
    }
  }

  public boolean isEmpty() {
    return dummyHead.next == dummyTail;
  }

  public DoublyLinkedListNode<E> getFirst() {
    if (!isEmpty()) {
      return dummyHead.next;
    } else {
      return null;
    }
  }

  public DoublyLinkedListNode<E> getLast() {
    if (!isEmpty()) {
      return dummyTail.prev;
    } else {
      return null;
    }
  }


}
