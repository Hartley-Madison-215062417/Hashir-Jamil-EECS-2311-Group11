package drums;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "unpitched")
@XmlAccessorType(XmlAccessType.NONE)
@XmlType(propOrder = {"display-step","display-octave"})

public class Unpitched {
	
	@XmlElement
	String step;
	
	@XmlElement
	int octave;
	
	public Unpitched() {
		super();
	}
	
	public Unpitched(String step, int octave) {
		super();
		this.step = step;
		this.octave = octave;
	}
	
	public String getStep() {
		return step;
	}
	
	public void setStep(String step) {
		this.step = step;
	}
	
	public int getOctave() {
		return octave;
	}
	
	public void setOctave(int octave) {
		this.octave = octave;
	}
	

}
