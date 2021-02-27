package tab2mxl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "notations")
@XmlAccessorType(XmlAccessType.NONE)
@XmlType(propOrder= {"technical"})
public class Notations {
	
	@XmlElement
	Technical technical = new Technical();
	
	public Notations() {
		super();
	}

	public Notations(Technical technical) {
		super();
		this.technical = technical;
	}

	public Technical getTechnical() {
		return technical;
	}

	public void setTechnical(Technical technical) {
		this.technical = technical;
	}
	
	
	
}