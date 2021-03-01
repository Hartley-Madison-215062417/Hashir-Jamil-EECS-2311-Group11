package guitar;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name ="note")
@XmlAccessorType(XmlAccessType.NONE)
@XmlType(propOrder= {"pitch","duration","voice","type","notations"})

public class Note {
	
	@XmlElement
	Pitch pitch = new Pitch();
	
	@XmlElement
	int duration;
	
	@XmlElement
	int voice;
	
	@XmlElement
	String type;
	
	@XmlElement
	Notations notations = new Notations();
	
	public Note() {
		super();
	}
	
	public Note(Pitch pitch, int duration, int voice, String type, Notations notations) {
		super();
		this.pitch = pitch;
		this.duration = duration;
		this.voice = voice;
		this.type = type;
		this.notations = notations;
	}
	public Pitch getPitch() {
		return pitch;
	}
	public void setPitch(Pitch pitch) {
		this.pitch = pitch;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Notations getNotations() {
		return notations;
	}
	public void setNotations(Notations notations) {
		this.notations = notations;
	}

	public int getVoice() {
		return voice;
	}

	public void setVoice(int voice) {
		this.voice = voice;
	}
	
	public void setDefaultStep(Note n) {
		
		
		int string = n.getNotations().getTechnical().getString();		
		
		if(string == 1) {
			n.getPitch().setStep('E');
			n.getPitch().setOctave(4);
		}
		else if(string == 2) {
			n.getPitch().setStep('B');
			n.getPitch().setOctave(3);
		}
		else if(string == 3) {
			n.getPitch().setStep('G');
			n.getPitch().setOctave(3);
		}
		else if(string == 4) {
			n.getPitch().setStep('D');
			n.getPitch().setOctave(3);
		}
		else if(string == 5) {
			n.getPitch().setStep('A');
			n.getPitch().setOctave(2);
			
		}
		else if(string == 6) {
			n.getPitch().setStep('E');
			n.getPitch().setOctave(2);
		}
		
	}
	

}
