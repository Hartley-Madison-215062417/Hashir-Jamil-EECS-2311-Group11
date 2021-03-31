package drums;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;



@XmlRootElement(name = "attributes")
@XmlAccessorType(XmlAccessType.NONE)
@XmlType(propOrder = {"divisions", "key", "time", "clef"})
public class Attributes {

	@XmlElement
	int divisions = 4;
	
	@XmlElement
	Key key;
	
	@XmlElement
	Time time;
	
	@XmlElement
	Clef clef;
	
	
	
	public Attributes() {
		super();
	}
	
	public Attributes(Key key, Time time, Clef clef) {
		super();
		divisions = 4;
		this.key = key;
		this.time = time;
		this.clef = clef;
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

	public int getDivisions() {
		return divisions;
	}
	
	public int setDivisions(int divisions) {
		return divisions;
	}
	
	
}
