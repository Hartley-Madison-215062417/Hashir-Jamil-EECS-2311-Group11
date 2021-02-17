package tab2mxl;

public class Clef {

	String sign;
	int line;

	

	
	public Clef(String sign, int line) {
		this.sign = sign;
		this.line = line;
	}
	
	public Clef() {
		this.sign = "TAB";
		this.line = 5;
		
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
