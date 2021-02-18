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
	//method started by Abby, Tommy is continuing it 
	/* 
	public List<String> primitiveArrayToNoteArray(List<String> line1Array) {}
		
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
	
	/**
	 * 
	 * @author Abhirami Venugopal
	 * The method sets the step and octave of a note based on fret and string
	 * 
	 * @param Note n, a note whose step and octave needs to be updated
	 * @return Note, whose step and octave has been updated
	 */
	public Note getPitch(Note n) {
		/*
		String dStep;
		dStep = Character.toString(defaultStep);
		//need to open alter tags whenever you encounter a sharp#
		String [] originalData = {"C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B", "C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B"};
		String[] relevantData = new String[24]; //specifically 24 because a guitar can have a maximum for 24 frets
		int index;
		
		for (int i =1 ; i <= 12; i++) {
			if(originalData[i] == dStep) {
				index = i;
				break;
			}
		}
		
		for (int i = j; i <=12;)
		*/// this part is supposed to generate the right list of step options 
		//automatically, but for now I'm making a database
		
		char defaultStep = n.getPitch().getStep();
		
		String[] rData = new String[24];
				
		if (n.getPitch().getStep() == 'E') {
			
		String[] relevantData = {"F", "F#", "G", "G#", "A", "A#", "B", "C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B", "C", "C#", "D", "D#", "E"};
		rData = relevantData;	
		
		}else if (n.getPitch().getStep() == 'B') {
			
		String[] relevantData = {"C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B", "C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B"};
		rData = relevantData;	
		
		}else if(n.getPitch().getStep() == 'G') {
			
		String[] relevantData = {"G#", "A", "A#", "B", "C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B", "C", "C#", "D", "D#", "E", "F", "F#", "G"};
		rData = relevantData;	
		
		}else if(n.getPitch().getStep() == 'D') {
			
		String[] relevantData = {"D#", "E", "F", "F#", "G", "G#", "A", "A#", "B", "C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B", "C", "C#", "D"};
		rData = relevantData;	
		
		}else if(n.getPitch().getStep() == 'A') {
			
		String[] relevantData = {"A#", "B", "C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B", "C", "C#", "D", "D#", "E","F", "F#", "G", "G#", "A"};
		rData = relevantData;	
		
		}
		
		String actualStep = rData[n.getNotation().getTechnical().getFret()];
		char[] aStep = actualStep.toCharArray();
		if (aStep[1] == '#')
			n.getPitch().setAlter(1);
			
		n.getPitch().setStep(aStep[0]); //actualStep is supposed to be char but we need to do something about the #
		
		if (defaultStep >= aStep[0])
			n.getPitch().setOctave(n.getPitch().getOctave()+1);
		
		return n;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


}