package sim;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Color;

public class ScrabbleApp {

	private JFrame frmScrabbleApp;
	private JTextField textFieldInput;
	private JLabel lblTitle;
	private JLabel lblInstruction;
	private JScrollPane scrollPaneCombos;
	private JTextArea textAreaPerms;
	private JTextArea textAreaWarning;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ScrabbleApp window = new ScrabbleApp();
					window.frmScrabbleApp.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ScrabbleApp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmScrabbleApp = new JFrame();
		frmScrabbleApp.setTitle("Scrabble App");
		frmScrabbleApp.setBounds(100, 100, 450, 300);
		frmScrabbleApp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmScrabbleApp.getContentPane().setLayout(null);
		
		lblTitle = new JLabel("Combination Generator");
		lblTitle.setBounds(150, 26, 145, 14);
		frmScrabbleApp.getContentPane().add(lblTitle);
		
		lblInstruction = new JLabel("Enter 7 letters");
		lblInstruction.setBounds(24, 61, 96, 14);
		frmScrabbleApp.getContentPane().add(lblInstruction);
		
		textFieldInput = new JTextField();
		lblInstruction.setLabelFor(textFieldInput);
		textFieldInput.setBounds(126, 61, 96, 20);
		frmScrabbleApp.getContentPane().add(textFieldInput);
		textFieldInput.setColumns(10);
		
		scrollPaneCombos = new JScrollPane();
		scrollPaneCombos.setBounds(271, 61, 104, 172);
		frmScrabbleApp.getContentPane().add(scrollPaneCombos);
		
		textAreaPerms = new JTextArea();
		scrollPaneCombos.setViewportView(textAreaPerms);
		
		textAreaWarning = new JTextArea();
		textAreaWarning.setBackground(new Color(240, 240, 240));
		textAreaWarning.setWrapStyleWord(true);
		textAreaWarning.setRows(2);
		textAreaWarning.setEditable(false);
		textAreaWarning.setBounds(24, 92, 199, 63);
		frmScrabbleApp.getContentPane().add(textAreaWarning);
		
		textFieldInput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				triggerBuilder();
			}
		});
	}
	
	/**
	 * Test the input and, if valid, build the output
	 */
	private void triggerBuilder() {
		// TASK 1: GET INPUT VALUE - ADD MARGIN FOR ANY WHITESPACE CHARACTERS
		String input = textFieldInput.getText().replaceAll("\\s", "");
		String output = "";
		String warning = "";
		String[] allCombos;
		boolean valid = true;
		
		// TASK 2: VALIDATE INPUT - BASED ON LENGTH AND CHARACTER VALIDITY
		
		if (input.length()>7) {
			valid = false;
			warning = "Please enter 7 characters or less.";
		}
		
		if (valid) {
			for (int i = 0; i < input.length(); i++) {
	            if (!(input.charAt(i) >= 'A' && input.charAt(i) <= 'Z') && !(input.charAt(i) >= 'a' && input.charAt(i) <= 'z')) {
	                valid = false;
	                warning = "Please enter letters only.";
	            }
	        }
		}
		
		// TASK 3: BUILD OUTPUT
		if (valid) {
			textAreaWarning.setText("");
			Set<String> uniquePerms = new HashSet<>();
			recursiveBuilder(input, "", uniquePerms);
			
			allCombos = new String[uniquePerms.size()];
			int i = 0;
			
			for (String perm : uniquePerms) {
	            allCombos[i] = perm;
	            i++;
	        }
			
			Arrays.sort(allCombos);
			
			for (String s : allCombos) {
				output += s + "\n";
			}
		}
	
		// TASK 4: DISPLAY OUTPUT
		textAreaWarning.setText(warning);
		textAreaPerms.setText(output);
	}
	
	/**
	 * Build the set of unique permutations
	 * @param s
	 * @param prefix
	 * @param uniquePerms
	 */
	private static void recursiveBuilder(String s, String prefix, Set<String> uniquePerms) {
		if (s.length()==0) {
			uniquePerms.add(prefix);
		}else {
			for (int i = 0; i < s.length(); i++) {
				String remnant = s.substring(0, i) + s.substring(i + 1);
				recursiveBuilder(remnant, prefix + s.charAt(i), uniquePerms);
			}
		}
	}
	
}
