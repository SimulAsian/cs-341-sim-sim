package sim;

public class Node {
	public Object value;
	public Node next;
	public Node prev;
	
	public Node(Object o) {
		value = o;
		next = null;
		prev = null;
	}
	
	public String toString() {
		return "" + value;
	}
}
