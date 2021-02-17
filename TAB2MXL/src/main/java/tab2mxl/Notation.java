package tab2mxl;

public class Notation {
	private Technical technical;
	
	public Notation(int string, int fret) {
		this.technical = new Technical(string, fret);
	}
	
	public Technical getTechnical() {
		return this.technical;
	}

	
	
}	
