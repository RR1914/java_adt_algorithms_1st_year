package heaps;

import java.util.ArrayList;

public abstract class AbstractHeap<T extends Comparable<T>> implements Heap<T> {

  protected static final int ROOT = 0;
  private static final int DEFAULT_CAPACITY = 10000;

  protected ArrayList<T> heap;
  protected int lastIndex;

  public AbstractHeap() {
    heap = new ArrayList<T>(DEFAULT_CAPACITY);
    lastIndex = 0;
  }

  public boolean isEmpty() {
    return lastIndex == 0;
  }

}
