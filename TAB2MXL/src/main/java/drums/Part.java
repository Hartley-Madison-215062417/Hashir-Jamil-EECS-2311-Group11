package drums;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;



@XmlRootElement(name = "part")
@XmlAccessorType(XmlAccessType.NONE)
@XmlType(propOrder= {"id","measuresList"})
public class Part {

	@XmlAttribute
	final String id = "P1";
	
	@XmlElement(name = "measure",type = Measure.class)
	private List<Measure> measuresList = new ArrayList<Measure>();
	
	public Part() {
		super();
	}

	public Part(List<Measure> measuresList) {
		super();
		this.measuresList = measuresList;
	}

	public List<Measure> getPart() {
		return measuresList;
	}

	public void setPart(List<Measure> part) {
		this.measuresList = part;
	}
	
}
