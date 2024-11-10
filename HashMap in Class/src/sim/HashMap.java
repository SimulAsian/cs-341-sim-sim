package sim;

import java.util.LinkedList;

public class HashMap {
	private int capacity;
	private LinkedList<Node>[] buckets;
	
	public HashMap() {
		capacity = 16;
		buckets = new LinkedList[capacity];
		for(int i = 0; i < capacity; i++) {
			buckets[i] = new LinkedList<>();
		}
	}
	
	private int getIndex(String key) {
		int sum = 0;
		for(int i = 0; i < key.length(); i++) {
			sum += key.charAt(i);
		}
		
		int hashCode = sum % buckets.length;
		
		return hashCode;
	}
	
	public void put(String key, String value) {
		int index = getIndex(key);
		
		//locate bucket
		LinkedList<Node> bucket = buckets[index];
		
		//search for dupe
		for(Node entry:bucket) {
			if(entry.key.equals(key)) {
				entry.value = value;
				return;
			}
		}
		
		bucket.add(new Node(key, value));
	}
	
	public String get(String key) {
		int index = getIndex(key);
		//locate bucket
			LinkedList<Node> bucket = buckets[index];
				
		//search for dupe
		for(Node entry:bucket) {
			if(entry.key.equals(key)) {
				return entry.value;
			}
		}
		return null;
	}
	
	public boolean containsKey(String key) {
		int index = getIndex(key);
		
		//locate bucket
		LinkedList<Node> bucket = buckets[index];
		
		for(Node entry:bucket) {
			if(entry.key.equals(key)) {
				return true;
			}
		}
		return false;
	}
}