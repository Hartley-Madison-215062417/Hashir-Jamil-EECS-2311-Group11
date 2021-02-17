package tab2mxl;

public class StaffTuning {
	private char tuningStep;
	private int tuningOctave;
	
	public StaffTuning(char tuningStep, int tuningOctave) {
		this.tuningStep = tuningStep;
		this.tuningOctave = tuningOctave;
	}
	public int getTuningStep() {
		return tuningStep;
	}
	public void setTuningStep(char tuningStep) {
		this.tuningStep = tuningStep;
	}
	public int getTuningOctave() {
		return tuningOctave;
	}
	public void setTuningOctave(int tuningOctave) {
		this.tuningOctave = tuningOctave;
	}
	
}
