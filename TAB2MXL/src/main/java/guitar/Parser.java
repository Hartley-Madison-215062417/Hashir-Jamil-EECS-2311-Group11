package guitar;
//
//import java.util.regex.*;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//import java.io.*;
//
///**
// * 
// * @author Hashir Jamil, Abhirami Venugopal, Tommy Lam
// *
// */
//public class Parser {
//
//	//private int tabCharMatrix;
//	//private ArrayList<String> tab;
//
//	 List<String> tabList;
//
//	private File inputFile;
//	private char[][] tabCharMatrix;
//	private String outputFile;
//
//	/**
//	 * 
//	 * Default constructor
//	 * 
//	 */
//	public Parser() {
//
//	}
//
//	/**
//	 * Input File Specified Constructor
//	 * @param inFile, a file path containing a tab in txt form
//	 */
//	public Parser(String inFile) {
//		inputFile = new File(inFile);		
//		tabList = new ArrayList<String>();
//		this.readFile();
//		this.tabCharMatrix = this.tabToCharMatrix(this.tabList);
//	}
//	
//	public Parser(File inputFile) {
//		//file.getPath();
//		
//		this.inputFile = inputFile;
//		tabList = new ArrayList<String>();
//		this.readFile();
//		this.tabCharMatrix = this.tabToCharMatrix(this.tabList);
//		
//	}
//
//	/**
//	 * 
//	 */
//	private void readFile() {
//
//		Scanner sc = null; 
//		try {
//			sc = new Scanner(inputFile);	
//			while(sc.hasNextLine()){
//				tabList.add(sc.nextLine());
//			}      
//		}
//		catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}
//		finally {
//			sc.close();
//		}
//	}
//
//
//	public List<String> getTab() {
//		return this.tabList;
//	}
//
//	/**
//	 * 
//	 * @param str
//	 * @return
//	 */
//	public char[][] tabToCharMatrix(List<String> list) {
//
//		int row = this.tabList.size();
//		int col = this.tabList.get(0).length();		
//		char[][] tabMatrix = new char[row][col];
//
//		for (int i = 0; i < row; i++) {
//			tabMatrix[i] = list.get(i).toCharArray();
//		}
//		return tabMatrix;
//	}
//
//	public void setTabCharMatrix(Parser p) {
//		this.tabCharMatrix = this.tabToCharMatrix(this.tabList);
//	}
//
//	public char[][] getTabCharMatrix() {
//		return this.tabCharMatrix;
//	}
//
//	/**
//	 * 
//	 * @author Hashir Jamil, Abhirami Venugopal, Tommy Lam
//	 * This method converts a line of tabs into an ArrayList
//	 * the ArrayList can then be used to check the measure (modulo) and be used to generate the notes
//	 * @param str, a string to be converted into an ArrayList
//	 * @return the ArrayList
//	 */
//	public List<String> tabToMatrix(String str) {
//
//		String regexPattern = "^[A-Z|a-z][|]{1}[0-9[-][p|h|s|x|o|b|/]]+[|]$";
//		Pattern pattern = Pattern.compile(regexPattern);
//		Matcher matcher = pattern.matcher(str);
//
//		List<String> line1Array = new ArrayList<String>();
//
//		if (matcher.find()) {
//
//			for (int i = 0; i < str.length(); i++) {
//				line1Array.add(Character.toString(str.charAt(i)));
//			}
//		}
//
//		return line1Array;
//
//	}
//
//	
//	public String getOctave(String str) {
//		
//		
//		
//		return null;
//		
//	}
//	
//	/*
//	 * public int stringLetterToNumber(Strings str) {
//	 * 
//	 * switch (str) {
//	 * 
//	 * case e: return 1;
//	 * 
//	 * case B: return 2;
//	 * 
//	 * case G: return 3;
//	 * 
//	 * case D: return 4;
//	 * 
//	 * case A: return 5;
//	 * 
//	 * case E: return 6; } return 0; }
//	 */
//	
//	
//	public void setKey() { //Is needed here? Would work in attributes?
//		
//		
//	}
//	
//	
//	
//	public void primitiveToXML(List<String> arr) {
//		
//		
//		
//		String guitarString = arr.get(0); //lowercase e
//		
//		
//		try {
//			
//		FileWriter fw = new FileWriter(this.outputFile);
//		PrintWriter pw = new PrintWriter(fw);
//		
//		pw.printf("%s","<technical>");
//		
//		//pw.printf("\t%s","<string>", Strings.valueOf(guitarString).toString(), "</string>");
//		
//		for (int i = 2; i < arr.size() - 2; i++) {
//			
//			
//			
//		}
//		
//		
//		pw.printf("%s","</technical>");
//		}
//		
//		catch (IOException e) {
//			e.printStackTrace();
//			System.exit(69420);
//		}
//		/*
//		 * must return something of the form
//		 * 
//		 * 	<technical>
//		 * 		<string>x</string>			where 1 <= x <= 6 
//		 * 		<fret>y</fret>				where 0 <= y <= 27
//		 * 	</technical>
//		 */
//		
//	}
//	
//	/**
//	 * @author Hashir Jamil, Abhirami Venugopol
//	 * @param notesList
//	 * @param division
//	 * @return
//	 */
//	public ArrayList<Note> updateDuration(ArrayList<Note> notesList, Division division) {
//		
//		for (int i = 0; i < notesList.size(); i++) {
//			notesList.get(i).setDuration((notesList.get(i).getDuration() - notesList.get(i + 1).getDuration())/(division.getDivisions()));
//			
//			if (notesList.get(i).getDuration() - notesList.get(i + 1).getDuration() == 0) {
//				//open a chord tag
//			}	
//		}
//		return notesList;
//	}
//	
//	
//	//public List<String> primitiveArrayToNoteArray(List<String> line1Array) {}
//	/*	
//	public getInfoFromArray(char[][] array) {
//		
//		Note n = new Note();
//		
//		
//		for (int i = 6; i >= 0; i++)
//			for(char j = 0; i <= 20; i++) {
//				
//				int a = Character.getNumericValue(array[j][i]);
//				//if you encounter a note
//				if(0 <= a &&  a <= 9) {
//					n.getNotation().getTechnical().setFret(a);
//					
//				}
//				
//				
//			}
//		
//	}
//	*/
//	/**
//	 * 
//	 * @author Abhirami Venugopal
//	 * The method sets the step and octave of a note based on fret and string
//	 * 
//	 * @param Note n, a note whose step and octave needs to be updated
//	 * @return Note, whose step and octave has been updated
//	 */
//	public Note getPitch(Note n) {
//		/*
//		String dStep;
//		dStep = Character.toString(defaultStep);
//		//need to open alter tags whenever you encounter a sharp#
//		String [] originalData = {"C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B", "C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B"};
//		String[] relevantData = new String[24]; //specifically 24 because a guitar can have a maximum for 24 frets
//		int index;
//		
//		for (int i =1 ; i <= 12; i++) {
//			if(originalData[i] == dStep) {
//				index = i;
//				break;
//			}
//		}
//		
//		for (int i = j; i <=12;)
//		*/// this part is supposed to generate the right list of step options 
//		//automatically, but for now I'm making a database
//		
//		char defaultStep = n.getPitch().getStep();
//		
//		String[] rData = new String[24];
//				
//		if (n.getPitch().getStep() == 'E') {
//			
//		String[] relevantData = {"F", "F#", "G", "G#", "A", "A#", "B", "C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B", "C", "C#", "D", "D#", "E"};
//		rData = relevantData;	
//		
//		}else if (n.getPitch().getStep() == 'B') {
//			
//		String[] relevantData = {"C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B", "C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B"};
//		rData = relevantData;	
//		
//		}else if(n.getPitch().getStep() == 'G') {
//			
//		String[] relevantData = {"G#", "A", "A#", "B", "C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B", "C", "C#", "D", "D#", "E", "F", "F#", "G"};
//		rData = relevantData;	
//		
//		}else if(n.getPitch().getStep() == 'D') {
//			
//		String[] relevantData = {"D#", "E", "F", "F#", "G", "G#", "A", "A#", "B", "C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B", "C", "C#", "D"};
//		rData = relevantData;	
//		
//		}else if(n.getPitch().getStep() == 'A') {
//			
//		String[] relevantData = {"A#", "B", "C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B", "C", "C#", "D", "D#", "E","F", "F#", "G", "G#", "A"};
//		rData = relevantData;	
//		
//		}
//		
//		String actualStep = rData[n.getNotation().getTechnical().getFret()];
//		char[] aStep = actualStep.toCharArray();
//		if (aStep[1] == '#')
//			n.getPitch().setAlter(1);
//			
//		n.getPitch().setStep(aStep[0]); //actualStep is supposed to be char but we need to do something about the #
//		
//		if (defaultStep >= aStep[0])
//			n.getPitch().setOctave(n.getPitch().getOctave()+1);
//		
//		return n;
//		
//	}
//
//

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
//
//import tab2mxl.Division;
//import tab2mxl.Note;



//import tab2mxl.Note;

//import tab2mxl.Division;
//import tab2mxl.Note;
//import tab2mxl.Parser;
//

public class Parser {
	
	List<String> tabList; // the list has all of the lines in it, every line of text input 
	private File inputFile;
	private char[][] tabCharMatrix;
	//private String outputFile; //not used at the moment
	private Part part = new Part();
	private scorePartwise scorepartwise = new scorePartwise();
	int hnum =1;
	ArrayList<String> stringTune = new ArrayList<String>();
	
	
	/*
	 * Defualt contructor 
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
	
	public char[][] getFirstLine(char[][] old) {
		int col = this.tabList.get(0).length();	
		char[][] current = new char[6][col];
		
		for(int i=0; i<6; i++) {
			  for(int j=0; j<this.tabList.get(0).length(); j++) {
					  current[i][j]=old[i][j];
					  
				 
			  }}
		
		return current;
		
		}
	
	/*
	 * @Author: Madison Hartley
	 * DM me for questions about method below.
	 */
	
	
	public ArrayList<char[][]> measureSplitter (char[][] input) {
		char[][] newMeasure = new char[6][input[0].length];
		
		ArrayList<char[][]> tmpArray = new ArrayList<char[][]>(); //an array list of all the measures to be returned later
		int newRow = 0; // no of rows 
		int newCol = 0; // no of columns 
		int counter = 0; 
		int newColEnd = 0;
		int prevColEnd = 0;
	//	int width = parsed[0].length; // width of the entire 2D array with all measures 
		int inputCol = 0;
		int inputRow = 0;
		int ttlRow = input.length;
		boolean bounds = false;
		int mesDur = 0;
		boolean chk = false;
		int repeatCounter = 0;
		boolean multiMes = false;
		int rowCount = 6;
		int contLoop = 0;
		int theresTooManyVars = 0;
		this.stringTune = new ArrayList<String>();
		boolean mesDurNeeded = false;
		boolean writeInGuitarTuning = false;
		
		//@Madison needs to implement a check for repeats
		
		
		System.out.println("initial length of char matrix: " + input[0].length);
		if(input[0].length == 0) {
			inputRow++;
			while(input[inputRow].length == 0) {
				inputRow++;
			}
		}
		
		for(; inputRow < ttlRow; inputRow++) {
			if(multiMes == true) {
				theresTooManyVars = 1;
			}
			else {
				theresTooManyVars = 1;
			}
			mesDur = 0;
				//lol++;
			boolean bnd = (input[inputRow].length == 0);
			
			// going through the entire 2D array of all measures, then i = 0 we are in the first column 
			if(bnd == false) {
			
			//System.out.println(" On row " + i + ", the length is " + parsed[i].length + " and k is " + k);


			
				if(input[inputRow][inputCol] == '|') {
					chk = ((inputCol+1) <= input.length);
					if(chk == true) {
						for(int j = 0; j < input[inputRow].length; j++) {
							if(input[inputRow][j] == 'r' || input[inputRow][j] == 'R') {
								if(input[inputRow][j+1] == 'e' || input[inputRow][j+1] == 'E') {
									if(input[inputRow][j+2] == 'p' || input[inputRow][j+2] == 'P') {
										repeatCounter = 1;
										for(int h = 0; h < input[inputRow].length; h++) {
											if(input[inputRow][h] == '0' ) {
												
											}
											else if(input[inputRow][h] == '1' ) {
												repeatCounter = 1;
											}
											else if(input[inputRow][h] == '2'  ) {
												repeatCounter = 2;
											}
											else if(input[inputRow][h] == '3' ) {
												repeatCounter = 3;
											}
											else if(input[inputRow][h] == '4' ) {
												repeatCounter = 4;
											}
											else if(input[inputRow][h] == '5' ) {
												repeatCounter = 5;
											}
											else if(input[inputRow][h] == '6' ) {
												repeatCounter = 6;
											}
											else if(input[inputRow][h] == '7' ) {
												repeatCounter = 7;
											}
											else if(input[inputRow][h] == '8' ) {
												repeatCounter = 8;
											}
											else if(input[inputRow][h] == '9' ) {
												repeatCounter = 9;
											}
											
											
										}
									}
								}
							}
						}//end of repeat check
						
						counter ++;
						bounds = true;
						
					}

					
					if(chk == true) {
					for(int g = 1;input[inputRow][inputCol+g] != '|';g++) {
						mesDur++;
					}
					
					}
					if(counter >= 2) {
						newMeasure = new char[6][mesDur];
					}
				}
				else {
					if(input[inputRow][inputCol] == 'A') {
						
						
						if(input[inputRow][inputCol+1] == '#') {
							stringTune.add("A#");
							inputCol = inputCol + 2;
							bounds = true;
							mesDurNeeded = true;
							writeInGuitarTuning = true;
						}
						if(input[inputRow][inputCol+1] == 'b') {
							stringTune.add("Ab");
							inputCol = inputCol + 2;
							bounds = true;
							mesDurNeeded = true;
							writeInGuitarTuning = true;
						}
						else {
						stringTune.add("A");
						inputCol = inputCol + 1;
						bounds = true;
						mesDurNeeded = true;
						writeInGuitarTuning = true;
						}
						
					}
					if(input[inputRow][inputCol] == 'B') {
						
						
						if(input[inputRow][inputCol+1] == '#') {
							stringTune.add("B#");
							inputCol = inputCol + 2;
							bounds = true;
							mesDurNeeded = true;
							writeInGuitarTuning = true;
						}
						if(input[inputRow][inputCol+1] == 'b') {
							stringTune.add("Bb");
							inputCol = inputCol + 2;
							bounds = true;
							mesDurNeeded = true;
							writeInGuitarTuning = true;
						}
						else {
						stringTune.add("B");
						inputCol = inputCol + 1;
						bounds = true;
						mesDurNeeded = true;
						writeInGuitarTuning = true;
						}
						
					}
					if(input[inputRow][inputCol] == 'C') {
						
						
						if(input[inputRow][inputCol+1] == '#') {
							stringTune.add("C#");
							inputCol = inputCol + 2;
							bounds = true;
							mesDurNeeded = true;
							writeInGuitarTuning = true;
						}
						if(input[inputRow][inputCol+1] == 'b') {
							stringTune.add("Cb");
							inputCol = inputCol + 2;
							bounds = true;
							mesDurNeeded = true;
							writeInGuitarTuning = true;
						}
						else {
						stringTune.add("C");
						inputCol = inputCol + 1;
						bounds = true;
						mesDurNeeded = true;
						writeInGuitarTuning = true;
						}
					}
					if(input[inputRow][inputCol] == 'D') {
						
						
						if(input[inputRow][inputCol+1] == '#') {
							stringTune.add("D#");
							inputCol = inputCol + 2;
							bounds = true;
							mesDurNeeded = true;
							writeInGuitarTuning = true;
						}
						if(input[inputRow][inputCol+1] == 'b') {
							stringTune.add("Db");
							inputCol = inputCol + 2;
							bounds = true;
							mesDurNeeded = true;
							writeInGuitarTuning = true;
						}
						else {
						stringTune.add("D");
						inputCol = inputCol + 1;
						bounds = true;
						mesDurNeeded = true;
						writeInGuitarTuning = true;
						}
						
					}
					if(input[inputRow][inputCol] == 'E') {
						
						
						if(input[inputRow][inputCol+1] == '#') {
							stringTune.add("E#");
							inputCol = inputCol + 2;
							bounds = true;
							mesDurNeeded = true;
							writeInGuitarTuning = true;
						}
						if(input[inputRow][inputCol+1] == 'b') {
							stringTune.add("Eb");
							inputCol = inputCol + 2;
							bounds = true;
							mesDurNeeded = true;
							writeInGuitarTuning = true;
						}
						else {
						stringTune.add("E");
						inputCol = inputCol + 1;
						bounds = true;
						mesDurNeeded = true;
						writeInGuitarTuning = true;
						}
						
					}
					if(input[inputRow][inputCol] == 'F') {
						
						
						if(input[inputRow][inputCol+1] == '#') {
							stringTune.add("F#");
							inputCol = inputCol + 2;
							bounds = true;
							mesDurNeeded = true;
							writeInGuitarTuning = true;
						}
						if(input[inputRow][inputCol+1] == 'b') {
							stringTune.add("Fb");
							inputCol = inputCol + 2;
							bounds = true;
							mesDurNeeded = true;
							writeInGuitarTuning = true;
						}
						else {
						stringTune.add("F");
						inputCol = inputCol + 1;
						bounds = true;
						mesDurNeeded = true;
						writeInGuitarTuning = true;
						}
						
					}
					if(input[inputRow][inputCol] == 'G') {
						
						
						if(input[inputRow][inputCol+1] == '#') {
							stringTune.add("G#");
							inputCol = inputCol + 2;
							bounds = true;
							mesDurNeeded = true;
							writeInGuitarTuning = true;
						}
						if(input[inputRow][inputCol+1] == 'b') {
							stringTune.add("Gb");
							inputCol = inputCol + 2;
							bounds = true;
							mesDurNeeded = true;
							writeInGuitarTuning = true;
						}
						else {
						stringTune.add("G");
						inputCol = inputCol + 1;
						bounds = true;
						mesDurNeeded = true;
						writeInGuitarTuning = true;
						}
						
					}
					if(input[inputRow][inputCol] == 'a') {
						
						if(input[inputRow][inputCol+1] == '#') {
							stringTune.add("a#");
							inputCol = inputCol + 2;
							bounds = true;
							mesDurNeeded = true;
							writeInGuitarTuning = true;
						}
						if(input[inputRow][inputCol+1] == 'b') {
							stringTune.add("ab");
							inputCol = inputCol + 2;
							bounds = true;
							mesDurNeeded = true;
							writeInGuitarTuning = true;
						}
						else {
						stringTune.add("a");
						inputCol = inputCol + 1;
						bounds = true;
						mesDurNeeded = true;
						writeInGuitarTuning = true;
						}
						
					}
					if(input[inputRow][inputCol] == 'b') {
						
						
						if(input[inputRow][inputCol+1] == '#') {
							stringTune.add("b#");
							inputCol = inputCol + 2;
							bounds = true;
							mesDurNeeded = true;
							writeInGuitarTuning = true;
						}
						if(input[inputRow][inputCol+1] == 'b') {
							stringTune.add("bb");
							inputCol = inputCol + 2;
							bounds = true;
							mesDurNeeded = true;
							writeInGuitarTuning = true;
						}
						else {
						stringTune.add("b");
						inputCol = inputCol + 1;
						bounds = true;
						mesDurNeeded = true;
						writeInGuitarTuning = true;
						}
						
					}
					if(input[inputRow][inputCol] == 'c') {
						
						if(input[inputRow][inputCol+1] == '#') {
							stringTune.add("c#");
							inputCol = inputCol + 2;
							bounds = true;
							mesDurNeeded = true;
							writeInGuitarTuning = true;
						}
						if(input[inputRow][inputCol+1] == 'b') {
							stringTune.add("cb");
							inputCol = inputCol + 2;
							bounds = true;
							mesDurNeeded = true;
							writeInGuitarTuning = true;
						}
						else {
						stringTune.add("c");
						inputCol = inputCol + 1;
						bounds = true;
						mesDurNeeded = true;
						writeInGuitarTuning = true;
						}
						
						
					}
					if(input[inputRow][inputCol] == 'd') {
						
						if(input[inputRow][inputCol+1] == '#') {
							stringTune.add("d#");
							inputCol = inputCol + 2;
							bounds = true;
							mesDurNeeded = true;
							writeInGuitarTuning = true;
						}
						if(input[inputRow][inputCol+1] == 'b') {
							stringTune.add("db");
							inputCol = inputCol + 2;
							bounds = true;
							mesDurNeeded = true;
							writeInGuitarTuning = true;
						}
						else {
						stringTune.add("d");
						inputCol = inputCol + 1;
						bounds = true;
						mesDurNeeded = true;
						writeInGuitarTuning = true;
						}
						
						
					}
					if(input[inputRow][inputCol] == 'e') {
						if(input[inputRow][inputCol+1] == '#') {
							stringTune.add("e#");
							inputCol = inputCol + 2;
							bounds = true;
							mesDurNeeded = true;
							writeInGuitarTuning = true;
						}
						if(input[inputRow][inputCol+1] == 'b') {
							stringTune.add("eb");
							inputCol = inputCol + 2;
							bounds = true;
							mesDurNeeded = true;
							writeInGuitarTuning = true;
						}
						else {
						stringTune.add("e");
						inputCol = inputCol + 1;
						bounds = true;
						mesDurNeeded = true;
						writeInGuitarTuning = true;
						}
						
						
					}
					if(input[inputRow][inputCol] == 'f') {
						if(input[inputRow][inputCol+1] == '#') {
							stringTune.add("f#");
							inputCol = inputCol + 2;
							bounds = true;
							mesDurNeeded = true;
							writeInGuitarTuning = true;
						}
						if(input[inputRow][inputCol+1] == 'b') {
							stringTune.add("fb");
							inputCol = inputCol + 2;
							bounds = true;
							mesDurNeeded = true;
							writeInGuitarTuning = true;
						}
						else {
						stringTune.add("f");
						inputCol = inputCol + 1;
						bounds = true;
						mesDurNeeded = true;
						writeInGuitarTuning = true;
						}
						
					}
					if(input[inputRow][inputCol] == 'g') {
						if(input[inputRow][inputCol+1] == '#') {
							stringTune.add("g#");
							inputCol = inputCol + 2;
							bounds = true;
							mesDurNeeded = true;
							writeInGuitarTuning = true;
						}
						if(input[inputRow][inputCol+1] == 'b') {
							stringTune.add("gb");
							inputCol = inputCol + 2;
							bounds = true;
							mesDurNeeded = true;
							writeInGuitarTuning = true;
						}
						else {
						stringTune.add("g");
						//inputCol = inputCol + 1;
						bounds = true;
						mesDurNeeded = true;
						writeInGuitarTuning = true;
						}
						
					}
				}
				
				if(mesDurNeeded == true) {
					for(int g = 1;input[inputRow][inputCol+g] != '|';g++) {
						mesDur++;
					}
				}
				
				if(bounds == true) {
					
					//for(int measurePerRow = 0 ; measurePerRow < input.length ; measurePerRow ++) { 
						
						int colCount = inputCol+1;
						newCol = colCount;
						contLoop = 0;
						while(contLoop == 0) {
							contLoop = 0;
							
					
						/*
						 * this loop is created to make a new measure when more than one measure is paired
						 * together of a horizontal line, since the method stops at the second '|' at the 
						 * moment.
						 */
						
					
					
						newRow = inputRow;
				
					newMeasure = new char[rowCount][mesDur];
					
					int r = 0;
					int c = 0;
						
					while(rowCount > r) {
						
						while(input[inputRow][newCol] != '|') {
						//newMeasure[newRow][tmpCol] = parsed[newRow][newCol];
							newMeasure[r][c]=input[newRow][newCol];
							//System.out.print(parsed[i][newCol]);
							newCol++;
						
							c++;
						}
						colCount = newCol;
						chk = ((colCount+1) < input[inputRow].length);
						if(chk == true) {
							if(input[inputRow][colCount+1] == '|') {
								tmpArray.add(newMeasure);
								chk = ((inputCol+2) <= input[inputRow].length);
								if(chk ==  true) {
									if(input[inputRow][colCount+2] != '|') {
										mesDur = mesDur + 1;
										for(int t = 2;input[inputRow][colCount+t] != '|'; t++) {
											mesDur++;
										}
									}
								}
								else if(chk == false) {
									contLoop = -1;
								}
								newMeasure = new char[6][mesDur];
							}
						}
						
						r++;
					
					
					//System.out.println(" ");
						newRow++;
						if(multiMes == true) {
							newCol = theresTooManyVars;
						}
						else if(multiMes == false){
							newCol=inputCol+1; 
							
						}

						//fix this
						c = 0;
					}
					
					tmpArray.add(newMeasure);
					int teeeemp = input[inputRow].length;
					
					chk = ((colCount+1) < input[inputRow].length);
					if(chk == true) {
						theresTooManyVars = colCount + 1;
						newCol = colCount + 1;
						//colCount = newCol;
						multiMes = true;
						
					}
					else if((colCount+1) < input[inputRow].length){
						contLoop = -1;
					}
					else {
						contLoop = -1;
					}
					
					
//					chk = ((inputCol+1) <= input[inputRow].length);
//					if(chk == true) {
//						for(int nextCol = newCol+1; nextCol < input[inputRow].length; nextCol++) {
//							if(input[newRow][nextCol] != '|') {
//								newCol = nextCol;
//							}
//						}
//					}
//					else if(chk == false) {
//						contLoop = -1;
//					}
					
					
					
					//contLoop = -1;
					
				} //contLoop checkpoint
					inputRow = inputRow + 5;
					
				}
				
				}
			
			}
	
		
		if(writeInGuitarTuning == true) {
			int whatRow = stringTune.size();
			char[][] firstie = tmpArray.get(0);
			System.out.println("whatRow = " + whatRow + " and firstie.length = " + firstie.length);
			if(whatRow < firstie.length) {
				
				int theRow = whatRow;
				int theCol = 0;
				while(whatRow < firstie.length) {
					
					if(input[theRow][theCol] == 'A') {
						
						
						if(input[theRow][theCol+1] == '#') {
							this.stringTune.add("A#");
							inputCol = inputCol + 2;
							bounds = true;
							mesDurNeeded = true;
							writeInGuitarTuning = true;
						}
						if(input[theRow][theCol+1] == 'b') {
							this.stringTune.add("Ab");
							inputCol = inputCol + 2;
							bounds = true;
							mesDurNeeded = true;
							writeInGuitarTuning = true;
						}
						else {
						this.stringTune.add("A");
						inputCol = inputCol + 1;
						bounds = true;
						mesDurNeeded = true;
						writeInGuitarTuning = true;
						}
						
					}
					if(input[theRow][theCol] == 'B') {
						
						
						if(input[theRow][theCol+1] == '#') {
							this.stringTune.add("B#");
							inputCol = inputCol + 2;
							bounds = true;
							mesDurNeeded = true;
							writeInGuitarTuning = true;
						}
						if(input[theRow][theCol+1] == 'b') {
							this.stringTune.add("Bb");
							inputCol = inputCol + 2;
							bounds = true;
							mesDurNeeded = true;
							writeInGuitarTuning = true;
						}
						else {
							this.stringTune.add("B");
						inputCol = inputCol + 1;
						bounds = true;
						mesDurNeeded = true;
						writeInGuitarTuning = true;
						}
						
					}
					if(input[theRow][theCol] == 'C') {
						
						
						if(input[theRow][theCol+1] == '#') {
							this.stringTune.add("C#");
							inputCol = inputCol + 2;
							bounds = true;
							mesDurNeeded = true;
							writeInGuitarTuning = true;
						}
						if(input[theRow][theCol+1] == 'b') {
							this.stringTune.add("Cb");
							inputCol = inputCol + 2;
							bounds = true;
							mesDurNeeded = true;
							writeInGuitarTuning = true;
						}
						else {
							this.stringTune.add("C");
						inputCol = inputCol + 1;
						bounds = true;
						mesDurNeeded = true;
						writeInGuitarTuning = true;
						}
					}
					if(input[theRow][theCol] == 'D') {
						
						
						if(input[theRow][theCol+1] == '#') {
							this.stringTune.add("D#");
							inputCol = inputCol + 2;
							bounds = true;
							mesDurNeeded = true;
							writeInGuitarTuning = true;
						}
						if(input[theRow][theCol+1] == 'b') {
							this.stringTune.add("Db");
							inputCol = inputCol + 2;
							bounds = true;
							mesDurNeeded = true;
							writeInGuitarTuning = true;
						}
						else {
							this.stringTune.add("D");
						inputCol = inputCol + 1;
						bounds = true;
						mesDurNeeded = true;
						writeInGuitarTuning = true;
						}
						
					}
					if(input[theRow][theCol] == 'E') {
						
						
						if(input[theRow][theCol+1] == '#') {
							this.stringTune.add("E#");
							inputCol = inputCol + 2;
							bounds = true;
							mesDurNeeded = true;
							writeInGuitarTuning = true;
						}
						if(input[theRow][theCol+1] == 'b') {
							this.stringTune.add("Eb");
							inputCol = inputCol + 2;
							bounds = true;
							mesDurNeeded = true;
							writeInGuitarTuning = true;
						}
						else {
							this.stringTune.add("E");
						inputCol = inputCol + 1;
						bounds = true;
						mesDurNeeded = true;
						writeInGuitarTuning = true;
						}
						
					}
					if(input[theRow][theCol] == 'F') {
						
						
						if(input[theRow][theCol+1] == '#') {
							this.stringTune.add("F#");
							inputCol = inputCol + 2;
							bounds = true;
							mesDurNeeded = true;
							writeInGuitarTuning = true;
						}
						if(input[theRow][theCol+1] == 'b') {
							this.stringTune.add("Fb");
							inputCol = inputCol + 2;
							bounds = true;
							mesDurNeeded = true;
							writeInGuitarTuning = true;
						}
						else {
							this.stringTune.add("F");
						inputCol = inputCol + 1;
						bounds = true;
						mesDurNeeded = true;
						writeInGuitarTuning = true;
						}
						
					}
					if(input[theRow][theCol] == 'G') {
						
						
						if(input[theRow][theCol+1] == '#') {
							this.stringTune.add("G#");
							inputCol = inputCol + 2;
							bounds = true;
							mesDurNeeded = true;
							writeInGuitarTuning = true;
						}
						if(input[theRow][theCol+1] == 'b') {
							this.stringTune.add("Gb");
							inputCol = inputCol + 2;
							bounds = true;
							mesDurNeeded = true;
							writeInGuitarTuning = true;
						}
						else {
							this.stringTune.add("G");
						inputCol = inputCol + 1;
						bounds = true;
						mesDurNeeded = true;
						writeInGuitarTuning = true;
						}
						
					}
					if(input[theRow][theCol] == 'a') {
						
						if(input[theRow][theCol+1] == '#') {
							this.stringTune.add("a#");
							inputCol = inputCol + 2;
							bounds = true;
							mesDurNeeded = true;
							writeInGuitarTuning = true;
						}
						if(input[theRow][theCol+1] == 'b') {
							this.stringTune.add("ab");
							inputCol = inputCol + 2;
							bounds = true;
							mesDurNeeded = true;
							writeInGuitarTuning = true;
						}
						else {
							this.stringTune.add("a");
						inputCol = inputCol + 1;
						bounds = true;
						mesDurNeeded = true;
						writeInGuitarTuning = true;
						}
						
					}
					if(input[theRow][theCol] == 'b') {
						
						
						if(input[theRow][theCol+1] == '#') {
							this.stringTune.add("b#");
							inputCol = inputCol + 2;
							bounds = true;
							mesDurNeeded = true;
							writeInGuitarTuning = true;
						}
						if(input[theRow][theCol+1] == 'b') {
							this.stringTune.add("bb");
							inputCol = inputCol + 2;
							bounds = true;
							mesDurNeeded = true;
							writeInGuitarTuning = true;
						}
						else {
							this.stringTune.add("b");
						inputCol = inputCol + 1;
						bounds = true;
						mesDurNeeded = true;
						writeInGuitarTuning = true;
						}
						
					}
					if(input[theRow][theCol] == 'c') {
						
						if(input[theRow][theCol+1] == '#') {
							this.stringTune.add("c#");
							inputCol = inputCol + 2;
							bounds = true;
							mesDurNeeded = true;
							writeInGuitarTuning = true;
						}
						if(input[theRow][theCol+1] == 'b') {
							this.stringTune.add("cb");
							inputCol = inputCol + 2;
							bounds = true;
							mesDurNeeded = true;
							writeInGuitarTuning = true;
						}
						else {
							this.stringTune.add("c");
						inputCol = inputCol + 1;
						bounds = true;
						mesDurNeeded = true;
						writeInGuitarTuning = true;
						}
						
						
					}
					if(input[theRow][theCol] == 'd') {
						
						if(input[theRow][theCol+1] == '#') {
							this.stringTune.add("d#");
							inputCol = inputCol + 2;
							bounds = true;
							mesDurNeeded = true;
							writeInGuitarTuning = true;
						}
						if(input[theRow][theCol+1] == 'b') {
							this.stringTune.add("db");
							inputCol = inputCol + 2;
							bounds = true;
							mesDurNeeded = true;
							writeInGuitarTuning = true;
						}
						else {
							this.stringTune.add("d");
						inputCol = inputCol + 1;
						bounds = true;
						mesDurNeeded = true;
						writeInGuitarTuning = true;
						}
						
						
					}
					if(input[theRow][theCol] == 'e') {
						if(input[theRow][theCol+1] == '#') {
							this.stringTune.add("e#");
							inputCol = inputCol + 2;
							bounds = true;
							mesDurNeeded = true;
							writeInGuitarTuning = true;
						}
						if(input[theRow][theCol+1] == 'b') {
							this.stringTune.add("eb");
							inputCol = inputCol + 2;
							bounds = true;
							mesDurNeeded = true;
							writeInGuitarTuning = true;
						}
						else {
							this.stringTune.add("e");
						inputCol = inputCol + 1;
						bounds = true;
						mesDurNeeded = true;
						writeInGuitarTuning = true;
						}
						
						
					}
					if(input[theRow][theCol] == 'f') {
						if(input[theRow][theCol+1] == '#') {
							this.stringTune.add("f#");
							inputCol = inputCol + 2;
							bounds = true;
							mesDurNeeded = true;
							writeInGuitarTuning = true;
						}
						if(input[theRow][theCol+1] == 'b') {
							this.stringTune.add("fb");
							inputCol = inputCol + 2;
							bounds = true;
							mesDurNeeded = true;
							writeInGuitarTuning = true;
						}
						else {
							this.stringTune.add("f");
						inputCol = inputCol + 1;
						bounds = true;
						mesDurNeeded = true;
						writeInGuitarTuning = true;
						}
						
					}
					if(input[theRow][theCol] == 'g') {
						if(input[theRow][theCol+1] == '#') {
							this.stringTune.add("g#");
							inputCol = inputCol + 2;
							bounds = true;
							mesDurNeeded = true;
							writeInGuitarTuning = true;
						}
						if(input[theRow][theCol+1] == 'b') {
							this.stringTune.add("gb");
							inputCol = inputCol + 2;
							bounds = true;
							mesDurNeeded = true;
							writeInGuitarTuning = true;
						}
						else {
							this.stringTune.add("g");
						inputCol = inputCol + 1;
						bounds = true;
						mesDurNeeded = true;
						writeInGuitarTuning = true;
						}
						
					}

					
					theRow++;
					whatRow ++;
				}
			}
		}
		
		
		return tmpArray;
		
	} //end of the method
	
	
	 

	
	/*
	 * this method gets a 2d char array of one measure
	 * and creates note objects for each note in the 
	 * measure, adds it to the measure object and returns 
	 * the measure object
	 */
	public Measure createMeasure(char[][] firstMeasure) {
		
		
		//the first measure does not include the vertical bars
		Measure m = new Measure();
		m.setNumber(Measure.measureNumber);
		
		if (firstMeasure[2][0] == '*' && firstMeasure[3][0] == '*') {
			m.getBarline1().setRepeat(new Repeat());
			m.getBarline1().getRepeat().setDirection("forward");
		}
		
		
/*	
		if(Measure.measureNumber == 3) {
		System.out.println("TESTING");
		
		for(int i = 0; i < firstMeasure.length; i++) {
			for(int j =0; j < firstMeasure[0].length; j++) {
				if(firstMeasure[i][j] == ' ') {
					System.out.print('a');
				}
				
				System.out.print(firstMeasure[i][j]+ " ");
			}
			System.out.println();
		}
		
		System.out.println(firstMeasure[2][18]);
		System.out.println("TESTING");
		}
	*/
		
		System.out.println("here?");
		for(int i = 0; i < firstMeasure.length; i++) {
			for(int j =0; j < firstMeasure[0].length; j++) {
				if (i == 0 && firstMeasure[i+1][j] == '|') {
					System.out.println("Hello");
					m.getBarline2().setRepeat(new Repeat());
					m.getBarline2().getRepeat().setDirection("backward");
				}
			}
		}
		
		
		
		
			Key k = new Key(0);
			Time t = new Time(4, 4);
			Clef c = new Clef("TAB", 5);
			StaffDetails sd = new StaffDetails();
			m.attributes = new Attributes();
			m.attributes.setKey(k);
			m.attributes.setTime(t);
			m.attributes.setClef(c);
			m.attributes.setSd(sd);
									

		
		Measure.measureNumber++;
		
		
		
		for (int j = 0; j < firstMeasure[0].length; j++) 
			for (int i = 0; i < firstMeasure.length; i++) {
				Note n = new Note();
				
				if(firstMeasure[i][j] >= '0' && firstMeasure[i][j] <= '9' ) {
					
					
					
				if ((firstMeasure[i][j-1] >= '0' &&  firstMeasure[i][j-1] <= '9') == false) { //if double digit
						//setting fret
						if(firstMeasure[i][j+1] >= '0' && firstMeasure[i][j+1] <= '9' ) {
							StringBuilder num = new StringBuilder();
							num.append(firstMeasure[i][j]);
							num.append(firstMeasure[i][j+1]);
							int fret = Integer.parseInt(num.toString());
							n.getNotations().getTechnical().setFret(fret);							
						
						if(firstMeasure[i][j+2] =='h' || firstMeasure[i][j-1] =='h') {
							if(firstMeasure[i][j-1] =='g') {
								Grace g = new Grace();
								n.setGrace(g);
							}
							createHammerOns(firstMeasure,i,j+1,n);
		
						}
						else if(firstMeasure[i][j+2] =='p' || firstMeasure[i][j-1] =='p') {
							if(firstMeasure[i][j-1] =='g') {
								Grace g = new Grace();
								n.setGrace(g);
							}
							createPullOffs(firstMeasure, i,j+1,n);
						}
						
						else if (firstMeasure[i][j+2] =='/' || firstMeasure[i][j-1] =='/') {
							if(firstMeasure[i][j-1] =='g') {
								Grace g = new Grace();
								n.setGrace(g);
							}
							createSlides(firstMeasure,i,j+1,n);
						}
						}

						
						else {				
							n.getNotations().getTechnical().setFret(Character.getNumericValue(firstMeasure[i][j]));
							
							if(firstMeasure[i][j+1] =='h' || firstMeasure[i][j-1] =='h') {
								if(firstMeasure[i][j-1] =='g') {
									Grace g = new Grace();
									n.setGrace(g);
								}
								createHammerOns(firstMeasure,i,j,n);
			
							}
							
							else if(firstMeasure[i][j+1] =='p' || firstMeasure[i][j-1] =='p') {
								if(firstMeasure[i][j-1] =='g') {
									Grace g = new Grace();
									n.setGrace(g);
								}
								createPullOffs(firstMeasure, i,j,n);
							}
							
							else if (firstMeasure[i][j+1] =='/' || firstMeasure[i][j-1] =='/') {
								if(firstMeasure[i][j-1] =='g') {
									Grace g = new Grace();
									n.setGrace(g);
								}
								createSlides(firstMeasure,i,j,n);
							}
					
						
						
						}
						//setting string
						n.getNotations().getTechnical().setString(i+1);
						
						//setting wrong duration
//						int duration = 0;
//						for(int k = j; k < firstMeasure[0].length; k++) {
//							duration++;
//							n.setDuration(duration);
//						}
						n.setDuration(firstMeasure[0].length - j);
						//System.out.println(firstMeasure[0].length);
						
						n.setDefaultStep(n);
						
						if(n.getNotations().getTechnical().getFret()!=0) {
						n.updatePitch(n);
						}
						
						
					}
				m.getNotes().add(n);	
						
				}
				
			
				
			}
		m.updateDuration(m);
		
		//testing
//		for (Note n: m.getNotes()) {
//		System.out.print(n.getNotations().getTechnical().getFret());
//		System.out.print(" " +n.getNotations().getTechnical().getString());
//		System.out.println(" "+n.getDuration());
//		}
		//System.out.println("end");
		return m;
		
		}
	

	
	
private void createSlides(char[][] firstMeasure, int i, int j, Note n) {
	//for single digits
	if(firstMeasure[i][j+1] == '/' && firstMeasure[i][j-1] != '/') {
		Slide slide = new Slide();
		n.getNotations().setSlide(slide);
		
		n.getNotations().getSlide().setNumber(hnum);
		n.getNotations().getSlide().setType("start");
		
		}
	
	else if(firstMeasure[i][j-1] == '/' && firstMeasure[i][j+1] != '/'  ) {
		Slide slide = new Slide();
		n.getNotations().setSlide(slide);
		
		n.getNotations().getSlide().setNumber(hnum);
		n.getNotations().getSlide().setType("stop");
		}
		
	
		
	}


private void createPullOffs(char[][] firstMeasure, int i, int j, Note n) {
	System.out.println(firstMeasure[i][j+1]+ " "+firstMeasure[i][j-1]);

	if(firstMeasure[i][j+1] == 'p' && firstMeasure[i][j-1] != 'p') {
		pullOff pnew = new pullOff();
		n.getNotations().getTechnical().setP(pnew);
		
		n.getNotations().getTechnical().getP().setNumber(hnum);
		n.getNotations().getTechnical().getP().setType("start");
		
		Slur slur = new Slur();
		n.getNotations().setSlur(slur);
		n.getNotations().getSlur().setNumber(hnum);
		n.getNotations().getSlur().setType("start");
		}
		
	
	else if(firstMeasure[i][j-1] == 'p' &&  firstMeasure[i][j+1] == 'p' ) {
		pullOff pnew = new pullOff();
		n.getNotations().getTechnical().setPnew(pnew);
		
		n.getNotations().getTechnical().getPnew().setNumber(hnum);
		n.getNotations().getTechnical().getPnew().setType("stop");
		
		pullOff p = new pullOff();
		n.getNotations().getTechnical().setP(p);
		
		n.getNotations().getTechnical().getP().setNumber(hnum);
		n.getNotations().getTechnical().getP().setType("start");
		

	}
	
	else if(firstMeasure[i][j-1] == 'p' && firstMeasure[i][j+1] != 'p'  ) {
		pullOff pnew = new pullOff();
		n.getNotations().getTechnical().setP(pnew);
		
		n.getNotations().getTechnical().getP().setNumber(hnum);
		n.getNotations().getTechnical().getP().setType("stop");
		
		Slur slur = new Slur();
		n.getNotations().setSlur(slur);
		n.getNotations().getSlur().setNumber(hnum);
		n.getNotations().getSlur().setType("stop");
		n.getNotations().getSlur().setPlacement(null);
		}
	
	}


private void createHammerOns(char[][] firstMeasure, int i, int j,Note n) {
	// for single digits
	if(firstMeasure[i][j+1] == 'h' && firstMeasure[i][j-1] != 'h') {
		
		//calculateHnum(firstMeasure,j+1);
		hammerOns hnew = new hammerOns();
		n.getNotations().getTechnical().setH(hnew);
		
		n.getNotations().getTechnical().getH().setNumber(hnum);
		n.getNotations().getTechnical().getH().setType("start");
		
		Slur slur = new Slur();
		n.getNotations().setSlur(slur);
		n.getNotations().getSlur().setNumber(hnum);
		n.getNotations().getSlur().setType("start");
	
		
		}
	
	else if(firstMeasure[i][j-1] == 'h' &&  firstMeasure[i][j+1] == 'h' ) {
		hammerOns hnew = new hammerOns();
		n.getNotations().getTechnical().setHnew(hnew);
		
		n.getNotations().getTechnical().getHnew().setNumber(hnum);
		n.getNotations().getTechnical().getHnew().setType("stop");
		
		hammerOns h = new hammerOns();
		n.getNotations().getTechnical().setH(h);
		
		n.getNotations().getTechnical().getH().setNumber(hnum);
		n.getNotations().getTechnical().getH().setType("start");
	}
	
	else if(firstMeasure[i][j-1] == 'h' && firstMeasure[i][j+1] != 'h'  ) {
		hammerOns hnew = new hammerOns();
		n.getNotations().getTechnical().setH(hnew);
		
		n.getNotations().getTechnical().getH().setNumber(hnum);
		n.getNotations().getTechnical().getH().setType("stop");
		
		Slur slur = new Slur();
		n.getNotations().setSlur(slur);
		n.getNotations().getSlur().setNumber(hnum);
		n.getNotations().getSlur().setType("stop");
		n.getNotations().getSlur().setPlacement(null);
		
		
	}

	
	
		
	}


private void calculateHnum(char[][] firstMeasure, int j) {
	for (int i=0;i<6;i++){
	if (firstMeasure[i][j] == 'h') {
		
		//cannot finish this without chords
		
	}
	}
	
		
	}


//	public ArrayList<Integer> createChordArray(List<Note> notes){
//		ArrayList<Integer> chordArray = new ArrayList<>();
//		for(int i =0; i<notes.size();i++) {
//			Note n = notes.get(i);
//			int current =n.getDuration();
//			int next = notes.get(i+1).getDuration();
//			
//			if(current == next){
//				chordArray.add(i);
//				
//			}
//			
//			
//			
//		}
//		return chordArray;
//		
//	}
	
	
	
	public Part createMusicalPart(ArrayList<char[][]> measures) {
		
		for (char[][] measure : measures) {
			Measure m = createMeasure(measure);
			part.getPart().add(m);
		}
		return part;
		
	}
	
	public scorePartwise createScore(Part p) {
		scorepartwise.getParts().add(p);
		return scorepartwise;
	}



		
	
}