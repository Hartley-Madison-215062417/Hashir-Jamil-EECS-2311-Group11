package tab2mxl;

public class Pitch {
	private int step;
	private int octave;
	
	public Pitch(int step, int octave) {
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
