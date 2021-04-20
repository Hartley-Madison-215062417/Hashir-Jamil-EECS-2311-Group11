package drums;

import java.io.File;
import java.util.ArrayList;

public class Caller {
	
	public ArrayList<char[][]> split = new ArrayList<char[][]>();
	public Parser parse;
	
	public Caller() {
		
	}
	
	public Caller(char[][] matr) {
		parse = new Parser();
		split = parse.measureSplitter(matr);
		System.out.println("made caller using matrix.");
	}
	
	public Caller(File file) {
		System.out.println("started constructor.");
		this.parse = new Parser(file);
		System.out.println("made parser with file.");
		this.split = parse.measureSplitter(parse.getTabCharMatrix());
		System.out.println("made caller using file.");
	}
	
	public Caller(String s) {
		this.parse = new Parser(s);
		this.split = parse.measureSplitter(parse.getTabCharMatrix());
	}
	
	
	

}
