package tab2mxl;

public class Time {
	
	/*
	 * @Author Madison Hartley
	 *  Need to write an exception for tabs that didn't even bother include the vertical bars (yes, those exist, they're garbage)
	 *  
	 */
	
	
	int beats; //beat is the numerator (number of beats in a bar)
	int beatType; //beatType is denominator (the note type, e.g. 4/4 is 4 beats, each beat a quarter note in length)
	
	int length; //length of a measure (in chars)
	char[] firstRow;
	public Time(Parser p) {
		this.firstRow = p.getTabCharMatrix()[1];
		this.length = constructDivision(p);
		this.beatType = timeSigBeatsType(p, length);
		this.beats = timeSigBeats(p, length, this.beatType);
		
	}

	private int constructDivision(Parser p) {
		int division = 0; //counter variable
		
		
		int index = 0;
		
		while(this.firstRow[index] != '|') {
			index++;
		}
		
		index += 1;
		
		while(this.firstRow[index] != '|') {
			index++;
			division++;
		}
		
		return division - 1; //need to decrement by 1 for proper return
		
	}
	
	
	
	
	
	private int timeSigBeats(Parser p, int barLength, int beatsType) {
		
		//Once beatsType is found, beats is simple. Figure out how many of the beat type occurs within a measure.
		
		return -1;
	}
	
	
	
	
	private int timeSigBeatsType(Parser p, int barlength) {
		
		//Divide the bar into quarters, then check if notes line up properly
		//If not, halves
		//If not, thirds
		//and so on
		//The hard-coded way, a temporary measure.
		
		
		return -1;
	}
	
	
	
	
}
