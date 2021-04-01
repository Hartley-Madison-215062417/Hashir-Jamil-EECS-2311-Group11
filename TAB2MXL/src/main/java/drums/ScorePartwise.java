package drums;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import guitar.Work;



@XmlRootElement(name ="score-partwise")
@XmlAccessorType(XmlAccessType.NONE)
@XmlType(propOrder= {"version","partlist","parts", "work"})
public class ScorePartwise {

	@XmlAttribute
	final double version = 3.1;
	
	@XmlElement(name = "part-list")
	PartList partlist = new PartList();
	
	@XmlElement(name = "work")
	Work work = new Work();
	
	@XmlElement(name ="part",type = part.class)
	ArrayList<part> parts = new ArrayList<part>();

	
	
	
	public ScorePartwise() {
		super();
	}

	public ArrayList<part> getParts() {
		return parts;
	}

	public void setParts(ArrayList<part> parts) {
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
	
	
	public void setWork(Work work) {
		this.work = work;
	}

	public Work getWork() {
		return work;
	}
	

}
