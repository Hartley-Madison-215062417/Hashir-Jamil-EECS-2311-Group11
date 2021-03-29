package guitar;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * This class is used to parse through the input file and return objects for marshalling
 */
public class Parser {
	
	private List<String> tabList; // a list of strings, each string is a line of the test guitar tab, the order of lines from top to bottom
	private File inputFile; // the input file that the user uploads into the application
	private char[][] tabCharMatrix; // a 2D char matrix that contains everything in the test file as is
	//private String outputFile; //not used at the moment
	private Part part = new Part(); // an Part object that contains all measures
	private scorePartwise scorepartwise = new scorePartwise(); // an object that contains the Part created, one per musicXML file
	private int hnum =1; 
	
	
	/*
	 * Default constructor that sets all the instance variables to null or default values
	 */
	public Parser() {
		
		tabList = null;
		inputFile = null;
		tabCharMatrix = null;
		part = null;
		scorepartwise = null;
		hnum = 1;
		
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
		
		this.inputFile = inputFile;
		tabList = new ArrayList<String>();
		this.readFile();
		this.tabCharMatrix = this.tabToCharMatrix(this.tabList);
		
	}
	
	
	/**
	 * Reads the input file given to the application and adds it line by line into tabList
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
	 * Converts a list of strings, each string representing a line of the tab file into 
	 * a 2D char array 
	 * @param str
	 * @return a 2D char array with all the measures in it
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
	/**
	 * returns the 2D char array with all measures in it
	 * @param p an object of parser class 
	 */
	public void setTabCharMatrix(Parser p) {
		this.tabCharMatrix = this.tabToCharMatrix(this.tabList);
	}

	public char[][] getTabCharMatrix() {
		return this.tabCharMatrix;
	}
	
	/*
	 * Returns an array list of measures that compose the entire tab music
	 * Later it will be iterated through to get information from each measure
	 * @param parsed
	 * @return an array list of 2D char array with each 2D arrays containing a single measure
	 */
	 public ArrayList<char[][]> measureSplitter (char[][] parsed) {
		
			ArrayList<char[][]> tmpArray = new ArrayList<char[][]>(); //an array list of all the measures to be returned later
			int newRow = 0; // no of rows 
			int newCol = 0; // no of columns 
			int counter = 0; 
			int newColEnd = 0;
			int prevColEnd = 0;
			int width = parsed[0].length; // width of the entire 2D array with all measures 
			
			//@Madison needs to implement a check for repeats
			
			for(int i = 0; i < width; i++) { // going through the entire 2D array of all measures, then i = 0 we are in the first column 
				
				//if(i != width - 1)
				
				//if(!(parsed[0][i] == '|' && parsed[0][i+1] == '|' )) {
				
				if(parsed[0][i] != '|') { //in the first row if any element is '|'
				}
				else { // for all other elements in 2D char array of all measures 
					counter++; 
					if(counter == 1) { //if counter is 1
						newCol = i+1; // new column = column number + 1
					}
					if(counter > 1) { // if counter is more than 1
						if(counter > 2) { // if counter is more than 2
							newCol ++; // new column = column number + 1
						}
						
						//System.out.println("prevColEnd: " + prevColEnd);
						//System.out.println("newColEnd " + newColEnd);
						
						prevColEnd = newColEnd;
						newColEnd = i; // new column end is the current column number 
						
						char[][] newMeasure = new char[6][newColEnd - prevColEnd-1
						                                  ]; //create a new measure with 6 rows and _____ columns 
						int tmpCol = 0; // counter
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
	 
	
	/*
	 * this method gets a 2d char array of one measure and creates note objects for each note in the 
	 * measure, adds it to the measure object and returns the measure object
	 * @param firstMeasure
	 * @return an object of Measure that contains the appropriate notes
	 */
	public Measure createMeasure(char[][] firstMeasure) {
		
		
		System.out.println("a measure is created");
		
		boolean chordExist = false;
		//the first measure does not include the vertical bars
		Measure m = new Measure(); //creating a new measure object, this will now be filled in
		m.setNumber(Measure.measureNumber); //setting the measure number using the static counter
		Measure.measureNumber++; //meausreNumber is updated after setting the current measure's number 
		
		//checking for repeats
		int timesRepeat = 0;
		
		//checking for beginning of repeat
		if (firstMeasure[2][0] == '*' && firstMeasure[3][0] == '*') { //if the '*' symbol is encountered in the 2nd or 3rd line of first column
			m.getBarline1().setRepeat(new Repeat());
			m.getBarline1().getRepeat().setDirection("forward");
		}
		
		//checking for end of repeat
		for(int i = 0; i < firstMeasure.length; i++) {
			for(int j =0; j < firstMeasure[0].length; j++) {
				if (i == 0 && firstMeasure[i+1][j] == '|') { //if the there is '|' in the 2nd column of first row 
					
					m.getBarline2().setRepeat(new Repeat());
					m.getBarline2().getRepeat().setDirection("backward");
					m.setDirection(new Direction());
					
				}
			}
		}
		
		//creating an attribute only for the first measure 
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
		
		//moving through the 2D char array that stores the measure we are focusing on, moving downwards staring with the first column
		for (int j = 0; j < firstMeasure[0].length; j++) 
			for (int i = 0; i < firstMeasure.length; i++) {
				Note n = new Note(); //creating an empty Note object that will be filled in
				
				if(firstMeasure[i][j] >= '0' && firstMeasure[i][j] <= '9' ) { //if the char is a number between 0 and 9 (the number indicates the fret)
					
				if ((firstMeasure[i][j-1] >= '0' &&  firstMeasure[i][j-1] <= '9') == false) { //to handle double digit fret numbers
						
						if(firstMeasure[i][j+1] >= '0' && firstMeasure[i][j+1] <= '9' ) {
							
							StringBuilder num = new StringBuilder();
							num.append(firstMeasure[i][j]);//adding the first digit
							num.append(firstMeasure[i][j+1]);//adding the second digit
							int fret = Integer.parseInt(num.toString());
							n.getNotations().getTechnical().setFret(fret);//setting the fret of the note		
							
							if(firstMeasure[i][j+2] =='h' || firstMeasure[i][j-1] =='h') { 
								if(firstMeasure[i][j-1] =='g') {
									Grace g = new Grace();
									n.setGrace(g);
								}
								createHammerOns(firstMeasure,i,j,n);
			
							}
							
							else if(firstMeasure[i][j+2] =='p' || firstMeasure[i][j-1] =='p') {
								if(firstMeasure[i][j-1] =='g') {
									Grace g = new Grace();
									n.setGrace(g);
								}
								createPullOffs(firstMeasure, i,j,n);
							}
							
							else if (firstMeasure[i][j+2] =='/' || firstMeasure[i][j-1] =='/') {
								if(firstMeasure[i][j-1] =='g') {
									Grace g = new Grace();
									n.setGrace(g);
								}
								createSlides(firstMeasure,i,j,n);
							}
							
						}

						
						else { // to handle single digit fret numbers 		
							n.getNotations().getTechnical().setFret(Character.getNumericValue(firstMeasure[i][j])); // getting the fret number 
							
							if(((i - 1) > -1) && (i + 1) < 6)
								if(Character.isDigit(firstMeasure[i-1][j]) || Character.isDigit(firstMeasure[i+1][j])) {
									n.setChord(new Chord());
									chordExist = true;
								}else if((i - 1) == -1 && Character.isDigit(firstMeasure[i+1][j])) {
									n.setChord(new Chord());
									chordExist = true;
								}
							
							
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
						
						//System.out.println("length of measure: " + firstMeasure[i].length + "j: " + j);
						
						n.setDuration(firstMeasure[i].length - j);
						
						n.setDefaultStep(n);
						
						if(n.getNotations().getTechnical().getFret()!=0) {
						n.updatePitch(n);
						}
						
						
					}
				m.getNotes().add(n);	
						
				}
				
			
				
			}
		//if(chordExist) {
			m.updateDuration(m);
		//	chordExist = false;
		//}
		
		//testing
//		for (Note n: m.getNotes()) {
//		System.out.print(n.getNotations().getTechnical().getFret());
//		System.out.print(" " +n.getNotations().getTechnical().getString());
//		System.out.println(" "+n.getDuration());
//		}
		//System.out.println("end");
		return m;
		
		}
	

	
/**
 * Creates slide objects if it detects an 's' in the measure while parsing 
 * through it	
 * @param firstMeasure the measure that is currently being created and updated
 * @param i
 * @param j
 * @param n 
 */
private void createSlides(char[][] firstMeasure, int i, int j, Note n) {
	
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
	
	//for 2 digit numbers...
		
	else if(firstMeasure[i][j+2] == '/' && firstMeasure[i][j-1] != '/') {
		Slide slide = new Slide();
		n.getNotations().setSlide(slide);
		
		n.getNotations().getSlide().setNumber(hnum);
		n.getNotations().getSlide().setType("start");
		
		}
		

	else if(firstMeasure[i][j-1] == '/' && firstMeasure[i][j+2] != '/'  ) {

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
	//for 2 digit numbers...

	else if(firstMeasure[i][j+2] == 'p' && firstMeasure[i][j-1] != 'p') {
		pullOff pnew = new pullOff();
		n.getNotations().getTechnical().setP(pnew);
		
		n.getNotations().getTechnical().getP().setNumber(hnum);
		n.getNotations().getTechnical().getP().setType("start");
		
		Slur slur = new Slur();
		n.getNotations().setSlur(slur);
		n.getNotations().getSlur().setNumber(hnum);
		n.getNotations().getSlur().setType("start");
		}
		
	

	
	
	else if(firstMeasure[i][j-1] == 'p' &&  firstMeasure[i][j+2] == 'p' ) {
		pullOff pnew = new pullOff();
		n.getNotations().getTechnical().setPnew(pnew);
		
		n.getNotations().getTechnical().getPnew().setNumber(hnum);
		n.getNotations().getTechnical().getPnew().setType("stop");
		
		pullOff p = new pullOff();
		n.getNotations().getTechnical().setP(p);
		
		n.getNotations().getTechnical().getP().setNumber(hnum);
		n.getNotations().getTechnical().getP().setType("start");
		

	}
	
	else if(firstMeasure[i][j-1] == 'p' && firstMeasure[i][j+2] != 'p'  ) {
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
	// for 2 digit numbers..
	else if(firstMeasure[i][j+2] == 'h' && firstMeasure[i][j-1] != 'h') {
		
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
	
	else if(firstMeasure[i][j-1] == 'h' &&  firstMeasure[i][j+2] == 'h' ) {
		hammerOns hnew = new hammerOns();
		n.getNotations().getTechnical().setHnew(hnew);
		
		n.getNotations().getTechnical().getHnew().setNumber(hnum);
		n.getNotations().getTechnical().getHnew().setType("stop");
		
		hammerOns h = new hammerOns();
		n.getNotations().getTechnical().setH(h);
		
		n.getNotations().getTechnical().getH().setNumber(hnum);
		n.getNotations().getTechnical().getH().setType("start");
	}
	
	else if(firstMeasure[i][j-1] == 'h' && firstMeasure[i][j+2] != 'h'  ) {
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
	
	/*
	 * Adds all the measures to a part 
	 * @param measures an arraylist of all the measures in the part
	 */
	public Part createMusicalPart(ArrayList<char[][]> measures) {
		
		for (char[][] measure : measures) {
			//System.out.println("Length of the measure " + measure[0].length);
			Measure m = createMeasure(measure);
			part.getPart().add(m);
		}
		return part;
		
	}
	/*
	 * Adds the part to scorePartwise object, only done once per music tab
	 */
	public scorePartwise createScore(Part p) {
		scorepartwise.getParts().add(p);
		return scorepartwise;
	}



		
	
}