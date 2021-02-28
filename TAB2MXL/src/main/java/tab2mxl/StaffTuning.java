package tab2mxl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement
public class StaffTuning{
	
	@XmlAttribute
	int line;
	@XmlElement //(type = "char")
	public char tuningStep;
	@XmlElement
	int tuningOctave;
	
	public StaffTuning(int line, char tuningStep, int tuningOctave) {
		super();
		this.line = line;
		this.tuningStep = tuningStep;
		this.tuningOctave = tuningOctave;
	}

	public StaffTuning() {
		
	}

	public char getTuningStep() {
		return tuningStep;
	}

	public void setTuningStep(char tuningStep) {
		this.tuningStep = tuningStep;
	}

	public int getTuningOctave() {
		return tuningOctave;
	}

	public void setTuningOctave(int tuningOctave) {
		this.tuningOctave = tuningOctave;
	}
	
	
		
	
}