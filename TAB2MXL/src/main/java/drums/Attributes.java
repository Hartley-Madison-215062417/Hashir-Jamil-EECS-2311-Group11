package drums;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import guitar.Clef;
import guitar.Key;
import guitar.StaffDetails;
import guitar.Time;

@XmlRootElement(name = "attributes")
@XmlAccessorType(XmlAccessType.NONE)
@XmlType(propOrder = {"divisions", "key", "time", "clef", "sd"})
public class Attributes extends StaffDetails {

	@XmlElement
	int divisions;
	
	@XmlElement
	Key key;
	
	@XmlElement
	Time time;
	
	@XmlElement
	Clef clef;
	
	@XmlElement (name = "staff-details")
	StaffDetails sd;
	
	
	public Attributes() {
		super();
	}
	
	public Attributes(Key key, Time time, Clef clef, StaffDetails sd) {
		super();
		divisions = 2;
		this.key = key;
		this.time = time;
		this.clef = clef;
		this.sd = sd;
	}

	public Key getKey() {
		return key;
	}

	public void setKey(Key key) {
		this.key = key;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	public Clef getClef() {
		return clef;
	}

	public void setClef(Clef clef) {
		this.clef = clef;
	}

	public StaffDetails getSd() {
		return sd;
	}

	public void setSd(StaffDetails sd) {
		this.sd = sd;
	}

	public int getDivisions() {
		return divisions;
	}
	
	
	
	
}
