package tab2mxl;

/*
 * @Author Tommy Lam
 */

public class DrumsStep {
	String Steps;
	public String StepDrums(char [][] array) {
		for (int i = 0; i<array.length; i++)
			for(int j = 0; j < 1; j++) {
				if(i==0) {
					Steps = "A";
				}else if(i==1) {
					Steps = "G";
				}else if(i==2) {
					Steps = "C";
				}else if(i==3) {
					Steps = "D";
				}else if(i==4) {
					Steps = "E";
				}else if(i==5) {
					Steps = "F";
				}else {
					Steps = "?";
				}
			}
		return Steps;
	}
	

}
