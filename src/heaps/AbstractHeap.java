package heaps;

public abstract class AbstractHeap<T extends Comparable<T>> implements Heap<T> {

  protected static final double EPSILON = 0;
  protected static final int ROOT = 0;
  private static final int DEFAULT_CAPACITY = 10000;

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
