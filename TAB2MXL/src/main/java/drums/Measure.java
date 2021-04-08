package drums;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

import drums.Attributes;
import drums.Note;





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
	
	

//	public void updateDuration(Measure m) {
//		
//		for (int i = 0; i <= m.notes.size()-1; i++) {
//			
//		}
// }
		
		
		
		
		
	
	
	
	
	
	
	
	
	
}
