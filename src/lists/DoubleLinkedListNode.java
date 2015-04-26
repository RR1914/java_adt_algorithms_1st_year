package lists;

public class DoubleLinkedListNode<K> {

  private K elem;
  private DoubleLinkedListNode<K> prev;
  private DoubleLinkedListNode<K> next;

  public DoubleLinkedListNode(K elem) {
    this.elem = elem;
    this.next = null;
  }

  public DoubleLinkedListNode(K elem, DoubleLinkedListNode<K> next) {
    this.elem = elem;
    this.next = next;
  }

  public DoubleLinkedListNode(K elem, DoubleLinkedListNode<K> next,
                              DoubleLinkedListNode<K> prev) {
    this.elem = elem;
    this.next = next;
    this.prev = prev;
  }

  public DoubleLinkedListNode<K> getPrev() {
    return prev;
  }

  public void setPrev(DoubleLinkedListNode<K> prev) {
    this.prev = prev;
  }

  public DoubleLinkedListNode<K> getNext() {
    return next;
  }

  public void setNext(DoubleLinkedListNode<K> next) {
    this.next = next;
  }

  public K getElem() {
    return elem;
  }
}
