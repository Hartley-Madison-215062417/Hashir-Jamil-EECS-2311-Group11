package bass;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "clef")
@XmlAccessorType(XmlAccessType.NONE)
@XmlType(propOrder= {"sign","line"})
public class Clef {
	
	@XmlElement
	String sign;
	
	@XmlElement
	int line;
	
	public Clef() {
		super();
	}
	public Clef(String sign, int line) {
		super();
		this.sign = sign;
		this.line = line;
	}
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	public int getLine() {
		return line;
	}
	public void setLine(int line) {
		this.line = line;
	}
	
	

}
