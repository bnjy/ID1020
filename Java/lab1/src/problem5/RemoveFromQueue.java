/***********************************************************
 * ID1020 Lab 1 - Problem 5
 * 
 * This is the lab task 'Problem 5' of Lab 1 in course ID1020 at KTH.
 * 
 * A queue with a method to choose which element in the list you want to delete.
 * Each list element is generic of type Item.
 * 
 * Test class in main adds 4 chars to the list, prints it, and prints the size.
 * Then node 3 is deleted from then list, and the list is then again printed.
 * 
 ***********************************************************/

package problem5;

import java.util.*;

public class RemoveFromQueue<Item> implements Iterable<Item> {
	private Node first;
	private Node last;
	private int size;
	
	/**
	 * A Node class.
	 */
    private class Node {
        private Node next;
        private Item item;
    }
    
	/**
	 *Class constructor.
	 */
    public RemoveFromQueue() {
    	first = new Node();
    	last = new Node();
    	size = 0;
    }
    
	/**
	 * Method that checks if the linked list is empty. Returns true if empty.
	 * @return true if empty stack. false if not.
	 */
    public boolean isEmpty() {
    	return size == 0;
    }
    
	/**
	 * returns an int with the number of the linked list size.
	 * @return number of the stack size. (The number of elements in the list)
	 */
    public int size() {
    	return size;
    }
    
    /**
     * A method that queues nodes.
     * 
     * When a new item is added to the list the size increases by one.
     * 
     * @param item the item that is added to the linked list.
     */
    public void enqueue(Item item) {
    	Node oldlast;
    	oldlast = last;
    	last = new Node();
    	last.item = item;
    	last.next = null;
    	if(isEmpty()) {
    		first = last;
    	} else {
    		oldlast.next = last;
    	}
    	size++;
    }
    
    /**
     * A method that delete the k:th node in the list.
     * When a node is deleted the size decreases by one.
     * @param position tells which element should be deleted, at the given position.
     * @return returns the item of the deleted node.
     */
    public Item deleteNode(int position) {
    	Node newNode = first;
    	int counter = 1;
    	while (counter < (position-1)) {
    		newNode = newNode.next;
    		counter++;
    	}
    	Item returnItem = newNode.item;			//fel
    	Node current = newNode.next;
    	//Item returnItem = current.item;
    	newNode.next = current.next;
    	size--;
    	return returnItem;
    }
    
	/**
	 * A method that iterates through the list and represents the items
	 * between brackets and separated by comma.
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(Item item : this) {
			sb.append("[" + item + "],");
		}
		return sb.toString();
	}	
	
	/**
	 * A iterator of the stack that iterates through the list.
	 */
    public Iterator<Item> iterator() {
		return new ListIterator(); 
		}
	
	private class ListIterator implements Iterator<Item> {
		private Node current = first;
		private int index = 0;
		
		public boolean hasNext() {
		return index < size;
		}
		
		public Item next() {
			Item item = current.item;
			current = current.next;
			index++;
			return item;
		}
	}
	
	/**
	 * Main class that test the linked list implementation of a Character list.
	 */
	public static void main(String[] args) {
		RemoveFromQueue<Character> dl = new RemoveFromQueue<Character>();
		
		dl.enqueue('a');
		dl.enqueue('b');
		dl.enqueue('c');
		dl.enqueue('d');
		
		System.out.println(dl.toString());
		System.out.println("The size of the stack: " + dl.size);
		
		System.out.println("Delete element 3");
		dl.deleteNode(1);
		System.out.println(dl.toString());
		System.out.println("The size of the stack: " + dl.size);
	}
}
