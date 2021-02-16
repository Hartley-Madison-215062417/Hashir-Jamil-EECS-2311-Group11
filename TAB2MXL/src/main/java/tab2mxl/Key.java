package tab2mxl;

public class Key {
	
	private String key;
	
	public Key (Parser p) {
	//	tmp = p.getTab();
		
		char[][] tabMatrix = p.getTabCharMatrix();
		 this.key = search(tabMatrix);
		
	}
	
	private static String search(char[][] tabMatrix) {
		String word = "Key";
		String wordAlt = "key";
		for(int i = 0; i < tabMatrix.length; i++) {
			String checker = new String(tabMatrix[i]);
			if (word.equals(checker) || wordAlt.equals(checker)) {
				return checker;
			}
		}
		return null; //If this is returned, in main method, include a throw or if statement to redirect into manually inputting key.
	}
	

	
}
