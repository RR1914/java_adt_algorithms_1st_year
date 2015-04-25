package heaps;

public class MaxHeap<T extends Comparable<T>> extends AbstractHeap<T> {
  @Override
  public void insert(T elem) throws HeapException {
    heap.set(lastIndex, elem);
    int index = lastIndex;
    while (heap.get(ROOT) != elem) {
      int parent = (int) Math.ceil(index / 2) - 1;
      if (heap.get(parent).compareTo(heap.get(index)) < 1) {
        swap(parent, index);
        index = parent;
      } else {
        return;
      }
    }
  }

  private void swap(int index_1, int index_2) {
    T temp = heap.get(index_1);
    heap.set(index_1, heap.get(index_2));
    heap.set(index_2, temp);
  }

  @Override
  public T getNext() {
    if (!isEmpty()) {
      T out = heap.get(0);
      removeNext();
      return out;
    }
    return null;
  }

  @Override
  public void removeNext() {
    // Heap is likely semi-heap after next call
    if (!isEmpty()) heap.set(ROOT, heap.get(lastIndex - 1));
    lastIndex--;

    // If condition -> semi-heap
    if (heap.get(ROOT).compareTo(heap.get(ROOT + 1)) < 1
      || heap.get(ROOT).compareTo(heap.get(ROOT + 2)) < 1) {
      heapRebuild(ROOT);
    }
  }

  @Override
  public void heapRebuild(int pos) {
    // Position has at least a left child
    int child = (2 * pos) + 1;
    if (heap.get(child) != null) {
      if (heap.get(child + 1) != null && heap.get(child).compareTo
        (heap.get(child + 1)) <= 1) child++;
      if (heap.get(pos).compareTo(heap.get(child)) < 1) {
        swap(pos, child);
        heapRebuild(child);
      }
    }
  }
}
