package junitTester;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import sim.BinarySearchTree;
import sim.Node;


class TestBST {

	
	@Test
	public void testNewNode() {
		// SAMPLE NODE 
		Node n1 = new Node(4);
		System.out.println("\n\nTest Node creation of integer: " + n1.value);
		assertEquals(n1.value,4);
	}
	
	@Test
	public void testEmptyTree() {
		// TEST 1: NEW BINARY SEARCH TREE IS EMPTY
		BinarySearchTree tree = new BinarySearchTree();
		System.out.println("\n\nTest Empty initial tree " + tree.toString());
		assertEquals("[]", tree.toString());
	}
	
	@Test
	public void testMultipleUniqueNode() {
		BinarySearchTree tree = new BinarySearchTree();
		
		tree.addNode(7);
		tree.addNode(9);
		tree.addNode(6);
		tree.addNode(2);
		System.out.println("\n\nTest Add Four Unique Nodes (7, 9, 6, 2) " + tree.toString());
		assertEquals("[2, 6, 7, 9]", tree.toString());
	}
}
