package sim;

public class Textbook {
//For each title in the inventory:
// SKU (stock-keeping unit, an int, must be unique)
// title (may contain spaces in it)
// price (dollars and cents, greater than 0)
//	quantity (number of copies in inventory, greater than or equal to 0)
//
//Must offer the user a menu
// Add textbook (all values)
// remove textbook (given sku)
// display info (given sku)
// display inventory (any order in a table)
// Error message if unsuccessful
//
//Store inventory in a file between program executions (use serialization)
//
//Draw a basic class diagram for this system (generalization and associational)
//
//Construct test cases to ensure code is correct
// i.e. file not present (initial inventory is empty), valid/invalid input test, and a summary of the test. Document all assumptions and decisions whenever requirements unclear
//
// PSP FORM AT THE END
	public int sku;
	public String title;
	public double price;
	public int quantity;
	
	public Textbook(int sku, String title, double price, int quantity) {
		this.sku = sku;
		this.title = title;
		this.price = price;
		this.quantity = quantity;
	}
	
}
