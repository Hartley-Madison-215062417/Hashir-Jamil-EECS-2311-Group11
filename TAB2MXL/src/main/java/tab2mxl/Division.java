package tab2mxl;

public class Division {
	
	/*
	 * @Author: Madison Hartley
	 */

	private int divisions;
	private char firstRow[];
	
	public Division() {
		this.divisions = 2;
	}
	
	public Division(int divisions) {
		this.divisions = divisions;
	}

	public Division(Parser p) {
		
		Time time = new Time(p);
		this.divisions = time.length/time.beatType;
		
		
	}
	
	
//	private int constructDivision(Parser p) {
//	int counter = 0; //counter variable
//	
//	
//	int index = 0;
//	
//	while(this.firstRow[index] != '|') {
//		index++;
//	}
//	
//	index += 1;
//	
//	while(this.firstRow[index] != '|') {
//		index++;
//		counter++;
//	}
//	
//	return counter - 1; //need to decrement by 1 for proper return
//	
//}

	
	
	
	
	
	
	public int getDivisions() {
		return divisions;
	}

	public void setDivisions(int divisions) {
		this.divisions = divisions;
	}
	
	
}
