package tab2mxl;

import java.util.ArrayList;

import guitar.Parser;

public class TempTest {

	public static void main(String[] args) {
		
		
		Parser p = new Parser("ShortTester.txt");
		char[][] parsed = p.getTabCharMatrix();
		

//        for (int i = 0; i < p.getTabCharMatrix().length; i++) {
//            System.out.println(p.getTabCharMatrix()[i]);
//        }

        ArrayList<char[][]> testArrayList = new ArrayList<char[][]>();
        testArrayList.add(parsed);
		
//        for(int j = 0; j < tmp.size(); j++) {
//        	System.out.println(tmp.get(j));
//        }
		
		
		
		
		
		

	}

}
