package io;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class FileReader {
	ArrayList<String> allSentences = new ArrayList<String>();
	HashMap<String, ArrayList<String>> library = new HashMap<String, ArrayList<String>>();
		

	public FileReader(String path, boolean isFolder) throws FileNotFoundException { 
		if (isFolder) {
			readFolder(path);
		} else {
			readFile(new File(path));
		}
	}

	private void readFolder(String path) throws FileNotFoundException{
		File[] folder = new File(path).listFiles();
		for(File f: folder){
			library.put(f.getAbsolutePath(), readFile(f));
		}
	}
	
	/**
	 * Takes the path of a formatted file (one sentence per line) and reads them
	 * into an arraylist
	 * Split sentence perl script in STP t6 folder
	 * 
	 * @param path
	 * @throws FileNotFoundException
	 */
	private  ArrayList<String> readFile(File file) throws FileNotFoundException {
		ArrayList<String> sentences = new ArrayList<String>();

		Scanner sc;
		sc = new Scanner(file);

		while (sc.hasNextLine()) {
			String sentence = sc.nextLine();
			sentences.add(sentence);
			allSentences.add(sentence);
		}
		
		sc.close();
		return sentences;
	}


}
