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
		this.inputFile = file;
		this.tabList = new ArrayList<String>();
		this.readFile();
		this.tabCharMatrix = this.tabToCharMatrix(this.tabList);
		this.inst = determineInstrument(tabCharMatrix);
		this.measureList = GetParsed(this.inst);
	}
	
	public DetermineInstrument(String file) {
		this.inputFile = new File(file);
		this.tabList = new ArrayList<String>();
		this.readFile();
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
		
		if(tabMatrix[0].length < 3) {
			inst = "drums";
			return "drums";
		}
		
		for(int j = 0; j < 3; j++) {
			for(int i = 0; i < tabMatrix.length; i++) {
				char check = tabMatrix[i][j];
				char check2 = tabMatrix[i+1][j];

				if(check == 'R' || check == 'S' || check == 'H' || check == 'M') {
					inst = "drums";
					return "drums";
				}
				else if((check == 'C' && check2 == 'C') || (check == 'B' && check2 == 'D')) {
					inst = "drums";
					return "drums";
				}
				
			}
		}
		
		if(tabMatrix[0].length < 6) {
			inst = "base";
			return "base";
		}
		
		inst = "guitar";
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
	
	
	

}
