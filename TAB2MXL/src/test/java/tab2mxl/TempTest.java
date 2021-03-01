package tab2mxl;

import java.util.ArrayList;

import guitar.Parser;

public class TempTest {

	public static void main(String[] args) {
		
		
	
		

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
//		
		Parser p = new Parser("ShortTester.txt");
		char[][] parsed = p.getTabCharMatrix();
		
        ArrayList<char[][]> testArrayList3 = new ArrayList<char[][]>();
        testArrayList3.add(parsed);
        testArrayList3.add(parsed);
        
        char[][] tmp = testArrayList3.get(0);
        
        for (int i = 0; i < tmp.length ; i++) {
        	System.out.println(p.getTabCharMatrix()[i]);
        }
        
        char[][] tmp2 = testArrayList3.get(1);
        for (int i = 0; i < tmp2.length ; i++) {
        	System.out.println(p.getTabCharMatrix()[i]);
        }
        
       // testArrayList3.forEach(arr -> System.out.println(new String()));
        
//        for(int i = 0; i < testArrayList3.size(); i++) {
//          for (int j = 0; i < ; j++) {
//        	  
//      }
//        }

        
        
        
	}

}
