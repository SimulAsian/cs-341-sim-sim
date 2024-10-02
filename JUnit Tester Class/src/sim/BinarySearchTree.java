package sim;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Test 1: Verify a new BinarySearchTree object is empty
// Test 2: Add four nodes and verify
// Test 3: Add duplicate nodes and verify they are not added
// Test 4: Verify on a larger scale. Add 50 random nodes (potential duplicates)
// Hit the child - indicative of child abuse
// Use the child - indicative of child labor or abuse
// Visit the child - not implicative of anything... except, at most, like a divorce, death or juvenile detention
// Stack, Stack using array, what congregate memory is and that an array is one, eliminate leaks, construct a BST and a JUnit Test, how to add a node

public class BinarySearchTree {
	private Node root; //pointer to a node
	
	public BinarySearchTree() {
		root = null;
	}
	
	/**
	 * AddNode based on value n
	 * @param n
	 */
	public void addNode(Integer n) {
		// SCENARIO 1: Generate Node
		Node temp = new Node(n);
		
		// SCENARIO 2: Handle an empty tree
		if (root == null) {
			root = temp;
			return;
		}
		
		// Task 3: Create a pointer (ptr) that starts at the root
		Node ptr = root;
		
		// TASK 4: Check whether you should go left or right or just stop
		while (true) {
			if (temp.value < ptr.value) {			// TRAVEL TO LEFT
				if(ptr.left == null) {
					ptr.left = temp;
					return;
				} else {
					ptr = ptr.left;
				}
				
			} else if(temp.value > ptr.value) {		// TRAVEL TO RIGHT
				if(ptr.right == null) {
					ptr.right = temp;
					return;
				} else {
					ptr = ptr.right;
				}
			} else {								// NO DUPLICATE NODE
				return;
			}
		}
		
		
	}
	
	public String toString() {
		// primitive state and recursive elements for recursion
		List <Integer> list = new ArrayList <>();
		inOrderRecursive(root, list);
		return list.toString();
	}
	
	private void inOrderRecursive(Node ptr, List <Integer> list) {
		if (ptr == null) {
			return;
		}
		
		inOrderRecursive(ptr.left, list);
		list.add(ptr.value);
		inOrderRecursive(ptr.right, list);
	}
	
	public void inOrderBalancedTreeRecursiveBuild(List <Integer> list) {
		if (list == null || list.isEmpty()) {
            return;
        }
		
		Collections.sort(list);
		
		root = recursiveBuilder(list, 0, list.size() - 1);
	}
	
	private Node recursiveBuilder(List<Integer> list, int start, int end) {
		if (start > end) {
            return null;
        }
		int mid = start + (end - start) / 2;
        Node node = new Node((Integer) list.get(mid));
        node.left = recursiveBuilder(list, start, mid - 1);
        node.right = recursiveBuilder(list, mid + 1, end);

		return node;
	}
}
