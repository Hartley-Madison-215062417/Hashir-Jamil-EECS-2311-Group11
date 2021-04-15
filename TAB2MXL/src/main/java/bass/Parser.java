package bass;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
		
		int countTheRows = 0;
		boolean startedReading = false;
		for(int amntRow = 0; amntRow < input.length; amntRow++) {
			if(input[amntRow].length == 0) {
				if(countTheRows > 0) {
					startedReading = true;
				}
				if(startedReading == true) {
					break;
				}
			}
			else {
				countTheRows++;
			}
		}
		//System.out.println("countTheRows is " + countTheRows + " and input.length is " + input.length + " and input[1] is " + input[1].length);
		
		char[][] newMeasure = new char[countTheRows][input[0].length];

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
		int rowCount = countTheRows;
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
						newMeasure = new char[countTheRows][mesDur];
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