package drums;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;



@XmlRootElement(name = "score-part")
@XmlAccessorType(XmlAccessType.NONE)
@XmlType(propOrder = {"partName","id", "scoreInst"})


public class scorePart {
	
	//@XmlAttribute
	@javax.xml.bind.annotation.XmlElement(name = "part-name")
	final String partName = "Drumset";
	
	@javax.xml.bind.annotation.XmlAttribute
	String id = "P1";
	
	@XmlElement(name = "score-instrument")
	ScoreInstrument scoreInst = new ScoreInstrument();
	
	
	public scorePart() {
		super();
	}
	
	public scorePart(ScoreInstrument instrumentName) {
		super();
		this.id = "P1";
		ScoreInstrument I1 = new ScoreInstrument();
		I1.setId("P1-I36");
		I1.setInstrumentName("Snare");
	}
	
	
	public ScoreInstrument getInstrumentName() {
		return scoreInst;
	}

	public void setInstrumentName(ScoreInstrument instrumentName) {
		this.scoreInst = instrumentName;
	}

	public String getPartName() {
		return partName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	

}
