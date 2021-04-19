package drums;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class Parser {
	
	private List<String> tabList;
	private File inputFile;
	private char[][] tabCharMatrix;
	private part part = new part();
	private ScorePartwise scorepartwise = new ScorePartwise();
	private int hnum = 1;
	List<String> drumType = new ArrayList<String>();
	
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

	public part getPart() {
		return part;
	}

	public void setPart(part part) {
		this.part = part;
	}

	public ScorePartwise getScorepartwise() {
		return scorepartwise;
	}

	public void setScorepartwise(ScorePartwise scorepartwise) {
		this.scorepartwise = scorepartwise;
	}

	public int getHnum() {
		return hnum;
	}

	public void setHnum(int hnum) {
		this.hnum = hnum;
	}

	public List<String> getDrumType() {
		return drumType;
	}

	public void setDrumType(List<String> drumType) {
		this.drumType = drumType;
	}

	public void setTabCharMatrix(char[][] tabCharMatrix) {
		this.tabCharMatrix = tabCharMatrix;
	}

	public Parser() {
		
	}
	
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
	
	private void readFile() {
		Scanner sc = null;
		try {
			sc = new Scanner(inputFile);
			while(sc.hasNextLine()) {
				tabList.add(sc.nextLine());
			}
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		finally {
			sc.close();
		}
	}
	
	public char[][] tabToCharMatrix(List<String> list){
		int row = this.tabList.size();
		int col = this.tabList.get(0).length();
		char[][] tabMatrix = new char[row][col];
		
		for(int i = 0; i<row; i++) {
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

	
	
	public char[][] getSplitMeasure(char[][] input) {
		ArrayList<char[][]> tmpArray = measureSplitter(input);
		System.out.println(" number of measures gotten: " + tmpArray.size());
		return tmpArray.get(0);
	}
	
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
		drumType = new ArrayList<String>();
		boolean mesDurNeeded = false;
		boolean writeInDrumType = false;
		
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

				
				if(mesDurNeeded == true) {
					for(int g = 1;input[inputRow][inputCol+g] != '|';g++) {
						mesDur++;
					}
				}
				
				if(bounds == true) {
						
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
								newMeasure = new char[countTheRows][mesDur];
							}
						}
						
						r++;

						newRow++;
						if(multiMes == true) {
							newCol = theresTooManyVars;
						}
						else if(multiMes == false){
							newCol=inputCol+1; 
							
						}

						c = 0;
					}
					
					tmpArray.add(newMeasure);
					//int teeeemp = input[inputRow].length;
					
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

					
				} //contLoop checkpoint
					inputRow = inputRow + 5;
					
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
		
	
		return tmpArray;
		
	} //end of the method
	
	
	
	
	
	
	public Measure createMeasure(char[][] firstMeasure) {
		
		/*
		 * Left to implement:
		 * -Beam Number
		 * -Duration
		 * -Some of the symbols
		 */
		
		//System.out.println("A drum measure is created");
		
		Measure m = new Measure();

		String[] asID = new String[firstMeasure.length];
		
		m.setNumber(Measure.measureNumber);
		Measure.measureNumber++;
		
		/*
		 * Start of first measure creation
		 */
		
		if(m.number == 1) {
			Key k = new Key(0);
			Time t = new Time(4,4);
			Clef cl = new Clef("percussion",2);
			m.attributes = new Attributes();
			m.attributes.setKey(k);
			m.attributes.setTime(t);
			m.attributes.setClef(cl);
		}
			

		
		for(int j = 0; j < 1; j++) {
			for(int i = 0; i < firstMeasure.length; i++) {
				Note n = new Note();
				char c = firstMeasure[i][j];
				if(c == 'C') {
					n.setInstrumentID("P1-I50");
					n.setVoice(1);
					n.setStem("up");
					n.setNotehead("x");
					asID[i] = "P1-I50";
					n.getUnpitched().setStep("A");
					System.out.println("Step is " + n.getUnpitched().getStep());
					
					
				}else if(c == 'R') {
					n.setInstrumentID("P1-I52");
					asID[i] = "P1-I52";
					System.out.println("Step is " + n.getUnpitched().getStep());
					
				}else if(c == 'H') {
					char e = firstMeasure [i][j];
					if(e == 'T') {
						n.setInstrumentID("P1-I48");
						n.setVoice(1);
						n.setStem("up");
					
						asID[i] = "P1-I48";
						n.getUnpitched().setStep("E");
						System.out.println("Step is " + n.getUnpitched().getStep());
						
					}else if(e == 'H'){
						n.setInstrumentID("P1-I43");
						n.setVoice(1);
						n.setStem("up");
						n.setNotehead("x");
						asID[i] = "P1-I43";
						n.getUnpitched().setStep("G");
						System.out.println("Step is " + n.getUnpitched().getStep());
					
					}
					else if(e == 'F') {
						n.setInstrumentID("P1-I45");
						asID[i] = "P1-I45";
						System.out.println("Step is " + n.getUnpitched().getStep());
					}
					else {
						System.out.println("Step is not good " + n.getUnpitched().getStep());
					}
				}else if(c == 'S') {
					n.setInstrumentID("P1-I39");
					n.setVoice(1);
					n.setStem("up");
					asID[i] = "P1-I39";
					n.getUnpitched().setStep("C");
					System.out.println("Step is " + n.getUnpitched().getStep());
					
				}else if(c == 'M') {
					n.setInstrumentID("P1-I46");
					n.setVoice(1);
					n.setStem("up");
					asID[i] = "P1-I46";
					n.getUnpitched().setStep("D");
					System.out.println("Step is " + n.getUnpitched().getStep());
					
				}else if (c == 'B') {
					n.setInstrumentID("P1-I36");
					n.setVoice(2);
					n.setStem("down"); 
					asID[i] = "P1-I36";
					n.getUnpitched().setStep("F");
					System.out.println("Step is " + n.getUnpitched().getStep());
					
				}
				
				if(firstMeasure[i][j] == 'x') {
					n.setInstrumentID("P1-I43");
					n.setVoice(1);
					n.setStem("up");
					n.setNotehead("x");
					StringBuilder type = new StringBuilder();
					type.append(firstMeasure[i][j]);
				}
				else if(firstMeasure[i][j] == 'X') {
					
				}
				else if(firstMeasure[i][j] == 'o' ) {
					n.setInstrumentID(asID[i]);
					n.setVoice(1);
					int tmp = firstMeasure.length;
					if((tmp/2) >= i) {
						n.setStem("up");
					}
					else {
						n.setStem("down");
					}
					n.setVoice(1); 
					// do not set notehead here
					
					StringBuilder type = new StringBuilder();
					type.append(firstMeasure[i][j]);
				}
				else if(firstMeasure[i][j] == 'O') {
					
				}
				else if(firstMeasure[i][j] == 'f') {
					StringBuilder type = new StringBuilder();
					type.append(firstMeasure[i][j]);
				}
				else if(firstMeasure[i][j] == 'd') {
					
				}
				else if(firstMeasure[i][j] == '@') {
					
				}
				else if(firstMeasure[i][j] == 'b') {
					
				}
				else if(firstMeasure[i][j] == 'g') {
					
				}
				
				
				m.getNotes().add(n);
				
			}
			
			
		}
		

		

				
				/*
				 * Symbols: o - drum, x - cymbol, 
				 * capitalized to denote accent or strong hit.
				 * 
				 * Check for capital or lowercase?
				 * 
				 * Other letters:
				 * they denote the drum used.
				 * Ride: r, rd
				 * Crash: c, cr
				 * High Tom: st (small tom), t1 (tom 1)
				 * Medium Tom: mt or t2
				 * Floor Tom: ft or t3
				 * Hi-Hat: h or Hh ("x" and "o" can also mean closed and open hats, respectively.
				 * Snare drum: s or sd
				 * Bass drum: b or bd
				 */

		
		return m;
		
		
	}
	
	/*
	 * Adds all the measures to a part 
	 * @param measures an arraylist of all the measures in the part
	 */
	
	public part createMusicalPart(ArrayList<char[][]> measures) {
		
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
	public ScorePartwise createScore(part p) {
		scorepartwise.getParts().add(p);
		return scorepartwise;
	}
	
	
	
	
	

}
