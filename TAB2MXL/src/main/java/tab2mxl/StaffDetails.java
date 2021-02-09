package tab2mxl;

import javax.xml.bind.annotation.XmlElement;

public class StaffDetails {
	StaffTuning staffTuning;
	int staffLines;
	
	public StaffDetails(int staffLines) {
		this.staffLines = staffLines;
		
	}
	
	@XmlElement
	public StaffTuning getStaffTuning() {
		return staffTuning;
	}

	public void setStaffTuning(StaffTuning staffTuning) {
		this.staffTuning = staffTuning;
	}

	@XmlElement
	public int getStaffLines() {
		return staffLines;
	}

	public void setStaffLines(int staffLines) {
		this.staffLines = staffLines;
	}
}
