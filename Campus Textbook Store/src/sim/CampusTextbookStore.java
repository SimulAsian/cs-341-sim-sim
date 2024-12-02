package sim;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JToolBar;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.BoxLayout;
import javax.swing.JTable;
import javax.swing.JTabbedPane;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;

public class CampusTextbookStore {

	private JFrame frame;
	private JTextField inputSKUAdd;
	private JTextField inputTitle;
	private JTextField inputPrice;
	private JTextField inputQuantity;
	private JTextField inputSKUDelete;
	private JPanel addTxtbkPanel;
	private JPanel deleteTxtbkPanel;
	private JPanel inventoryPanel;
	private JPanel queryPanel;
	private JPanel buttonAndResultPanel;
	private JTable table;
	private JTextField inputSKUQuery;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CampusTextbookStore window = new CampusTextbookStore();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CampusTextbookStore() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		// ADD TEXTBOOK PANEL ///////////////////////////////////////////
		 addTxtbkPanel = new JPanel();
		addTxtbkPanel.setBounds(0, 11, 436, 139);
		frame.getContentPane().add(addTxtbkPanel);
		addTxtbkPanel.setLayout(null);
		
		JLabel labelSKUAdd = new JLabel("SKU");
		labelSKUAdd.setBounds(10, 29, 191, 14);
		addTxtbkPanel.add(labelSKUAdd);
		
		inputSKUAdd = new JTextField();
		inputSKUAdd.setBounds(63, 26, 138, 20);
		addTxtbkPanel.add(inputSKUAdd);
		inputSKUAdd.setColumns(10);
		
		JTextArea errorMsgSKUAdd = new JTextArea();
		errorMsgSKUAdd.setWrapStyleWord(true);
		errorMsgSKUAdd.setBackground(new Color(240, 240, 240));
		errorMsgSKUAdd.setBounds(10, 46, 191, 36);
		addTxtbkPanel.add(errorMsgSKUAdd);
		
		JTextArea errorMsgTitle = new JTextArea();
		errorMsgTitle.setWrapStyleWord(true);
		errorMsgTitle.setBackground(UIManager.getColor("Button.background"));
		errorMsgTitle.setBounds(235, 49, 191, 36);
		addTxtbkPanel.add(errorMsgTitle);
		
		JLabel labelTitle = new JLabel("Title");
		labelTitle.setBounds(235, 32, 191, 14);
		addTxtbkPanel.add(labelTitle);
		
		inputTitle = new JTextField();
		inputTitle.setColumns(10);
		inputTitle.setBounds(288, 29, 138, 20);
		addTxtbkPanel.add(inputTitle);
		
		JTextArea errorMsgPrice = new JTextArea();
		errorMsgPrice.setWrapStyleWord(true);
		errorMsgPrice.setBackground(UIManager.getColor("Button.background"));
		errorMsgPrice.setBounds(10, 113, 191, 36);
		addTxtbkPanel.add(errorMsgPrice);
		
		JLabel labelPrice = new JLabel("Price");
		labelPrice.setBounds(10, 96, 191, 14);
		addTxtbkPanel.add(labelPrice);
		
		inputPrice = new JTextField();
		inputPrice.setColumns(10);
		inputPrice.setBounds(63, 93, 138, 20);
		addTxtbkPanel.add(inputPrice);
		
		JTextArea errorMsgQuantity = new JTextArea();
		errorMsgQuantity.setWrapStyleWord(true);
		errorMsgQuantity.setBackground(UIManager.getColor("Button.background"));
		errorMsgQuantity.setBounds(235, 113, 191, 36);
		addTxtbkPanel.add(errorMsgQuantity);
		
		JLabel labelQuantity = new JLabel("Quantity");
		labelQuantity.setBounds(235, 96, 191, 14);
		addTxtbkPanel.add(labelQuantity);
		
		inputQuantity = new JTextField();
		inputQuantity.setColumns(10);
		inputQuantity.setBounds(288, 93, 138, 20);
		addTxtbkPanel.add(inputQuantity);
		
		// INVENTORY PANEL (Table of textbooks and info) ////////////////
		inventoryPanel = new JPanel();
		inventoryPanel.setBounds(0, 16, 436, 247);
		frame.getContentPane().add(inventoryPanel);
		
		table = new JTable();
		inventoryPanel.add(table);
		
		// BUTTON AND QUERY RESULT PANEL /////////////////////////////////
		buttonAndResultPanel = new JPanel();
		buttonAndResultPanel.setBounds(0, 144, 436, 119);
		frame.getContentPane().add(buttonAndResultPanel);
		buttonAndResultPanel.setLayout(new BorderLayout(0, 0));
		
		JButton btnSubmit = new JButton("Submit");
		buttonAndResultPanel.add(btnSubmit, BorderLayout.NORTH);
		
		JTextArea searchResult = new JTextArea();
		buttonAndResultPanel.add(searchResult, BorderLayout.CENTER);
		
		// DELETE PANEL ///////////////////////////////////////////////////
		deleteTxtbkPanel = new JPanel();
		deleteTxtbkPanel.setBounds(0, 11, 436, 102);
		frame.getContentPane().add(deleteTxtbkPanel);
		deleteTxtbkPanel.setLayout(null);
		
		JLabel labelSKUDelete = new JLabel("SKU");
		labelSKUDelete.setBounds(105, 14, 235, 14);
		deleteTxtbkPanel.add(labelSKUDelete);
		
		inputSKUDelete = new JTextField();
		inputSKUDelete.setBounds(130, 11, 210, 20);
		inputSKUDelete.setColumns(10);
		deleteTxtbkPanel.add(inputSKUDelete);
		
		JTextArea errorMsgSKUDelete = new JTextArea();
		errorMsgSKUDelete.setBounds(105, 39, 235, 58);
		errorMsgSKUDelete.setWrapStyleWord(true);
		errorMsgSKUDelete.setBackground(UIManager.getColor("Button.background"));
		deleteTxtbkPanel.add(errorMsgSKUDelete);
		
		queryPanel = new JPanel();
		queryPanel.setBounds(0, 11, 436, 102);
		frame.getContentPane().add(queryPanel);
		queryPanel.setLayout(null);
		
		JLabel labelSKUQuery = new JLabel("SKU");
		labelSKUQuery.setBounds(81, 28, 235, 14);
		queryPanel.add(labelSKUQuery);
		
		inputSKUQuery = new JTextField();
		inputSKUQuery.setColumns(10);
		inputSKUQuery.setBounds(126, 28, 165, 20);
		queryPanel.add(inputSKUQuery);
		
		JTextArea errorMsgSKUQuery = new JTextArea();
		errorMsgSKUQuery.setWrapStyleWord(true);
		errorMsgSKUQuery.setBackground(UIManager.getColor("Button.background"));
		errorMsgSKUQuery.setBounds(80, 44, 235, 47);
		queryPanel.add(errorMsgSKUQuery);
		
		// MENU BAR /////////////////////////////////////////////////////////
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenuItem addTxtbkMenuItem = new JMenuItem("Add Textbook");
		addTxtbkMenuItem.setHorizontalAlignment(SwingConstants.CENTER);
		addTxtbkMenuItem.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent ev) {
		        addTxtbkPanel.setVisible(true);
		        buttonAndResultPanel.setVisible(true);
		        inventoryPanel.setVisible(false);
		        deleteTxtbkPanel.setVisible(false);
		        queryPanel.setVisible(false);
		      }
		    });
		menuBar.add(addTxtbkMenuItem);
		
		JMenuItem deleteTxtbkMenuItem = new JMenuItem("Delete Textbook");
		deleteTxtbkMenuItem.setHorizontalAlignment(SwingConstants.CENTER);
		deleteTxtbkMenuItem.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent ev) {
			        addTxtbkPanel.setVisible(false);
			        buttonAndResultPanel.setVisible(true);
			        inventoryPanel.setVisible(false);
			        deleteTxtbkPanel.setVisible(true);
			        queryPanel.setVisible(false);
			      }
			    });
		menuBar.add(deleteTxtbkMenuItem);
		
		JMenuItem queryMenuItem = new JMenuItem("Query");
		queryMenuItem.setHorizontalAlignment(SwingConstants.CENTER);
		queryMenuItem.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent ev) {
			        addTxtbkPanel.setVisible(false);
			        buttonAndResultPanel.setVisible(true);
			        inventoryPanel.setVisible(false);
			        deleteTxtbkPanel.setVisible(false);
			        queryPanel.setVisible(true);
			      }
			    });
		menuBar.add(queryMenuItem);
		
		JMenuItem catalogMenuItem = new JMenuItem("View Catalog");
		catalogMenuItem.setHorizontalAlignment(SwingConstants.CENTER);
		catalogMenuItem.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent ev) {
			        addTxtbkPanel.setVisible(false);
			        buttonAndResultPanel.setVisible(false);
			        inventoryPanel.setVisible(true);
			        deleteTxtbkPanel.setVisible(false);
			        queryPanel.setVisible(false);
			      }
			    });
		menuBar.add(catalogMenuItem);
		
		// FUNCTIONALITY TO SUBMIT BUTTON /////////////////////////////////////
		btnSubmit.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent ev) {
			       // Note: No need to test for inventoryPanel since it will never be visible when button is
		    	  if(addTxtbkPanel.isVisible()) {
		    		  
		    	  }else if(deleteTxtbkPanel.isVisible()) {
		    		  
		    	  }else {//query panel is visible
		    		  
		    	  }
			  }
		});
		
		// SET PANELS TO BE INVISIBLE /////////////////////////////////////////
		queryPanel.setVisible(false);
		addTxtbkPanel.setVisible(false);
		inventoryPanel.setVisible(false);
		deleteTxtbkPanel.setVisible(false);
		buttonAndResultPanel.setVisible(false);
	}
	
}
