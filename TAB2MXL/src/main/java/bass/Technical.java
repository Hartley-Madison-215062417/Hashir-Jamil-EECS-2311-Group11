//package bass;
//
////public class Technical {
////	private int string;
////	private int fret;
////	
////	public Technical(int stringNum, int fretNum) {
////		this.string = stringNum;
////		this.fret = fretNum;
////	}
////
////	public int getString() {
////		return string;
////	}
////
////	public void setString(int string) {
////		this.string = string;
////	}
////
////	public int getFret() {
////		return fret;
////	}
////
////	public void setFret(int fret) {
////		this.fret = fret;
////	}
////	
////	
////
////}
//
//
//import javax.xml.bind.annotation.XmlAccessType;
//import javax.xml.bind.annotation.XmlAccessorType;
//import javax.xml.bind.annotation.XmlElement;
//import javax.xml.bind.annotation.XmlRootElement;
//import javax.xml.bind.annotation.XmlType;
//
//@XmlRootElement(name = "technical")
//@XmlAccessorType(XmlAccessType.NONE)
//@XmlType(propOrder= {"hnew","h","pnew","p","string","fret"})
//public class Technical {
//	
//	@XmlElement
//	int string;
//	
//	@XmlElement
//	int fret;
//	
//	@XmlElement(name = "hammer-on")
//	hammerOns h;
//	
//	@XmlElement(name = "hammer-on")
//	hammerOns hnew;
//	
//	@XmlElement(name = "pull-off")
//	pullOff p;
//	
//	@XmlElement(name = "pull-off")
//	pullOff pnew;
//	
//
//	public Technical() {
//		super();
//	}
//	
//	public Technical(int string, int fret) {
//		super();
//		this.string = string;
//		this.fret = fret;
//	}
//	
//	public int getString() {
//		return string;
//	}
//	public void setString(int string) {
//		this.string = string;
//	}
//	public int getFret() {
//		return fret;
//	}
//	public void setFret(int fret) {
//		this.fret = fret;
//	}
//
//	public hammerOns getH() {
//		return h;
//	}
//
//	public void setH(hammerOns h) {
//		this.h = h;
//	}
//	
//	public pullOff getP() {
//		return p;
//	}
//
//	public void setP(pullOff p) {
//		this.p = p;
//	}
//
//	public hammerOns getHnew() {
//		return hnew;
//	}
//
//	public void setHnew(hammerOns hnew) {
//		this.hnew = hnew;
//	}
//
//	public pullOff getPnew() {
//		return pnew;
//	}
//
//	public void setPnew(pullOff pnew) {
//		this.pnew = pnew;
//	}
//}
//
