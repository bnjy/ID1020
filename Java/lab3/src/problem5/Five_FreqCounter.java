package problem5;

import java.util.*;

/*******************************************************************
 * 
 * Class FreqCounter reads words and hash values depending on user input
 * and prints how many unique words and hash values are generated. 
 * The minlen tells the minimum words size of the words that is counted.
 * 
 * Example execution for the whole text:
 * ------------------------------------
 * Number of unique hashes: 9944
 * Number of unique words: 9944
 * ------------------------------------
 * 
 * In this case it means that no collisions occur.
 * 
 * @author Benjamin Roth
 *
 *******************************************************************/

public class Five_FreqCounter {
	private Five_FreqCounter() { }
	
	public static void main(String[] args) {
		
		int minlen = 1; 	//word is not shorter than the given length minlen
		Scanner scanner = new Scanner(System.in);
		int uniqueHashes = 0;
		int uniqueWords = 0;
		
	    Five_BinarySearchTree<String, Integer> st = new Five_BinarySearchTree<String, Integer>();
	    Five_BinarySearchTree<Integer, Integer> stHash = new Five_BinarySearchTree<Integer, Integer>();
	    
		//Build symbol table and count frequencies of words and hash values.
		while (scanner.hasNext()) {
			String wordKey = scanner.next().toLowerCase();
			int hashKey = wordKey.hashCode();
			
			if (wordKey.length() < minlen)
				continue;
			
			if (st.contains(wordKey)) {
				st.put(wordKey, st.get(wordKey) + 1);				 
			} 
			else {
				st.put(wordKey, 1);
				uniqueWords++;			//counts every unique word
			}
			
			if (stHash.contains(hashKey)) {
				stHash.put(hashKey, stHash.get(hashKey) + 1);
			}
			else {
				stHash.put(hashKey, 1);
				uniqueHashes++;		//counts every unique hash value
			}
		}
		
		System.out.println();
		System.out.println("Number of unique hashes: " + uniqueHashes);
		System.out.println("Number of unique words: " + uniqueWords);
		}
}
