package tab2mxl;

import java.util.regex.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.*;

/**
 * 
 * @author Hashir Jamil, Abhirami Venugopal, Tommy Lam
 *
 */
public class Parser {

	//private int tabCharMatrix;
	//private ArrayList<String> tab;

	 List<String> tabList;

	private File inputFile;
	private char[][] tabCharMatrix;
	private String outputFile;

	/**
	 * 
	 * Default constructor
	 * 
	 */
	public Parser() {

	}

	/**
	 * Input File Specified Constructor
	 * @param inFile, a file path containing a tab in txt form
	 */
	public Parser(String inFile) {
		inputFile = new File(inFile);		
		tabList = new ArrayList<String>();
		this.readFile();
		this.tabCharMatrix = this.tabToCharMatrix(this.tabList);
	}
	
	public Parser(File inputFile) {
		//file.getPath();
		
		this.inputFile = inputFile;
		tabList = new ArrayList<String>();
		this.readFile();
		this.tabCharMatrix = this.tabToCharMatrix(this.tabList);
		
	}

	/**
	 * 
	 */
	private void readFile() {

		Scanner sc = null; 
		try {
			sc = new Scanner(inputFile);	
			while(sc.hasNextLine()){
				tabList.add(sc.nextLine());
			}      
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		finally {
			sc.close();
		}
	}


	public List<String> getTab() {
		return this.tabList;
	}

	/**
	 * 
	 * @param str
	 * @return
	 */
	public char[][] tabToCharMatrix(List<String> list) {

		int row = this.tabList.size();
		int col = this.tabList.get(0).length();		
		char[][] tabMatrix = new char[row][col];

		for (int i = 0; i < row; i++) {
			tabMatrix[i] = list.get(i).toCharArray();
		}
		return tabMatrix;
	}

	public void setTabCharMatrix(Parser p) {
		this.tabCharMatrix = this.tabToCharMatrix(this.tabList);
	}

	public char[][] getTabCharMatrix() {
		return this.tabCharMatrix;
	}

	/**
	 * 
	 * @author Hashir Jamil, Abhirami Venugopal, Tommy Lam
	 * This method converts a line of tabs into an ArrayList
	 * the ArrayList can then be used to check the measure (modulo) and be used to generate the notes
	 * @param str, a string to be converted into an ArrayList
	 * @return the ArrayList
	 */
	public List<String> tabToMatrix(String str) {

		String regexPattern = "^[A-Z|a-z][|]{1}[0-9[-][p|h|s|x|o|b|/]]+[|]$";
		Pattern pattern = Pattern.compile(regexPattern);
		Matcher matcher = pattern.matcher(str);

		List<String> line1Array = new ArrayList<String>();

		if (matcher.find()) {

			for (int i = 0; i < str.length(); i++) {
				line1Array.add(Character.toString(str.charAt(i)));
			}
		}

		return line1Array;

	}

	
	public String getOctave(String str) {
		
		
		
		return null;
		
	}
	
	/*
	 * public int stringLetterToNumber(Strings str) {
	 * 
	 * switch (str) {
	 * 
	 * case e: return 1;
	 * 
	 * case B: return 2;
	 * 
	 * case G: return 3;
	 * 
	 * case D: return 4;
	 * 
	 * case A: return 5;
	 * 
	 * case E: return 6; } return 0; }
	 */
	
	
	public void setKey() { //Is needed here? Would work in attributes?
		
		
	}
	
	
	
	public void primitiveToXML(List<String> arr) {
		
		
		
		String guitarString = arr.get(0); //lowercase e
		
		
		try {
			
		FileWriter fw = new FileWriter(this.outputFile);
		PrintWriter pw = new PrintWriter(fw);
		
		pw.printf("%s","<technical>");
		
		//pw.printf("\t%s","<string>", Strings.valueOf(guitarString).toString(), "</string>");
		
		for (int i = 2; i < arr.size() - 2; i++) {
			
			
			
		}
		
		
		pw.printf("%s","</technical>");
		}
		
		catch (IOException e) {
			e.printStackTrace();
			System.exit(69420);
		}
		/*
		 * must return something of the form
		 * 
		 * 	<technical>
		 * 		<string>x</string>			where 1 <= x <= 6 
		 * 		<fret>y</fret>				where 0 <= y <= 27
		 * 	</technical>
		 */
		
	}
	
	public ArrayList<Note> updateDuration(ArrayList<Note> notesList, Division division) {
		
		for (int i = 0; i < notesList.size(); i++) {
			notesList.get(i).setDuration((notesList.get(i).getDuration() - notesList.get(i + 1).getDuration())/(division.getDivisions()));
			
			if (notesList.get(i).getDuration() - notesList.get(i + 1).getDuration() == 0) {
				//open a chord tag
			}	
		}
		return notesList;
	}
	
	
	//public List<String> primitiveArrayToNoteArray(List<String> line1Array) {}
	/*	
	public getInfoFromArray(char[][] array) {
		
		Note n = new Note();
		
		
		for (int i = 6; i >= 0; i++)
			for(char j = 0; i <= 20; i++) {
				
				int a = Character.getNumericValue(array[j][i]);
				//if you encounter a note
				if(0 <= a &&  a <= 9) {
					n.getNotation().getTechnical().setFret(a);
					
				}
				
				
			}
		
	}
	*/


}