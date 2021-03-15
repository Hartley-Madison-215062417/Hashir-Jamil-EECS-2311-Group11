package drums;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="note")
@XmlAccessorType(XmlAccessType.NONE)
@XmlType(propOrder= {"unpitched","duration","instrumentID","voice","type","stem","notehead"})

public class Note{

	@XmlElement
	Unpitched unpitched = new Unpitched();

	@XmlElement
	int duration;

	@XmlElement
	String instrumentID;

	@XmlElement
	int voice;

	@XmlElement
	String type;

	@XmlElement
	String stem;

	@XmlElement
	String notehead;



	public Note() {
		super();
	}

	public Note(Unpitched unpitched, int duration, String instrumentID, int voice, String type, String stem, String notehead, String beamnumber) {
		super();
		this.unpitched = unpitched;
		this.duration = duration;
		this.instrumentID = instrumentID;
		this.voice = voice;
		this.type = type;
		this.stem = stem;
		this.notehead = notehead;
		


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

	public String setInstrumentID() {
		return instrumentID;
	}

	public void getInstrumentID(String instrumentID) {
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
}

