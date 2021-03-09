package drums;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "key")
@XmlAccessorType(XmlAccessType.NONE)
@XmlType(propOrder= {"fifths"})
public class Key {

	@XmlElement
	int fifths;

	public Key() {
		super();
	}

	public Key(int fifths) {
		super();
		this.fifths = fifths;
	}

	public int getFifths() {
		return fifths;
	}

	public void setFifths(int fifths) {
		this.fifths = fifths;
	}
	
}
