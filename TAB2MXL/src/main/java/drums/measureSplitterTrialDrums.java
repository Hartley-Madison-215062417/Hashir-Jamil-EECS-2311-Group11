package drums;

import java.util.ArrayList;


public class measureSplitterTrialDrums {

	public static void main(String[] args) {
		
		Parser p = new Parser("drumTestTab.txt");
		char[][] parsed = p.getTabCharMatrix();
		
		//int width = parsed[0].length; //gets the length of the entire first row
		
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
		
		System.out.println("Printing drum type, from first to last row: ");
		System.out.println("drumType size: " + p.drumType.size());
			for(int m = 0; m < p.drumType.size(); m++) {
				System.out.println(p.drumType.get(m));
			}


	}

}
