package com.data.stack;

import java.util.Vector;

public class VectorStack<E> extends Vector<E> implements Stack<E>{

	private static final long serialVersionUID = 1L;

	public VectorStack() {
		super();
	}
	
	public boolean empty() {
		return this.size() == 0;
	}
	
	public E peek() {
		return this.lastElement();
	}
	
	public E pop() {
		return this.remove(this.size() - 1);
	}
	
	public E push(E item) {
		E itemToReturn = null;
		this.add(item);
		this.peek();
		
		return itemToReturn;
	}
	
	public int search(Object object) {
		return this.indexOf(object);
	}

	@Override
	public String toString() {
		return "VectorStack [toString()=" + super.toString() + "]";
	}
}
