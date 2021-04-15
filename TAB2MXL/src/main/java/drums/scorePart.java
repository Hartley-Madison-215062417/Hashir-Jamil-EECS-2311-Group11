package drums;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.sun.xml.txw2.annotation.XmlAttribute;

@XmlRootElement(name = "score-part")
@XmlAccessorType(XmlAccessType.NONE)
@XmlType(propOrder = {"partName","scoreInstrumentID", "instrumentName"})


public class scorePart {
	
	//@XmlAttribute
	@javax.xml.bind.annotation.XmlElement(name = "part-name")
	final String partName = "Drumset";
	
	@XmlElement
	String scoreInstrumentID = "P1";
	
	@XmlElement(name = "score-instrument")
	ScoreInstrument instrumentName;
	
	
	public scorePart() {
		super();
	}
	
	public scorePart(ScoreInstrument instrumentName) {
		super();
		this.scoreInstrumentID = "P1";
		this.instrumentName = instrumentName;
	}
	
	
	public ScoreInstrument getInstrumentName() {
		return instrumentName;
	}

	public void setInstrumentName(ScoreInstrument instrumentName) {
		this.instrumentName = instrumentName;
	}

	public String getPartName() {
		return partName;
	}
	
	public String getScoreInstrumentID() {
		return scoreInstrumentID;
	}
	
	public void setScoreInstrumentID(String scoreInstrumentID) {
		this.scoreInstrumentID = scoreInstrumentID;
	}

}
