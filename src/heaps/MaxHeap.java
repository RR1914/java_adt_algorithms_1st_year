package heaps;

public class MaxHeap<T extends Comparable<T>> extends AbstractHeap<T> {
  @Override
  public void insert(T elem) throws HeapException {

  }

  @Override
  public void delete(T elem) {

  }

  @Override
  public T getNext() {
    return isEmpty() ? null: heap[0];
  }

  @Override
  public void removeNext() {
    if (!isEmpty()) heap[ROOT_VALUE] = heap[lastIndex - 1];
  }

  @Override
  public void heapRebuild() {

  }
}
