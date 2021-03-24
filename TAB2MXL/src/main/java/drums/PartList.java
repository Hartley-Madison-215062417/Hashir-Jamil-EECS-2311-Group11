package drums;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlRootElement(name ="part-list")
@XmlAccessorType(XmlAccessType.NONE)
@XmlType(propOrder= {"scorepart"})
public class PartList {
	
	
	@XmlElement(name ="score-part")
scorePart scorepart = new scorePart();

	public scorePart getScorepart() {
		return scorepart;
	}

	public void setScorepart(scorePart scorepart) {
		this.scorepart = scorepart;
	}

}
