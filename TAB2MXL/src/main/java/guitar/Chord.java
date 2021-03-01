package guitar;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement(name = "chord")
public class Chord {
	
	@XmlTransient
	int chord;

	public Chord() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
