package drums;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="note")
@XmlAccessorType(XmlAccessType.NONE)
@XmlType(propOrder= {"unpitched","duration","instrumentID","voice","type","stem","notehead","beamNumber"})

public class Note{

	@XmlElement
	Unpitched unpitched = new Unpitched();

	@XmlElement
	int duration = 2;

	@XmlElement
	String instrumentID;

	@XmlElement
	int voice = 1;

	@XmlElement
	String type;

	@XmlElement
	String stem;
	
	@XmlElement
	String notehead;
	
	@XmlElement
	String beamNumber;


	



	public Note() {
		super();
	}

	public Note(Unpitched unpitched, int duration, String instrumentID, int voice, String type, String stem, String notehead, String beamNumber) {
		super();
		this.unpitched = unpitched;
		this.duration = 2;
		this.instrumentID = instrumentID;
		this.voice = voice;
		this.type = type;
		this.stem = stem;
		this.notehead = notehead;
		this.beamNumber = beamNumber;
		


	}

	public Unpitched getUnpitched() {
		return unpitched;
	}

	public void setUnpitched(Unpitched unpitched) {
		this.unpitched = unpitched;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getInstrumentID() {
		return instrumentID;
	}

	public void setInstrumentID(String instrumentID) {
		this.instrumentID = instrumentID;
	}

	public int getVoice() {
		return voice;
	}

	public void setVoice(int voice) {
		this.voice = voice;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStem() {
		return stem;
	}

	public void setStem(String stem) {
		this.stem = stem;
	}

	public String getNotehead() {
		return notehead;
	}

	public void setNotehead(String notehead) {
		this.notehead = notehead;
	}
	
	public String getBeamNumber() {
		return beamNumber;
	}
	
	public void setBeamNumber(String beamNumber) {
		this.beamNumber = beamNumber;
	}

	//sets the display-octave
	public void setOctave(Note n) {
		int voice = n.getVoice();

		if(voice == 1) {
			n.getUnpitched().setOctave(5);
		}else if(voice == 2) {
			n.getUnpitched().setOctave(2);
		}else {
			n.getUnpitched().setOctave(0);
		}
	}
	
	//sets the display-step 
	public void setStep(char[][] firstMeasure) {
		Note n = new Note();
		for(int i = 0; i<firstMeasure.length; i++) {
			for(int j = 0; j<1; j++) {
				if(i==0) {
					n.getUnpitched().setStep("A");
				}else if(i==1) {
					n.getUnpitched().setStep("G");
				}else if(i==2) {
					n.getUnpitched().setStep("C");
				}else if(i==3) {
					n.getUnpitched().setStep("E");
				}else if(i==4) {
					n.getUnpitched().setStep("D");
				}else if(i==5) {
					n.getUnpitched().setStep("F");
				}else {
					n.getUnpitched().setStep("?");
				}
			}
		}
	}


	
	

	




}

