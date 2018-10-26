/***********************************************************
 * ID1020 Lab 2 - Problem 1
 * 
 * This is the lab task 'Problem 4' of Lab 2 in course ID1020 at KTH.
 * 
 * Algorithm Selection sort, that count the number of inversions, then
 * sorts an integer array in ascending order.
 * 
 * Example execution:
 * 
 * array = {6,9,17,0,4}
 * 
 * [i,6], [j,0]
 * [i,6], [j,4]
 * [i,9], [j,0]
 * [i,9], [j,4]
 * [i,17], [j,0]
 * [i,17], [j,4]
 * The number of inversions: 6
 *
 * Prints array in ascending order: 
 * 0 4 6 9 17 
 * 
 ****************************************************/

package problem4;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class NumberOfInversions {
	
	public static void main(String[] args) {
		
		StdOut.print("Enter array elements: ");
		int[] array = new int[setArraySize()];
		setArrayValues(array);
		
		CountInversions(array);
		
		sort(array);
	
		StdOut.println();
		StdOut.println("Prints array in ascending order: ");
		showAscending(array);
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
			StdOut.print(a[i] + " ");
	}
	
	/**
	 * Loops thru the array from the last element in the array to the first,
	 * and prints every element in descending order.
	 **/
	private static void showDescending(int[] array) {
		for(int i = (array.length - 1); i >= 0; i--) {
			StdOut.print(array[i] + " ");
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
	
	/**
	 * Loops thru the array and counts the inversions.
	 * @param array the array to be counted.
	 */
	private static void CountInversions(int[] array) {
		int inversions = 0;
		for(int i = 0; i < array.length; i++) {
			for(int j = i+1; j < array.length; j++) 
				if(less(array[j], array[i])) {
					StdOut.println("[i," + array[i] + "], " + "[j," + array[j] + "]");
					inversions++;
				}
			
		}
		StdOut.println("The number of inversions: " + inversions);
	}
}
