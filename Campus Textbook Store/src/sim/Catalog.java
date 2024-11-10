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
	private Textbook[] textbook;
	public size;
	public Catalog() {
		
	}
	
	public void processSentences() {
		Scanner fileInputScan = null;
		
		try {
			fileInputScan = new Scanner(inputFile);
			getSentenceWordCount(fileInputScan);
		} catch (FileNotFoundException e) {
			System.out.println("Error - File not found.");
		} finally {
			if(fileInputScan != null)
				fileInputScan.close();
		}
	}
	
	private void getSentenceWordCount(Scanner fileInputScan) {
		while(fileInputScan.hasNextLine()) {
			String paragraphs = fileInputScan.nextLine();
			sentences = paragraphs.split("[.!?]");
			
			for(int i = 0; i < sentences.length; i++) {
				String s = sentences[i].trim();
				String[] words = s.split("\\s+");
				
				if(words.length > 1 || !words[0].equals("")) {
					sentenceWordCount.add(words.length);
				}
			}
		}		
	}
	
}
