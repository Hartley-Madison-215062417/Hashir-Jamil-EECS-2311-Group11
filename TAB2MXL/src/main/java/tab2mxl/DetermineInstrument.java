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
	
	
	public DetermineInstrument() {
		
	}
	
	public DetermineInstrument(File file) {
		System.out.println("Code has reached DetInst constructor. ");
		this.inputFile = file;
		this.tabList = new ArrayList<String>();
		readFile();
		this.tabCharMatrix = this.tabToCharMatrix(this.tabList);
		this.inst = determineInstrument(tabCharMatrix);
		this.measureList = GetParsed(this.inst);
	}
	
	public DetermineInstrument(String file) {
		System.out.println("Code has reached DetInst constructor. ");
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
		
		for(int i = 0; i < measureList.size(); i++) {
			System.out.println("Code reached first for loop");
			char[][] len = measureList.get(i);
			int lennn = len[i].length;
			for(int j = 0; j < lennn; j++) {
				System.out.println("Code reached second for loop, len.length = " + len.length);
				for(int k = 0; k < len.length; k++) {
					System.out.println("Code reached third for loop");
					System.out.print(len[k][j]);
					if(len[k][j] == 'o' || len[k][j] == 'O' || len[k][j] == 'x' || len[k][j] == 'X' || len[k][j] == 'd' || len[k][j] == 'f') {
						System.out.println("returning drums");
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
		return measureList;
	}
	
	
	
	
	public ArrayList<char[][]> measureSplitter (char[][] input) {
		char[][] newMeasure = new char[6][input[0].length];
		
		ArrayList<char[][]> tmpArray = new ArrayList<char[][]>(); //an array list of all the measures to be returned later
		int newRow = 0; // no of rows 
		int newCol = 0; // no of columns 
		int counter = 0; 
		//int newColEnd = 0;
		//int prevColEnd = 0;
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
										int numRep = input[inputRow].length;
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
								newMeasure = new char[6][mesDur];
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
					
					
					chk = ((colCount+1) < input[inputRow].length);
					if(chk == true) {
						theresTooManyVars = colCount + 1;
						newCol = colCount + 1;
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
	
		return tmpArray;
		
	} //end of the method
	
	
	

}
