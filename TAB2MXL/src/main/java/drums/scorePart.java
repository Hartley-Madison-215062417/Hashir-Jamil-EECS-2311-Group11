package drums;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "score-part")
@XmlAccessorType(XmlAccessType.NONE)
@XmlType(propOrder = {"partName","scoreInstrumentID"})


public class scorePart {
	
	//@XmlAttribute
	@javax.xml.bind.annotation.XmlElement(name = "part-name")
	final String partName = "Drumset";
	
	@XmlAttribute
	String scoreInstrumentID = "P1";
	
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
