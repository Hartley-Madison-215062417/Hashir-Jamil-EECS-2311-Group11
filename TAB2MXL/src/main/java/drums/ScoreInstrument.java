package drums;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "score-instrument")
@XmlAccessorType(XmlAccessType.NONE)
@XmlType(propOrder = {"id", "instrumentName"})


public class ScoreInstrument {
	
	@XmlAttribute
	String id = new String();
	
	@XmlElement(name = "instrument-name")
	String instrumentName = new String();
	
	public ScoreInstrument() {
		super();
		
	}
	

	public ScoreInstrument(int i) {
		super();
		
		if (i == 39) {
		this.instrumentName = "Snare";
		this.id = "P1-I39";
		}
		
		if(i == 36) {
			this.instrumentName = "Bass Drum 1";
			this.id = "P1-I36";
			
		}

				
		
		
		
	}
	
	public ScoreInstrument(String instrumentName, String id) {
		this.instrumentName = instrumentName;
		this.id = id;
	}
	
	public ScoreInstrument(String instrumentName) {
		super();
		//this.id = "P1";
		this.instrumentName = instrumentName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getInstrumentName() {
		return instrumentName;
	}

	public void setInstrumentName(String instrumentName) {
		this.instrumentName = instrumentName;
	}



}









//this.id = "P1";
//this.instrumentName = new String("Snare");




//d1 = new InstrumentName("Bass Drum 1", "P1-I36");
//d2 = new InstrumentName("Bass Drum 2", "P1-I37");
//d3 = new InstrumentName("Side Stick", "P1-I38");
//d4 = new InstrumentName("Snare","P1-I39");
//d5 = new InstrumentName("Low Floor Tom", "P1-I42");
//d6 = new InstrumentName("Closed Hi-Hat", "P1-I43");
//d7 = new InstrumentName("High Floor Tom", "P1-I44");
//d8 = new InstrumentName("Pedal Hi-Hat", "P1-I45");
//d9 = new InstrumentName("Low Tom", "P1-I46");
//d10 = new InstrumentName("Open Hi-Hat", "P1-I47");
//d11 = new InstrumentName("Low-Mid Tom", "P1-I48");
//d12 = new InstrumentName("Hi-Mid Tom", "P1-I49");
//d13 = new InstrumentName("Crash Symbol 1", "P1-I50");
//d14 = new InstrumentName("High Tom","P1-I51");
//d15 = new InstrumentName("Ride Cymbal 2", "P1-I52");
//d16 = new InstrumentName("Chinese Cymbal", "P1-I53");
//d17 = new InstrumentName("Ride Bell", "P1-I54");
//d18 = new InstrumentName("Tambourine", "P1-I55");
//d19 = new InstrumentName("Splash Cymbal","P1-I56");
//d20 = new InstrumentName("Cowbell","P1-I57");
//d21 = new InstrumentName("Crash Cymbal 2","P1-I58");
//d22 = new InstrumentName("Ride Cymbal 2", "P1-I60");
//d23 = new InstrumentName("Open Hi Conga","P1-I64");
//d24 = new InstrumentName("Low Conga","P1-I65");
