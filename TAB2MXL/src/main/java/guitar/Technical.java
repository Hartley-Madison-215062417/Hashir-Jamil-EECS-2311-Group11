package guitar;

//public class Technical {
//	private int string;
//	private int fret;
//	
//	public Technical(int stringNum, int fretNum) {
//		this.string = stringNum;
//		this.fret = fretNum;
//	}
//
//	public int getString() {
//		return string;
//	}
//
//	public void setString(int string) {
//		this.string = string;
//	}
//
//	public int getFret() {
//		return fret;
//	}
//
//	public void setFret(int fret) {
//		this.fret = fret;
//	}
//	
//	
//
//}


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "technical")
@XmlAccessorType(XmlAccessType.NONE)
@XmlType(propOrder= {"string","fret"})
public class Technical {
	
	@XmlElement
	int string;
	
	@XmlElement
	int fret;
		
	public Technical() {
		super();
	}
	
	public Technical(int string, int fret) {
		super();
		this.string = string;
		this.fret = fret;
	}
	
	public int getString() {
		return string;
	}
	public void setString(int string) {
		this.string = string;
	}
	public int getFret() {
		return fret;
	}
	public void setFret(int fret) {
		this.fret = fret;
	}
	
	
}

