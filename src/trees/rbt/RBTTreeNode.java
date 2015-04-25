package trees.rbt;

import trees.AbstractTreeNode;

public class RBTTreeNode<K, V> extends AbstractTreeNode<K, V> {

  private RBTTreeNode<K, V> left;
  private RBTTreeNode<K, V> right;
  private RBTTreeNode<K, V> parent;
  private Colour colour;


  public RBTTreeNode(K key, V value) {
    super(key, value);
  }

  public RBTTreeNode<K, V> getLeft() {
    return left;
  }

  public void setLeft(RBTTreeNode<K, V> node) {
    if (left != null && left.getParent() == this) {
      left.setParent(null);
    }
    this.left = node;
    if (node != null) {
      node.setParent(this);
    }
  }

  public RBTTreeNode<K, V> getRight() {
    return right;
  }

  public void setRight(RBTTreeNode<K, V> node) {
    if (right != null && right.getParent() == this) {
      right.setParent(null);
    }
    this.right = node;
    if (node != null) {
      node.setParent(this);
    }
  }

  public RBTTreeNode<K, V> getParent() {
    return parent;
  }

  public void setParent(RBTTreeNode<K, V> parent) {
    this.parent = parent;
  }

  public RBTTreeNode<K, V> rotateRight(RBTTreeNode<K, V> node) {
    RBTTreeNode<K, V> left = node.getLeft();
    node.setLeft(left.getRight());
    left.setRight(node);
    return left;
  }

  public RBTTreeNode<K, V> rotateLeft(RBTTreeNode<K, V> node) {
    RBTTreeNode<K, V> right = node.getRight();
    node.setRight(right.getLeft());
    right.setLeft(node);
    return right;
  }

  public void setColour(Colour colour) {
    this.colour = colour;
  }

  public Colour getColour() {
    return colour;
  }
}
