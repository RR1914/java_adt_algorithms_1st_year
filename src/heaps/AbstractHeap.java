package heaps;

public abstract class AbstractHeap<T extends Comparable<T>> implements Heap<T> {

  protected static final int ROOT_VALUE = 0;
  private static final int DEFAULT_CAPACITY = 50;

  protected T[] heap;
  protected int lastIndex;

  public AbstractHeap() {
    heap = (T[]) new Comparable[DEFAULT_CAPACITY];
    lastIndex = 0;
  }

  public boolean isEmpty() {
    return lastIndex == 0;
  }

}
