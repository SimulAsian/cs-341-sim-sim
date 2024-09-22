package tester;

import sim.StackLinkedList;

public class TestStack {
	public static void main(String[] args) {
		//Test 1: Construct and verify empty
		StackLinkedList myStack = new StackLinkedList();
		System.out.println("Test 1: empty stack? " + myStack.isEmpty());
		
		//Test 2
		myStack.push(90);
		myStack.push("cat");
		myStack.push(100);
		System.out.println("Test 2: " + myStack);
		
		// Test 3: Pop one object
		System.out.println("Test 3: popped " + myStack.pop());
		
		
	}
}
