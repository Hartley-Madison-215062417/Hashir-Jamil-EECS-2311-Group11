package tab2mxl;

/*
 * @Author Tommy Lam
 */

public class DrumsStem {
	
	String stem;
	public String Stem(int voice) {
		if(voice == 1) {
			stem = "up";
		}else {
			stem = "down";
		}
		return stem;
	}

}
