package trees.avl;

import trees.AbstractTreeNode;

public class AVLTreeNode<K, V> extends AbstractTreeNode<K, V> {

  protected AVLTreeNode<K, V> left;
  protected AVLTreeNode<K, V> right;

  public AVLTreeNode(K key, V value) {
    super(key, value);
  }

  public AVLTreeNode<K, V> getLeft() {
    return null;
  }

  public AVLTreeNode<K, V> getRight() {
    return null;
  }

  public void setLeft(AVLTreeNode<K, V> node) {
    this.left = node;
  }

  public void setRight(AVLTreeNode<K, V> node) {
    this.right = node;
  }
}
