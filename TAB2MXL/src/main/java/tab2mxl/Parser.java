package tab2mxl;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
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
	private String outputFile; //not used at the moment

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

	/**
	 * @author Abhirami & Niharika
	 * @param old
	 * @return
	 */
	public char[][] getFirstLine(char[][] old) {
		int col = this.tabList.get(0).length();	
		char[][] current = new char[6][col];

		for(int i=0; i<6; i++) {
			for(int j=0; j<this.tabList.get(0).length(); j++) {
				current[i][j]=old[i][j];


			}}

		return current;

	}

	/**
	 * Private helper method to compute number of measures in a line of measures
	 * @param arr
	 * @return
	 */
	private static int computeNumberOfMeasures(char[][] arr) {
		
		int n = -1; //negative 1 because total number of measures in a line is number of occurrences of '|' minus one
		for (int i = 0; i < arr[0].length; i++) {
			if (arr[0][i] == '|') {
				n++;
			}
		}
		return n;
	}

	/**
	 * @author Abhirami & Niharika
	 * This method is supposed to return all the measures that are found in one grouping (one horizontal stream)
	 * @param old - a set of measures; 2d array that is guaranteed to have n rows, where n is the number of lines for the instrument
	 * @return
	 */
	public HashMap<Integer, char[][]> getFirstMeasure(char[][] old) {
		
		//possible exception for more than n rows could be handled
		
		HashMap<Integer, char[][]> measures = new HashMap<Integer, char[][]>();
		int totalmeasures = Parser.computeNumberOfMeasures(old);
		
		int col = this.tabList.get(0).length()/totalmeasures;
		//int col = this.tabList.get(0).length();
		char[][] current = new char[6][col];

		for(int i=0; i<6; i++) {
			for(int j=1; j< col; j++) {
				current[i][j]=old[i][j];
			}
		}
		return measures;
	}
	
	/*
	 * @author Abhirami & Niharika
	 * this method gets a 2d char array of one measure
	 * and creates note objects for each note in the 
	 * measure, adds it to the measure object and returns 
	 * the measure object
	 */
	public Measure CreateMeasure(char[][] firstMeasure) {
		//the first measure does not include the vertical bars
		Measure m = new Measure();

		for (int j = 0; j < firstMeasure[0].length; j++) 
			for (int i = 0; i < firstMeasure.length; i++) {
				Note n = new Note();

				if(firstMeasure[i][j] >= '0' && firstMeasure[i][j] <= '9' ) {

					if ((firstMeasure[i][j-1] >= '0' &&  firstMeasure[i][j-1] <= '9') == false) {
						//setting fret
						if(firstMeasure[i][j+1] >= '0' && firstMeasure[i][j+1] <= '9' ) {
							StringBuilder num = new StringBuilder();
							num.append(firstMeasure[i][j]);
							num.append(firstMeasure[i][j+1]);
							int fret = Integer.parseInt(num.toString());
							n.getNotations().getTechnical().setFret(fret);							
						}else {				
							n.getNotations().getTechnical().setFret(Character.getNumericValue(firstMeasure[i][j]));
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
						System.out.println(firstMeasure[0].length);




					}
					m.getNotes().add(n);	

				}



			}
		//testing
		for (Note n: m.getNotes()) {
			System.out.print(n.getNotations().getTechnical().getFret());
			System.out.print(" " +n.getNotations().getTechnical().getString());
			System.out.println(" "+n.getDuration());
		}

		return m;

	}

	/**
	 * @author Abhirami & Niharika
	 * @param m
	 */
	public void updateDuration(Measure m) {

		for (int i = 0; i < m.notes.size(); i++) {
			if(i != m.notes.size()-1) {
				System.out.println((m.notes.get(i).getDuration() - m.notes.get(i + 1).getDuration()));
				m.notes.get(i).setDuration((m.notes.get(i).getDuration() - m.notes.get(i + 1).getDuration())/(2));

				if (m.notes.get(i).getDuration() - m.notes.get(i + 1).getDuration() == 0) {
					List<Integer> indexArray = new ArrayList<Integer>();//considering that guitar will only have 6 strings
					indexArray.add(i);
				}	
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


}