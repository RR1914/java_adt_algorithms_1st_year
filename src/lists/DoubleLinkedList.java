package lists;

public class DoubleLinkedList<K> extends AbstractLinkedList<K> {

  private DoubleLinkedListNode<K> head;
  private DoubleLinkedListNode<K> last;

  public DoubleLinkedList() {
    super();
    head = null;
    last = null;
  }

  @Override
  public void add(K elem) throws LinkedListException {
    if (retrieve(elem) != 1) {
      if (head != null) {
        last.setNext(new DoubleLinkedListNode<>(elem, null, last));
        last = last.getNext();
        numelems++;
      } else {
        head = new DoubleLinkedListNode<K>(elem);
        last = head;
      }
      numelems++;
    } else {
      throw new LinkedListException("Element already exists!");
    }
  }

  public void add(int n, K elem) throws IllegalArgumentException {
    if (0 < n && n <= numelems) {
      int count = 1;
      DoubleLinkedListNode<K> current = head;
      while (count < n) {
        current = current.getNext();
        count++;
      }
      DoubleLinkedListNode<K> prev = current.getPrev();
      if (prev != null) {
        prev.setNext(new DoubleLinkedListNode<K>(elem, current, prev));
      } else {
        head = new DoubleLinkedListNode<K>(elem, head);
      }
      numelems++;
    } else {
      throw new IllegalArgumentException("n must be < numelems, > 0");
    }
  }

  @Override
  public void delete(K elem) throws LinkedListException {
    DoubleLinkedListNode<K> current = head;
    while (current != null) {
      if (current.getElem().equals(elem)) {
        if (current == head) {
          head = head.getNext();
        } else {
          current.getPrev().setNext(current.getNext());
        }
        numelems--;
      }
      current = current.getNext();
    }
    throw new LinkedListException("Element doesn't exist!");
  }

  @Override
  public int retrieve(K elem) {
    DoubleLinkedListNode<K> current = head;
    while (current != null) {
      if (current.getElem().equals(elem)) return 1;
      current = current.getNext();
    }
    return -1;
  }

  @Override
  public boolean isEmpty() {
    return head == null;
  }

  @Override
  public int size() {
    return numelems;
  }

}
