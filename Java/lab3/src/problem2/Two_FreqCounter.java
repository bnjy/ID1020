package problem2;

import java.util.*;
import java.util.concurrent.*;

/*******************************************************************
 * 
 * Class FreqCounter reads N words from user input and prints
 * the most frequently occurring word in the input. The minlen
 * tells the minimum words size of the words that is counted.
 * 
 * Example execution for 1000 words with BinarySearchST:
 * ------------------------------------
 * Size of the Search ST/Tree: 468
 * Time: 0.00373318 seconds.
 * Word: 'the', Frequency: 78
 * ------------------------------------
 * 
 * Example execution for 1000 words with BinarySearchTree:
 * ------------------------------------
 * Size of the Search ST/Tree: 468
 * Time: 0.006659789 seconds.
 * Word: 'the', Frequency: 78
 * ------------------------------------
 * 
 * @author Benjamin Roth
 *
 *******************************************************************/

public class Two_FreqCounter {
	private Two_FreqCounter() { }
	
	public static void main(String[] args) {
		 
		int counter = 0;
		int minlen = 1; 	//word is not shorter than the given length minlen
		Scanner scanner = new Scanner(System.in);
		 
	    //BinarySearchST<String, Integer> st = new BinarySearchST<String, Integer>(1000);
		Two_BinarySearchTree<String, Integer> st = new Two_BinarySearchTree<String, Integer>();
		 
		//Build symbol table/tree and count the frequencies of the words.
		while (scanner.hasNext()) {
			String word = scanner.next().toLowerCase();
			if (word.length() < minlen)
				continue;
			 
			if(st.contains(word)) {
				st.put(word, st.get(word) + 1);
			} 
			else {
				st.put(word, 1);
			}
			counter++;
		}

		//get key with highest frequency
		String max = "";
		st.put(max, 0);
		
		//start clock to be able to compare running times.
		long startTime = System.nanoTime();
		for(String word : st.keys()) {
			if(st.get(word) > st.get(max))
				max = word;
		}
		//stop clock and set double to represent the time in seconds.
		long endTime = System.nanoTime();
		long elapsedTime = endTime - startTime;
		double seconds = (double) elapsedTime / 1000000000.0;
		 
		System.out.println();
		System.out.println("Size of the Search ST/Tree: " + st.size());
		System.out.println("Time: " + seconds + " seconds.");
		System.out.println("Word: '" + max + "', Frequency: " + st.get(max));
     }
}
