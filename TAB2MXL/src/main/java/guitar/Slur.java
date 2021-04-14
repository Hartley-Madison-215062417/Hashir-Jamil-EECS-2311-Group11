package guitar;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement
@XmlType(propOrder= {"number", "placement" ,"type"})
public class Slur {
	@XmlAttribute
	int number;
	
	@XmlAttribute
	String type;
	
	@XmlAttribute
	final String placement ="above";

	public Slur(int num, String type) {
		super();
		this.number = num;
		this.type = type;
	}


	public Slur(){
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

	public String getPlacement() {
		return placement;
	}
	

}
