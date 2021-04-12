package drums;

import java.util.ArrayList;


public class measureSplitterTrialDrums {

	public static void main(String[] args) {
		
		Parser p = new Parser("drumTestTab.txt");
		char[][] parsed = p.getTabCharMatrix();
		
		int width = parsed[0].length; //gets the length of the entire first row
		
		ArrayList<char[][]>tmpArray1 = p.measureSplitter(parsed);
		
		System.out.println();
		System.out.println("Printing only first measure stored in array list: ");
		System.out.println();
		
		
		/*
		 * This will print the first measure in the array list.
		 */
		if(tmpArray1.size() > 0) {
		char[][] tmpPrint1 = tmpArray1.get(0);
		for(int j = 0; j < tmpPrint1.length; j++) {
			System.out.println(" ");
			for(int k = 0; k < tmpPrint1[0].length; k++) {
				System.out.print(tmpPrint1[j][k]);
			}
			if(j+1 == tmpPrint1.length) {
				System.out.println(" ");
			}
		}
		}
		else {
			System.out.println("First measure does not exist");
		}
		
		System.out.println();
		System.out.println("Printing every measure stored in array list: ");
		System.out.println(" ");
		
		/*
		 * This will print every element in the array list.
		 */
		
		for(int i = 0; i < tmpArray1.size(); i++) {
			char[][] tmpPrint2 = tmpArray1.get(i);
			for(int j = 0; j < tmpPrint2.length; j++) {
				System.out.println(" ");
				for(int k = 0; k < tmpPrint2[0].length; k++) {
					/*if(tmpPrint2[j][k] != '-')
						System.out.print('&');
					else */
						System.out.print(tmpPrint2[j][k]);
				}
			}
			System.out.println(" ");
		}
		
		
		
		


		ArrayList<char[][]> tmpArray = new ArrayList<char[][]>();
		int newRow = 0;
		int newCol = 0;
		int counter = 0;
		int newColEnd = 0;

		
		for(int i = 0; i < width; i++) {
			if(parsed[0][i] != '|') {
			}
			else {
				counter++;
				if(counter == 1) {
					newCol = i+1;
				}
				if(counter > 1) {
					newColEnd = i;
					char[][] newMeasure = new char[6][newColEnd];
					while(newCol < newColEnd) {
						for(newRow = 0; newRow < 6; newRow++) {
							newMeasure[newRow][newCol] = parsed[newRow][newCol];
						}
						newCol++;
					}
					
					tmpArray.add(newMeasure);
					
				}
			}
			
			
			
		}


	






		for(int i = 0; i < width; i++) {
			if(parsed[0][i] != '|') {
			}
			else {
				counter++;
				if(counter == 1) {
					newCol = i+1;
				}
				if(counter > 1) {
					newColEnd = i;
					char[][] newMeasure = new char[6][newColEnd];
					while(newCol < newColEnd) {
						for(newRow = 0; newRow < 6; newRow++) {
							newMeasure[newRow][newCol] = parsed[newRow][newCol];
						}
						newCol++;
					}
					
					tmpArray.add(newMeasure);
					
				}
			}
			
			
			
		}

	}

}
