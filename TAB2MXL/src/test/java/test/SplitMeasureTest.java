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

}
