package guitar;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "pitch")
@XmlAccessorType(XmlAccessType.NONE)
@XmlType(propOrder= {"step","octave","alter"})
public class Pitch {
	
	@XmlElement
	char step;
	
	@XmlElement
	int octave;
	
	@XmlElement
	int alter;
	
	public Pitch() {
		super();
	}
	
	public Pitch(char step, int octave) {
		super();
		this.step = step;
		this.octave = octave;
	}	
	
	public Pitch(char step, int octave,int alter) {
		super();
		this.step = step;
		this.octave = octave;
		
	}
	
	public char getStep() {
		return step;
	}
	
	public void setStep(char step) {
		this.step = step;
	}
	
	public int getOctave() {
		return octave;
	}
	
	public void setOctave(int octave) {
		this.octave = octave;
	}
	
	public void setAlter(int alter) {
		this.alter =alter;
	}
	
	public int getAlter() {
		return alter;
	}
	
}
