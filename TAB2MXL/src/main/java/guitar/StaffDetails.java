package guitar;

//public class StaffDetails {
//	StaffTuning staffTuning;
//	
//
//	public StaffDetails(Parser p) {
//		this.staffTuning = new StaffTuning(p);
//	}
//	
//
//	//@XMLElement(name = "staff-lines")
//	private int staffLines = 6;
//	
//
//	/**
//	 * This constructor only supports standard tuning at this time
//	 */
//	public StaffDetails() {
//		this.staffTuning = new StaffTuning('E',2);
//		this.staffTuning = new StaffTuning('A',2);
//		this.staffTuning = new StaffTuning('D',3);
//		this.staffTuning = new StaffTuning('G',3);
//		this.staffTuning = new StaffTuning('B',3);
//		this.staffTuning = new StaffTuning('E',4);
//	}
//	
//
//}

import javax.xml.bind.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "staff-details")
@XmlAccessorType(XmlAccessType.NONE)
@XmlType(propOrder= {"staffLines", "s1", "s2", "s3", "s4", "s5", "s6"})

public class StaffDetails{
	
	@XmlElement(name = "staff-lines")
	int staffLines;
	
	@XmlElement (name = "staff-tuning")
	StaffTuning s1;
	
	@XmlElement(name = "staff-tuning")
	StaffTuning s2 ;
	
	@XmlElement(name = "staff-tuning")
	StaffTuning s3;
	
	@XmlElement(name = "staff-tuning")
	StaffTuning s4;
	
	@XmlElement(name = "staff-tuning")
	StaffTuning s5;
	
	@XmlElement(name = "staff-tuning")
	StaffTuning s6;
	
	public StaffDetails() {
		
		staffLines = 6;
		s1 = new StaffTuning(1, 'E', 2);
		s2 = new StaffTuning(2, 'A', 2);
		s3 = new StaffTuning(3, 'D', 3);
		s4 = new StaffTuning(4, 'G', 3);
		s5 = new StaffTuning(5, 'B', 3);
		s6 = new StaffTuning(6, 'E', 4);
		
		
		
		
	}

	public int getStaffLines() {
		return staffLines;
	}

	public void setStaffLines(int staffLines) {
		this.staffLines = staffLines;
	}

	public StaffTuning getS1() {
		return s1;
	}

	public void setS1(StaffTuning s1) {
		this.s1 = s1;
	}

	public StaffTuning getS2() {
		return s2;
	}

	public void setS2(StaffTuning s2) {
		this.s2 = s2;
	}

	public StaffTuning getS3() {
		return s3;
	}

	public void setS3(StaffTuning s3) {
		this.s3 = s3;
	}

	public StaffTuning getS4() {
		return s4;
	}

	public void setS4(StaffTuning s4) {
		this.s4 = s4;
	}

	public StaffTuning getS5() {
		return s5;
	}

	public void setS5(StaffTuning s5) {
		this.s5 = s5;
	}

	public StaffTuning getS6() {
		return s6;
	}

	public void setS6(StaffTuning s6) {
		this.s6 = s6;
	}
	
//	@Override 
//	public String toString() {
//	//	return staffLines + " "+ s1 + s2 + s3 + s4 + s5 + s6;
//	}
//	
	
}

