package tester;

import sim.SalesItem;

public class SalesItemTester {

	public static void main(String[] args) {
		// Try printing nameless item.
		SalesItem item1 = new SalesItem();
		
		item1.setPrice("5.99");
		item1.setQuantity("2");
		
		System.out.println(item1 + "\n");
		
		// Create fully assigned SalesItem
		item1.setName("Watermelon");
		System.out.println(item1);
		
		// Create partially assigned SalesItem
		SalesItem item2 = new SalesItem();
		item2.setName("Oatmeal");
		
		System.out.println(item2);
		
		// Test an empty item
		SalesItem item3 = new SalesItem();
		
		System.out.println(item3 + "\n");
		
		// Try setting invalid name value
		item2.setName("ThisIsLongerThanFifteenChars");
	}

}
