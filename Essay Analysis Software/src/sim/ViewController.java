package sim;

import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.filechooser.FileSystemView;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.*;

public class ViewController {

	// APPLICATION ELEMENTS: UI AND OBJECTS
	private static JFrame jframeWindow;
	private static JPanel panel;
	private static JButton inputBtn;
	private static JTextField inputTxt;
	private static JButton runAnalysisBtn;
	private static JTextArea display;
	private static File fileToRead;


	public static void main(String[] args) {
		constructAppWindow();
		addListenerEvents();
	}
	
	private static void constructAppWindow() 
	{
		jframeWindow = new JFrame();
		jframeWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// buttons, text elements
		inputBtn = new JButton("Essay File:");
		inputTxt = new JTextField(25);
		inputTxt.setEditable(false);
		runAnalysisBtn = new JButton("Essay Analyzer");

		display = new JTextArea("", 10, 400);
		display.setEditable(false);
		display.setLineWrap(true);
		JScrollPane scrollPane = new JScrollPane(display);
		scrollPane.setPreferredSize(new Dimension(390, 400));

		panel = new JPanel();
		panel.setPreferredSize(new Dimension(400, 520));
		panel.setBackground(Color.DARK_GRAY);
		panel.add(inputBtn);
		panel.add(inputTxt);
		panel.add(runAnalysisBtn);
		panel.add(scrollPane);
		
		jframeWindow.add(panel);
		jframeWindow.pack();
		jframeWindow.setVisible(true);
	}
	
	private static void addListenerEvents() 
	{
		inputBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				requestInputFile();
			}
		});
		
		runAnalysisBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SentenceAnalysis analyzer = new SentenceAnalysis(fileToRead);
				analyzer.processSentences();
				display.setText(""+analyzer.getAverage());
			}
		});
	}
	
	public static void requestInputFile() {
		JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
		int returnValue = jfc.showOpenDialog(null);
		if (returnValue == JFileChooser.APPROVE_OPTION) {
			fileToRead = jfc.getSelectedFile();
			inputTxt.setText(fileToRead.toString());
		}
	}
	
}
