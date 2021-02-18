package tab2mxl;

public class Pitch {
	private char step;
	private int octave;
	private int alter;
	
	public Pitch(char step, int octave) {
		this.step = step;
		this.octave = octave;
		this.alter = 0;
	}
	
	public Pitch(char step, int octave, int alter) {
		this.step = step;
		this.octave = octave;
		this.alter = alter;
	}

	public char constructStep() {
		return '0';
	}
	
	public char getStep() {
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
