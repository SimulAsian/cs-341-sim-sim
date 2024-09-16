package bigNumAddApp;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class MyMain {

	private JFrame frmBigNumberAdder;
	private JTextField textFieldX;
	private JTextField textFieldY;
	private JTextArea textArea;
	private JButton btnAdd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyMain window = new MyMain();
					window.frmBigNumberAdder.setVisible(true);
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
		frmBigNumberAdder = new JFrame();
		frmBigNumberAdder.setTitle("Big Number Adder");
		frmBigNumberAdder.setBounds(100, 100, 450, 300);
		frmBigNumberAdder.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBigNumberAdder.getContentPane().setLayout(null);
		
		JLabel lblInstruction = new JLabel("Enter ONLY positive integers");
		lblInstruction.setBounds(102, 26, 238, 14);
		frmBigNumberAdder.getContentPane().add(lblInstruction);
		
		JLabel lblX = new JLabel("X");
		lblX.setBounds(44, 76, 49, 14);
		frmBigNumberAdder.getContentPane().add(lblX);
		
		JLabel lblY = new JLabel("Y");
		lblY.setBounds(44, 120, 49, 14);
		frmBigNumberAdder.getContentPane().add(lblY);
		
		textFieldX = new JTextField();
		textFieldX.setBounds(126, 73, 283, 20);
		frmBigNumberAdder.getContentPane().add(textFieldX);
		textFieldX.setColumns(10);
		
		textFieldY = new JTextField();
		textFieldY.setBounds(126, 117, 283, 20);
		frmBigNumberAdder.getContentPane().add(textFieldY);
		textFieldY.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(27, 186, 382, 53);
		frmBigNumberAdder.getContentPane().add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		btnAdd = new JButton("Add");
		btnAdd.setBounds(173, 152, 89, 23);
		frmBigNumberAdder.getContentPane().add(btnAdd);
		
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buildOutput();
			}
		});
	}
	
	private void buildOutput() {
		// TASK 1: GET X AND Y VALUES 
		BigNumber x = new BigNumber(textFieldX.getText());
		BigNumber y = new BigNumber(textFieldY.getText());
		
		// TASK 2: CREATE RESULTING BIG NUMBER FROM ADDING X AND Y, Z
		BigNumber z = x.add(y);
		
		// TASK 3: DISPLAY THE OUTPUT (Z)
		textArea.setText(z.getValue());
		
	}
}
