package drums;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;





@XmlRootElement(name = "measure")
@XmlAccessorType(XmlAccessType.NONE)
@XmlType(propOrder= {"number","attributes","notes","barline"})
public class Measure {

	@XmlAttribute
	int number;
	
	@XmlElement
	Attributes attributes; 
	
	@XmlElement(name = "note",type = Note.class)
	List<Note> notes = new ArrayList<Note>();
	
	@XmlElement (name = "barline")
	Barline barline = new Barline();
	
	
	public Measure() {
		super();
	}
	
	@XmlTransient
	public static int measureNumber = 1;
	
	public static int getMeasureNumber() {
		return measureNumber;
	}

	public static void setMeasureNumber(int measureNumber) {
		Measure.measureNumber = measureNumber;
	}


	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}


	public List<Note> getNotes() {
		return notes;
	}
	
	public void setNotes(ArrayList<Note> notes) {
		this.notes = notes;
	}
	
	public Attributes getAttributes() {
		return attributes;
	}
	
	public void setAttributes(Attributes attributes) {
		this.attributes = attributes;
	}

	public void setNotes(List<Note> notes) {
		this.notes = notes;
	}

		
		
		
		
	public void updateType(Note n, Map<String, Integer> reference) {

		for(Map.Entry<String, Integer> entry: reference.entrySet()) {
			if(n.getDuration() == entry.getValue()) {
				//System.out.println("The duration is: " + n.getDuration());
				//System.out.println("The type is: " + entry.getKey());
				n.setType(entry.getKey());
			}
		}


	}

	public static Map<String, Integer> typeTable(Attributes a) {
		Map<String, Integer> typeTable= new HashMap<String, Integer>(); // the type of note, the duration
		Map<Integer, String> noteType = new HashMap<Integer, String>(); // the number corresponding to note type, name of type of note 

		noteType.put(1, "whole");
		noteType.put(2, "half");
		noteType.put(4, "quarter");
		noteType.put(8, "eighth");
		noteType.put(16, "sixteenth");

		String beatType = "";
		int divisions = 0;
		int durWhole = 0;

		for(Map.Entry<Integer, String> entry : noteType.entrySet()) {
			if(a.getTime().beatType	== entry.getKey()) { //find the name of the note from the number 
				beatType = entry.getValue();
				divisions = a.divisions;
			}
		}

		//now check what the duration would be for a whole note 
		if(beatType == "whole")
			durWhole = divisions;
		else if(beatType == "half")
			durWhole = divisions*2;
		else if(beatType == "quarter")
			durWhole = divisions*4;
		else if(beatType == "eighth")
			durWhole = divisions*8;
		else if(beatType == "sixteenth")
			durWhole = divisions*16;

		//fill the typeTable that will be used later for reference with the type of note and corresponding duration
		typeTable.put("whole", durWhole);
		typeTable.put("half", durWhole/2);
		typeTable.put("quarter", durWhole/4);
		typeTable.put("eighth", durWhole/8);
		typeTable.put("sixteenth", durWhole/16);
		//System.out.println("=======================");
		//System.out.println("printing the note and type table");
		//		for(Map.Entry<Integer, String> entry: noteType.entrySet()) {
		//			System.out.println("note number: " + entry.getKey() + " note name:" + entry.getValue());
		//		}
		//		for(Map.Entry<String, Integer> entry: typeTable.entrySet()) {
		//			System.out.println("note name: " + entry.getKey() + " note duration:" + entry.getValue());
		//		}
		//System.out.println("=======================");
		return typeTable;
	}
	
	
	
	
	
	
	
	
	
	public int updateDuration(Measure m) {

		
		return 8;
	}
	
	
	
	
	
}
