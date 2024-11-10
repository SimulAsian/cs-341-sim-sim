package sim;

public class MyMain {

	public static void main(String[] args) {
		HashMap hashMap = new HashMap();
		
		hashMap.put("Bobo", "blue");
		hashMap.put("Filo", "red");
		hashMap.put("Tibo", "white");

		System.out.println("Favorite color of Bobo: " + hashMap.get("Bobo"));
		System.out.println("Favorite color of Filo: " + hashMap.get("Filo"));
		System.out.println("Favorite color of Tibo: " + hashMap.get("Tibo"));
	}

}
