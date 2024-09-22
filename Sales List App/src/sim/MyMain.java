package sim;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

public class MyMain {

	private JFrame frmSalesList;
	private JLabel itemLabel, costLabel, quantityLabel, totalSalesLabel;
	private JScrollPane salesListScrollList;
	private JButton addItemBtn;
    private JTextField itemTextField, costTextField, quantityTextField, totalSalesTextField;
    private JTextArea salesListTextArea, errorTextArea;
    private SalesSlip salesList;
    private int maxLength;
    private boolean valid;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MyMain window = new MyMain();
                    window.frmSalesList.setVisible(true); 
                } catch (Exception e) {
                    e.printStackTrace(); 
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public MyMain() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frmSalesList = new JFrame();
        frmSalesList.setTitle("Sales List");
        frmSalesList.setBounds(100, 100, 450, 300);
        frmSalesList.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmSalesList.getContentPane().setLayout(null);

        itemLabel = new JLabel("Item:");
        itemLabel.setBounds(42, 14, 57, 14);
        frmSalesList.getContentPane().add(itemLabel);
        
        costLabel = new JLabel("Cost: $");
        costLabel.setBounds(42, 52, 57, 14);
        frmSalesList.getContentPane().add(costLabel);
        
        quantityLabel = new JLabel("Quantity:");
        quantityLabel.setBounds(42, 90, 57, 14);
        frmSalesList.getContentPane().add(quantityLabel);
        
        // Text fields for user input
        itemTextField = new JTextField();
        itemTextField.setBounds(103, 11, 120, 20);
        frmSalesList.getContentPane().add(itemTextField);
        itemTextField.setColumns(10);
        
        costTextField = new JTextField();
        costTextField.setBounds(103, 49, 120, 20);
        frmSalesList.getContentPane().add(costTextField);
        costTextField.setColumns(10);
        
        quantityTextField = new JTextField();
        quantityTextField.setBounds(103, 87, 120, 20);
        frmSalesList.getContentPane().add(quantityTextField);
        quantityTextField.setColumns(10);
        
        addItemBtn = new JButton("Add Item to the Sales List");
        addItemBtn.setBounds(115, 118, 207, 23);
        frmSalesList.getContentPane().add(addItemBtn);
        
        salesListScrollList = new JScrollPane();
        salesListScrollList.setBounds(42, 152, 352, 72);
        frmSalesList.getContentPane().add(salesListScrollList);
        
        salesListTextArea = new JTextArea();
        salesListScrollList.setViewportView(salesListTextArea);
        
        totalSalesLabel = new JLabel("Total Sales: $");
        totalSalesLabel.setBounds(130, 235, 86, 14);
        frmSalesList.getContentPane().add(totalSalesLabel);
        
        totalSalesTextField = new JTextField();
        totalSalesTextField.setEditable(false);
        totalSalesTextField.setBounds(215, 232, 76, 20);
        frmSalesList.getContentPane().add(totalSalesTextField);
        totalSalesTextField.setColumns(10);
        
        errorTextArea = new JTextArea();
        errorTextArea.setEditable(false);
        errorTextArea.setWrapStyleWord(true);
        errorTextArea.setBackground(new Color(240, 240, 240)); 
        errorTextArea.setBounds(234, 9, 160, 96);
        frmSalesList.getContentPane().add(errorTextArea);
        
        // Initialize sales list and max length from a SalesItem
        salesList = new SalesSlip();
        SalesItem temp = new SalesItem();
        maxLength = temp.getConstantMaxLen();
        
        addItemBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                adder();
            }
        });
    }
    
    /**
     * Builds the list contents based on user input.
     */
    public void adder() {
        // Task 1: Get input values
        String item = itemTextField.getText();
        String cost = costTextField.getText();
        String quantity = quantityTextField.getText();
        
        // Task 2: Check validity of input
        String errorTxt = validityChecker();
        
        // Task 3: If valid, add item and update display
        if (valid) {
            salesList.addItem(item, cost, quantity);
            salesListTextArea.setText(salesList.toString());
        }
        errorTextArea.setText(errorTxt);
        totalSalesTextField.setText(salesList.totalSales());
    }
    
    /**
     * Checks that the item name is a valid length and that cost and quantity are provided.
     * @return Error message if invalid, or empty string if valid.
     */
    public String validityChecker() {
        valid = true;
        String errorText = "";
        
        if (itemTextField.getText().length() > maxLength) {
            valid = false;
            errorText += "Please keep item names\n" + maxLength + " characters or less.\n"; // Add error message
        }
        if (itemTextField.getText().length() == 0) {
            valid = false;
            errorText += "Please enter an item name between 1 and " + maxLength + " characters.\n"; // Add error message
        }
        if (costTextField.getText().isBlank()) {
            valid = false;
            errorText += "Please enter the cost.\n";
        }
        if (quantityTextField.getText().isBlank()) {
            valid = false;
            errorText += "Please enter the quantity.";
        }
        if (!valid) {
        	errorText = "Input Instructions:\n" + errorText;
        }
        
        return errorText;
    }
}
