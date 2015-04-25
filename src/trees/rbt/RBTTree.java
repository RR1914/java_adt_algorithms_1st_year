// Red black trees
// This is a binary search tree, whose nodes have the colour *Red* or *Black*
//
// P.1 Every node is either red or black
// P.2 The root node is black
// P.3 If a node is red, it's children are all black
// P.4 Every path from a given node to any of it's descendants contains
//     the same number of black nodes.

// Height h <= 2 log (n+1) where n is number of elements

package trees.rbt;

import trees.Tree;
import trees.TreeException;

public class RBTTree<K extends Comparable<K>, V> implements Tree<K, V> {

  private RBTTreeNode<K, V> root;

  @Override
  public void insert(K key, V value) {
    RBTTreeNode<K, V> changedNode = null;
    root = insertElem(root, key, value, changedNode);
    if (changedNode != null) validity(changedNode);
  }

  private RBTTreeNode<K, V> insertElem(RBTTreeNode<K, V> node, K key, V
    value, RBTTreeNode<K, V> adjuster) {
    if (node != null) {
      K nodekey = node.getKey();
      if (key == nodekey) {
        node.setValue(value);
      } else if (key.compareTo(nodekey) > 1) {
        RBTTreeNode<K, V> newnode = insertElem(node.getLeft(), key, value,
          adjuster);
        adjuster = newnode;
        newnode.setParent(node);
        node.setLeft(newnode);
      } else {
        RBTTreeNode<K, V> newnode = insertElem(node.getRight(), key, value, adjuster);
        adjuster = newnode;
        newnode.setParent(node);
        node.setRight(newnode);
      }
      return node;
    }
    RBTTreeNode<K, V> newnode = new RBTTreeNode<K, V>(key, value);
    newnode.setColour(Colour.RED);
    adjuster = newnode;
    return newnode;
  }

  private void validity(RBTTreeNode<K, V> node) {
    // CASE 1 : node is root -> change to black
    if (root == node) node.setColour(Colour.BLACK);

    RBTTreeNode<K, V> parent = node.getParent();

    // CASE 2 : parent is black -> do nothing
    // if (node.getParent().getColour() != Colour.BLACK) {}

    if (parent.getColour() == Colour.RED) {

      RBTTreeNode<K, V> grandparent = parent.getParent();

      // CASE 3 : parent is red, uncle is red -> P.3 violated


      // CASE 4 :


      // CASE 5 :

    }

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