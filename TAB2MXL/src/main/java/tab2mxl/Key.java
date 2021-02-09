package tab2mxl;

import javax.xml.bind.annotation.XmlElement;

//Standard key signatures are represented very much like MIDI key signatures. 
//The fifths element specifies the number of flats or sharps in the key signature - negative 
//for flats, positive for sharps. The fifths name indicates that this value represents the
//key signature's position on the circle of fifths. MusicXML uses the mode 
//element to indicate major or minor key signatures.

public class Key {
	int fifths;
	String mode;
	
	
	public Key(int fifths,String mode) {
		this.fifths = fifths;
		this.mode = mode;
		
	}
	
	@XmlElement
	public int getFifths() {
		return fifths;
	}


	public void setFifths(int fifths) {
		this.fifths = fifths;
	}

	@XmlElement
	public String getMode() {
		return mode;
	}


	public void setMode(String mode) {
		this.mode = mode;
	}
	
}
