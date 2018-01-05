package com.data.list;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Generic iterable linked list
 * @author Ejesalva
 *
 * @param <T>
 */
public class LinkedList<T> implements Iterable<T> {

	private Node first;
	private Node last;
	private int size;
	
	public LinkedList() {
		this.first = null;
		this.last = null;
		this.size = 0;
	}
	
	/**
	 * Adds the item to the end of the linked list.
	 * <p>This method runs in O(1) time due to a reference of the last node being held
	 *  
	 * @param item object/data/item to be added
	 * @return true if the append is successful
	 * @throws NullPointException if the item given is null
	 */
	public boolean add(T item) {
		if(item == null) { throw new NullPointerException(ERROR_EMPTY_ITEM_ADD); }
		
		// New linkedlist
		if(first == null) {
			first = new Node(item, null);
			last = first;
		} else {
			Node prev = last;
			last = new Node(item, null);
			prev.next = last;
		}
		size++;
		
		return true;
	}

	/**
	 * Removes item from the linked list.
	 * 
	 * <p>This method runs in O(n) time.
	 * 
	 * @param item object/data/item to be deleted from list
	 * @return true if remove is successful
	 * @throws NullPointerException if list is empty
	 * @throws NullPointerException if item to remove is empty
	 */
	public boolean remove(T item) {
		if(isEmpty()) { throw new NullPointerException(ERROR_EMPTY_LIST); }
		if(item == null) { throw new NullPointerException(ERROR_EMPTY_ITEM); }
		
		boolean isRemoved = false;
		Node prev = first;
		Node current = first;
		
		while(!isRemoved && current != null) {
			if(current.data.equals(item)) {
				// Only element
				if(size() == 1) { first = null; last = null; }
				// First element
				else if(current.equals(first)) { first = first.next; }
				// Last element
				else if(current.equals(last)) { last = prev; last.next = null; }
				else { prev.next = current.next; }
				size--;
				isRemoved = true;
			} else {
				prev = current;
				current = prev.next;	
			}
		}
		
		return isRemoved;
	}
	
	/**
	 * Returns the size of the linked list
	 * @return integer size of list
	 */
	public int size() {
		return this.size;
	}
	
	/**
	 * Checks if linked list is empty
	 * @return true if list is empty
	 */
	public boolean isEmpty() {
		return size == 0;
	}
	
	@Override
	public Iterator<T> iterator() {
		return new LinkedListIterator();
	}
	
	private class LinkedListIterator implements Iterator<T> {

		private Node current = first;
		
		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public T next() {
			if(!hasNext()) { throw new NoSuchElementException(); }
			T item = current.data;
			current = current.next;
			
			return item;
		}
		
	}

	private class Node {
		private T data;
		private Node next;
		
		public Node(T data, Node next) {
			this.data = data;
			this.next = next;
		}
	}
	
	
	
	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("[");
		for(T item : this) {
			stringBuilder.append(item + " ");
		}
		stringBuilder.append("]");
		
		return stringBuilder.toString();
	}

	private static final String ERROR_EMPTY_LIST = "Can not remove item from empty";
	private static final String ERROR_EMPTY_ITEM = "Item must be given to delete";
	
	private static final String ERROR_EMPTY_ITEM_ADD = "Item must have value";

}
