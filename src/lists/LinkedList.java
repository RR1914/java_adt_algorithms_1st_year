package lists;

public interface LinkedList<K> {

  void add(int n, K elem) throws LinkedListException;

  void add(K elem) throws LinkedListException;

  void delete(int n);

  void delete(K elem);

  K retrieve(int n);

  int retrieve(K elem);

  boolean isEmpty();

  int size();

}
