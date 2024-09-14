package passwordApp;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.Color;

public class PasswordApp {

	private JFrame frmPasswordJudger;
	private static JTextField textFieldInput;
	private static JTextArea textArea;
	private JLabel lblNewLabel;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PasswordApp window = new PasswordApp();
					window.frmPasswordJudger.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PasswordApp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPasswordJudger = new JFrame();
		frmPasswordJudger.setTitle("Password Judger");
		frmPasswordJudger.setBounds(100, 100, 450, 300);
		frmPasswordJudger.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPasswordJudger.getContentPane().setLayout(null);
		
		lblNewLabel = new JLabel("Enter password: ");
		lblNewLabel.setBounds(79, 52, 103, 14);
		frmPasswordJudger.getContentPane().add(lblNewLabel);
		
		textFieldInput = new JTextField();
		textFieldInput.setBounds(182, 49, 171, 20);
		frmPasswordJudger.getContentPane().add(textFieldInput);
		
		textArea = new JTextArea("The password must be 8-12 characters long with no spaces.");
		textArea.setLineWrap(true);
		textArea.setBackground(new Color(240, 240, 240));
		textArea.setBounds(78, 90, 275, 47);
		frmPasswordJudger.getContentPane().add(textArea);
		
		textFieldInput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				builder();
			}
		});
	}
	
	/**
	 * Test the input and, if valid, build the output
	 */
	private static void builder() {
		// TASK 1: GET INPUT
		String input, output;
		input = textFieldInput.getText();
		output = "";
		int blockLength, longest;
		blockLength = 1;
		longest = 1;
		System.out.println(input);
		
		// TASK 2: VALIDATE INPUT
		if (input.length()<8 || input.length()>12 || input.contains(" ")) {
			output = (input.contains(" ") ? "The password MUST NOT contain spaces." : 
											"The password MUST be 8-12 characters.");
		}
		
		// TASK 3: BUILD OUTPUT
		if (output.equals("")) {
			for(int i = 1; i < input.length(); i++) {
				if (input.charAt(i-1) == input.charAt(i)) {
					blockLength++;
				}else {
					longest = (blockLength > longest ? blockLength : longest);
					blockLength = 1;
				}
			}
			
			output = "The largest block in the password is " + longest + ".\n";
			output += (longest <= 2 ? "This is a decent password." : 
									  "This password can be made stronger by reducing this block by "+(longest-2)+".");
		}
		
		// TASK 4: DISPLAY OUTPUT
		textArea.setText(output);
	}
}
