package problem3;

import java.util.*;
import edu.princeton.cs.algs4.*;

/*******************************************************************
 * 
 * Class FreqCounter takes an given interval from user, reads words from user input
 * and prints the most frequently occurring word in the interval. The minlen
 * tells the minimum words size of the words that is counted.
 * 
 * Example execution of interval 2-6:
 * ------------------------------------
 * of
 * chapter
 * a
 * to
 * and
 * ------------------------------------
 * 
 * @author Benjamin Roth
 *
 *******************************************************************/

public class Three_FreqCounter {
	private Three_FreqCounter() { }
	
	public static void main(String[] args) {
		
		int counter = 0;
		int uniqueWords = 0;
		int minlen = 1; 	//word is not shorter than the given length minlen
		Scanner scanner = new Scanner(System.in);
	    Three_BinarySearchTree<String, Integer> st = new Three_BinarySearchTree<String, Integer>();

	    //takes the interval from user
	    System.out.println("Set the interval of the most frequent words between a and b");
		System.out.println("n:th word:");
		int a = scanner.nextInt();
		System.out.println("m:th word:");
		int b = scanner.nextInt();
	    
		 //Build symbol tree and count the frequencies of the words.
		while (scanner.hasNext() && counter < 1000) {
			String word = scanner.next().toLowerCase();
			if (word.length() < minlen)
				continue;
			
			if(st.contains(word)) {
				st.put(word, st.get(word) + 1);
			} 
			else {
				st.put(word, 1);
				uniqueWords++;
			}
			counter++;
		}
		
		//creates a string array with all the words
	    String[] intervalArray = new String[uniqueWords];
	    int k = 0;
		for(String word : st.keys()) {
			intervalArray[k] = word;
			k++;
		 }
		
		//sorts the array, using quicksort in ascending order.
		Three_Quick.sort(intervalArray, st);
		
		//prints out the given interval
		a = (intervalArray.length) - a;
		b = (intervalArray.length) - b;
		System.out.println();
		while(a >= b) {
			System.out.println(intervalArray[a]);
			a--;
		}
	}
}