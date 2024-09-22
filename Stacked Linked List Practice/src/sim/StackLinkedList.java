package sim;
import java.util.EmptyStackException;

public class StackLinkedList {
	private Node head;
	private Node tail;
	
	public StackLinkedList() {
		head = null;
		tail = null;
	}
	
	public void push(Object e) {
		if(head==null) {
			head = new Node(e);
			tail = head;
		}
		else {
			Node temp = new Node(e);
			tail.next = temp;
			temp.prev = tail;
			tail = temp;
		}
	}
	
	public Object pop() {
		if(head==null) {
			throw new EmptyStackException();
		}
		
		Object result = tail.value;
		
		if(head == tail){
			head = null;
			tail = null;
		}else
		{
			tail = tail.prev;
			tail.next = null;
		}
		return result;
	}
	
	public boolean isEmpty() {
		return head==null;
	}
	
	public String toString() {
		String result = "";
		
		Node ptr = head;
		
		while(ptr != null) {
			result += "" + ptr.value + ", ";
			ptr = ptr.next;
		}
		
		return result;
	}
}
