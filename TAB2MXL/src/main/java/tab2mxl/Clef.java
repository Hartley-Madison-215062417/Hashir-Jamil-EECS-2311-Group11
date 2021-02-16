package tab2mxl;

public class Clef {
	char sign;
	int line;
	
	public Clef(char sign, int line) {
		this.sign = sign;
		this.line = line;
	}
	
	public char getSign() {
		return sign;
	}
	public void setSign(char sign) {
		this.sign = sign;
	}
	public int getLine() {
		return line;
	}
	public void setLine(int line) {
		this.line = line;
	}
}
