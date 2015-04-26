package lists;

public class ArrayBasedLinkedList<K> extends AbstractLinkedList<K> {

  private final K[] elems;

  public ArrayBasedLinkedList() {
    super();
    elems = (K[]) new Object[MAX_LIST_STATIC];
    numelems = 0;
  }

  @Override
  public void add(int n, K elem) throws LinkedListException {
    if (numelems < MAX_LIST_STATIC) {
      for (int i = numelems - 1; i >= n - 1; i--) {
        elems[i + 1] = elems[i];
      }
      elems[n - 1] = elem;
      numelems++;
    } else {
      throw new LinkedListException("No more elements may be added. List full. Try " +
        "deleting?");
    }
  }

  @Override
  public void add(K elem) throws LinkedListException {
    if (numelems < MAX_LIST_STATIC) {
      elems[numelems] = elem;
      numelems++;
    } else {
      throw new LinkedListException("No more elements may be added. List full. Try " +
        "deleting?");
    }
  }

  @Override
  public void delete(int n) {
    if (n <= numelems && elems[n-1] != null) {
      for (int i = n - 1; i < numelems; i++) {
        elems[i] = elems[i + 1];
      }
      numelems--;
    }
  }

  @Override
  public void delete(K elem) {
    int element = retrieve(elem);
    if (element != -1) {
      delete(element);
    }
  }

  @Override
  public K retrieve(int n) {
    return null;
  }

  @Override
  public int retrieve(K elem) {
    return 0;
  }

  @Override
  public boolean isEmpty() {
    return numelems == 0;
  }

  @Override
  public int size() {
    return numelems;
  }
}
