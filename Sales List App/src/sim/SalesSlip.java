package sim;

import java.util.ArrayList;

public class SalesSlip {
	private ArrayList<SalesItem> list;
	
	public SalesSlip() {
		list = new ArrayList<SalesItem>();
	}
	
	public void addItem(String name, String price, String quantity) {
		SalesItem item = new SalesItem();
		item.setName(name);
		item.setPrice(price);
		item.setQuantity(quantity);
		
		list.add(item);
	}
	
	public String totalSales() {
		double result = 0;
		
		if (!list.isEmpty()) {
			for (SalesItem item : list) {
				if (item.getPrice() == 0 || item.getQuantity()== 0) {
					System.out.println("Not all items have had values properly assigned.\nPlease assign values before trying again.\n");
					return "X.XX";
				}else {
					result += item.getTotalPrice();
				}
			}
		}else {
			return "X.XX";
		}
		
		return String.format("%.2f", result);
	}
	
	public String toString() {
		String result = "";
		
		for (SalesItem item : list) {
			result += item.toString() + "\n";
		}
		
		return result;
	}
}
