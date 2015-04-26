package lists;

public interface LinkedList<K> {

  void add(K elem) throws LinkedListException;

  void delete(K elem) throws LinkedListException;

  int retrieve(K elem);

  boolean isEmpty();

  int size();

}
