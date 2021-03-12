package drums;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlRootElement(name = "stem")
@XmlAccessorType(XmlAccessType.NONE)
@XmlType(propOrder = {"stem"})
public class Stem {

	@XmlElement
	String stem;
	
	
	public Stem() {
		super();
	}
	
	
	public Stem(int voice) {
		super();
		if(voice == 1) {
		stem = "up";
	}
		else {
		stem = "down";
		}
	}


	public String getStem() {
		return stem;
	}


	public void setStem(String stem) {
		this.stem = stem;
	}
	

	
}
