package tab2mxl;

import javax.xml.bind.annotation.XmlElement;

public class Clef {
	String sign;
	int line;
	
	public Clef(String sign, int line) {
		this.sign = sign;
		this.line = line;
		
	}
	
	@XmlElement
	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}
	
	@XmlElement

	public int getLine() {
		return line;
	}

	public void setLine(int line) {
		this.line = line;
	}
	
}
