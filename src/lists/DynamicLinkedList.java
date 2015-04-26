package lists;

public class DynamicLinkedList<K> extends AbstractLinkedList<K> {

  private LinkedListNode<K> head;
  private LinkedListNode<K> last;

  public DynamicLinkedList() {
    super();
    head = null;
    last = null;
  }

  @Override
  public void add(K elem) throws LinkedListException {
    if (retrieve(elem) != 1) {
      if (head != null) {
        last.setNext(new LinkedListNode<>(elem));
        last = last.getNext();
        numelems++;
      } else {
        head = new LinkedListNode<K>(elem);
        last = head;
      }
      numelems++;
    } else {
      throw new LinkedListException("Element already exists!");
    }
  }

  @Override
  public void delete(K elem) throws LinkedListException {
    LinkedListNode<K> current = head;
    LinkedListNode<K> prev = null;
    while (current != null) {
      if (current.getElem().equals(elem)) {
        if (prev == null) {
          head = head.getNext();
        } else {
          prev.setNext(current.getNext());
        }
        numelems--;
      }
      prev = current;
      current = current.getNext();
    }
    throw new LinkedListException("Element doesn't exist!");
  }

  @Override
  public int retrieve(K elem) {
    LinkedListNode<K> current = head;
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
