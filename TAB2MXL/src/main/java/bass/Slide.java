package bass;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement
@XmlType(propOrder= {"linetype","number","type"})
public class Slide {
	
	@XmlAttribute(name ="line-type")
	String linetype = "solid";
	
	@XmlAttribute
	int number;


	@XmlAttribute
	String type;
	
	public Slide() {
		super();
	}
	
	
	public String getLinetype() {
		return linetype;
	}

	public void setLinetype(String linetype) {
		this.linetype = linetype;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
			

}
