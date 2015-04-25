package heaps;

// Minheap : smallest element at ROOT_VALUE
// Maxheap : largest element at ROOT_VALUE

public interface Heap<T extends Comparable<T>> {

  void insert(T elem) throws HeapException;

  void delete(T elem);

  T getNext();

  void removeNext();

  boolean isEmpty();

  void heapRebuild();

}