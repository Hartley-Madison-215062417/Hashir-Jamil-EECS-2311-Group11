package tab2mxl;

public class StaffTuning {
	int tuningStep;
	int tuningOctave;
	
	public StaffTuning(int tuningStep, int tuningOctave) {
		this.tuningStep = tuningStep;
		this.tuningOctave = tuningOctave;
	}
	public int getTuningStep() {
		return tuningStep;
	}
	public void setTuningStep(int tuningStep) {
		this.tuningStep = tuningStep;
	}
	public int getTuningOctave() {
		return tuningOctave;
	}
	public void setTuningOctave(int tuningOctave) {
		this.tuningOctave = tuningOctave;
	}
	
}
