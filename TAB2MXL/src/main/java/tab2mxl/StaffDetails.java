package tab2mxl;

public class StaffDetails {
	StaffTuning staffTuning;
	
	public StaffDetails(Parser p) {
		this.staffTuning = new StaffTuning(p);
	}
	
	public StaffDetails() {
		this.staffTuning = new StaffTuning();
	}
}
