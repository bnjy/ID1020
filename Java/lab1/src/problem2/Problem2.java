/***********************************************************
 * ID1020 Lab 1 - Problem 2
 * 
 * This is the lab task 'Problem 2' of Lab 1 in course ID1020 at KTH.
 * 
 * A stack with LIFO logic is used, see StackLifo.java. Each stack element is generic of type Item.
 * 
 * Test class main takes char inputs from user and prints each element in reverse order. 
 * 
 ***********************************************************/

package problem2;

import java.util.*;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Problem2 {
	public static void main(String[] args) {
		StackLifo stack = new StackLifo();
		
		recursive(stack);
		iterative(stack);
	}
	
	/**
	 * A recursive method that read chars an pushes them to the stack.
	 * Then pops the stack in recursive order. 
	 * @param stack The stack to push and pop chars to.
	 */
 	public static void recursive(StackLifo stack) {
 		char c = StdIn.readChar();
 		stack.push(c);
 		
		if(c == '\n') {
			System.out.println(stack.toString());
			for(int i = stack.size(); i > 0; --i) {
			stack.pop();
			System.out.println(stack.toString());
			}
		} else {
			recursive(stack);
		}
	}
 	
 	/**
 	 * A iterative method that takes input from user, then push it to a stack and 
	 * pops the stack.
	 * @param stack The stack to push and pop chars to.
 	 */
	public static void iterative(StackLifo stack) {
		char c = StdIn.readChar();
		int counter = 0;
		
		while(c != '\n') {
			stack.push(c);
			counter++;
			c = StdIn.readChar();
		}
		
		System.out.println(stack.toString());
		
		while (counter > 0) {
			stack.pop();
			System.out.println(stack.toString());
			counter--;
		}
	}
}

