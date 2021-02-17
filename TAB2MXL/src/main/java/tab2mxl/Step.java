package tab2mxl;

import java.util.ArrayList;

/*
 * @Author Tommy Lam, Hashir Jamil
 */

public class Step {

	public void getInfoFromArray(char[][] array) {


		ArrayList<Integer> Notes = new ArrayList<Integer>();


		for (int i = 0; i<array.length; i++)
			for(char j = 0; i <= 20; i++) {

				int a = Character.getNumericValue(array[j][i]);
				//if you encounter a note
				if(0 <= a &&  a <= 100) {
					int x = array[j][i];
					Notes.add(x);

				}


			}
	}

}
