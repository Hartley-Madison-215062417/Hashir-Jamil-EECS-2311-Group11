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
	ScoreInstrument d1 = new ScoreInstrument("Bass Drum 1", "P1-I36");
	
	@XmlElement(name = "score-instrument")
	ScoreInstrument d2 = new ScoreInstrument("Bass Drum 2", "P1-I37");
	
	@XmlElement(name = "score-instrument")
	ScoreInstrument d3 = new ScoreInstrument("Side Stick", "P1-I38");
	
	@XmlElement(name = "score-instrument")
	ScoreInstrument d4 = new ScoreInstrument("Snare","P1-I39");
	
	@XmlElement(name = "score-instrument")
	ScoreInstrument d5 = new ScoreInstrument("Low Floor Tom", "P1-I42");
	
	@XmlElement(name = "score-instrument")
	ScoreInstrument d6 = new ScoreInstrument("Closed Hi-Hat", "P1-I43");
	
	@XmlElement(name = "score-instrument")
	ScoreInstrument d7 = new ScoreInstrument("High Floor Tom", "P1-I44");
	
	@XmlElement(name = "score-instrument")
	ScoreInstrument d8 = new ScoreInstrument("Pedal Hi-Hat", "P1-I45");
	
	@XmlElement(name = "score-instrument")
	ScoreInstrument d9 = new ScoreInstrument("Low Tom", "P1-I46");
	
	@XmlElement(name = "score-instrument")
	ScoreInstrument d10 = new ScoreInstrument("Open Hi-Hat", "P1-I47");
	
	@XmlElement(name = "score-instrument")
	ScoreInstrument d11 = new ScoreInstrument("Low-Mid Tom", "P1-I48");
	
	@XmlElement(name = "score-instrument")
	ScoreInstrument d12 = new ScoreInstrument("Hi-Mid Tom", "P1-I49");
	
	@XmlElement(name = "score-instrument")
	ScoreInstrument d13 = new ScoreInstrument("Crash Symbol 1", "P1-I50");
	
	@XmlElement(name = "score-instrument")
	ScoreInstrument d14 = new ScoreInstrument("High Tom","P1-I51");
	
	@XmlElement(name = "score-instrument")
	ScoreInstrument d15 = new ScoreInstrument("Ride Cymbal 2", "P1-I52");
	
	@XmlElement(name = "score-instrument")
	ScoreInstrument d16 = new ScoreInstrument("Chinese Cymbal", "P1-I53");
	
	@XmlElement(name = "score-instrument")
	ScoreInstrument d17 = new ScoreInstrument("Ride Bell", "P1-I54");
	
	@XmlElement(name = "score-instrument")
	ScoreInstrument d18 = new ScoreInstrument("Tambourine", "P1-I55");
	
	@XmlElement(name = "score-instrument")
	ScoreInstrument d19 = new ScoreInstrument("Splash Cymbal","P1-I56");
	
	@XmlElement(name = "score-instrument")
	ScoreInstrument d20 = new ScoreInstrument("Cowbell","P1-I57");
	
	@XmlElement(name = "score-instrument")
	ScoreInstrument d21 = new ScoreInstrument("Crash Cymbal 2","P1-I58");
	
	@XmlElement(name = "score-instrument")
	ScoreInstrument d22 = new ScoreInstrument("Ride Cymbal 2", "P1-I60");
	
	@XmlElement(name = "score-instrument")
	ScoreInstrument d23 = new ScoreInstrument("Open Hi Conga","P1-I64");
	
	@XmlElement(name = "score-instrument")
	ScoreInstrument d24 = new ScoreInstrument("Low Conga","P1-I65");
	
	
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
