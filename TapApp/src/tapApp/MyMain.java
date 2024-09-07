package tapApp;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;

public class MyMain {

	private JFrame frame;
	public JLabel countLabel;
	public JButton tapBtn;
	private static Count myCount;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		// Instantiate objects
//		countLabel = new JLabel(); // commented out because "Cannot make a static reference to the non-static field countLabel"
//		tapBtn = new JButton(); // Cannot make a static reference to the non-static field tapBtn

		myCount = new Count();

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyMain window = new MyMain();
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
	public MyMain() {
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

		JLabel countLabel = new JLabel("0");
		countLabel.setBounds(180, 120, 49, 14);
		frame.getContentPane().add(countLabel);

		JButton tapBtn = new JButton("Tap!");
		tapBtn.setBounds(180, 211, 89, 23);
		frame.getContentPane().add(tapBtn);

		tapBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				myCount.increment(); 
				countLabel.setText(myCount.toString()); 

				//countLabel.setText("Omg it worked hallelujah");
			}
		});
	}
}
