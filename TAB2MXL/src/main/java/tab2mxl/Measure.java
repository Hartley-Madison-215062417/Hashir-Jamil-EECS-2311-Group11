package tab2mxl;


import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement(name = "measure")
@XmlAccessorType(XmlAccessType.NONE)
public class Measure {
	
	@XmlAttribute
	int number;
	
	@XmlElement
	Attributes attributes; 
	
	@XmlElement(name = "note",type = Note.class)
	List<Note> notes = new ArrayList<Note>();
	
	@XmlElement (name = "barline")
	Barline barline = new Barline();
	
	@XmlTransient
	static int measureNumber;
	
	
	
	public Measure(Note n) {
		// TODO Auto-generated constructor stub
	}

	public Measure() {
		// TODO Auto-generated constructor stub
	}

	public void setNotes(ArrayList<Note> notes) {
		this.notes = notes;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public Attributes getAttributes() {
		return attributes;
	}

	public void setAttributes(Attributes attributes) {
		this.attributes = attributes;
	}

	public List<Note> getNotes() {
		return notes;
	}

	public void setNotes(List<Note> notes) {
		this.notes = notes;
	}
	
	
	
}
