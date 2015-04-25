package trees;

public abstract class AbstractTreeNode<K, V> implements TreeNode<K, V> {

  protected TreeNode<K, V> left;
  protected TreeNode<K, V> right;
  protected final K key;
  protected V value;

  public AbstractTreeNode(K key, V value) {
    this.left = null;
    this.right = null;
    this.key = key;
    this.value = value;
  }

  public abstract TreeNode<K, V> getLeft();

  public abstract TreeNode<K, V> getRight();

  public V getValue() {
    return value;
  }

  public void setValue(V value) {
    this.value = value;
  }

  public K getKey() {
    return key;
  }

}
