package problem4;

public class Four_RedBlackBinarySearchTree<Key extends Comparable<Key>, Value> {
	
	private Node root;
	private static final boolean RED = true;
	private static final boolean BLACK = false;
	
	/**
	 * Helper class, node data type.
	 */
	private class Node{
		Key key;
		Value val;
		Node left;
		Node right;
		int n;
		boolean color;
		
		Node(Key key, Value val, int n, boolean color){
			this.key = key;
			this.val = val;
			this.n = n;
			this.color = color;
		}
	}
		
		/**
		 * checks if node x is red -> true.
		 * if node is null -> false.
		 */
		private boolean isRed(Node x) {
			if (x == null)
				return false;
			return x.color = RED;		
		}
		
		/**
		 * Makes a right-leaning tree lean to the left 
		 */
		private Node rotateLeft(Node current) {
			Node x = current.right;
			current.right = x.left;
			x.left = current;
			x.color = current.color;
			current.color = RED;
			x.n = current.n;
			current.n = 1 + size(current.right) + size(current.left);
			return x;
		}
		
		/**
		 * Makes a left-leaning tree lean to the right
		 */
		private Node rotateRight(Node current) {
			Node x = current.left;
			current.left = x.right;
			x.right = current;
			x.color = current.color;
			current.color = RED;
			x.n = current.n;
			current.n = 1 + size(current.left) + size(current.right);
			return x;
		}
		
		/**
		 * Flips the colors of a node and the nodes children
		 */
		private void flipColors(Node current) {
			current.color = RED;
			current.left.color = BLACK;
			current.right.color = BLACK;
		}
		
		/**
		 * Returns the number of keys in the tree.
		 * @return the number of keys in the tree.
		 */
		public int size() {
			return size(root);
		} 
		
		private int size(Node x) {
			if(x == null)
				return 0;
			else 
				return x.n;
		}
		
		/**
		 * Checks if the tree is empty.
		 */
	    public boolean isEmpty() {
	        return root == null;
	    }
		
	    /**
	     * Inserts a given key-value pair to the tree.
	     * @param key the key
	     * @param val the value
	     */
		public void put(Key key, Value val) {
			root = put(root, key, val);
			root.color = BLACK;
		}
		
		// insert the key-value pair in the subtree rooted at current
		private Node put(Node current, Key key, Value val) {
			if(current == null)
				return new Node (key, val, 1, RED);
			int cmp = key.compareTo(current.key);
			if(cmp < 0 )
				current.left = put(current.left, key, val);
			else if(cmp > 0)
				current.right = put(current.right, key, val);
			else
				current.val = val;
			
			if(isRed(current.right) && !isRed(current.left))
				current = rotateLeft(current);
			
			if (isRed(current.left) && isRed(current.left.left)) 
				current = rotateRight(current);
			
	        if (isRed(current.left) && isRed(current.right))
	        	flipColors(current);

	        current.n = size(current.left) + size(current.right) + 1;
	        return current;
		}
		
		
		/**
		 * Returns the value associated to the key.
		 * @param key the key.
		 * @return the value associated to the key.
		 */
	    public Value get(Key key) {
	        return get(root, key);
	    }

	    private Value get(Node x, Key key) {
	        while (x != null) {
	            int cmp = key.compareTo(x.key);
	            if      (cmp < 0) x = x.left;
	            else if (cmp > 0) x = x.right;
	            else              return x.val;
	        }
	        return null;
	    }
		
	    /**
	     * Does the tree contain the given key?
	     * @param the key.
	     * @return true if the key is in the tree, false otherwise.
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
	     * Returns the largest key in the symbol table.
	     * @return the largest key in the symbol table.
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
	     * Returns all keys in the tree.
	     * @return all keys in the tree.
	     */
	    public Iterable<Key> keys() {
	        return keys(min(), max());
	    }
	    
	    public Iterable<Key> keys(Key lo, Key hi) {
	        Four_Queue<Key> queue = new Four_Queue<Key>();
	        keys(root, queue, lo, hi);
	        return queue;
	    } 

	    private void keys(Node x, Four_Queue<Key> queue, Key lo, Key hi) {
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
