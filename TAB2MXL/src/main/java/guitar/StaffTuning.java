package guitar;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement
public class StaffTuning{
	
	@XmlAttribute
	int line;
	@XmlElement(name = "tuning-step") 
	public String tuningStep;
	@XmlElement(name = "tuning-octave")
	int tuningOctave;
	
	public StaffTuning(int line, String tuningStep, int tuningOctave) {
		super();
		this.line = line;
		this.tuningStep = tuningStep;
		this.tuningOctave = tuningOctave;
	}

	public StaffTuning() {
		
	}

	public String getTuningStep() {
		return tuningStep;
	}

	public void setTuningStep(String tuningStep) {
		this.tuningStep = tuningStep;
	}

	public int getTuningOctave() {
		return tuningOctave;
	}

	public void setTuningOctave(int tuningOctave) {
		this.tuningOctave = tuningOctave;
	}
	
	
		
	
}