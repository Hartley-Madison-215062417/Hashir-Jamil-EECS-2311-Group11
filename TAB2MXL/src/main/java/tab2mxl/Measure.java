package tab2mxl;

import java.util.ArrayList;
import java.util.List;

public class Measure {
	
	List<String> notesList = new ArrayList<String>(); 
	Attributes attributes;
	Barline barline;
	Parser p;
	Key key;
	Time time;
	Clef clef;
	StaffDetails staffDetails;
	Division division;
	Note note;
	
	/*
	 * @Author Madison Hartley
	 */
	public Measure(Parser p, Key key, Time time, Clef clef, StaffDetails staffDetails, Division division, Note note) {
		this.attributes = new Attributes(this.p, this.key, this.time, this.clef, this.staffDetails, this.division);
		Measure measure = new Measure(this.note);
	}
	
	public Measure(Note note) {
		
	}
	
	
}
