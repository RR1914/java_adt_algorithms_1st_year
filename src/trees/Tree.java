package trees;

public interface Tree<K extends Comparable<K>, V> {

  void insert(K key, V value);

  void delete(K key);

  V retrieve(K key) throws TreeException;

  boolean contains(K key);

}
