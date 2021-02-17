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
	public Measure(Parser p) {
		this.key = new Key(p);
		this.time = new Time(p);
		this.clef = new Clef();
		this.staffDetails = new StaffDetails(p);
		this.division = new Division(p);
		//this.note = new Note(p); Uncomment when constructor is made
		
	}
	/*
	 * Use this one for the first measure.
	 */
	public Measure(Parser p, Key key, Time time, Clef clef, StaffDetails staffDetails, Division division, Note note) {
		
		this.attributes = new Attributes(this.p, this.key, this.time, this.clef, this.staffDetails, this.division);
		this.note = note;
	}
	
	/*
	 * Use this one for middle measures.
	 */
	public Measure(Note note) {
		//write when Note constructor is made
	}
	
	/*
	 * Use this one for the final measure.
	 */
	public Measure(Note note, int placeholder) {
		//replace the placeholder with whatever value we will use to set this constructor aside as the final measure.
	}



	
}
