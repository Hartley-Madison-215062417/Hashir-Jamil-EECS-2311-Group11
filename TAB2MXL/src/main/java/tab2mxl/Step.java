package tab2mxl;

import java.util.ArrayList;
import java.util.List;

/*
 * @Author Tommy Lam, Hashir Jamil
 */

public class Step {

	
	public static int counter = 0;
	
	public ArrayList<Note> getInfoFromArray(char[][] array) {


		//List<Integer> Notes = new ArrayList<Integer>();
		List<Note> NoteList = new ArrayList<Note>();


		for (int i = 0; i<array.length; i++)
			for(int j = 0; j < array[i].length; j++) {

				int a = Character.getNumericValue(array[j][i]);
				//if you encounter a note
				if(0 <= a && a <= 9) {
					int s = i;
					int f = array[j][i];
					Note n = new Note(s,f);
					NoteList.add(n);
				}


			}
		return (ArrayList<Note>) NoteList;
	}
	
	public int duration(char [][] array) {
		
		
		for(int i = 0; i<array[i].length; i++) {
			for(int j =0; j < array[i].length; j++) {
				
				int a = Character.getNumericValue(array[j][i]);
				if(0 <= a && a <= 9) {
					int b = Character.getNumericValue(array[j][i]);
					if(b==-1) {
						for(int j = 0; j)
					}
				}
				
			}
		}
		
		return counter;
	}
	

}
