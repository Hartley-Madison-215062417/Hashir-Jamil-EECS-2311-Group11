package drums;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlTransient;

public class Measure {

	public Measure() {
		
	}
	
	@XmlTransient
	static int measureNumber = 1;
	
	@XmlAttribute
	int number;

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public void updateDuration(Measure m) {
		// TODO Auto-generated method stub
		
	}

	public Object getNotes() {
		// TODO Auto-generated method stub
		return null;
	}
}
