package tab2mxl;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name ="attributes")
public class Attributes {
	int division;
	Key key;
	Time time;
	Clef clef;
	StaffDetails staffdetails;


public Attributes() {
	super();
}
public Attributes(int division, Key key, Time time, Clef clef,StaffDetails staffdetails) {
	super();
	this.division = division;
	this.key = key;
	this.time = time;
	this.clef = clef;
	this.staffdetails = staffdetails;
}


@XmlElement
public int getDivision() {
	return division;
}
public void setDivision(int division) {
	this.division = division;
}

@XmlElement
public Key getKey() {
	return key;
}
public void setKey(Key key) {
	this.key = key;
}

@XmlElement
public Time getTime() {
	return time;
}
public void setTime(Time time) {
	this.time = time;
}

@XmlElement
public Clef getClef() {
	return clef;
}
public void setClef(Clef clef) {
	this.clef = clef;
}

@XmlElement
public StaffDetails getStaffdetails() {
	return staffdetails;
}
public void setStaffdetails(StaffDetails staffdetails) {
	this.staffdetails = staffdetails;
}
}