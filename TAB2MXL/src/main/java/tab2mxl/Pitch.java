package tab2mxl;

public class Pitch {
	int step;
	int octave;
	
	public Pitch(int step, int octave) {
		super();
		this.step = step;
		this.octave = octave;
	}

	public int getStep() {
		return step;
	}

	public void setStep(int step) {
		this.step = step;
	}

	public int getOctave() {
		return octave;
	}

	public void setOctave(int octave) {
		this.octave = octave;
	}
	
}
