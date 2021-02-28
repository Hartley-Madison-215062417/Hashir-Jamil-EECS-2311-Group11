package tab2mxl;

/*
 * @Author Tommy Lam
 */

public class Drums {

	public String instrumentID(char [][] array) {
		String instID = " ";
		
		for (int i = 0; i<array.length; i++)
			for(int j = 0; j < 1; j++) {
				char d = array [i][j];
				String c = Character.toString(d);
				if (c == "C"){
					instID = "P1-I50";
				}else if(c == "R") {
					instID = "P1-I52";
				}else if(c == "H") {
					char e = array [i][2];
					String f = Character.toString(e);
					if(f == "T") {
						instID = "P1-I51";
					}else {
					instID = "P1-I43";}
				}else if(c == "S") {
					instID = "P1-I39";
				}else if(c == "M") {
					instID = "P1-I49";
				}else if (c == "T") {
					instID = "P1-I48";
				}else if (c == "B") {
					instID = "P1-I36";
				}

			}
		return instID;
	}
	
	public String Stem(int voice) {
		String stem;
		if(voice == 1) {
			stem = "up";
		}else {
			stem = "down";
		}
		return stem;
	}
	
	public String StepDrums(char [][] array) {
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
					Steps = "D";
				}else if(i==4) {
					Steps = "E";
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
	
	
}



