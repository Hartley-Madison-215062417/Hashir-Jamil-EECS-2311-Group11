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
		//ScoreInstrument I1 = new ScoreInstrument();
		//I1.setId("P1-I39");
		//I1.setInstrumentName("Snare");
	}
	
	public scorePart(ScoreInstrument instrumentName) {
		super();
		this.id = "P1";
		//ScoreInstrument I1 = new ScoreInstrument();
		//I1.setId("P1-I39");
		//I1.setInstrumentName("Snare");


	}
	
	public ScoreInstrument getD1() {
		return d1;
	}

	public void setD1(ScoreInstrument d1) {
		this.d1 = d1;
	}

	public ScoreInstrument getD2() {
		return d2;
	}

	public void setD2(ScoreInstrument d2) {
		this.d2 = d2;
	}

	public ScoreInstrument getD3() {
		return d3;
	}

	public void setD3(ScoreInstrument d3) {
		this.d3 = d3;
	}

	public ScoreInstrument getD4() {
		return d4;
	}

	public void setD4(ScoreInstrument d4) {
		this.d4 = d4;
	}

	public ScoreInstrument getD5() {
		return d5;
	}

	public void setD5(ScoreInstrument d5) {
		this.d5 = d5;
	}

	public ScoreInstrument getD6() {
		return d6;
	}

	public void setD6(ScoreInstrument d6) {
		this.d6 = d6;
	}

	public ScoreInstrument getD7() {
		return d7;
	}

	public void setD7(ScoreInstrument d7) {
		this.d7 = d7;
	}

	public ScoreInstrument getD8() {
		return d8;
	}

	public void setD8(ScoreInstrument d8) {
		this.d8 = d8;
	}

	public ScoreInstrument getD9() {
		return d9;
	}

	public void setD9(ScoreInstrument d9) {
		this.d9 = d9;
	}

	public ScoreInstrument getD10() {
		return d10;
	}

	public void setD10(ScoreInstrument d10) {
		this.d10 = d10;
	}

	public ScoreInstrument getD11() {
		return d11;
	}

	public void setD11(ScoreInstrument d11) {
		this.d11 = d11;
	}

	public ScoreInstrument getD12() {
		return d12;
	}

	public void setD12(ScoreInstrument d12) {
		this.d12 = d12;
	}

	public ScoreInstrument getD13() {
		return d13;
	}

	public void setD13(ScoreInstrument d13) {
		this.d13 = d13;
	}

	public ScoreInstrument getD14() {
		return d14;
	}

	public void setD14(ScoreInstrument d14) {
		this.d14 = d14;
	}

	public ScoreInstrument getD15() {
		return d15;
	}

	public void setD15(ScoreInstrument d15) {
		this.d15 = d15;
	}

	public ScoreInstrument getD16() {
		return d16;
	}

	public void setD16(ScoreInstrument d16) {
		this.d16 = d16;
	}

	public ScoreInstrument getD17() {
		return d17;
	}

	public void setD17(ScoreInstrument d17) {
		this.d17 = d17;
	}

	public ScoreInstrument getD18() {
		return d18;
	}

	public void setD18(ScoreInstrument d18) {
		this.d18 = d18;
	}

	public ScoreInstrument getD19() {
		return d19;
	}

	public void setD19(ScoreInstrument d19) {
		this.d19 = d19;
	}

	public ScoreInstrument getD20() {
		return d20;
	}

	public void setD20(ScoreInstrument d20) {
		this.d20 = d20;
	}

	public ScoreInstrument getD21() {
		return d21;
	}

	public void setD21(ScoreInstrument d21) {
		this.d21 = d21;
	}

	public ScoreInstrument getD22() {
		return d22;
	}

	public void setD22(ScoreInstrument d22) {
		this.d22 = d22;
	}

	public ScoreInstrument getD23() {
		return d23;
	}

	public void setD23(ScoreInstrument d23) {
		this.d23 = d23;
	}

	public ScoreInstrument getD24() {
		return d24;
	}

	public void setD24(ScoreInstrument d24) {
		this.d24 = d24;
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
