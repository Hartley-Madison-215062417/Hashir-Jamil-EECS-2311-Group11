package drums;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name ="score-partwise")
@XmlAccessorType(XmlAccessType.NONE)
@XmlType(propOrder= {"version","partlist","parts"})
public class scorePartwise {

	@XmlAttribute
	final double version = 3.1;
	
	@XmlElement(name = "part-list")
	PartList partlist = new PartList();
	
	@XmlElement(name ="part",type = Part.class)
	ArrayList<Part> parts = new ArrayList<Part>();
	
	
	public scorePartwise() {
		super();
	}

	public ArrayList<Part> getParts() {
		return parts;
	}

	public void setParts(ArrayList<Part> parts) {
		this.parts = parts;
	}

	public PartList getPartlist() {
		return partlist;
	}

	public void setPartlist(PartList partlist) {
		this.partlist = partlist;
	}

	public double getVersion() {
		return version;
	}

}
