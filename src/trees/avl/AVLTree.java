package trees.avl;

import trees.Tree;
import trees.TreeException;

public class AVLTree<K extends Comparable<K>, V> implements Tree<K, V> {

  private AVLTreeNode<K, V> root;

  // Rotates the left tree right, bringing the left child of the
  // current node to the ROOT of this tree section
  public AVLTreeNode<K, V> rotateRight(AVLTreeNode<K, V> node) {
    AVLTreeNode<K, V> left = node.getLeft();
    node.setLeft(left.getRight());
    left.setRight(node);
    return left;
  }

  // Rotates the right tree left, bringing the right child of the
  // current node to the ROOT of this tree section
  public AVLTreeNode<K, V> rotateLeft(AVLTreeNode<K, V> node) {
    AVLTreeNode<K, V> right = node.getRight();
    node.setRight(right.getLeft());
    right.setLeft(node);
    return right;
  }

  // Rotates the left tree left before rotating the ROOT right
  public AVLTreeNode<K, V> rotateLeftRight(AVLTreeNode<K, V> node) {
    AVLTreeNode<K, V> newLeft = rotateLeft(node.getLeft());
    node.setLeft(newLeft);
    return rotateRight(node);
  }

  // Rotates the right tree right before rotating the ROOT left
  public AVLTreeNode<K, V> rotateRightLeft(AVLTreeNode<K, V> node) {
    AVLTreeNode<K, V> newRight = rotateRight(node.getRight());
    node.setRight(newRight);
    return rotateLeft(node);
  }

  // Rebalances the node from the top
  public AVLTreeNode<K, V> rebalance(AVLTreeNode<K, V> node) {
    int heightdiff = getHeightDifference(node);
    if (heightdiff > 1) {
      heightdiff = getHeightDifference(node.getLeft());
      if (heightdiff > 0) {
        rotateRight(node);
      } else {
        rotateLeftRight(node);
      }
    } else if (heightdiff < -1) {
      heightdiff = getHeightDifference(node.getRight());
      if (heightdiff < 0) {
        rotateLeft(node);
      } else {
        rotateRightLeft(node);
      }
    }
    return node;
  }

  // Gets the height difference between the two children of a node
  // Returning 0 if they are the same or the node is null
  // Returning >= 1 if the left is greater than the right
  // Returning <= -1 if the right is greater than the left
  private int getHeightDifference(AVLTreeNode<K, V> node) {
    return node != null ?
      getHeight(node.getLeft()) - getHeight(node.getRight())
      : 0;
  }

  // If the node is null, returns 0
  // Otherwise returns the height of each child + 1
  private int getHeight(AVLTreeNode<K, V> node) {
    return node != null ?
      1 + max(getHeight(node.getLeft()), getHeight(node.getRight()))
      : 0;
  }

  private int max(int a, int b) {
    return (a > b) ? a : b;
  }

  // Inserts an element with a key and value.
  // Overwrites existing nodes with the same key.
  // Rebalances node at each point insertElem is called.
  public AVLTreeNode<K, V> insertElem(AVLTreeNode<K, V> node, K key, V value) {
    if (node != null) {
      K nodekey = node.getKey();
      if (key == nodekey) {
        node.setValue(value);
      } else if (key.compareTo(nodekey) > 1) {
        AVLTreeNode<K, V> newLeft = insertElem(node.getLeft(), key, value);
        node.setLeft(rebalance(newLeft));
      } else {
        AVLTreeNode<K, V> newRight = insertElem(node.getRight(), key, value);
        node.setRight(rebalance(newRight));
      }
      return node;
    }
    return new AVLTreeNode<K, V>(key, value);
  }

  // Deletes an element with the specified key.
// Rebalances node at each point deleteElem is called.
  public AVLTreeNode<K, V> deleteElem(AVLTreeNode<K, V> node, K key) throws
    TreeException {
    if (node != null) {
      K nodekey = node.getKey();
      if (key == nodekey) {
        return deleteNode(node);
      } else if (key.compareTo(nodekey) > 1) {
        AVLTreeNode<K, V> newLeft = deleteElem(node.getLeft(), key);
        node.setLeft(newLeft);
        return rebalance(node);
      } else {
        AVLTreeNode<K, V> newRight = deleteElem(node.getRight(), key);
        node.setRight(newRight);
        return rebalance(node);
      }
    }
    throw new TreeException();
  }

  // Deletes a the node at the ROOT of the tree given
// Returns the resulting tree
  private AVLTreeNode<K, V> deleteNode(AVLTreeNode<K, V> node) throws TreeException {
    if (node.getLeft() == null && node.getRight() == null) {
      return null;
    }
    if (node.getRight() == null) {
      return node.getLeft();
    } else if (node.getLeft() == null) {
      return node.getRight();
    } else {
      AVLTreeNode<K, V> replacementNode = findLeftMost(node.getRight());
      AVLTreeNode<K, V> newRight = deleteLeftMost(node.getRight());
      replacementNode.setLeft(node.getLeft());
      replacementNode.setRight(newRight);
      return rebalance(replacementNode);
    }
  }

  // Deletes the left most node in a tree
  private AVLTreeNode<K, V> deleteLeftMost(AVLTreeNode<K, V> node) throws TreeException {
    if (node == null) throw new TreeException();
    if (node.getLeft() == null) {
      return node.getRight();
    } else {
      node.setLeft(deleteLeftMost(node.getLeft()));
      return rebalance(node);
    }
  }

  // Finds the left most node in a tree
  private AVLTreeNode<K, V> findLeftMost(AVLTreeNode<K, V> node) throws TreeException {
    if (node == null) throw new TreeException();
    while (node.getLeft() != null) {
      node = node.getLeft();
    }
    return node;
  }

  @Override
  public void insert(K key, V value) {
    root = insertElem(root, key, value);
  }

  @Override
  public void delete(K key) {
    try {
      root = deleteElem(root, key);
    } catch (TreeException e) {
      System.out.println("Couldn't delete element with key: " + key);
    }
  }

  @Override
  public V retrieve(K key) throws TreeException {
    AVLTreeNode<K, V> node = root;
    while (node != null) {
      K nodekey = node.getKey();
      if (key == nodekey) {
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
    AVLTreeNode<K, V> node = root;
    while (node != null) {
      K nodekey = node.getKey();
      if (key == nodekey) {
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