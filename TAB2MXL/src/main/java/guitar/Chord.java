package guitar;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/*
 * A class for chords, chord tags are self closing tags so we do not 
 * need any instance variables
 */

@XmlRootElement(name = "chord")
public class Chord {
	
	@XmlTransient
	int chord; //transient variable as chord tags are self closing

	public Chord() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
