package stackExploration;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class StackMain {

	//Restrict the stack to an array data structure
	// Allow the array to hold a generic Object value
	// Set an initial capacity of three for the stack size. If more space is needed, double the size of the array.
	// Add push(), pop(), and toString()
	// Respond appropriately to a pop() of an empty stack.
	// Check if more memory capacity is needed during every push
	
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StackMain window = new StackMain();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		
		// TESTING GROUNDS
		// TEST 1: CREATE A STACK OBJECT AND CHECK IF IT IS EMPTY
		Stack myStack = new Stack();
		System.out.println("Test 1: Empty Stack? " + myStack.isEmpty());
		
		// TEST 3: PLUS THREE STRING OBJECTS
		myStack.push("Software ");
		myStack.push("Engineering ");
		myStack.push(": CS-");
		System.out.println("Test 2: Three Strings: " + myStack.toString());
		
		// TEST 3: PLUS THREE INTEGER OBJECTS
		myStack.push(3);
		myStack.push(4);
		myStack.push(1);
		System.out.println("Test 3: Three Ints: " + myStack);
		
		// TEST 4: POP TWO OBJECTS AND DISPLAY THE STACK
		System.out.println("TEST 4: POP " + myStack.pop());
		System.out.println("TEST 4: POP " + myStack.pop());
		System.out.println("Stack size: " + myStack.getSize());
		
		// TEST 5: PUSH 10 ELEMENTS ONTO STACK AND DISPLAY THE STACK
		myStack.push(4);
		myStack.push(1);
		myStack.push('-');
		myStack.push(0);
		myStack.push(1);
		myStack.push(" ");
		myStack.push("by");
		myStack.push(" ");
		myStack.push("Trish Cornez");
		myStack.push(".");
		System.out.println("Test 5: (Stack with 10 more items) " + myStack);
		System.out.println("Test 5: stack size of " + myStack.getSize());
		
		// TEST 6: POP THE STACK UNTIL IT IS EMPTY AND DISPLAY THE STACK
		while (!myStack.isEmpty()) {
			myStack.pop();
		}
		System.out.println("Test 6: EMPTY STACK" + myStack + " " + myStack.isEmpty());
		
		// TEST 7: TEST THE EXCEPTION OF POPPING AN EMPTY STACK
		System.out.println("Test 7: Pop an empty stack check for exceptions");
		myStack.pop();
	}

	/**
	 * Create the application.
	 */
	public StackMain() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
