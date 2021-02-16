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
	private List<String> tabList;
	private File inputFile;
	private char[][] tabCharMatrix;
	private String outputFile;

	/**
	 * 
	 * Default constructor
	 * 
	 */
	public Parser() {

	}

	/**
	 * Input File Specified Constructor
	 * @param inFile, a file path containing a tab in txt form
	 */
	public Parser(String inFile) {
		inputFile = new File(inFile);		
		tabList = new ArrayList<String>();
		this.readFile();
		this.tabCharMatrix = this.tabToCharMatrix(this.tabList);
	}

	/**
	 * 
	 */
	private void readFile() {

		Scanner sc = null; 
		try {
			sc = new Scanner(inputFile);	
			while(sc.hasNextLine()){
				tabList.add(sc.nextLine());
			}      
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		finally {
			sc.close();
		}
	}


	public List<String> getTab() {
		return this.tabList;
	}

	/**
	 * 
	 * @param str
	 * @return
	 */
	public char[][] tabToCharMatrix(List<String> list) {

		int row = this.tabList.size();
		int col = this.tabList.get(0).length();		
		char[][] tabMatrix = new char[row][col];

		for (int i = 0; i < row; i++) {
			tabMatrix[i] = list.get(i).toCharArray();
		}
		return tabMatrix;
	}

	public void setTabCharMatrix(Parser p) {
		this.tabCharMatrix = this.tabToCharMatrix(this.tabList);
	}

	public char[][] getTabCharMatrix() {
		return this.tabCharMatrix;
	}

	/**
	 * 
	 * @author Hashir Jamil, Abhirami Venugopal, Tommy Lam
	 * This method converts a line of tabs into an ArrayList
	 * the ArrayList can then be used to check the measure (modulo) and be used to generate the notes
	 * @param str, a string to be converted into an ArrayList
	 * @return the ArrayList
	 */
	public List<String> tabToMatrix(String str) {

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

}