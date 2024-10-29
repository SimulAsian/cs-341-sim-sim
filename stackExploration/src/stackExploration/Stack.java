package stackExploration; //

import java.util.Arrays;
import java.util.EmptyStackException;

public class Stack {
	// Data members (Private)
	private Object[] elements;
	private int size; //Size of the stack (how many elements the stack holds)
	private static final int INITIAL_CAPACITY = 3;
	
	
	
	public Stack() {
		elements = new Object[INITIAL_CAPACITY];
		size = 0;
	}
	
	public int getSize() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public void push(Object o) {
		if (elements.length == size) elements = Arrays.copyOf(elements, 2*size);
		
		//will provide size then increment :O
		elements[size++] = o;
	}
	
	public Object pop() {
		if(size == 0) {
			// WILL BE ON THE TEST!!
			throw new EmptyStackException();
		}

		Object o = elements[--size];
		elements[size] = null;
		
		return o;
	}
	
	public String toString() {
//		String output = Arrays.toString(elements);
		String output = ""; //
		
		for (int i = 0; i < size; i++) {
			output += elements[i];
		}
		
		return output;
	}
}
