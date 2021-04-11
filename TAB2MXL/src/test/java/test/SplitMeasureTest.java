package test;

import java.util.ArrayList;

import guitar.Parser;

/*
 * @Author: Madison Hartley
 */
public class SplitMeasureTest {

	public static void main(String[] args) {
		
		Parser p = new Parser("creep.txt");
		char[][] parsed = p.getTabCharMatrix();
		
		int width = parsed[0].length; //gets the length of the entire first row
		
		ArrayList<char[][]>tmpArray1 = p.measureSplitter(parsed);
		
		System.out.println();
		System.out.println("Printing only first measure stored in array list: ");
		System.out.println();
		
		
		/*
		 * This will print the first measure in the array list.
		 */
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
					System.out.print(tmpPrint2[j][k]);
				}
			}
			System.out.println(" ");
		}
		
		
		
		

////        for (int i = 0; i < p.getTabCharMatrix().length; i++) {
////            System.out.println(p.getTabCharMatrix()[i]);
////        }
//
//        ArrayList<char[][]> testArrayList = new ArrayList<char[][]>();
//        testArrayList.add(parsed);
//		
////        for(int j = 0; j < tmp.size(); j++) {
////        	System.out.println(tmp.get(j));
////        }
//		
//		
//        Parser p2 = new Parser("prototypeGuitarTab.txt");
//		char[][] parsed2 = p.getTabCharMatrix();
//		
//		ArrayList<char[][]> testArrayList2 = new ArrayList<char[][]>();
//        testArrayList.add(parsed2);
		
		
		/*
		 * Print List~
		 * parsed[i][0] will print a vertical line of |
		 * parsed[j][0] same. 
		 * parsed[j][1] will print the first line after the bar, vertical line of -.
		 * 
		 */
//		

		
		
		
		/*
		 * char array [row][col]
		 */
	/*
	 * THE METHOD STARTS HERE	
	 */
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
		
	//	tmpArray.forEach(arr -> System.out.println(Arrays.toString(arr)));
		
	//	for(int i = 0; i < tmpArray.size();  i++) {
//			char[][] tmpPrint = tmpArray.get(0);
//			for(int j = 0; j < tmpPrint.length; j++) {
//				System.out.println(" ");
//				for(int k = 0; k < tmpPrint[0].length; k++) {
//					System.out.print(tmpPrint[j][k]);
//				}
//			}
//			
	//	}
		
		/*
		 * THE METHOD ENDS HERE
		 */
		
		
		
		
		//if(parsed[0][j] != '|') {
//			
//			}
//			else {
//				counter++;
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		int counter = 0;
//		int i = 0;
//		int j = 0;
//		int k = 0;
//		
//		while(j < width) {
//			
//			if(parsed[0][j] != '|') {
//			
//			}
//			else {
//				counter++;
//				
//				if(counter == 1) {
//					col1 = j;
//				}
//				if(counter > 1) {
//					//j = 0;
//					col2 = j;
//					i++;
//					
//					//System.out.print(" ");
//					
//					int col = col1;
////					while(k < p.getTabCharMatrix().length) {
////						System.out.println();
////						for(int g = 1; g < 5 ; g++) {
////							
////						}
////						//System.out.print()
////						col++;
////						k++;
////					}
////					for(int k = 1; k < p.getTabCharMatrix().length; k++) {
////						
////					}
//					
//					
//				}
//			}
//			
//			
//			j++;
//			
//		}
	
	//	System.out.println(counter);
	//	System.out.println(p.getTabCharMatrix().length);
//			while(i < p.getTabCharMatrix().length) {
//		//	for (int i = 0; i < p.getTabCharMatrix().length; i++) {
//
//				if(parsed[0][i] != '|') {
//					System.out.println(p.getTabCharMatrix()[i]);
//					}
//				else if(parsed[0][i] == '|'){
//					counter++;
//				}
//				
//				if(counter <= 1) {
//					
//				}
//				
//				i++;
//			}
		
//		for(int i = 0; i<parsed[0].length; i++) {
////			if(parsed[0][i] == '|') {
////				
////			}
//			System.out.println(parsed[0][i]);
//			
//		}
		
		
//        ArrayList<char[][]> testArrayList3 = new ArrayList<char[][]>();
//        testArrayList3.add(parsed);
//        testArrayList3.add(parsed);
//        
//        char[][] tmp = testArrayList3.get(0);
//        
//        for (int i = 0; i < tmp.length ; i++) {
//        	System.out.println(p.getTabCharMatrix()[i]);
//        }
//        
//        char[][] tmp2 = testArrayList3.get(1);
//        for (int i = 0; i < tmp2.length ; i++) {
//        	System.out.println(p.getTabCharMatrix()[i]);
//        }
//        
       // testArrayList3.forEach(arr -> System.out.println(new String()));
        
//        for(int i = 0; i < testArrayList3.size(); i++) {
//          for (int j = 0; i < ; j++) {
//        	  
//      }
//        }

        
        

	}
	
	
	/*
	 * Code dump
	 */
	
//	 public ArrayList<char[][]> measureSplitter (char[][] parsed) {
//		
//			ArrayList<char[][]> tmpArray = new ArrayList<char[][]>();
//			int newRow = 0;
//			int newCol = 0;
//			int counter = 0;
//			int newColEnd = 0;
//
//			int prevColEnd = 0;
//		//	int width = parsed[0].length; // width of the entire 2D array with all measures 
//			int k = 0;
//			int i = 0;
//			int ttlRow = parsed.length;
//			boolean bounds = false;
//			System.out.println(ttlRow);
//
//			int width = parsed[0].length;
//
//			
//			/*
//			 * implement a CHECK for repeats
//			 */
//			
//			
////<<<<<<< HEAD
////			System.out.println("initial length of char matrix: " + parsed[0].length);
////			if(parsed[0].length == 0) {
////				i++;
////				while(parsed[i].length == 0) {
////					i++;
////=======
//			
////			for(i = 0; i < width; i++) {
////				if(parsed[0][i] != '|') {
////				}
////				else {
////					counter++;
////					if(counter == 1) {
////						newCol = i+1;
////					}
////					if(counter > 1) {
////						if(counter > 2) {
////							newCol ++;
////						}
////						newColEnd = i;
////						char[][] newMeasure = new char[6][newColEnd];
////						int tmpCol = 0;
////						while(newCol < newColEnd) {
////							for(newRow = 0; newRow < 6; newRow++) {
////								newMeasure[newRow][tmpCol] = parsed[newRow][newCol];
////							}
////							
////							tmpCol++;
////							newCol++;
////						}
////						
////						tmpArray.add(newMeasure);
////						
////					}
////>>>>>>> branch 'develop' of https://github.com/Hartley-Madison-215062417/Hashir-Jamil-EECS-2311-Group11
//				
//
//		
//			
//			for(; i < ttlRow; i++) { 
//				boolean bnd = (parsed[i].length == 0);
//				
//				// going through the entire 2D array of all measures, then i = 0 we are in the first column 
//				if(bnd == false) {
//				//for(int k = 0; k < parsed[i].length; k++) {
//				//System.out.println(" On row " + i + ", the length is " + parsed[i].length + " and k is " + k);
//				//if(i != width - 1) 
//				
//				//if(!(parsed[0][i] == '|' && parsed[0][i+1] == '|' )) {
//
//
//				
//					if(parsed[i][k] == '|') {
//						bounds = true;
//					}
//				
//				
//				if(bounds == true) {
//					
//					newCol = k+1;
//					newRow = i;
//					
//					char[][] newMeasure = new char[6][parsed[i].length];
//					
//					int r = 0;
//					int c = 0;
//						
//					while(parsed.length > newRow) {
//					while(parsed[i][newCol] != '|') {
//						//newMeasure[newRow][tmpCol] = parsed[newRow][newCol];
//						newMeasure[r][c]=parsed[newRow][newCol];
//						//System.out.print(parsed[i][newCol]);
//						
//						newCol++;
//						c++;
//						
//					}
//					newRow++;
//					r++;
//					
//					
//					
//					//System.out.println(" ");
//					
//					c = 0;
//					//newCol = k+1;
//					}
//					
//					
//					tmpArray.add(newMeasure);
//
//				}
//				
//				
//				
//				
//				
//				
//				
//				
//				
//				
//				
//				
//				
//				
//				
//				
//				
//				
//				
//				
//				
//				
//				
//				
//				
//				
//					
//
////				else { //in the first row if any element is '|'
////					System.out.println(parsed[i].length);
////					if(parsed[i][k] != '|') {
////						bounds = true;
////					}
////				} 
//					
////				if(bnd == false && bounds == true) { // for all other elements in 2D char array of all measures 
////					counter++; 
////					if(counter == 1) { //if counter is 1
////						newCol = i; // new column = column number + 1
////						System.out.println("newCol is started as " + newCol);
////					}
////					if(counter >= 1) { // if counter is more than 1
////						if(counter > 2) { // if counter is more than 2
////							newCol = 1 + i; // new column = column number + 1
////						}
////						//System.out.println(" line 174 is accessed");
////						//System.out.println("prevColEnd: " + prevColEnd);
////						//System.out.println("newColEnd " + newColEnd);
////						
////						prevColEnd = newColEnd;
////						newColEnd = i; // new column end is the current column number 
////						
////						char[][] newMeasure = new char[6][newColEnd - prevColEnd-1
////						                                  ]; //create a new measure with 6 rows and _____ columns 
////						int tmpCol = 0; // counter
////						System.out.println("Before loop: newCol is " + newCol);
////						System.out.println("Before loop: newColEnd is " + newColEnd);
////						System.out.println("Before loop: tmpCol is " + tmpCol);
////						//while(newCol < newColEnd) {
////							//if(parsed.length != 0) {
////							for(newRow = 0; newRow < 6; newRow++) {
//////								System.out.println("newRow is " + newRow);
//////								System.out.println("tmpCol is " + tmpCol);
//////								System.out.println("newCol is " + newCol);
////								System.out.println("writing loop is accessed");
////								newMeasure[newRow][tmpCol] = parsed[newRow][newCol];
////							//}
////							}
////							tmpCol++;
////							newCol++;
////							
////					//	}
////						
////						if(parsed[i].length == 0) {
////							i++;
////							//k = 0;
////							while(parsed[i].length == 0) {
////								i++;
////							}
////						}
////						
////						tmpArray.add(newMeasure);
////					}
////				}
////				System.out.println(" k is " + k);
////				
//			
//			
//			//} // end of the really big for loop
//				}
//			
//
//		//return tmpArray;
//			}
//			return tmpArray;
//	} //end of the method
	
	
	
	

}
