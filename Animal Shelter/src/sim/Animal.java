package sim;

public class Animal {
	protected String name;
	private int timestamp;
	
	public Animal(String name) {
		this.name = name;
	}
	
	public void setTimestamp(int timestamp) {
		this.timestamp = timestamp;
	}
	
	public void setTimeStamp(int timestamp) {
		this.timestamp = timestamp;
	}
	
	public int getTimestamp() {
		return timestamp;
	}
	
	public boolean isOlderThan(Animal a) {
		return this.timestamp < a.getTimestamp();
	}
	
	public String toString() {
		return "Timestamp" + timestamp + " Name:" + name;
	}
}
