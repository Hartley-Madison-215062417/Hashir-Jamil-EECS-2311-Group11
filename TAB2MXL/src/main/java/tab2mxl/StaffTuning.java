package tab2mxl;

public class StaffTuning {
	private char tuningStep;
	private int tuningOctave;
	
	private TuningStep string1;
	private TuningStep string2;
	private TuningStep string3;
	private TuningStep string4;
	private TuningStep string5;
	private TuningStep string6;
	
	
	/*
	 * The hard-coded method, based off standard guitar tuning.
	 * @Author Madison Hartley
	 */
	
	public StaffTuning() {
		this.setString1(new TuningStep(1));
		this.setString2(new TuningStep(2));
		this.setString3(new TuningStep(3));
		this.setString4(new TuningStep(4));
		this.setString5(new TuningStep(5));
		this.setString6(new TuningStep(6));
	}
	
	public StaffTuning(Parser p) {
		this.setString1(new TuningStep(1));
		this.setString2(new TuningStep(2));
		this.setString3(new TuningStep(3));
		this.setString4(new TuningStep(4));
		this.setString5(new TuningStep(5));
		this.setString6(new TuningStep(6));
	}
	


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

	public TuningStep getString1() {
		return string1;
	}

	public void setString1(TuningStep string1) {
		this.string1 = string1;
	}

	public TuningStep getString2() {
		return string2;
	}

	public void setString2(TuningStep string2) {
		this.string2 = string2;
	}

	public TuningStep getString3() {
		return string3;
	}

	public void setString3(TuningStep string3) {
		this.string3 = string3;
	}

	public TuningStep getString4() {
		return string4;
	}

	public void setString4(TuningStep string4) {
		this.string4 = string4;
	}

	public TuningStep getString5() {
		return string5;
	}

	public void setString5(TuningStep string5) {
		this.string5 = string5;
	}

	public TuningStep getString6() {
		return string6;
	}

	public void setString6(TuningStep string6) {
		this.string6 = string6;
	}
	
}
