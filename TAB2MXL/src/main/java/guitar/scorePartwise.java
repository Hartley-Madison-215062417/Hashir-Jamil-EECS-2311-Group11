package guitar;

import java.util.ArrayList;

import javax.xml.bind.annotation.*;

@XmlRootElement(name ="score-partwise")
@XmlAccessorType(XmlAccessType.NONE)
@XmlType(propOrder= {"version","work","partlist","parts"})
public class scorePartwise {
	
	@XmlAttribute
	final double version = 3.1;
	
	@XmlElement(name = "part-list")
	partList partlist = new partList();
	
	@XmlElement(name = "work")
	Work work = new Work();
	
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

	public partList getPartlist() {
		return partlist;
	}

	public void setPartlist(partList partlist) {
		this.partlist = partlist;
	}

	public double getVersion() {
		return version;
	}
//	public void setWork(Work work) {
//		this.work = work;
//	}
//
//	public Work getWork() {
//		return work;
//	}
	
	

}
