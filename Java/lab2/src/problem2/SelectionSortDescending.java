/***********************************************************
 * ID1020 Lab 2 - Problem 1
 * 
 * This is the lab task 'Problem 2' of Lab 2 in course ID1020 at KTH.
 * 
 * Algorithm Selection sort, that sorts an integer array in ascending order
 * from user input, and then prints it in descending order.
 * 
 * Example execution:
 * 
 * array = {6,9,17,0,4}
 * 
 * 0, 9, 17, 6, 4, 
 * 0, 4, 17, 6, 9, 
 * 0, 4, 6, 17, 9, 
 * 0, 4, 6, 9, 17, 
 * 0, 4, 6, 9, 17, 
 *	
 * Prints array in descending order: 
 * 17, 9, 6, 4, 0, 
 * 
 ****************************************************/

package problem2;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class SelectionSortDescending {
	
	public static void main(String[] args) {
				
		StdOut.print("Enter array elements: ");
		int[] array = new int[setArraySize()];
		setArrayValues(array);
		
		sort(array);
		StdOut.println();
		StdOut.println("Prints array in descending order: ");
		showDescending(array);
		
	}
	
	/**
	 * A method that sorts the elements of a integer array. The elements in the array are
	 * compared to the next (n+1) element in the array. If the (n+1) element in the array
	 * is less then the n:th element, this is the new minimum value. At the end of the method the
	 * minimum value are swaped with the index value.
	 * @param array the array to be sorted
	 */
	public static void sort(int[] array) {
		int arrLength = array.length;
		for(int i = 0; i < arrLength; i++) {
			int min = i;
				for(int j = i+1; j < arrLength; j++) {
					if(less(array[j], array[min])) 
						min = j;
					}
				switchElements(array, i, min);
				showAscending(array);
		}
	}
	
	/**
	 * Compares two elements and returns value -1, 0 or 1.
	 */
	private static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}
	
	/**
	 * Helper method for the {@code sort} method. The switchElements method switches the element
	 * in a array at index i with the current minimum number.
	 * @param array the array to be sorted
	 * @param i index to be replaced
	 * @param min the current minimum number
	 */
	private static void switchElements(int[] array, int i, int min) {
		int t = array[i];		//save element s[i] to int
		array[i] = array[min];	//overwrite element s[i] with value in s[j]
		array[min] = t;			//place element s[i] to s[j]
	}
	
	/**
	 * Loops thru the array from index 0 to index N and prints every element
	 * in ascending order.
	 **/
	private static void showAscending(int[] a) {
		for(int i = 0; i < a.length; i++)
			StdOut.print(a[i] + ", ");
			StdOut.println();
	}
	
	/**
	 * Loops thru the array from the last element in the array to the first,
	 * and prints every element in descending order.
	 **/
	private static void showDescending(int[] array) {
		for(int i = (array.length - 1); i >= 0; i--) {
			StdOut.print(array[i] + ", ");
		}
	}
	
	/**
	 * User input of the array size.
	 **/
	private static int setArraySize() {
		int size = StdIn.readInt();
		return size;
	}
	
	/**
	 * Lets the user set the array with integers.
	 **/
	private static void setArrayValues(int[] array) {
		for(int i = 0; i < array.length; i++) {
			array[i] = StdIn.readInt();
		}
	}
}
