package tab2mxl;

public class Attributes {
	int division;
	Key key;
	Time time;
	Clef clef;
	StaffDetails staffdetails;
	
	public Attributes(Parser p) {
		this.division = this.constructDivision(p);
	}
	
	public Attributes(Parser p, Key key, Time time, Clef clef, StaffDetails staffdetails) {
		this.division = this.constructDivision(p);;
		this.key = key;
		this.time = time;
		this.clef = clef;
		this.staffdetails = staffdetails;
	}
	
	
	/**
	 * @author Hashir Jamil & Madison Hartley
	 * @param p
	 * @return
	 */
	private int constructDivision(Parser p) {
		int division = 0; //counter variable to be returned
		
		char[] firstRow = p.getTabCharMatrix()[1];
		
		int index = 0;
		
		while(firstRow[index] != '|') {
			index++;
		}
		
		index += 1;
		
		while(firstRow[index] != '|') {
			index++;
			division++;
		}
		
		return division - 1; //need to decrement by 1 for proper return
		
	}
	
	public int getDivision() {
		return division;
	}
	public void setDivision(int division) {
		this.division = division;
	}
	public Key getKey() {
		return key;
	}
	public void setKey(Key key) {
		this.key = key;
	}
	public Time getTime() {
		return time;
	}
	public void setTime(Time time) {
		this.time = time;
	}
	public Clef getClef() {
		return clef;
	}
	public void setClef(Clef clef) {
		this.clef = clef;
	}
	public StaffDetails getStaffdetails() {
		return staffdetails;
	}
	public void setStaffdetails(StaffDetails staffdetails) {
		this.staffdetails = staffdetails;
	}
}
