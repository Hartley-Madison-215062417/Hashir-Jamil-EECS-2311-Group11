package guitar;

import java.util.ArrayList;

/*
 * @Author: Madison Hartley
 */
public class Main {

public static void main(String[] args) {
		
		Parser p = new Parser("prototypeGuitarTab.txt");
		char[][] parsed = p.getTabCharMatrix();
		
		int width = parsed[0].length; //gets the length of the entire first row
		
		ArrayList<char[][]>tmpArray1 = p.measureSplitter(parsed);
		
		System.out.println();
		System.out.println("Printing only first measure stored in array list: ");
		System.out.println();
	
	
	

	}

}
