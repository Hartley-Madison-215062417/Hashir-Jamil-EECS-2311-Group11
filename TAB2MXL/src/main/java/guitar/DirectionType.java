package guitar;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name ="direction-type")
@XmlAccessorType(XmlAccessType.NONE)
@XmlType(propOrder= {"words"})
public class DirectionType {
	
//	@XmlElement
//	Words words = new Words();
//
//	public Words getWords() {
//		return words;
//	}
//
//	public void setWords(Words words) {
//		this.words = words;
//	}
//	
	@XmlElement
	String words;

	public String getWords() {
		return words;
	}

	public void setWords(String words) {
		this.words = words;
	}
	
	
}
