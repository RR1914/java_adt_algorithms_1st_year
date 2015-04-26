package heaps;

/*
    HeapSort is an algorithm for sorting arrays using the heap we have
    implemented below. Rather than checking the heap on every entry as we
    have below it follows a different methodology.

    1. Have an array of length n with an unknown ordering, but an agreed method
    2. Set a parameter to array.length, call it index.
      3. Decrement index (index--)
      4. heap[0] = heap[index] && heap[index] = heap[0] --SWAP
      5. heapRebuild(heap, 0, index)
    6. Repeat 3 -> 5 whilst index > 0
    7. heap[0] is smallest, heap[heap.length - 1] is largest.
 */

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
      int parent = (int) Math.floor((index) / 2);
      if (heap[parent].compareTo(heap[index]) < 1) {
        swap(parent, index);
        index = parent;
      } else {
        return;
      }
    }
  }

  public void heapSort() {

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
    if (child < lastIndex) {
      if (child + 1 < lastIndex && heap[child].compareTo
        (heap[child + 1]) <= 1) child++;
      if (heap[pos].compareTo(heap[child]) < 1) {
        swap(pos, child);
        heapRebuild(child);
      }
    }
  }

  public T[] toArray() {
    T[] array = (T[]) new Integer[lastIndex];
    // POOR! Integer only for testsuite purposes!
    System.arraycopy(heap, 0, array, 0, lastIndex);
    return array;
  }
}
