package sim;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Catalog implements Serializable{
	private File inputFile;
	private ArrayList<Textbook> textbooks;
	public int size;
	
	public Catalog() {
		textbooks = new ArrayList<Textbook>();
		processLog();
	}
	
	public void processLog() {
		Scanner fileInputScan = null;
		
		try {
			fileInputScan = new Scanner(inputFile);
			fillArray(fileInputScan);
		} catch (FileNotFoundException e) {
			System.out.println("Error - File not found.");
		} finally {
			if(fileInputScan != null)
				fileInputScan.close();
		}
	}
	
	
	
	private void fillArray(Scanner fileInputScan) {
		String[] params = new String[4];
		
		while(fileInputScan.hasNextLine()) {
			String line = fileInputScan.nextLine();
			params = line.split(",");
			
			textbooks.add(new Textbook(Integer.parseInt(params[0]),params[1],Double.parseDouble(params[2]),Integer.parseInt(params[3])));
		}
		
		size = textbooks.size();
	}
	
}
