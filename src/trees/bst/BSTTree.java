package trees.bst;

import trees.Tree;
import trees.TreeException;

public class BSTTree<K extends Comparable<K>, V> implements Tree<K, V> {

  @Override
  public void insert(K key, V value) {

  }

  @Override
  public void delete(K key) {

  }

  @Override
  public V retrieve(K key) throws TreeException {
    return null;
  }

  @Override
  public boolean contains(K key) {
    return false;
  }
}