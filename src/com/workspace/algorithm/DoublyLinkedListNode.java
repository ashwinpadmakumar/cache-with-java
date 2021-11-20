/**
 * Description: Custom Banner for Startup.
 *
 * @author: Ashwin Padmakumar
 * @since: 2021-08-23
 * @version: 0.1
 */

package com.workspace.algorithm;

public class DoublyLinkedListNode<E> {

  DoublyLinkedListNode<E> prev;
  DoublyLinkedListNode<E> next;
  E element;

  public DoublyLinkedListNode(E element) {
    this.element = element;
    this.prev = null;
    this.next = null;
  }

  public E getElement() {
    return element;
  }
}
