package drums;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "score-part")
@XmlAccessorType(XmlAccessType.NONE)
@XmlType(propOrder = {"part-name","score-instrument id"})


public class scorePart {
	
	@XmlAttribute
	final String partName = "Drumset";
	
	@XmlAttribute
	String scoreInstrumentID;
	
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
