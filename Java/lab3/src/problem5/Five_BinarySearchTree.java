package problem5;

import java.util.*;

public class Five_BinarySearchTree<Key extends Comparable<Key>, Value> {
	private Node root;
	
	/**
	 * Helper class, node data type.
	 */
	private class Node {
	private Key key;
	private Value value;
	private Node left;
	private Node right;
	private int n;
	
		public Node(Key key, Value val, int N) {
			this.key = key;
			this.value = val;
			this.n = N;
		}
	}
	
	/**
	 * Returns the number of key-value pairs in the tree.
	 * @return the number of key-value pairs in the tree.
	 */
	public int size() {
		return size(root);
	}
	
	/**
	 * Checks if the tree is empty, depending on if the tree size.
	 * @return boolean value true/false.
	 */
    public boolean isEmpty() {
        return size() == 0;
    }
	
	private int size(Node node) {
		if(node == null)
			return 0;
		else
			return node.n;
	}
		
	/**
	 * Inserts the given pair key-value to the tree. If the key is already
	 * in the tree the value is overwritten by the new value. 
	 * 
	 * @param key the key that is inserted
	 * @param val the value that is inserted
	 */
	public void put (Key key, Value val) {
		root = put(root, key, val);
	}
	
	private Node put(Node node, Key key, Value val) {
		if (node == null)
			return 	new Node(key, val, 1);
		int cmp = key.compareTo(node.key);
		if (cmp < 0)
			node.left = put(node.left, key, val);
		else if (cmp > 0)
			node.right = put(node.right, key, val);
		else
			node.value = val;
		node.n = size(node.left) + size(node.right) + 1;
		return node;
	}
	
    /**
     * Returns the value of the given key.
     * @param key the key we are looking for the associated value for.
     * @return the key value.
     */
	public Value get(Key key) {
		return get(root, key);
	}
	private Value get(Node node, Key key) {
		if(node == null)
			return null;
		int cmp = key.compareTo(node.key);
		if(cmp < 0)
			return get(node.left, key);
		else if (cmp > 0)
			return get (node.right, key);
		else
			return node.value;
	}
	
	/**
	 * Checks if the given key is in the tree.
	 * @param key the key
	 * @return  true/false depending if the given key is in the
	 * 			tree or not.
	 */
    public boolean contains(Key key) {
        return get(key) != null;
    }
   
    /**
     * Returns the smallest key in the tree. 
     * @return the smallest key in the tree.
     */
    public Key min() {
        return min(root).key;
    } 

    private Node min(Node x) { 
        if (x.left == null)
        	return x; 
        else 
        	return min(x.left); 
    }

    /**
     * Returns the largest key in the tree. 
     * @return the largest key in the tree.
     */
    public Key max() {
        return max(root).key;
    } 

    private Node max(Node x) {
        if (x.right == null)
        	return x; 
        else
        	return max(x.right);
    }

    /**
     * Iterates all of the keys in the tree.
     * Returns all the keys in the tree.
     * @return all keys in the tree.
     */
    public Iterable<Key> keys() {
        return keys(min(), max());
    }
    
    public Iterable<Key> keys(Key lo, Key hi) {
        Five_Queue<Key> queue = new Five_Queue<Key>();
        keys(root, queue, lo, hi);
        return queue;
    } 

    private void keys(Node x, Five_Queue<Key> queue, Key lo, Key hi) { 
        if (x == null)
        	return; 
        int cmplo = lo.compareTo(x.key); 
        int cmphi = hi.compareTo(x.key); 
        if (cmplo < 0)
        	keys(x.left, queue, lo, hi); 
        if (cmplo <= 0 && cmphi >= 0)
        	queue.enqueue(x.key); 
        if (cmphi > 0)
        	keys(x.right, queue, lo, hi); 
    } 
}
