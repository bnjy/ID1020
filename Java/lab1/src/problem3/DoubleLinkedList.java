/***********************************************************
 * ID1020 Lab 1 - Problem 3
 * 
 * This is the lab task 'Problem 3' of Lab 1 in course ID1020 at KTH.
 * 
 * A double linked list with FIFO logic. Each list element is generic of type Item.
 * 
 * Test class in main adds three chars to the list, then pops the first element that was added.
 * 
 ***********************************************************/

package problem3;

import java.util.*;

/**
 * Code for a double linked list with FIFO (first-in-first-out) logic. The linked list is of generic type
 * and can handle Items. {@code enqueue} are used to add elements to the queue, {@code dequeue} are used
 * to dequeue the first element of the list.
 * 
 * @author Benjamin Roth
 *
 * @param <Item> a generic type for implementing the linked list.
 */

public class DoubleLinkedList<Item> implements Iterable<Item> {
	private Node start;				//empty node in start
    private Node end;				//empty node in end
	private int size;				//holds the number of elements in the list.
    
	/**
	 * Node class.
	 */
    private class Node {
        private Node next;
        private Node previous;
        private Item item;
    }
	
	/**
	 *Class constructor. Two nodes that points to each other and creates a double linked list.
	 */
	public DoubleLinkedList(){
		start = new Node();		//Creates new node (a)
		end = new Node();		//Creates new node (b)
		start.next = end;		//Node (a) points at node (b)
		end.previous = start;	//Node (b) points at node (b)
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
	 * @return number of the stack size. (The number of elements in the linked list)
	 */
    public int size() {
    	return size;
    }
    
    /**
     * A node {@code insert} is added just before the last node in the list. Then a new node {@code newNode} are added
     * and stores the @param item in it. As newNode should point to the null object {@code end} with make it point to
     * this node, in both directions.
     * 
     * When a new item is added to the list the size increases by one.
     * 
     * @param item the item that is added to the linked list.
     */
    public void enqueue(Item item) {
    	Node insert = end.previous;
    	Node newNode = new Node();
    	newNode.item = item;
    	newNode.next = end;
    	newNode.previous = insert;
    	end.previous = newNode;
    	insert.next = newNode;
    	size++;
    }
    
    /**
     * With FIFO-queue logic the first element that was added to the list is also the one
     * poped when dequeuing. We store the dequeued nodes element in a new {@code Item} and returns 
     * this value.
     * 
     * When a item is dequeued from the list the size decreases by one. 
     * 
     * @return the dequeued nodes element.
     */
    public Item dequeue() {
    	Item returnItem = start.next.item;
    	start = start.next;
    	size--;
    	return returnItem;
    }
    
	/**
	 * A method that iterates through the linked list and represents the items
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
	 * A iterator that iterates through the list.
	 */
    public Iterator<Item> iterator() {
		return new ListIterator(); }
	
	private class ListIterator implements Iterator<Item>
	{
		private Node current = start.next;
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
	 * Main class that test the linked list implementation of a Character linked list.
	 */
	public static void main(String[] args) {
		DoubleLinkedList<Character> dl = new DoubleLinkedList<Character>();
		
		dl.enqueue('a');
		System.out.println(dl.toString());
		dl.enqueue('b');
		System.out.println(dl.toString());
		dl.enqueue('c');
		System.out.println(dl.toString());
		
		System.out.println("Pop element:");
		dl.dequeue();
		System.out.println(dl.toString());
		System.out.println("The size of the stack: " + dl.size);
	}
}
