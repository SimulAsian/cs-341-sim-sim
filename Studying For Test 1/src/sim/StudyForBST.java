package sim;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class StudyForBST {
	// Data members
	private Node root;
	
	public StudyForBST() {
		root = null;
	}
	
	public void addNode(int n) {
		Node node = new Node(n);
		if(root == null) {
			root = node;
			return;
		}
		Node ptr = root;
		while(true) {
			if(node.value < ptr.value) {
				if(ptr.left == null) {
					ptr.left = node;
					return;
				}else {
					ptr = ptr.left;
				}
			} else if(node.value > ptr.value) {
				if(ptr.right == null) {
					ptr.right = node;
					return;
				}else {
					ptr = ptr.right;
				}
			} else {
				return;
			}
		}
	}
	
	private void inOrderRecursive(Node ptr, List<Integer> list) {
		if(ptr == null) return;
		inOrderRecursive(ptr.left, list);
		list.add(ptr.value);
		inOrderRecursive(ptr.right, list);
	}
	
	private 
}
