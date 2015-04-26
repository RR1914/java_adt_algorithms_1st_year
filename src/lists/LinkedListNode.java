package lists;

public class LinkedListNode<K> {

  private K elem;
  private LinkedListNode<K> next;

  public LinkedListNode(K elem) {
    this.elem = elem;
    this.next = null;
  }

  public LinkedListNode(K elem, LinkedListNode<K> next) {
    this.elem = elem;
    this.next = next;
  }

  public LinkedListNode<K> getNext() {
    return next;
  }

  public void setNext(LinkedListNode<K> next) {
    this.next = next;
  }

  public K getElem() {
    return elem;
  }

  public void setElem(K elem) {
    this.elem = elem;
  }
}
