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
		
		System.out.println("A drum measure is created");
		
		Measure m = new Measure();
		
		m.setNumber(Measure.measureNumber);
		Measure.measureNumber++;
		
		if(m.number == 1) {
			Key k = new Key(0);
			Time t = new Time(4,4);
			Clef c = new Clef("percussion",2);
			m.attributes = new Attributes();
			m.attributes.setKey(k);
			m.attributes.setTime(t);
			m.attributes.setClef(c);
			
			
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
				}else if(c == 'R') {
					n.setInstrumentID("P1-I52");
				}else if(c == 'H') {
					char e = firstMeasure [i][1];
					if(e == 'T') {
						n.setInstrumentID("P1-I48");
						n.setVoice(1);
						n.setStem("up");
					}else {
						n.setInstrumentID("P1-I43");
						n.setVoice(1);
						n.setStem("up");
						n.setNotehead("x");
					}
				}else if(c == 'S') {
					n.setInstrumentID("P1-I39");
					n.setVoice(1);
					n.setStem("up");
				}else if(c == 'M') {
					n.setInstrumentID("P1-I46");
					n.setVoice(1);
					n.setStem("up");
				}else if (c == 'B') {
					n.setInstrumentID("P1-I36");
					n.setVoice(2);
					n.setStem("down");
				}
			}
		}
		
		
	}
	
	
 
	
	

}
