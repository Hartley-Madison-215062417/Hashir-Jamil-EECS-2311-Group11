package tab2mxl;

public class StaffDetails {
	StaffTuning staffTuning;
	
	//@XMLElement(name = "staff-lines")
	private int staffLines = 6;
	

	/**
	 * This constructor only supports standard tuning at this time
	 */
	public StaffDetails() {
		this.staffTuning = new StaffTuning('E',2);
		this.staffTuning = new StaffTuning('A',2);
		this.staffTuning = new StaffTuning('D',3);
		this.staffTuning = new StaffTuning('G',3);
		this.staffTuning = new StaffTuning('B',3);
		this.staffTuning = new StaffTuning('E',4);
	}
	
}
