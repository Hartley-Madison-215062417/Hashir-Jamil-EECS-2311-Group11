package tab2mxl;

/*
 * @Author Tommy Lam
 */





public class DrumsXML extends Drums {
	
	
	
	public DrumsXML(char[][] tabs) {
		String instID1 = instrumentID(tabs);
		String step1 = stepDrums(tabs);
		int voice1 = voice(instID1);
		String stem1 = stem(voice1);
		int duration1 = duration();
		type(duration1);
		octave(voice1);
		
	}
	
	


}