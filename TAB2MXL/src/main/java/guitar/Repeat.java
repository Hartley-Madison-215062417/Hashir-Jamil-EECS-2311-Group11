package guitar;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlRootElement(name = "repeat")
@XmlAccessorType(XmlAccessType.NONE)
@XmlType(propOrder= {"direction"})
public class Repeat {
	
	@XmlAttribute
	String direction;

	
	public Repeat() {
		super();
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}
	

}
