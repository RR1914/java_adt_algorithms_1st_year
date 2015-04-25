package trees;

public interface TreeNode<K, V> {

  V getValue();

  void setValue(V value);

  K getKey();

}
