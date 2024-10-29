package sim;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class SentenceAnalysis {
	private File inputFile;
	private String[] sentences;
	private ArrayList<Integer> sentenceWordCount;
	
	public SentenceAnalysis(File inputFile) {
		this.inputFile = inputFile;
		sentences = null;
		sentenceWordCount = new ArrayList<>();
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
	
	public int getAverage() {
		double sum = 0;
		for(int i = 0; i < sentenceWordCount.size(); i++)
			sum += sentenceWordCount.get(i);
		return (int) (sum/sentenceWordCount.size());
	}
}
