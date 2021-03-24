package bass;

import javax.xml.bind.annotation.*;

@XmlRootElement(name ="part-list")
@XmlAccessorType(XmlAccessType.NONE)
@XmlType(propOrder= {"scorepart"})
public class partList {
	
	@XmlElement(name ="score-part")
scorePart scorepart = new scorePart();

	public scorePart getScorepart() {
		return scorepart;
	}

	public void setScorepart(scorePart scorepart) {
		this.scorepart = scorepart;
	}


}
