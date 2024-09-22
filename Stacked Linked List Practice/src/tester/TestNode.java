package tester;

import sim.Node;

public class TestNode {
	
	public static void main(String[] args) {
		Node integer = new Node(19);
		System.out.println(integer.toString());
		
		Node string = new Node("Cat");
		System.out.println(string.toString());
		
		Node doubL = new Node(2.73);
		System.out.println(doubL.toString());
	}
	
}
