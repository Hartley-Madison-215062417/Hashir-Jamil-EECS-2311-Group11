package guitar;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name ="harmonic")
@XmlAccessorType(XmlAccessType.NONE)
@XmlType(propOrder= {"defaultX","defaultY","placement","printObject"})
public class Harmonic {
	
	@XmlAttribute(name = "default-x")
	final int defaultX = 3;
	
	@XmlAttribute(name = "default-y")
	final int defaultY = 24;
	
	@XmlAttribute
	final String placement = "above";
	
	@XmlAttribute(name = "print-object")
	final String printObject = "yes";
	
	public int getDefaultX() {
		return defaultX;
	}
	public int getDefaultY() {
		return defaultY;
	}
	public String getPlacement() {
		return placement;
	}
	public String getPrintObject() {
		return printObject;
	}
	
	

}
