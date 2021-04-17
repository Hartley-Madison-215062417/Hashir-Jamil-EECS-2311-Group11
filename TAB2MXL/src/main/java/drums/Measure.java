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
	
	
	
	
	
	
	
	
	
	public void updateDuration(Measure m) {

		//array to store to index of each note in 1 chord, it has to be rewritten for each chord
		List<Integer> indexArray = new ArrayList<Integer>();//considering that guitar will only have 6 strings

		//duration of 1 chord, it has to be rewritten for each chord
		int chordDuration = 0; 

		//System.out.println("notes.size(): " + m.notes.size());
		
		//looping through a list of all notes inside 1 measure
		for (int i = 0; i <= m.notes.size()-1; i++) {
			//System.out.println("entered for loop");

			//System.out.println("test0");

			//if last note in measure 
			if(i == m.notes.size()-1) {
				/* TO CHECK HOW MANY TIMES THIS FUNCTION IS CALLED - don't need to call if measure doesn't contain a chord
				System.out.println("The value of i: " + i);
				System.out.println("The size of the notes: " + notes.size());
				System.out.println("First note's step: " + notes.get(1).getPitch().getStep() + " octave " + notes.get(1).getPitch().getOctave());
				System.out.println("This note is the last note of the chord");
				 */

				//System.out.println("This note is the last note of the chord");
				chordDuration = m.getNotes().get(i).getDuration();
				//System.out.println("The duration of this chord is: " + chordDuration);

				//if not first note in measure 
				if (i!=0 && m.notes.get(i-1).getDuration() - m.notes.get(i).getDuration() == 0 ) {
					chordDuration = m.getNotes().get(i).getDuration(); 

					for (int index: indexArray) {
						m.notes.get(index).setDuration(chordDuration);						
					}

					m.notes.get(i).setDuration(chordDuration);	
					indexArray.removeAll(indexArray);
				}



			}

			//if the note is not the last note
			else {

				//if it is the last note of a chord
				if (i!=0 && m.notes.get(i).getDuration() - m.notes.get(i + 1).getDuration() != 0 && m.notes.get(i-1).getDuration() - m.notes.get(i).getDuration() == 0 ) {


					if(i!= m.notes.size()-1) {

						chordDuration = (m.notes.get(i).getDuration() - m.notes.get(i + 1).getDuration());
						m.notes.get(i).setDuration(chordDuration);
					}


					for (int index: indexArray) {

						m.notes.get(index).setDuration(chordDuration);						
					}

					indexArray.removeAll(indexArray);

				}



				//if it is a note in the chord, but not last note in chord
				else if (m.notes.get(i).getDuration() - m.notes.get(i + 1).getDuration() == 0) {

					indexArray.add(i);


				}	


				//if not part of a chord
				else{
					System.out.println("not part of chord");
					m.notes.get(i).setDuration((m.notes.get(i).getDuration() - m.notes.get(i + 1).getDuration()));
				}


//				if(i == m.notes.size()-1) {
//					m.notes.get(i).setDuration(m.notes.get(i).getDuration());
//				}

			}
			Map<String, Integer> reference = typeTable(m.getAttributes());
			updateType(m.notes.get(i), reference);
		}

	}
	
	
	
	
	
}
