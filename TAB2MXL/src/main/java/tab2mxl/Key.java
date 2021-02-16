package tab2mxl;

public class Key {
	
	String key;
	
	
	int fifths;
	//fifths as an int, pos sharp, neg flats
	//mode: minor or major
	
	public Key() {
		this.key = "C";
		this.fifths = 0;
	}
	
	public Key (Parser p) {

		
		char[][] tabMatrix = p.getTabCharMatrix();
		this.key = search(tabMatrix);
		this.fifths = GenerateFifths(this.key);
		
	}
	
	private static String search(char[][] tabMatrix) {
		String defaultKey = "C";
		String word = "Key";
		String wordAlt = "key";
		String wordAlt2 = "KEY";
		char wordStart = 'k';
		for(int i = 0; i < tabMatrix.length; i++) {
			String checker = new String(tabMatrix[i]);
			if (word.equals(checker) || wordAlt.equals(checker) || wordAlt2.equals(checker)) {
				
				
				
				
				return checker;
			}
		}
		return defaultKey;
	}
	
	//Make method to change key to standard capital letter followed by lowercase b,s,m, or nothing
	
	private static int GenerateFifths(String key2) {
		/*
		 * Excuse the garbage if-else, wasn't wanting to make an enum and recursive method at the moment.
		 * May come and update later for efficiency.
		 */
		if(key2.equals("C") || key2.equals("Am")) {
			return 0;
		}
		else if(key2.equals("G")|| key2.equals("Em")) {
			return 1;
		}
		else if(key2.equals("D")|| key2.equals("Bm")) {
			return 2;
		}
		else if(key2.equals("A")|| key2.equals("Fsm")) {
			return 3;
		}
		else if(key2.equals("E")|| key2.equals("Csm")) {
			return 4;
		}
		else if(key2.equals("B")|| key2.equals("Gsm")) {
			return 5;
		}
		else if(key2.equals("Fs")|| key2.equals("Dsm")) {
			return 6;
		}
		else if(key2.equals("Cs")|| key2.equals("Asm")) {
			return 7;
		}
		else if(key2.equals("F")|| key2.equals("Dm")) {
			return -1;
		}
		else if(key2.equals("Bb")|| key2.equals("Gm")) {
			return -2;
		}
		else if(key2.equals("Eb")|| key2.equals("Cm")) {
			return -3;
		}
		else if(key2.equals("Ab")|| key2.equals("Fm")) {
			return -4;
		}
		else if(key2.equals("Db")|| key2.equals("Bbm")) {
			return -5;
		}
		else if(key2.equals("Gb")|| key2.equals("Ebm")) {
			return -6;
		}
		else if(key2.equals("F")|| key2.equals("Abm")) {
			return -7;
		}
		
		
		
		return 0;
		
	}
	
	

	
}
