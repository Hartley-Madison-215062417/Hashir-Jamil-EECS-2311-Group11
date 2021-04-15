package drums;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "score-instrument")
@XmlAccessorType(XmlAccessType.NONE)
@XmlType(propOrder = {"id", "instrumentName", "d1", "d2", "d3", "d4", "d5", "d6", "d7", "d8", "d9", "d10", "d11", "d12", "d13", "d14", "d15", "d16", "d17", "d18", "d19", "d20", "d21", "d22", "d23", "d24"})


public class ScoreInstrument {
	
	@XmlAttribute
	String id;
	
	@XmlElement(name = "score-instrument")
	String instrumentName;
	
	@XmlElement (name = "instrument-name")
	InstrumentName d1;
	
	@XmlElement (name = "instrument-name")
	InstrumentName d2;
	
	@XmlElement (name = "instrument-name")
	InstrumentName d3;
	
	@XmlElement (name = "instrument-name")
	InstrumentName d4;
	
	@XmlElement (name = "instrument-name")
	InstrumentName d5;
	
	@XmlElement (name = "instrument-name")
	InstrumentName d6;
	
	@XmlElement (name = "instrument-name")
	InstrumentName d7;
	
	@XmlElement (name = "instrument-name")
	InstrumentName d8;
	
	@XmlElement (name = "instrument-name")
	InstrumentName d9;
	
	@XmlElement (name = "instrument-name")
	InstrumentName d10;
	
	@XmlElement (name = "instrument-name")
	InstrumentName d11;
	
	@XmlElement (name = "instrument-name")
	InstrumentName d12;
	
	@XmlElement (name = "instrument-name")
	InstrumentName d13;

	@XmlElement (name = "instrument-name")
	InstrumentName d14;
	
	@XmlElement (name = "instrument-name")
	InstrumentName d15;
	
	@XmlElement (name = "instrument-name")
	InstrumentName d16;
	
	@XmlElement (name = "instrument-name")
	InstrumentName d17;
	
	@XmlElement (name = "instrument-name")
	InstrumentName d18;
	
	@XmlElement (name = "instrument-name")
	InstrumentName d19;
	
	@XmlElement (name = "instrument-name")
	InstrumentName d20;
	
	@XmlElement (name = "instrument-name")
	InstrumentName d21;
	
	@XmlElement (name = "instrument-name")
	InstrumentName d22;
	
	@XmlElement (name = "instrument-name")
	InstrumentName d23;
	
	@XmlElement (name = "instrument-name")
	InstrumentName d24;

	
	
	public ScoreInstrument() {
		
		id = "P1";
		
//		d1 = new InstrumentName("Bass Drum 1", "P1-I36");
//		d2 = new InstrumentName("Bass Drum 2", "P1-I37");
//		d3 = new InstrumentName("Side Stick", "P1-I38");
//		d4 = new InstrumentName("Snare","P1-I39");
//		d5 = new InstrumentName("Low Floor Tom", "P1-I42");
//		d6 = new InstrumentName("Closed Hi-Hat", "P1-I43");
//		d7 = new InstrumentName("High Floor Tom", "P1-I44");
//		d8 = new InstrumentName("Pedal Hi-Hat", "P1-I45");
//		d9 = new InstrumentName("Low Tom", "P1-I46");
//		d10 = new InstrumentName("Open Hi-Hat", "P1-I47");
//		d11 = new InstrumentName("Low-Mid Tom", "P1-I48");
//		d12 = new InstrumentName("Hi-Mid Tom", "P1-I49");
//		d13 = new InstrumentName("Crash Symbol 1", "P1-I50");
//		d14 = new InstrumentName("High Tom","P1-I51");
//		d15 = new InstrumentName("Ride Cymbal 2", "P1-I52");
//		d16 = new InstrumentName("Chinese Cymbal", "P1-I53");
//		d17 = new InstrumentName("Ride Bell", "P1-I54");
//		d18 = new InstrumentName("Tambourine", "P1-I55");
//		d19 = new InstrumentName("Splash Cymbal","P1-I56");
//		d20 = new InstrumentName("Cowbell","P1-I57");
//		d21 = new InstrumentName("Crash Cymbal 2","P1-I58");
//		d22 = new InstrumentName("Ride Cymbal 2", "P1-I60");
//		d23 = new InstrumentName("Open Hi Conga","P1-I64");
//		d24 = new InstrumentName("Low Conga","P1-I65");
				
		
		
		
	}
	
	public String getInstrumentName() {
		return instrumentName;
	}



	public void setInstrumentName(String instrumentName) {
		this.instrumentName = instrumentName;
	}



	public InstrumentName getD1() {
		return d1;
	}



	public void setD1(InstrumentName d1) {
		this.d1 = d1;
	}



	public InstrumentName getD2() {
		return d2;
	}



	public void setD2(InstrumentName d2) {
		this.d2 = d2;
	}



	public InstrumentName getD3() {
		return d3;
	}



	public void setD3(InstrumentName d3) {
		this.d3 = d3;
	}



	public InstrumentName getD4() {
		return d4;
	}



	public void setD4(InstrumentName d4) {
		this.d4 = d4;
	}



	public InstrumentName getD5() {
		return d5;
	}



	public void setD5(InstrumentName d5) {
		this.d5 = d5;
	}



	public InstrumentName getD6() {
		return d6;
	}



	public void setD6(InstrumentName d6) {
		this.d6 = d6;
	}



	public InstrumentName getD7() {
		return d7;
	}



	public void setD7(InstrumentName d7) {
		this.d7 = d7;
	}



	public InstrumentName getD8() {
		return d8;
	}



	public void setD8(InstrumentName d8) {
		this.d8 = d8;
	}



	public InstrumentName getD9() {
		return d9;
	}



	public void setD9(InstrumentName d9) {
		this.d9 = d9;
	}



	public InstrumentName getD10() {
		return d10;
	}



	public void setD10(InstrumentName d10) {
		this.d10 = d10;
	}



	public InstrumentName getD11() {
		return d11;
	}



	public void setD11(InstrumentName d11) {
		this.d11 = d11;
	}



	public InstrumentName getD12() {
		return d12;
	}



	public void setD12(InstrumentName d12) {
		this.d12 = d12;
	}



	public InstrumentName getD13() {
		return d13;
	}



	public void setD13(InstrumentName d13) {
		this.d13 = d13;
	}



	public InstrumentName getD14() {
		return d14;
	}



	public void setD14(InstrumentName d14) {
		this.d14 = d14;
	}



	public InstrumentName getD15() {
		return d15;
	}



	public void setD15(InstrumentName d15) {
		this.d15 = d15;
	}



	public InstrumentName getD16() {
		return d16;
	}



	public void setD16(InstrumentName d16) {
		this.d16 = d16;
	}



	public InstrumentName getD17() {
		return d17;
	}



	public void setD17(InstrumentName d17) {
		this.d17 = d17;
	}



	public InstrumentName getD18() {
		return d18;
	}



	public void setD18(InstrumentName d18) {
		this.d18 = d18;
	}



	public InstrumentName getD19() {
		return d19;
	}



	public void setD19(InstrumentName d19) {
		this.d19 = d19;
	}



	public InstrumentName getD20() {
		return d20;
	}



	public void setD20(InstrumentName d20) {
		this.d20 = d20;
	}



	public InstrumentName getD21() {
		return d21;
	}



	public void setD21(InstrumentName d21) {
		this.d21 = d21;
	}



	public InstrumentName getD22() {
		return d22;
	}



	public void setD22(InstrumentName d22) {
		this.d22 = d22;
	}



	public InstrumentName getD23() {
		return d23;
	}



	public void setD23(InstrumentName d23) {
		this.d23 = d23;
	}



	public InstrumentName getD24() {
		return d24;
	}



	public void setD24(InstrumentName d24) {
		this.d24 = d24;
	}




	
	

}
