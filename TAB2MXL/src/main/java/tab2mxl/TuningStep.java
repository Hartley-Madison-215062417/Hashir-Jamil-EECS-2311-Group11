package tab2mxl;

public class TuningStep {

	/*
	 * Hard-coded for standard guitar tuning. Update with alternate tunings later, or,
	 * a method to construct tuning based off info within the tab.
	 * @Author Madison Hartley
	 */
	
	char note;
	int octave;
	int string;
	
	public TuningStep(int string) {
		
		this.string = string;
		
		if(this.string == 1) {
			this.note = 'E';
			this.octave = 2;
		}
		else if(this.string == 2) {
			this.note = 'A';
			this.octave = 2;
		}
		else if(this.string == 3) {
			this.note = 'D';
			this.octave = 3;
		}
		else if(this.string == 4) {
			this.note = 'G';
			this.octave = 3;
		}
		else if(this.string ==  5) {
			this.note = 'B';
			this.octave = 3;
		}
		else if(this.string == 6) {
			this.note = 'E';
			this.octave = 4;
		}
		else {
			this.note = '?';
			this.octave = -1;
		}
	}
	
	
	
	
	
}
