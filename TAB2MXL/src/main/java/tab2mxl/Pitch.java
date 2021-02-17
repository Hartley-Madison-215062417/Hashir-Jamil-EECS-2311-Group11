package tab2mxl;

public class Pitch {
	private char step;
	private int octave;
	private int alter;
	
	public Pitch(char step, int octave) {
		this.step = step;
		this.octave = octave;
	}

	public int constructStep() {
		return 0;
	}
	
	public int getStep() {
		return step;
	}

	public void setStep(char step) {
		this.step = step;
	}

	public int getAlter() {
		return alter;
	}

	public void setAlter(int alter) {
		this.alter = alter;
	}

	public int getOctave() {
		return octave;
	}

	public void setOctave(int octave) {
		this.octave = octave;
	}
	
}
