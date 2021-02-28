package tab2mxl;
//
//public class Time {
//	
//	/*
//	 * @Author Madison Hartley 
//	 */
//	
//	
//	 int beats; //beat is the numerator (number of beats in a bar)
//	 int beatType; //beatType is denominator (the note type, e.g. 4/4 is 4 beats, each beat a quarter note in length)
//	
//	int length; //length of a measure (in chars)
//	char[] firstRow;
//	
//	
//	
//	public Time(Parser p) {
//		
//		this.firstRow = p.getTabCharMatrix()[1];
//		this.length = barLength(p);
//		this.beatType = timeSigBeatsType(p, this.length);
//		this.beats = timeSigBeats(p, length, this.beatType);
//		
//	}
//	
//	
//	/*
//	 * @Author Madison Hartley and Hashir Jamil
//	 */
//	private int barLength(Parser p) {
//		int length = 0;
//		int index = 0;
//		
//		while(this.firstRow[index] != '|') {
//			index++;
//		}
//		
//		index +=1;
//		
//		while(this.firstRow[index] != '|') {
//			index++;
//			length++;
//		}
//		
//		if(length-1 >= 13 && length-1 <= 19) {
//			return 16;
//		}
//		else {
//			return length-1; //need to decrement by 1 for proper return
//		}
//		
//	}
//
//	
//	
//	private int timeSigBeats(Parser p, int barlong, int beatstype) {
//		
//		int divvie = barlong/beatstype;
//		int mod = barlong%beatstype;
//		
//		
//		
//		
//		if(mod == 0 && divvie == beatstype) {
//			return divvie;
//		}
//		else if(mod == 0) {
//			return divvie;
//		}
//		else if(mod > 0) {
//			return divvie + mod;
//		}
//		
//		return 4;
//		
//	}
//	
//	
//	
//	
//	private int timeSigBeatsType(Parser p, int barlong) {
//		/*
//		 * Author: Madison Hartley
//		 * This is currently semi-hardcoded, but will suit 95% of tabs inputted. Will come back to update.
//		 */
//		
//		if((barlong%4)==0 || (barlong%4)==1) {
//			return 4;
//		}
//		else if((barlong%8)==0 || ((barlong%8)==1) || ((barlong%8)==2)) {
//			return 8;
//		}
//		
//
//		//Once beatsType is found, beats is simple. Figure out how many of the beat type occurs within a measure.
//		
//		return -1;
//	}
//	
//	
//	
//	
//	
//		
//
//	
//	
//	
//	
//}


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "time")
@XmlAccessorType(XmlAccessType.NONE)
@XmlType(propOrder= {"beats","beatType"})
public class Time {
	
	@XmlElement
	int beats;
	
	@XmlElement(name = "beat-type")
	int beatType;
	
	public Time() {
		super();
	}

	public Time(int beats, int beatType) {
		super();
		this.beats = beats;
		this.beatType = beatType;
	}

	public Time(Parser p) {
		// TODO Auto-generated constructor stub
	}

	public int getBeats() {
		return beats;
	}

	public void setBeats(int beats) {
		this.beats = beats;
	}

	public int getBeatType() {
		return beatType;
	}

	public void setBeatType(int beatType) {
		this.beatType = beatType;
	}
	
	
	
	

}

