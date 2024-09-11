package sim;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class IterationApp {
	
	private JFrame frame;
	private JTextField txtFieldCount;
	private JTextField txtFieldText;
	private JButton btnBuild;
	private JTextArea textAreaOutput;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IterationApp window = new IterationApp();
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
	public IterationApp() {
		initialize();
//		createEvents();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblTitle = new JLabel("Iteration App");
		//lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(169, 6, 104, 16);
		frame.getContentPane().add(lblTitle);
		
		JLabel lblCount = new JLabel("Count:");
		lblCount.setBounds(38, 68, 61, 16);
		frame.getContentPane().add(lblCount);
		
		JLabel lblText = new JLabel("Text to be iterated:");
		lblText.setBounds(6, 115, 135, 16);
		frame.getContentPane().add(lblText);
		
		txtFieldCount = new JTextField();
		txtFieldCount.setBounds(173, 63, 130, 26);
		frame.getContentPane().add(txtFieldCount);
		txtFieldCount.setColumns(10);
		
		txtFieldText = new JTextField();
		txtFieldText.setBounds(183, 101, 130, 26);
		frame.getContentPane().add(txtFieldText);
		txtFieldText.setColumns(10);
		
		JButton btnBuild = new JButton("BUILD OUTPUT");
		btnBuild.setBounds(156, 150, 117, 29);
		frame.getContentPane().add(btnBuild);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(31, 191, 370, 61);
		frame.getContentPane().add(scrollPane);
		
		textAreaOutput = new JTextArea();
		scrollPane.setViewportView(textAreaOutput);
		
		
		btnBuild.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buildOutput();
			}
		});
	}
	
//	private void createEvents() {
//		btnBuild.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				buildOutput();
//			}
//		});
//	}
	
	private void buildOutput() {
		//TASK 1: GET COUNT
		Integer cnt = Integer.parseInt(txtFieldCount.getText());
		
		//TASK 2: BUILD THE OUTPUT STRING
		String outString = "";
		for(int i = 1; i <= cnt; i++) {
			outString += txtFieldText.getText();
		}
		
		//TASK 3: DISPLAY THE OUTPUT STRING
		textAreaOutput.setText(outString);
		
	}
	
}
