package tab2mxl;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import drums.part;
import guitar.Part;

public class DetermineInstrument {
	
	
	List<String> tabList;
	File inputFile;
	char[][] tabCharMatrix;
	public String inst;
	ArrayList<char[][]> measureList = new ArrayList<char[][]>();
	Part partg;
	part partd;
	List<String> stringTune = new ArrayList<String>();
	List<String> drumType = new ArrayList<String>();
	
	
	public DetermineInstrument() {
		
	}
	
	public DetermineInstrument(File file) {
	//	System.out.println("Code has reached DetInst constructor. ");
		this.inputFile = file;
		this.tabList = new ArrayList<String>();
		readFile();
		this.tabCharMatrix = this.tabToCharMatrix(this.tabList);
		this.inst = determineInstrument(tabCharMatrix);
		this.measureList = GetParsed(this.inst);
	}
	
	public DetermineInstrument(String file) {
		//System.out.println("Code has reached DetInst constructor. ");
		this.inputFile = new File(file);
		this.tabList = new ArrayList<String>();
		readFile();
		this.tabCharMatrix = this.tabToCharMatrix(this.tabList);
		this.inst = determineInstrument(tabCharMatrix);
		this.measureList = GetParsed(this.inst);
	}
	
	
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
	
	
	public char[][] tabToCharMatrix(List<String> list) {

		int row = this.tabList.size();
		int col = this.tabList.get(0).length();		
		char[][] tabMatrix = new char[row][col];

		for (int i = 0; i < row; i++) {
			tabMatrix[i] = list.get(i).toCharArray();
		}
		return tabMatrix;
	}
	
	
	public String determineInstrument(char[][] tabMatrix) {
		ArrayList<char[][]> measureList = measureSplitter(tabMatrix);
		System.out.println("1.no of measures: " + measureList.size());		
		
		for(int i = 0; i < measureList.size(); i++) {
			//System.out.println("Code reached first for loop");
			char[][] len = measureList.get(i);
			int lennn = len[i].length;
			for(int j = 0; j < lennn; j++) {
				//System.out.println("Code reached second for loop, len.length = " + len.length);
				for(int k = 0; k < len.length; k++) {
					//System.out.println("Code reached third for loop");
					System.out.print(len[k][j]);
					if(len[k][j] == 'o' || len[k][j] == 'O' || len[k][j] == 'x' || len[k][j] == 'X' || len[k][j] == 'd' || len[k][j] == 'f') {
						System.out.println("returning drums");
						System.out.println("2.no of measures: " + measureList.size());	
						return "drums";
					}
					
				}
				System.out.println(" ");
				//System.out.println("length of measureList.get(i).length is " + measureList.get(i).length);
			}
		}
		for(int h = 0; h < measureList.size(); h++) {
			
			char[][] temp = measureList.get(h);
			if(temp.length >= 6) {
				System.out.println("returning guitar");
				return "guitar";
			}
			else if(temp.length <= 5 && temp.length > 0) {
				System.out.println("returning bass");
				return "bass";
			}
		}
		System.out.println("3.no of measures: " + measureList.size());	
		System.out.println("returning failsafe guitar");
		return "guitar";
	}
	
	
	public ArrayList<char[][]> GetParsed(String inst) {
		//ArrayList<char[][]> measureList = new ArrayList<char[][]>();
		if(inst.equals("drums")) {
			ParseDrums dr = new ParseDrums(inputFile);
			partd = dr.getPart();
			measureList = dr.tmp;
			return dr.tmp;
		}
		else if(inst.equals("guitar")) {
			ParseGuitar gr = new ParseGuitar(inputFile);
			partg=gr.getPart();
			measureList = gr.tmp;
			return gr.tmp;
		}
		else if(inst.equals("base")) {
			
		}
		else {
			return null;
		}
		System.out.println("3.no of measures: " + measureList.size());	
		return measureList;
	}
	
	
	
	
	public ArrayList<char[][]> measureSplitter (char[][] input) {
		System.out.println("entered measureSplitter");
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
		
		this.drumType = new ArrayList<String>();
		
		this.stringTune = new ArrayList<String>();
		boolean mesDurNeeded = false;
		boolean writeInGuitarTuning = false;
		boolean writeInDrumType = false;
		
		//@Madison needs to implement a check for repeats
		
		
		//System.out.println("initial length of char matrix: " + input[0].length);
		
		
		
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
						if(input[inputRow][inputCol+1] == '|') {
							inputCol = inputCol + 1;
						}
						else {
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
					}
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
				else if(input[inputRow][inputCol] == 'C') {
					if(input[inputRow][inputCol+1] == 'C') {
						drumType.add("CC");
						inputCol = inputCol + 2;
						bounds = true;
						mesDurNeeded = true;
						writeInDrumType = true;
					}
					if(input[inputRow][inputCol+1] == 'H') {
						drumType.add("CH");
						inputCol = inputCol + 2;
						bounds = true;
						mesDurNeeded = true;
						writeInDrumType = true;
					}
					if(input[inputRow][inputCol+1] == 'F') {
						drumType.add("CF");
						inputCol = inputCol + 2;
						bounds = true;
						mesDurNeeded = true;
						writeInDrumType = true;
					}
				}
				else if(input[inputRow][inputCol] == 'H') {
					if(input[inputRow][inputCol+1] == 'H') {
						drumType.add("HH");
						inputCol = inputCol + 2;
						bounds = true;
						mesDurNeeded = true;
						writeInDrumType = true;
					}
					if(input[inputRow][inputCol+1] == 'F') {
						drumType.add("HF");
						inputCol = inputCol + 2;
						bounds = true;
						mesDurNeeded = true;
						writeInDrumType = true;
					}
					if(input[inputRow][inputCol+1] == 'T') {
						drumType.add("HT");
						inputCol = inputCol + 2;
						bounds = true;
						mesDurNeeded = true;
						writeInDrumType = true;
					}
				}
				else if(input[inputRow][inputCol] == 'R') {
					if(input[inputRow][inputCol+1] == 'D') {
						drumType.add("RD");
						inputCol = inputCol + 2;
						bounds = true;
						mesDurNeeded = true;
						writeInDrumType = true;
					}
					else if(input[inputRow][inputCol+1] == 'C') {
						drumType.add("RC");
						inputCol = inputCol + 2;
						bounds = true;
						mesDurNeeded = true;
						writeInDrumType = true;
					}
				}
				else if(input[inputRow][inputCol] == 'S') {
					if(input[inputRow][inputCol+1] == 'N') {
						drumType.add("SN");
						inputCol = inputCol + 2;
						bounds = true;
						mesDurNeeded = true;
						writeInDrumType = true;
					}
					if(input[inputRow][inputCol+1] == 'C') {
						drumType.add("SC");
						inputCol = inputCol + 2;
						bounds = true;
						mesDurNeeded = true;
						writeInDrumType = true;
					}
					if(input[inputRow][inputCol+1] == 'H') {
						drumType.add("SH");
						inputCol = inputCol + 2;
						bounds = true;
						mesDurNeeded = true;
						writeInDrumType = true;
					}
				}
				else if(input[inputRow][inputCol] == 'T') {
					if(input[inputRow][inputCol+1] == '1') {
						drumType.add("T1");
						inputCol = inputCol + 2;
						bounds = true;
						mesDurNeeded = true;
						writeInDrumType = true;
					}
					else if(input[inputRow][inputCol+1] == '2') {
						drumType.add("T2");
						inputCol = inputCol + 2;
						bounds = true;
						mesDurNeeded = true;
						writeInDrumType = true;
					}
					else if(input[inputRow][inputCol+1] == '3') {
						drumType.add("T3");
						inputCol = inputCol + 2;
						bounds = true;
						mesDurNeeded = true;
						writeInDrumType = true;
					}
				}
				else if(input[inputRow][inputCol] == 'F') {
					if(input[inputRow][inputCol+1] == 'T') {
						drumType.add("FT");
						inputCol = inputCol + 2;
						bounds = true;
						mesDurNeeded = true;
						writeInDrumType = true;
					}
				}
				else if(input[inputRow][inputCol] == 'B') {
					if(input[inputRow][inputCol+1] == 'D') {
						drumType.add("BD");
						inputCol = inputCol + 2;
						bounds = true;
						mesDurNeeded = true;
						writeInDrumType = true;
					}
				}
				else if(input[inputRow][inputCol] == 'S') {
					if(input[inputRow][inputCol+1] == 'C') {
						drumType.add("SC");
						inputCol = inputCol + 2;
						bounds = true;
						mesDurNeeded = true;
						writeInDrumType = true;
					}
				}
				else if(input[inputRow][inputCol] == 'O') {
					if(input[inputRow][inputCol+1] == 'H') {
						drumType.add("BD");
						inputCol = inputCol + 2;
						bounds = true;
						mesDurNeeded = true;
						writeInDrumType = true;
					}
				}
				else if(input[inputRow][inputCol] == 'S') {
					if(input[inputRow][inputCol+1] == 'H') {
						drumType.add("SH");
						inputCol = inputCol + 2;
						bounds = true;
						mesDurNeeded = true;
						writeInDrumType = true;
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
					mesDurNeeded = false;
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
						
					
						if(mesDurNeeded == true) {
								for(int g = 1;input[inputRow][colCount+g] != '|';g++) {
									mesDur++;
								}
								mesDurNeeded = false;
							}
					
						newRow = inputRow;
				
					newMeasure = new char[rowCount][mesDur];
					
					int r = 0;
					int c = 0;
						
					while(rowCount > r) {
						
						while(input[inputRow][newCol] != '|') {
						//newMeasure[newRow][tmpCol] = parsed[newRow][newCol];
//							System.out.println("r: " + r + " c:" + c);
//							System.out.println("newRow: " + newRow + " newCol: " + newCol);
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
								newMeasure = new char[rowCount][mesDur];
							}
							mesDur = 0;
							mesDurNeeded = true;
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
		
		if(writeInDrumType == true) {
			int whatRow = drumType.size();
			char[][] firstie = tmpArray.get(0);
			System.out.println("whatRow = " + whatRow + " and firstie.length = " + firstie.length);
			if(whatRow < firstie.length) {
				
				int theRow = whatRow;
				int theCol = 0;
				while(whatRow < firstie.length) {
					
					
					
					if(input[theRow][theCol] == 'C') {
						if(input[theRow][theCol+1] == 'C') {
							drumType.add("CC");
							

						}
					}
					if(input[theRow][theCol] == 'H') {
						if(input[theRow][theCol+1] == 'H') {
							drumType.add("HH");
							

						}
					}
					if(input[theRow][theCol] == 'R') {
						if(input[theRow][theCol+1] == 'D') {
							drumType.add("RD");
							

						}
					}
					if(input[theRow][theCol] == 'S') {
						if(input[theRow][theCol+1] == 'N') {
							drumType.add("SN");
							

						}
					}
					if(input[theRow][theCol] == 'T') {
						if(input[theRow][theCol+1] == '1') {
							drumType.add("T1");
						

						}
						else if(input[theRow][theCol+1] == '2') {
							drumType.add("T2");
							

						}
						else if(input[theRow][theCol+1] == '3') {
							drumType.add("T3");
							

						}
					}
					if(input[theRow][theCol] == 'F') {
						if(input[theRow][theCol+1] == 'T') {
							drumType.add("FT");
							

						}
					}
					if(input[theRow][theCol] == 'B') {
						if(input[theRow][theCol+1] == 'D') {
							drumType.add("BD");
							

						}
					}
					if(input[theRow][theCol] == 'S') {
						if(input[theRow][theCol+1] == 'C') {
							drumType.add("SC");
							

						}
					}
					if(input[theRow][theCol] == 'O') {
						if(input[theRow][theCol+1] == 'H') {
							drumType.add("OH");
							

						}
					}
					if(input[theRow][theCol] == 'S') {
						if(input[theRow][theCol+1] == 'H') {
							drumType.add("SH");
							

						}
					}
					if(input[theRow][theCol] == 'C') {
						if(input[theRow][theCol+1] == 'H') {
							drumType.add("CH");
							

						}
					}
					if(input[theRow][theCol] == 'H') {
						if(input[theRow][theCol+1] == 'F') {
							drumType.add("HF");
							

						}
					}
					if(input[theRow][theCol] == 'S') {
						if(input[theRow][theCol+1] == 'D') {
							drumType.add("SD");
							

						}
					}
					if(input[theRow][theCol] == 'H') {
						if(input[theRow][theCol+1] == 'T') {
							drumType.add("HT");
							

						}
					}
					if(input[theRow][theCol] == 'M') {
						if(input[theRow][theCol+1] == 'T') {
							drumType.add("MT");
							

						}
					}
					
					theRow++;
					whatRow ++;
				}
			}
		}
		
		System.out.println("no of measures is = " + tmpArray.size());
		return tmpArray;
		
	} //end of the method

	public List<String> getTabList() {
		return tabList;
	}

	public void setTabList(List<String> tabList) {
		this.tabList = tabList;
	}

	public File getInputFile() {
		return inputFile;
	}

	public void setInputFile(File inputFile) {
		this.inputFile = inputFile;
	}

	public char[][] getTabCharMatrix() {
		return tabCharMatrix;
	}

	public void setTabCharMatrix(char[][] tabCharMatrix) {
		this.tabCharMatrix = tabCharMatrix;
	}

	public String getInst() {
		return inst;
	}

	public void setInst(String inst) {
		this.inst = inst;
	}

	public ArrayList<char[][]> getMeasureList() {
		return measureList;
	}

	public void setMeasureList(ArrayList<char[][]> measureList) {
		this.measureList = measureList;
	}

	public Part getPartg() {
		return partg;
	}

	public void setPartg(Part partg) {
		this.partg = partg;
	}

	public part getPartd() {
		return partd;
	}

	public void setPartd(part partd) {
		this.partd = partd;
	}

	public List<String> getStringTune() {
		return stringTune;
	}

	public void setStringTune(List<String> stringTune) {
		this.stringTune = stringTune;
	}

	public List<String> getDrumType() {
		return drumType;
	}

	public void setDrumType(List<String> drumType) {
		this.drumType = drumType;
	}
	
	
	
	
	
	

}
