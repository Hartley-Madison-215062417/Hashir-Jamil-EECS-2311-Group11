package guitar;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name ="direction-type")
@XmlAccessorType(XmlAccessType.NONE)
@XmlType(propOrder= {"words","relativeX","relativeY"})
public class DirectionType {
	
	@XmlElement
	String words;
	
	@XmlAttribute
	String relativeX;
	
	@XmlAttribute
	String relativeY;

	public String getWords() {
		return words;
	}

	public void setWords(String words) {
		this.words = words;
	}

	public String getRelativeX() {
		return relativeX;
	}

	public void setRelativeX(String relativeX) {
		this.relativeX = relativeX;
	}

	public String getRelativeY() {
		return relativeY;
	}

	public void setRelativeY(String relativeY) {
		this.relativeY = relativeY;
	}
	
	
}
