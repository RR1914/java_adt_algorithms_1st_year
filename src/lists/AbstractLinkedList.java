package lists;

public abstract class AbstractLinkedList<K> implements LinkedList<K>{

  protected static final int MAX_LIST_STATIC = 100;
  protected int numelems;

  public AbstractLinkedList() {
    numelems = 0;
  }

}
