// Rotates the left tree right, bringing the left child of the 
// current node to the root of this tree section
public TreeNode<K, V> rotateRight(TreeNode<K, V> node) {
	TreeNode<K, V> left = node.getLeft();
	node.setLeft(left.getRight());
	left.setRight(node);
	return left;
}

// Rotates the right tree left, bringing the right child of the 
// current node to the root of this tree section
public TreeNode<K, V> rotateLeft(TreeNode<K, V> node) {
	TreeNode<K, V> right = node.getRight();
	node.setRight(right.getLeft());
	right.setLeft(node);
	return right;
}

// Rotates the left tree left before rotating the root right
public TreeNode<K, V> rotateLeftRight(TreeNode<K, V> node) {
	TreeNode<K, V> newLeft = rotateLeft(node.getLeft());
	node.setLeft(newLeft);
	return rotateRight(node)
}

// Rotates the right tree right before rotating the root left
public TreeNode<K, V> rotateRightLeft(TreeNode<K, V> node) {
	TreeNode<K, V> newRight = rotateRight(node.getRight());
	node.setRight(newRight);
	return rotateLeft(node)
}

// Rebalances the node from the top
public TreeNode<K, V> rebalance(TreeNode<K, V> node) {
	heightdiff = getHeightDifference(node);
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
	return node
}

// Gets the height difference between the two children of a node
// Returning 0 if they are the same or the node is null
// Returning >= 1 if the left is greater than the right
// Returning <= -1 if the right is greater than the left
private int getHeightDifference(TreeNode<K, V> node) {
	return node != null ?
		getHeight(node.getLeft()) - getHeight(node.getRight())
		: 0;
}

// If the node is null, returns 0
// Otherwise returns the height of each child + 1
private int getHeight(TreeNode<K, V> node) {
	return node != null ? 
		1 + getHeight(node.getLeft()) + getHeight(node.getRight())
		: 0;
}

// Inserts an element with a key and value.
// Overwrites existing nodes with the same key. 
// Rebalances node at each point insertElem is called. 
public TreeNode<K, V> insertElem(TreeNode<K, V> node, K key, V value) {
  if (node != null) {
    K nodekey = node.getKey();
    if (key == nodekey) {
      node.setValue(value);
    } else if (key < nodekey) {
      TreeNode<K, V> newLeft = insertElem(node.getLeft(), key, value);
      node.setLeft(rebalance(newLeft));
    } else {
      TreeNode<K, V> newRight = insertElem(node.getRight(), key, value);
      node.setRight(rebalance(newRight));
    }
    return node;
  }
  return new TreeNode<K, V>(K key, V Value);
}

// Deletes an element with the specified key.
// Rebalances node at each point deleteElem is called.
public TreeNode<K, V> deleteElem(TreeNode<K, V> node, K key) {
  if (node != null) {
    K nodekey = node.getKey();
    if (key == nodekey) {
      return deleteNode(node);
    } else if (key > nodeKey) {
      TreeNode<K, V> newLeft = deleteElem(node.getLeft(), key);
      node.setLeft(newLeft);
      return rebalance(node);
    } else {
      TreeNode<K, V> newRight = deleteElem(node.getRight(), key);
      node.setRight(newRight);
      return rebalance(node);
    }
  }
  throw new TreeException();
}

// Deletes a the node at the root of the tree given
// Returns the resulting tree
private TreeNode<K, V> deleteNode(TreeNode<K, V> node) {
  if (node.getLeft() == null && node.getRight() == null) {
    return null;
  }
  if (node.getRight() == null) {
    return node.getLeft();
  } else if (node.getLeft() == null) {
    return node.getRight();
  } else {
    TreeNode<K, V> replacementNode = findLeftMost(node.getRight());
    TreeNode<K, V> newRight = deleteLeftMost(node.getRight());
    replacementNode.setLeft(node.getLeft());
    replacementNode.setRight(newRight);
    return rebalance(replacementNode);
  }
}

private TreeNode<K, V> findLeftMost(TreeNode<K, V> node) {
  if (node == null) throw new TreeException();
  while (node.getLeft() != null) {
    node = node.getLeft();
  }
  return node;
}
