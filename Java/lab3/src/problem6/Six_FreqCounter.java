package problem6;

import java.util.*;

import problem2.Two_BinarySearchTree;

/*******************************************************************
 * 
 * Class FreqCounter reads words and hash values depending on user input
 * and prints how many unique words and hash values are generated. 
 * The minlen tells the minimum words size of the words that is counted.
 * 
 * Example execution for the 1000 first words in the text:
 * ------------------------------------
 * The word 'the' occurs at indices:
 * 18
 * 63
 * 89
 * 101
 * 132
 * ...
 * ...
 * ...
 * ...
 * ------------------------------------
 * 
 * In this case it means that no hash values are generated more than once.
 * 
 * @author Benjamin Roth
 *
 *******************************************************************/

public class Six_FreqCounter {
	private Six_FreqCounter() { }
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int counter = 0;
		int minlen = 1; 	//word is not shorter than the given length minlen
		
		System.out.println("The word you are looking for: ");
		String lookupWord = scanner.next();
		
		LinkedList<String> linkedlist = new LinkedList<String>();
		Two_BinarySearchTree<String, Integer> st = new Two_BinarySearchTree<String, Integer>();
		 
		//Build symbol table/tree and count the frequencies of the words.
		while (scanner.hasNext() && counter < 1000) {
			String word = scanner.next().toLowerCase();
			int position = 0;
			
			if (word.length() < minlen)
				continue;
			
			if(st.contains(word)) {
				st.put(word, st.get(word) + 1);
				linkedlist.add(position, word);
			} 
			else {
				st.put(word, 1);
				linkedlist.add(position, word);
			}
			counter++;
			position++;
		}
		
		//Prints the whole linked list
		System.out.println();
		System.out.println("Linked List: " + linkedlist);
		
		System.out.println("The word '" + lookupWord + "' occurs at indices:");
		
		//loops the whole linked list and prints the lookup word indices.
		for(int i = 0; i < linkedlist.size(); i++) {
			if(linkedlist.get(i).equals(lookupWord)){
				System.out.println(i);
			}
		}
    }
}

