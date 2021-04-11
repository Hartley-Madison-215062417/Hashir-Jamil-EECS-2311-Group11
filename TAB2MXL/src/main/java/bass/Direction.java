package bass;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name ="direction")
@XmlAccessorType(XmlAccessType.NONE)
@XmlType(propOrder= {"placement","directionType"})

public class Direction {
	
	@XmlAttribute
	String placement;
	
	@XmlElement
	DirectionType directionType;

	public String getPlacement() {
		return placement;
	}

	public void setPlacement(String placement) {
		this.placement = placement;
	}

	public DirectionType getDirectionType() {
		return directionType;
	}

	public void setDirectionType(DirectionType directionType) {
		this.directionType = directionType;
	}
	
	
	

}
