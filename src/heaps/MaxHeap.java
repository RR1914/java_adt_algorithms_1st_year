package heaps;

import java.util.ArrayList;

public class MaxHeap<T extends Comparable<T>> extends AbstractHeap<T> {

  public MaxHeap() {
    super();
  }

  @Override
  public void insert(T elem) throws HeapException {
    heap[lastIndex] = elem;
    int index = lastIndex;
    lastIndex++;
    while (heap[ROOT] != elem) {
      double pos = index + EPSILON;
      int parent = (int) Math.floor(pos / 2);
      if (heap[parent].compareTo(heap[index]) < 1) {
        swap(parent, index);
        index = parent;
      } else {
        return;
      }
    }
  }

  private void swap(int index_1, int index_2) {
    T temp = heap[index_1];
    heap[index_1] = heap[index_2];
    heap[index_2] = temp;
  }

  @Override
  public T getNext() {
    if (!isEmpty()) {
      T out = heap[0];
      removeNext();
      return out;
    }
    return null;
  }

  @Override
  public void removeNext() {
    // Heap is likely semi-heap after next call
    if (!isEmpty()) heap[ROOT] = heap[lastIndex - 1];
    lastIndex--;

    // If condition -> semi-heap
    if (heap[ROOT].compareTo(heap[ROOT + 1]) < 1
      || heap[ROOT].compareTo(heap[ROOT + 2]) < 1) {
      heapRebuild(ROOT);
    }
  }

  @Override
  public void heapRebuild(int pos) {
    // Position has at least a left child
    int child = (2 * pos) + 1;
    if (heap[child] != null) {
      if (heap[child + 1] != null && heap[child].compareTo
        (heap[child + 1]) <= 1) child++;
      if (heap[pos].compareTo(heap[child]) < 1) {
        swap(pos, child);
        heapRebuild(child);
      }
    }
  }

  public T[] toArray() {
    T[] array = (T[]) new Integer[lastIndex];
    System.arraycopy(heap, 0, array, 0, lastIndex);
    return array;
  }
}
