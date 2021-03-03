package guitar;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "chord")
@XmlAccessorType(XmlAccessType.NONE)
@XmlType(propOrder= {"vacant"})

public class Chord {
	
	@XmlElement
	String vacant;	
	
	public Chord() {
		super();
	}

	public Chord(String vacant) {
		super();
		this.vacant = vacant;
	}

	public String getVacant() {
		return vacant;
	}

	public void setVacant(String vacant) {
		this.vacant = vacant;
	}
	
	

}
