package tab2mxl;

import javax.xml.bind.annotation.XmlElement;

//Standard time signatures are represented more simply in MusicXML than in MIDI.
//The beats element represents the time signature numerator, and the beat-type element 
//represents the time signature denominator (vs. a log denominator in MIDI).
public class Time {
int beats;
//beat-type cannot be a variable


public Time(int beats) {
	this.beats = beats;
}

@XmlElement
public int getBeats() {
	return beats;
}

public void setBeats(int beats) {
	this.beats = beats;
}
}
