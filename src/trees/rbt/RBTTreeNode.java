package trees.rbt;

import trees.AbstractTreeNode;

public class RBTTreeNode<K, V> extends AbstractTreeNode<K, V> {

  protected RBTTreeNode<K, V> left;
  protected RBTTreeNode<K, V> right;

  public RBTTreeNode(K key, V value) {
    super(key, value);
  }

  public RBTTreeNode<K, V> getLeft() {
    return left;
  }

  public RBTTreeNode<K, V> getRight() {
    return right;
  }
}
