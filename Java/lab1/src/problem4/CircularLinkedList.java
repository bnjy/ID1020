/***********************************************************
 * ID1020 Lab 1 - Problem 4
 * 
 * This is the lab task 'Problem 4' of Lab 1 in course ID1020 at KTH.
 * 
 * A circular linked list, with a head and a tail. Each list element is generic of type Item.
 * 
 * Test class in main adds three integers to the list, from both ends. Then it deletes
 * one element from both ends, and prints the list again.
 * 
 ***********************************************************/

package problem4;

import java.util.*;

/**
 * Code for a circular linked list. The cicular linked list is of generic type
 * and can handle Items. There are method to add/delete elements in both ends of the list.
 * 
 * @author Benjamin Roth
 *
 * @param <Item>
 */
public class CircularLinkedList<Item> implements Iterable<Item> {
	private Node head;			//first element of the list
	private Node tail;			//last element of the list
	private int size;
	
	/**
	 * A Node class.
	 */
    private class Node {
        private Node next;
        private Node previous;
        private Item item;
    }
    
	/**
	 *Class constructor.
	 */
    public CircularLinkedList() {
    	head = new Node();
    	tail = new Node();
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
	 * Method that places the new node at the beginning of the circular linked list. If the linked list is filled the first time,
	 * we just add the Item to the head node and create a circular linked list between the two nodes head and tail.   
	 * 
	 * When a item is added to the list the size increases by one. 
	 *  
	 * @param item the item that we want to place in a node.
	 */
    public void addAtStart(Item item) {  	
    	if(head.item == null) {
    		head.item = item;
	    		if(isEmpty()) {
	    		head.next = tail;
	    		tail.next = head;
	    		}    		
    	} else {
    		Node oldHead;
    		oldHead = head;
    		head = new Node();
    		head.item = item;
    		head.next = oldHead;
    		tail.next = head;
    	}
    	size++;
    }
    
    /**
     * Method that deletes the first element in the circular linked list.
     * 
     * When a item is deleted from the list the size decreases by one. 
     * 
     * @return the deleted nodes element.
     */
    public Item deleteAtStart() {    	
    	Item returnItem = head.item;
    	head = head.next;
    	tail.next = head;
    	size--;
    	return returnItem;
    }
	
    /**
	 * Method that places the new node at the end of the circular linked list. If the linked list is filled
	 * the first time, {@code isEmpty()} we just add the Item to the first node and create a circular linked 
	 * list between the two nodes head and tail.   
	 * 
	 *  When a item is added to the list the size increases by one. 
	 *  
	 * @param item the item that we want to place in a node.
	 */
    public void addAtEnd(Item item) {
    	if(tail.item == null) {
    		tail.item = item;
	    if(isEmpty()) {
	    	tail.next = head;
	    	head.next = tail;
	    }    		
    	} else {
    		Node oldTail;
    		oldTail = tail;
    		tail = new Node();
    		tail.item = item;
    		tail.next = head;
    		oldTail.next = tail;
    	}
    	size++;
    }
    
    /**
     * Method that deletes the last element in the circular linked list.
     * 
     * When a item is deleted from the list the size decreases by one. 
     * 
     * @return the deleted nodes element.
     */
    public Item deleteAtEnd() {
    	Item returnItem = tail.item;    	
    	tail = tail.previous;
    	head.previous = tail;
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
	 * A iterator of the list that iterates through the list.
	 */
    public Iterator<Item> iterator() {
		return new ListIterator(); 
		}
	
	private class ListIterator implements Iterator<Item> {
		private Node current = head;
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
	 * Main class that test the linked list implementation of a Integer linked list.
	 */
	public static void main(String[] args) {
		CircularLinkedList<Integer> cl = new CircularLinkedList<Integer>();
			
		cl.addAtStart(1);
		System.out.println(cl.toString());
		cl.addAtStart(2);
		System.out.println(cl.toString());
		cl.addAtStart(3);
		System.out.println(cl.toString());
		
		cl.addAtEnd(1);
		System.out.println(cl.toString());
		cl.addAtEnd(2);
		System.out.println(cl.toString());
		cl.addAtEnd(3);
		System.out.println(cl.toString());
	
		System.out.println("Delete at start:");
		cl.deleteAtStart();
		System.out.println(cl.toString());
		
		System.out.println("Delete at end:");
		cl.deleteAtEnd();
		System.out.println(cl.toString());
		
		System.out.println("The size of the stack: " + cl.size);
	}
}
