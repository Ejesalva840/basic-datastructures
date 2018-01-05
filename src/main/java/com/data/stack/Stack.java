package com.data.stack;

public interface Stack<E> {
	/**
	 * Checks if the list is empty
	 * 
	 * @return true if stack is empty
	 */
	boolean empty();
	
	/**
	 * Shows the top item on the stack
	 * 
	 * @return the last pushed item
	 */
	E peek();
	
	/**
	 * Removes the last pushed item from the stack and decreases the size by one
	 * 
	 * @return the last pushed item
	 */
	E pop();
	
	/**
	 * Puts the item on top of the stack
	 * 
	 * @param item item to be put onto stack
	 * @return item on stack
	 */
	E push(E item);
	
	/**
	 * Searches for the item in the stack and gives index if found
	 * 
	 * @param object item to be searched
	 * @return index in stack or -1 if not found
	 */
	int search(Object object);
}
