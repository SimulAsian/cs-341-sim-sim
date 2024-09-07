package tapApp;

public class Count {
	int value;
	
	public Count() {
		value = 0;
	}
	
	public void increment(){
		value++;
		
	}
	
	public String toString() {
		return Integer.toString(value);
	}
}
