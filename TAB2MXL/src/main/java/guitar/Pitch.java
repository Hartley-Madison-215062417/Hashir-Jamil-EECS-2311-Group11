package guitar;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "pitch")
@XmlAccessorType(XmlAccessType.NONE)
@XmlType(propOrder= {"step","alter","octave"})
public class Pitch {
	
	@XmlElement
	String step;
	
	
	@XmlElement
	String alter;
	
	@XmlElement
	int octave;
	
	public Pitch() {
		super();
	}
	
	public Pitch(String step, int octave) {
		super();
		this.step = step;
		this.octave = octave;
	}	
	
	public Pitch(String step, int octave,String alter) {
		super();
		this.step = step;
		this.octave = octave;
		
	}
	
	public String getStep() {
		return step;
	}
	
	public void setStep(String aStep) {
		this.step = aStep;
	}
	
	public int getOctave() {
		return octave;
	}
	
	public void setOctave(int octave) {
		this.octave = octave;
	}
	
	public void setAlter(String alter) {
		this.alter =alter;
	}
	
	public String getAlter() {
		return alter;
	}


	
}
