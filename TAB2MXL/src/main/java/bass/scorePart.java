package bass;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.sun.xml.txw2.annotation.XmlElement;

@XmlRootElement(name ="score-part")
@XmlAccessorType(XmlAccessType.NONE)
@XmlType(propOrder= {"id","partName"})
public class scorePart {
	
	@XmlAttribute
	final String id = "P1";
	
	
	@javax.xml.bind.annotation.XmlElement(name = "part-name")
	final String partName = "Classical Guitar";

	public String getId() {
		return id;
	}

	public String getPartName() {
		return partName;
	}
	
	

}
