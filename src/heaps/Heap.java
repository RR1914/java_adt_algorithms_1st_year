package heaps;

// Minheap : smallest element at ROOT
// Maxheap : largest element at ROOT

public interface Heap<T extends Comparable<T>> {

  void insert(T elem) throws HeapException;

  T getNext();

  void removeNext();

  boolean isEmpty();

  void heapRebuild(int pos);

}