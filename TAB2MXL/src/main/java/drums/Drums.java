package drums;

/*
 * @Author Tommy Lam
 */

public class Drums {

	public static String instrumentID(char [][] array) {
		String instID = " ";
		
		for (int i = 0; i<array.length; i++)
			for(int j = 0; j < 1; j++) {
				char c = array [i][j];
				if (c == 'C'){
					instID = "P1-I50";
				}else if(c == 'R') {
					instID = "P1-I52";
				}else if(c == 'H') {
					char e = array [i][1];
					if(e == 'T') {
						instID = "P1-I48";
					}else {
					instID = "P1-I43";}
				}else if(c == 'S') {
					instID = "P1-I39";
				}else if(c == 'M') {
					instID = "P1-I46";
				}else if (c == 'B') {
					instID = "P1-I36";
				}

			}
		return instID;
	}
	
	public String stem(int voice) {
		String stem;
		if(voice == 1) {
			stem = "up";
		}else {
			stem = "down";
		}
		return stem;
	}
	
	public static String stepDrums(char [][] array) {
		String Steps = " ";
		for (int i = 0; i<array.length; i++)
			for(int j = 0; j < 1; j++) {
				if(i==0) {
					Steps = "A";
				}else if(i==1) {
					Steps = "G";
				}else if(i==2) {
					Steps = "C";
				}else if(i==3) {
					Steps = "E";
				}else if(i==4) {
					Steps = "D";
				}else if(i==5) {
					Steps = "F";
				}else {
					Steps = "?";
				}
			}
		return Steps;
	}
	
	
	public int voice(String id) {
		int x;
		if(id == "P1-I36") {
			x = 2;
		}else {
			x = 1;
		}
		return x;
		
	}
	
	/**public int duration(char [][] array) {
		int duration = 0;
		for (int i = 0; i<array.length; i++)
			for(int j = 0; j < 1; j++) {
				char d = array [i][j];
				String c = Character.toString(d);
				int counter1 = 1;
				int counter2 = 1;
				while(c != "x || o || X") {
					counter1++;
				}
				char e = array[i+1][j];
				String f = Character.toString(e);
				while(f != "x || o || X") {
					counter2++;
				}
				duration = counter2 - counter1;
			}
		return duration;

	}**/
	
	public int duration() {
		return 2;
	}
	
	public String type(int duration) {
		String t = " ";
		if(duration == 1) {
			t = "16th";
		}else if(duration == 2) {
			t = "eighth";
		}else if(duration == 4) {
			t = "quarter";
		}else if(duration == 8) {
			t = "half";
		}
		return t;
	}
	
	public int octave(int voice) {
		int oct = 0;
		if(voice == 1) {
			oct = 5;
		}else if (voice == 2) {
			oct = 4;
		}
		return oct;
	}
	
	
	
	/**public static void main(String args[]) {
		
		char mat[][] = { {'H','H','X','X'},
               };
		
		
		
		char [][] mat = {{"C","C","|",'x','-','-','-','-'},
				{"C","C","|",'x','-','-','-','-'},
			{"C","C","|",'x','-','-','-','-'}
				}
		}
		
		System.out.println("" + instrumentID(mat));
	}**/
	
	
	
}



