package drums;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import drums.Attributes;
import drums.Note;




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
	
	
	public Measure() {
		
	}
	
	@XmlTransient
	static int measureNumber = 1;
	


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
	
	
	/*
	 * Need to update this for drums, for now stays like this.
	 */
	public void updateDuration(Measure m) {
		
		//array to store to index of each note in 1 chord, it has to be rewritten for each chord
		List<Integer> indexArray = new ArrayList<Integer>();//considering that guitar will only have 6 strings
		//duration of 1 chord, it has to be rewritten for each chord
		int chordDuration = 0; 
		
		//System.out.println(m.notes.size());
		
		//looping through a list of all notes inside 1 measure
		for (int i = 0; i <= m.notes.size()-1; i++) {
			
			//System.out.println("test0");
			
			//if the note is the last note
			if(i == m.notes.size()-1) {
				chordDuration = m.getNotes().get(i).getDuration();
				
			
				if (i!=0 && m.notes.get(i-1).getDuration() - m.notes.get(i).getDuration() == 0 ) {
					for (int index: indexArray) {
						//System.out.println("test1a");
						chordDuration = m.getNotes().get(i).getDuration()/2;
						m.notes.get(index).setDuration(chordDuration);						
					}
					//System.out.println("niaa");
					m.notes.get(i).setDuration(chordDuration);	
					indexArray.removeAll(indexArray);
				}
				
				
				
			}
			
			//if the note is not the last note
			else {
								
				//if it is the last note of a chord
				if (i!=0 && m.notes.get(i).getDuration() - m.notes.get(i + 1).getDuration() != 0 && m.notes.get(i-1).getDuration() - m.notes.get(i).getDuration() == 0 ) {
					

					
					if(i!= m.notes.size()-1) {
					
					chordDuration = (m.notes.get(i).getDuration() - m.notes.get(i + 1).getDuration())/2;
					m.notes.get(i).setDuration(chordDuration);
					}
					
					
					for (int index: indexArray) {
						System.out.println("test1");
						m.notes.get(index).setDuration(chordDuration);						
					}
					System.out.println("nia");
					indexArray.removeAll(indexArray);
					
				}
				
				
				
				//if it is a note in the chord, but not last note in chord
				else if (m.notes.get(i).getDuration() - m.notes.get(i + 1).getDuration() == 0) {
				
					indexArray.add(i);
					//System.out.println(i + " " + m.notes.get(i).getNotations().getTechnical().getFret());
					
				}	
				 
				
				//if not part of a chord
				else{
					
					m.notes.get(i).setDuration((m.notes.get(i).getDuration() - m.notes.get(i + 1).getDuration())/2);
				}
				
				
				if(i == m.notes.size()-1) {
					
					m.notes.get(i).setDuration(m.notes.get(i).getDuration()/2);
					
				}
				
				
				
			}
			
		}
		
	}
	
	
	
	
	
	
	
	
}
