package tab2mxl;

import java.util.regex.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.*;

/**
 * 
 * @author Hashir Jamil, Abhirami Venugopal, Tommy Lam
 *
 */
public class Parser {
	
	private String outputFile;
	//List<String> primitiveTabArr = new ArrayList<>();
	//public static int dashCount;
	
	/**
	 * 
	 * Default constructor
	 * 
	 */
	public Parser() {
		
	}
	
	/**
	 * 
	 * @author Hashir Jamil, Abhirami Venugopal, Tommy Lam
	 * This method converts a line of tabs into an ArrayList
	 * the ArrayList can then be used to check the measure (modulo) and be used to generate the notes
	 * @param str, a string to be converted into an ArrayList
	 * @return the ArrayList
	 */
	public List<String> tabToPrimitiveArray(String str) {
		
		String regexPattern = "^[A-Z|a-z][|]{1}[0-9[-][p|h|s|x|o|b|/]]+[|]$";
		Pattern pattern = Pattern.compile(regexPattern);
		Matcher matcher = pattern.matcher(str);
		
		List<String> line1Array = new ArrayList<String>();
		
		if (matcher.find()) {
			
			for (int i = 0; i < str.length(); i++) {
				line1Array.add(Character.toString(str.charAt(i)));
			}
		}
		
		return line1Array;
		
	}
	
	public String getOctave(String str) {
		
		
		
		return null;
		
	}
	
	/*
	 * public int stringLetterToNumber(Strings str) {
	 * 
	 * switch (str) {
	 * 
	 * case e: return 1;
	 * 
	 * case B: return 2;
	 * 
	 * case G: return 3;
	 * 
	 * case D: return 4;
	 * 
	 * case A: return 5;
	 * 
	 * case E: return 6; } return 0; }
	 */
	
	public void primitiveToXML(List<String> arr) {
		
		
		
		String guitarString = arr.get(0); //lowercase e
		
		
		try {
			
		FileWriter fw = new FileWriter(this.outputFile);
		PrintWriter pw = new PrintWriter(fw);
		
		pw.printf("%s","<technical>");
		
		pw.printf("\t%s","<string>", Strings.valueOf(guitarString).toString(), "</string>");
		
		for (int i = 2; i < arr.size() - 2; i++) {
			
			
			
		}
		
		
		
		
		
		pw.printf("%s","</technical>");
		}
		
		catch (IOException e) {
			e.printStackTrace();
			System.exit(69420);
		}
		/*
		 * must return something of the form
		 * 
		 * 	<technical>
		 * 		<string>x</string>			where 1 <= x <= 6 
		 * 		<fret>y</fret>				where 0 <= y <= 27
		 * 	</technical>
		 */
		
	}
	
	//public List<String> primitiveArrayToNoteArray(List<String> line1Array) {}
		
		
	
}