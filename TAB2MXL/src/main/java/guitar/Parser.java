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
	
	 public ArrayList<char[][]> measureSplitter (char[][] parsed) {
		
			ArrayList<char[][]> tmpArray = new ArrayList<char[][]>();
			int newRow = 0;
			int newCol = 0;
			int counter = 0;
			int newColEnd = 0;
			int width = parsed[0].length;
			
			/*
			 * implement a CHECK for repeats
			 */
			
			
			
			for(int i = 0; i < width; i++) {
				if(parsed[0][i] != '|') {
				}
				else {
					counter++;
					if(counter == 1) {
						newCol = i+1;
					}
					if(counter > 1) {
						if(counter > 2) {
							newCol ++;
						}
						newColEnd = i;
						char[][] newMeasure = new char[6][newColEnd];
						int tmpCol = 0;
						while(newCol < newColEnd) {
							for(newRow = 0; newRow < 6; newRow++) {
								newMeasure[newRow][tmpCol] = parsed[newRow][newCol];
							}
							
							tmpCol++;
							newCol++;
						}
						
						tmpArray.add(newMeasure);
						
					}
				}

			}

		return tmpArray;
	}
	
	 


	
	
	public char[][] getFirstMeasure(char[][] old) {
		int totalmeasures = 2;						// hard coded for now. this method would work great if we knew 
													// total number of measures
	
		int col = this.tabList.get(0).length()/totalmeasures;
		//int col = this.tabList.get(0).length();
		char[][] current = new char[6][col];
		
		for(int i=0; i<6; i++) {
			  for(int j=1; j< col; j++) {
					  current[i][j]=old[i][j];
				  
				  
			  }}
		
		return current;
		
		}
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
			m.getBarline().getRepeat().setDirection("forward");
		}
		
		
		if (m.number == 1) {
			Key k = new Key(0);
			Time t = new Time(4, 4);
			Clef c = new Clef("TAB", 5);
			StaffDetails sd = new StaffDetails();
			m.attributes = new Attributes();
			m.attributes.setKey(k);
			m.attributes.setTime(t);
			m.attributes.setClef(c);
			m.attributes.setSd(sd);
									
		}
		
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
	
	if(firstMeasure[i][j+1] == '/' && firstMeasure[i][j-1] != '/') {
		Slide slide = new Slide();
		n.getNotations().setSlide(slide);
		
		n.getNotations().getSlide().setNumber(hnum);
		n.getNotations().getSlide().setType("start");
		
		}
		
	

	
//	
//	else if(firstMeasure[i][j-1] == '/' &&  firstMeasure[i][j+1] == '/' ) {
//		pullOff pnew = new pullOff();
//		n.getNotations().getTechnical().setPnew(pnew);
//		
//		n.getNotations().getTechnical().getPnew().setNumber(hnum);
//		n.getNotations().getTechnical().getPnew().setType("stop");
//		
//		Slide slide = new Slide();
//		n.getNotations().setSlide(slide);
//		
//		n.getNotations().getSlide().setNumber(hnum);
//		n.getNotations().getSlide().setType("start");
//
//	}
//	
	


	else if(firstMeasure[i][j-1] == '/' && firstMeasure[i][j+1] != '/'  ) {
		Slide slide = new Slide();
		n.getNotations().setSlide(slide);
		
		n.getNotations().getSlide().setNumber(hnum);
		n.getNotations().getSlide().setType("stop");
		}
		
		
		
	}


private void createPullOffs(char[][] firstMeasure, int i, int j, Note n) {

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