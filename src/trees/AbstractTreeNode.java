package trees;

public abstract class AbstractTreeNode<K, V> implements TreeNode<K, V> {

  protected final K key;
  protected V value;

  public AbstractTreeNode(K key, V value) {
    this.key = key;
    this.value = value;
  }

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
