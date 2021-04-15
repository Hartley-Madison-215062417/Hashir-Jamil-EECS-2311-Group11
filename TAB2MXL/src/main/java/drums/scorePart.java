package drums;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;



@XmlRootElement(name = "score-part")
@XmlAccessorType(XmlAccessType.NONE)
@XmlType(propOrder = {"partName","id", "d1", "d2", "d3", "d4", "d5", "d6", "d7", "d8", "d9", "d10", "d11", "d12", "d13", "d14", "d15", "d16", "d17", "d18", "d19", "d20", "d21", "d22", "d23", "d24"})


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
		this.id = "P1";
		ScoreInstrument I1 = new ScoreInstrument();
		I1.setId("P1-I39");
		I1.setInstrumentName("Snare");
	}
	
	public scorePart(ScoreInstrument instrumentName) {
		super();
		this.id = "P1";
		ScoreInstrument I1 = new ScoreInstrument();
		I1.setId("P1-I39");
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
