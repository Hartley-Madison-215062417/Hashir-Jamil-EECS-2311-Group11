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
	private Part part = new Part();
	private scorePartwise scorepartwise = new scorePartwise();
	private int hnum = 1;
	
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
	
	public ArrayList<char[][]> measureSplitter (char[][] parsed) {
		
		ArrayList<char[][]> tmpArray = new ArrayList<char[][]>();
		int newRow = 0;
		int newCol = 0;
		int counter = 0;
		int newColEnd = 0;
		int width = parsed[0].length;
		
		//@Madison needs to implement a check for repeats
		
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
	
	public Measure createMeasure(char[][] firstMeasure) {
		
		/*
		 * Left to implement:
		 * -Beam Number
		 * -Duration
		 * -Some of the symbols
		 */
		
		System.out.println("A drum measure is created");
		
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
					
				}else if(c == 'R') {
					n.setInstrumentID("P1-I52");
					asID[i] = "P1-I52";
					
				}else if(c == 'H') {
					char e = firstMeasure [i][j];
					if(e == 'T') {
						n.setInstrumentID("P1-I48");
						n.setVoice(1);
						n.setStem("up");
						asID[i] = "P1-I48";
						
					}else if(e == 'H'){
						n.setInstrumentID("P1-I43");
						n.setVoice(1);
						n.setStem("up");
						n.setNotehead("x");
						asID[i] = "P1-I43";
					
					}
					else if(e == 'F') {
						n.setInstrumentID("P1-I45");
						asID[i] = "P1-I45";
					}
					else {
						
					}
				}else if(c == 'S') {
					n.setInstrumentID("P1-I39");
					n.setVoice(1);
					n.setStem("up");
					asID[i] = "P1-I39";
					
				}else if(c == 'M') {
					n.setInstrumentID("P1-I46");
					n.setVoice(1);
					n.setStem("up");
					asID[i] = "P1-I46";
					
				}else if (c == 'B') {
					n.setInstrumentID("P1-I36");
					n.setVoice(2);
					n.setStem("down"); 
					asID[i] = "P1-I36";
					
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
					
					int tmp = firstMeasure.length;
					if((tmp/2) >= i) {
						n.setStem("up");
					}
					else {
						n.setStem("down");
					}
					n.setVoice(1); // hard-coded for now
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
	
	
 
	
	

}
