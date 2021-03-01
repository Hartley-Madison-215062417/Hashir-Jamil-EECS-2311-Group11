package guitar;


import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;



@XmlRootElement(name = "part")
@XmlAccessorType(XmlAccessType.NONE)
public class Part {
	
	@XmlElement(name = "measure",type = Measure.class)
	private List<Measure> part = new ArrayList<Measure>();
	

	public Part() {
		super();
	}

	public Part(List<Measure> part) {
		super();
		this.part = part;
	}

	public List<Measure> getPart() {
		return part;
	}

	public void setMeasures(List<Measure> part) {
		this.part = part;
	}
	
	
}
