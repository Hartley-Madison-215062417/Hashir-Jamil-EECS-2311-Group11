package tab2mxl;

public class Notation {
	private Technical technical;
	
	public Notation(int stringNum, int fretNum) {
		this.technical = new Technical(stringNum, fretNum);
	}
	
	public Technical getTechnical() {
		return this.technical;
	}

	
	
}	
