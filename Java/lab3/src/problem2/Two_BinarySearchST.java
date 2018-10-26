package problem2;

public class Two_BinarySearchST<Key extends Comparable<Key>, Value> {
   private Key[] keys;
   private Value[] vals;
   private int n;
   
   /**
    * Initialize an empty symbol table.
    * @param capacity the given capacity of the table.
    */
   public Two_BinarySearchST(int capacity){
	   keys = (Key[]) new Comparable[capacity];
	   vals = (Value[]) new Object[capacity];
   }
   
	/**
	 * Returns the number of key-value pairs in the table.
	 * @return the number of key-value pairs in the table.
	 */
   public int size() {
	   return n;
   }
   
	/**
	 * Checks if the table is empty, depending on if the table size.
	 * @return boolean value true/false.
	 */
   public boolean isEmpty() {
       return size() == 0;
   }
   
	/**
	 * Inserts the given pair key-value to the table. If the key is already
	 * in the table the value is overwritten by the new value. 
	 * 
	 * @param key the key that is inserted
	 * @param val the value that is inserted
	 */
   public void put(Key key, Value val) {
	   int i = rank(key);
	   
	   //key is already in table
	   if(i < n && keys[i].compareTo(key) == 0) {
		   vals[i] = val;
		   return;
	   }
	   
	   //insert new key-value pair
	   for(int j = n; j > i; j--) {
		   keys[j] = keys[j-1];
		   vals[j] = vals[j-1];
	   }
	   keys[i] = key;
	   vals[i] = val;
	   n++;
   }
   
   /**
    * Returns the value of the given key.
    * @param key the key we are looking for the associated value for.
    * @return the key value.
    */
   public Value get(Key key) {
	   if(isEmpty())
		   return null;
	   int i = rank(key);
	   if (i < n && keys[i].compareTo(key) == 0)
		   return vals[i];
	   else
		   return null;
   }
   
   
   /**
    * Uses binary search to find the rank of a given key. 
    * @param key, the key we want to know the rank of.
    * @return the rank of they key.
    */
   public int rank (Key key) {
	   int lo = 0;
	   int hi = n-1;
	   
	   while(lo <= hi) {
		   int mid = lo + (hi - lo) / 2;
		   int compare = key.compareTo(keys[mid]);
		   if (compare < 0 )
			   hi = mid - 1;
		   else if (compare > 0)
			   lo = mid + 1;
		   else 
			   return mid;
	   }
	   return lo;
   }
   
   /**
    * Removes the key-value pair from the table, depending on the given key.
    * @param key the key we want to delete.
    */
   public void delete(Key key) {
	   if(isEmpty())
		   return;
	   int i = rank(key);
	   
	   if(i == n || keys[i].compareTo(key) != 0) {
		   return;
	   }
	   for(int j = i; j < n-1; j++) {
		   keys[j] = keys[j+1];
		   vals[j] = vals[j+1];
	   }
	   n--;
	   keys[n] = null;
	   vals[n] = null;
   }
   
	/**
	 * Checks if the given key is in the table.
	 * @param key the key
	 * @return  true/false depending if the given key is in the
	 * 			tree or not.
	 */
   public boolean contains(Key key) {
   return get(key) != null;
   }
   
   /**
    * Returns the smallest key in the table. 
    * @return the smallest key in the table.
    */
   public Key min() {
       return keys[0]; 
   }

   /**
    * Returns the largest key in the table. 
    * @return the largest key in the table.
    */
   public Key max() {
       return keys[n-1];
   }
   
   /**
    * Iterates all of the keys in the table.
    * Returns all the keys in the table.
    * @return all keys in the table.
    */
   public Iterable<Key> keys() {
       return keys(min(), max());
   }

   public Iterable<Key> keys(Key lo, Key hi) {
       Two_Queue<Key> queue = new Two_Queue<Key>();
       for (int i = rank(lo); i < rank(hi); i++) 
           queue.enqueue(keys[i]);
       if (contains(hi))
    	   queue.enqueue(keys[rank(hi)]);
       return queue;
   }
}
