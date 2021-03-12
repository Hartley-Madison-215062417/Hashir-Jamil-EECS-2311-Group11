package guitar;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement
@XmlType(propOrder= {"number","type"})
public class HammerOn {
	
	@XmlAttribute
	int number;
	
	@XmlAttribute
	String type;
	

	//final String h = "H";


	public HammerOn(int num, String type) {
		super();
		this.number = num;
		this.type = type;
	}


	public HammerOn() {
		super();

		// TODO Auto-generated constructor stub
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
