// Red black trees
// This is a binary search tree, whose nodes have the colour *Red* or *Black*
//
// - Every node is either red or black
// - The root node is black
// - If a node is red, it's children are all black
// - Every path from a given node to any of it's descendants contains
//   the same number of black nodes.

// Height h <= 2 log (n+1) where n is number of elements

package trees.rbt;

import trees.Tree;
import trees.TreeException;

public class RBTTree<K extends Comparable<K>, V> implements Tree<K, V> {

  private RBTTreeNode<K, V> root;

  @Override
  public void insert(K key, V value) {
    root = insertElem(root, key, value);
  }

  private RBTTreeNode<K, V> insertElem(RBTTreeNode<K, V> root, K key, V value) {
    return null;
  }

  @Override
  public void delete(K key) {
    root = deleteElem(root, key);
  }

  private RBTTreeNode<K, V> deleteElem(RBTTreeNode<K, V> root, K key) {
    return null;
  }

  @Override
  public V retrieve(K key) throws TreeException {
    RBTTreeNode<K, V> node = root;
    while (node != null) {
      K nodekey = node.getKey();
      if (key.compareTo(nodekey) == 0) {
        return node.getValue();
      } else if (key.compareTo(nodekey) > 1) {
        node = node.getRight();
      } else {
        node = node.getLeft();
      }
    }
    throw new TreeException();
  }

  @Override
  public boolean contains(K key) {
    RBTTreeNode<K, V> node = root;
    while (node != null) {
      K nodekey = node.getKey();
      if (key.compareTo(nodekey) == 0) {
        return true;
      } else if (key.compareTo(nodekey) > 1) {
        node = node.getRight();
      } else {
        node = node.getLeft();
      }
    }
    return false;
  }
}