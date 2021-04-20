package guitar;

//public class Attributes {
//
//	Division division;
//
//
//	//private int division;
//	private Key key;
//	private Time time;
//	private Clef clef;
//	private StaffDetails staffdetails;
//
//	
//	public Attributes(Parser p) {
//		//this.division = this.constructDivision(p);
//	}
//	
//	public Attributes(Parser p, Key key, Time time, Clef clef, StaffDetails staffdetails, Division division) {
//		//this.division = this.constructDivision(p);;
//		this.key = key;
//		this.time = time;
//		this.clef = clef;
//		this.staffdetails = staffdetails;
//		this.division = division;
//	}
//	
//	
//	/**
//	 * @author Hashir Jamil & Madison Hartley
//	 * @param p
//	 * @return
//	 */
//
//	/*
//	 * Obsolete now? Divisions class made.
//	 */
////	private int constructDivision(Parser p) {
////		int division = 0; //counter variable to be returned
////		
////		char[] firstRow = p.getTabCharMatrix()[1]; //Will we need to change if there are blank rows at the start of the text input?
////		//Or, will the parser deal with blanks and sort it into the matrix uniformly?
////		
////		int index = 0;
////		
////		while(firstRow[index] != '|') {
////			index++;
////		}
////		
////		index += 1;
////		
////		while(firstRow[index] != '|') {
////			index++;
////			division++;
////		}
////		
////		return division - 1; //need to decrement by 1 for proper return
////		
////	}
//
//	
//	public Division getDivision() {
//		return division;
//	}
//	public void setDivision(Division division) {
//		this.division = division;
//	}
//	public Key getKey() {
//		return key;
//	}
//	public void setKey(Key key) {
//		this.key = key;
//	}
//	public Time getTime() {
//		return time;
//	}
//	public void setTime(Time time) {
//		this.time = time;
//	}
//	public Clef getClef() {
//		return clef;
//	}
//	public void setClef(Clef clef) {
//		this.clef = clef;
//	}
//	public StaffDetails getStaffdetails() {
//		return staffdetails;
//	}
//	public void setStaffdetails(StaffDetails staffdetails) {
//		this.staffdetails = staffdetails;
//	}
//}


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "attributes")
@XmlAccessorType(XmlAccessType.NONE)
@XmlType(propOrder = {"divisions", "key", "time", "clef", "sd", "sdb", "sdb5"})
public class Attributes {
	
	@XmlElement
	int divisions;

	@XmlElement
	Key key;
	
	@XmlElement
	Time time;

	@XmlElement
	Clef clef;

	@XmlElement (name = "staff-details")
	StaffDetailsG sd;
	
	@XmlElement (name = "staff-details")
	StaffDetailsB sdb;
	
	@XmlElement (name = "staff-details")
	StaffDetailsB5 sdb5;

	public Attributes() {
		super();
	}

	public Attributes(Key key, Time time, Clef clef, StaffDetailsG sd) {
		super();
		this.key = key;
		this.time = time;
		this.clef = clef;
		this.sd = sd;
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

	public StaffDetailsG getSd() {
		return sd;
	}

	public void setSd(StaffDetailsG sd) {
		this.sd = sd;
	}

	public int getDivisions() {
		return divisions;
	}
	
	public void setDivisions(int divisions) {
		this.divisions = divisions;
	}
	

	public StaffDetailsB getSdb() {
		return sdb;
	}

	public void setSdb(StaffDetailsB sdb) {
		this.sdb = sdb;
	}

	public StaffDetailsB5 getSdb5() {
		return sdb5;
	}

	public void setSdb5(StaffDetailsB5 sd2) {
		this.sdb5 = sd2;
	}
	
	
	
	
}
