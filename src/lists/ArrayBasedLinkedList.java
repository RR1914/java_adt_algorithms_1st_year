package lists;

public class ArrayBasedLinkedList<K> extends AbstractLinkedList<K> {

  private final K[] elems;

  public ArrayBasedLinkedList() {
    super();
    elems = (K[]) new Object[MAX_LIST_STATIC];
  }

  public void add(int n, K elem) throws LinkedListException {
    if (0 < n && n <= numelems && numelems < MAX_LIST_STATIC) {
      System.arraycopy(elems, n - 1, elems, n, numelems - n);
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

  public void delete(int n) {
    if (0 < n && n <= numelems && elems[n-1] != null) {
      System.arraycopy(elems, n, elems, n - 1, numelems - n);
      numelems--;
    }
  }

  @Override
  public void delete(K elem) throws LinkedListException {
    int element = retrieve(elem);
    if (element != -1) {
      delete(element);
    } else {
      throw new LinkedListException("Element already exists!");
    }
  }

  public K retrieve(int n) {
    if (0 < n && n <= numelems) {
      return elems[n-1];
    }
    return null;
  }

  @Override
  public int retrieve(K elem) {
    int index = 0;
    while (index < numelems) {
      if (elems[index].equals(elem)) return index;
      index++;
    }
    return -1;
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
