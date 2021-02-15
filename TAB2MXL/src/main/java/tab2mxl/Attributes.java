package tab2mxl;

public class Attributes {
	int division;
	Key key;
	Time time;
	Clef clef;
	StaffDetails staffdetails;
	
	public Attributes(int division, Key key, Time time, Clef clef, StaffDetails staffdetails) {
		super();
		this.division = division;
		this.key = key;
		this.time = time;
		this.clef = clef;
		this.staffdetails = staffdetails;
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
