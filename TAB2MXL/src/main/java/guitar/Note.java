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
	public Note(int s, int f) {
		// TODO Auto-generated constructor stub
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
	
	

}
