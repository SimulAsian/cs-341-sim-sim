package sim;

public class Node {
	public Integer value;
	public Node left;
	public Node right;
	
	public Node(Integer i) {
		value = i;
		left = null;
		right = null;
	}
	
	public String toString() {
		return "" + value;
	}
}
