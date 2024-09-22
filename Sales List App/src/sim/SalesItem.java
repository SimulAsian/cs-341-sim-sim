package sim; 

public class SalesItem {
	private String name; 
	private Double price; 
	private Integer quantity; 
	private int CONSTANT_CHARLIMIT = 15; 
	private int CONSTANT_SPACESINTAB = 8; 
	
	public SalesItem() {
		name = null; 
		price = null; 
		quantity = null; 
	}
	
	// SETTERS & GETTERS
	public String getName() {
		return name;
		}
	public double getPrice() {
		try {
			return price;
		}catch (Exception e) {
			return 0; 
		}
	}
	public int getQuantity() {
		try {
			return quantity;
		}catch (Exception e) {
			return 0;
		}
	}
	public int getConstantMaxLen() {
		return CONSTANT_CHARLIMIT;
	}
	public int getConstantTabSpaces() {
		return CONSTANT_SPACESINTAB;
	}
	
	
	public void setName(String input) {
		name = input; 
	}
	public void setPrice(String input) {
		try{
			price = Double.parseDouble(input);
		}
		catch (Exception e){
			System.out.println("Invalid price set attempted");
			}
	}
	public void setQuantity(String input) {
		try{
			quantity = Integer.parseInt(input);
		}
		catch (Exception e){
			System.out.println("Invalid quantity set attempted");
			}
	}
	
	// TOSTRING() PORTION
	public String toString() {
		String result = ""; 
		int nameLen; 
		
		// Format according to name length 
		if (!(name == null)){
			result += name; 
			nameLen = name.length(); 
		}else {
			result += "Name missing."; 
			nameLen = 13; 
		}
		// Add appropriate number of tabs
		if (CONSTANT_CHARLIMIT >= nameLen) {
			int tabs = (CONSTANT_CHARLIMIT-nameLen)/CONSTANT_SPACESINTAB; 
			for (int i = 0;  i <= tabs;  i++) {
				result += "\t"; 
			}
		}
		
		// Format according to price
		if (!(price == null)){
			result += String.format("%.2f", price); 
			result += (price.doubleValue() > 10.0 ? "\t" : ""); 
		}else {
			result += "Price missing.\t"; 
		}
		
		// Format according to quantity
		if (!(quantity == null)) {
			result += "\t\t" + quantity; 
		}else {
			result += "Quantity missing. "; 
		}
		
	    return result; 
	}
	
	// CALCULATIONS
	public double getTotalPrice() {
		return price.doubleValue() * quantity.intValue(); 
	}
}
