package tester;

import sim.SalesSlip;
public class SalesSlipTester {

    public static void main(String[] args) {
        // Create an instance of SalesSlip
        SalesSlip slip = new SalesSlip();
        
        // Add items to the sales slip
        slip.addItem("Watermelon", "5.99", "2");
        slip.addItem("Cabbage - Green", "3.99", "4");
        slip.addItem("Avocados", "0.99", "7");
        
        // Print the contents of the sales slip and the total price of items added
        System.out.println(slip + "\n Total price: " + slip.totalSales() + "\n");
        
        // Attempt to add an item with empty cost and quantity
        slip.addItem("Croissant", "", "");
        
        // Print the updated sales slip and total price again, now with an item with invalid values
        System.out.println(slip + "\n Total price: " + slip.totalSales());
    }
}
