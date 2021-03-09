package drums;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import guitar.Note;

public class Parser {
	
	List<String> tabList;
	private File inputFile;
	private char[][] tabCharMatrix;
	private Part part = new Part();

	public Parser() {
		
	}
	
	/*
	 * @param a filepath collected from GUI
	 */
	
	public Parser(String inFile) {
		inputFile = new File(inFile);
		tabList = new ArrayList<String>();
		this.readFile();
		this.tabCharMatrix = this.tabToCharMatrix(this.tabList);
	}

	public char[][] tabToCharMatrix(List<String> tabList2) {
		int row = this.tabList.size();
		int col = this.tabList.get(0).length();
		char[][] tabMatrix = new char[row][col];
		return null;
	}

	private void readFile() {
		Scanner scan = null;
		try {
			scan = new Scanner(inputFile);
			while(scan.hasNextLine()) {
				tabList.add(scan.nextLine());
			}
		}
		catch (FileNotFoundException welp) {
			welp.printStackTrace();
		}
		finally {
			scan.close();
		}
		
	}
	
	
	public void setTabCharMatrix(Parser p) {
		this.tabCharMatrix = this.tabToCharMatrix(this.tabList);
	}
	
	public char[][] getTabCharMatrix() {
		return this.tabCharMatrix;
	}
	
	public char[][] getFirstLine(char[][] old) {
		int col = this.tabList.get(0).length();
		char[][] current = new char[6][col]; //change 6 depending on what drums needs, this is temp
		
		for(int i = 0; i < 6; i++) {
			for(int j = 0; j < this.tabList.get(0).length(); j++) {
				current[i][j] = old[i][j];
			}
		}
		return current;
	}
	
	
	/* 
	 * Direct copy and paste from guitar parser. 
	 * Again, any questions or issues,
	 * ask Maddi.
	 */
	 public ArrayList<char[][]> measureSplitter (char[][] parsed) {
			
		ArrayList<char[][]> tmpArray = new ArrayList<char[][]>();
		int newRow = 0;
		int newCol = 0;
		int counter = 0;
		int newColEnd = 0;
		int width = parsed[0].length;
			
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
	 
	 /*
	  * May have remade wrong, check this, as well as incomplete,
	  * need to see what methods we are doing for drums
	  * to finish this method.
	  */
	 
	 public Measure createMeasure(char[][] firstMeasure) {
		 Measure m = new Measure();
		 m.setNumber(Measure.measureNumber);
		 
		 if(m.number == 1) {
			 Key k = new Key(0);
			 Time t = new Time(4,4); 
			 Clef c = new Clef();
			 StaffDetails sd = new StaffDetails();
			 
			 
		 }
		 
		 Measure.measureNumber++;
		 
		 for(int j = 0; j < firstMeasure[0].length; j++) {
			 for(int i = 0; i < firstMeasure.length; i++) {
				 Note n = new Note();
				 if(firstMeasure[i][j] >= '0' && firstMeasure[i][j] <= '9' ) {
				 if((firstMeasure[i][j] >= '0' && firstMeasure[i][j-1] <= '9') == false) {
					 StringBuilder num = new StringBuilder();
					 num.append(firstMeasure[i][j]);
					 num.append(firstMeasure[i][j+1]);
					 int fret = Integer.parseInt(num.toString());
					 n.getNotations().getTechnical().setFret(fret);
				 }
				 else {
					 n.getNotations().getTechnical().setFret(Character.getNumericValue(firstMeasure[i][j]));
				 }
				 
				 n.getNotations().getTechnical().setString(i+1);
				 n.setDuration(firstMeasure[0].length - j);
				 n.setDefaultStep(n);
				 if(n.getNotations().getTechnical().getFret()!=0) {
						n.updatePitch(n);
						}
				 }
			// m.getNotes().add(n);
			 }
			
			 
		 }
//		 m.updateDuration(m);
//		 for (Note n: m.getNotes()) {
//				System.out.print(n.getNotations().getTechnical().getFret());
//				System.out.print(" " +n.getNotations().getTechnical().getString());
//				System.out.println(" "+n.getDuration());
//				}
				System.out.println("end");
				return m;
	 }
	
	public Part createMusicalPart(ArrayList<char[][]> measures) {
		for(char[][] measure : measures) {
			Measure m = createMeasure(measure);
		//	part.getPart().add(m);
		}
		return part;
	}
	
	
	
	
}
