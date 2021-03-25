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
		this.tabCharMatrix = this.tabCharMatrix(this.tabList);
		
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
	
	
 
	
	

}
