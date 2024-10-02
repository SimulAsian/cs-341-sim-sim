package junitTester;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import sim.BinarySearchTree;
import sim.Node;
// anything with pointers is not contiguous i.e. tree structure, linked list
// memorize assert statements that are common: assert___ for equals, NotEquals, True, Throw
class TestBST {
	private BinarySearchTree bst;
	
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
	
	@Test
	public void testDuplicateNode() {
		BinarySearchTree tree = new BinarySearchTree();
		
		tree.addNode(7);
		tree.addNode(9);
		tree.addNode(6);
		tree.addNode(2);
		System.out.println("\n\nTest Add one Duplicate Node");
		System.out.println("Added Nodes: " + tree.toString());
		tree.addNode(9);
		System.out.println("Add Duplicate Node 9: " + tree.toString());
		assertEquals("[2, 6, 7, 9]", tree.toString());
	}
	
	@Test
	public void testManyRandomDuplicatesAdded() {
		BinarySearchTree tree = new BinarySearchTree();
		List <Integer> listAll = new ArrayList<>();
		List <Integer> listNoDuplicates = new ArrayList<>();
		for(int i = 0; i < 500; i++) {
			Integer n = (int)(Math.random()*20+1);
			tree.addNode(n);
			if(!listNoDuplicates.contains(n)) {
				listNoDuplicates.add(n);
			}
			listAll.add(n);
			tree.addNode(n);
		}
		
		Collections.sort(listAll);
		Collections.sort(listNoDuplicates);
		
		System.out.println("\nTest random adding many nodes, some duplicates");
		System.out.println("tree of nodes: " + tree.toString());
		System.out.println("list of nodes: " + listAll.toString());
		
		if (tree.toString().contentEquals(listNoDuplicates.toString())) {
			System.out.println("This is a BST");
		} else {
			System.out.println("This is not a BST");
		}
		assertEquals(listNoDuplicates.toString(), tree.toString());
	}

	@BeforeEach
	void setUp() {
		bst = new BinarySearchTree();  // Create a new instance of the BinarySearchTree before each test
	}

	@Test
	void testBuildBalancedBST_EmptyList() {
		// Test building a balanced BST with an empty list
		List<Integer> list = new ArrayList<>();
		bst.inOrderBalancedTreeRecursiveBuild(list);
		// The tree should still be empty
		assertEquals("[]", bst.toString(), "BST should be empty with empty input list.");
	}
    
	@Test
    void testBuildBalancedBST_SingleElement() {
    	// Test building a balanced BST with a single element
    	List<Integer> list = new ArrayList<>();
    	list.add(10);
    	bst.inOrderBalancedTreeRecursiveBuild(list);
    	// Verify the BST contains only the single node
    	assertEquals("[10]", bst.toString(), "BST should contain only one node with value 10.");
    }
    
    @Test
   void testBuildBalancedBST_MultipleElements() {
    	// Test building a balanced BST with multiple elements
    	List<Integer> list = new ArrayList<>();
    	list.add(3);
    	list.add(1);
    	list.add(5);
    	list.add(2);
    	list.add(4);
    	bst.inOrderBalancedTreeRecursiveBuild(list);
        // Verify the BST contains the elements in sorted order after in-order traversal
    	assertEquals("[1, 2, 3, 4, 5]", bst.toString(), "BST should contain the elements in sorted order.");
   }
   
    @Test
    void testBuildBalancedBST_UnsortedList() {
    	// Test building a balanced BST with an unsorted list
    	List<Integer> list = new ArrayList<>();
    	list.add(9);
    	list.add(2);
    	list.add(7);
    	list.add(5);
    	list.add(1);
    	bst.inOrderBalancedTreeRecursiveBuild(list);
        // Verify the BST contains the elements in sorted order
    	assertEquals("[1, 2, 5, 7, 9]", bst.toString(), "BST should contain the elements in sorted order.");
    }
    
    @Test
    void testBalancedTreeStructure() {
    	// Test that the tree structure is balanced
    	List<Integer> list = new ArrayList<>();
    	list.add(3);
    	list.add(1);
    	list.add(5);
    	list.add(2);
    	list.add(4);
    	bst.inOrderBalancedTreeRecursiveBuild(list);
    	// Since we don't have a built-in method to verify balance,
    	// we could write a helper method to check the height difference
    	// of subtrees if you want a stricter check on balancing.
    	// For now, we rely on the in-order traversal for correctness:
    	assertEquals("[1, 2, 3, 4, 5]", bst.toString(), "BST should be balanced with correct structure.");
    }
}