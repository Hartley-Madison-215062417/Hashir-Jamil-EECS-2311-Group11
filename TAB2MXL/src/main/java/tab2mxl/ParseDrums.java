package tab2mxl;

import java.io.File;
import java.util.ArrayList;

import drums.Parser;
import drums.part;
import drums.ScorePartwise;

public class ParseDrums {

	ArrayList<char[][]> tmp = new ArrayList<char[][]>();
	Parser p;
	char[][] parsed;
	part part;
	ScorePartwise sp;
	
	//part part = p.createMusicalPart(tmpArray1);
	
	public ParseDrums(File file) {
		System.out.println("Code has reached ParsedDrums constructor. ");
		this.p = new Parser(file);
		this.parsed = p.getTabCharMatrix();
		this.tmp = p.measureSplitter(parsed);
		this.tmp.add(parsed);
		this.part = p.createMusicalPart(tmp);
		this.sp = new ScorePartwise();
		this.part = this.p.createMusicalPart(tmp);
		//this.sp.getParts().add(part);
		
	}

	public ArrayList<char[][]> getTmp() {
		return tmp;
	}

	public void setTmp(ArrayList<char[][]> tmp) {
		this.tmp = tmp;
	}

	public Parser getP() {
		return p;
	}

	public void setP(Parser p) {
		this.p = p;
	}

	public char[][] getParsed() {
		return parsed;
	}

	public void setParsed(char[][] parsed) {
		this.parsed = parsed;
	}

	public part getPart() {
		return part;
	}

	public void setPart(part part) {
		this.part = part;
	}

	public ScorePartwise getSp() {
		return sp;
	}

	public void setSp(ScorePartwise sp) {
		this.sp = sp;
	}
	
}
