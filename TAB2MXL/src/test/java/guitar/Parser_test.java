package guitar;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.jupiter.api.Test;
import guitar.Parser;

public class Parser_test {
	
	/*
	 * Testing if the right division is calculated from given time signature, 
	 * only beats used not beatType
	 */
	@Test
	void testDivisions() {
		int beats = 4;
		int lengthMeasure = 33;
		int expected = 8;
		//int actual = Parser.calculateDivision(beats, lengthMeasure);
		//assertEquals(expected, actual);
	}
	
	@Test
	void testReadFile() {
		Parser p = new Parser("GRepeat.txt");
		List<String> actual = p.getTabList();
		assertTrue(actual.size() > 0);
		
	}
	
	//@Test
	void testCreateRepeatForward() {
		boolean repeatCreated = false;
		
		Parser p = new Parser("GRepeat.txt");
		char[][] parsed = p.getTabCharMatrix();
		int width = parsed[0].length; //gets the length of the entire first row
		ArrayList<char[][]>tmpArray1 = p.measureSplitter(parsed);
		Part part = p.createMusicalPart(tmpArray1);
		scorePartwise sp = new scorePartwise();
		sp.getParts().add(part);
		
		System.out.println(p.getPart().getPart().size());
		assertNotNull(p.getPart().getPart().get(0).getBarline1().getRepeat());	
	}
	
	//@Test
	void testCreateRepeatBackward() {
		boolean repeatCreated = false;
		
		Parser p = new Parser("GRepeat.txt");
		char[][] parsed = p.getTabCharMatrix();
		int width = parsed[0].length; //gets the length of the entire first row
		ArrayList<char[][]>tmpArray1 = p.measureSplitter(parsed);
		Part part = p.createMusicalPart(tmpArray1);
		scorePartwise sp = new scorePartwise();
		sp.getParts().add(part);
		
		//System.out.println(p.getPart().getPart().size());
		assertNotNull(p.getPart().getPart().get(0).getBarline2().getRepeat());	
	}
	
	@Test
	void testDoubleDigitFretBasic() {
		Parser p = new Parser("DoubleFretBasic.txt");
		char[][] parsed = p.getTabCharMatrix();
		int width = parsed[0].length; //gets the length of the entire first row
		ArrayList<char[][]>tmpArray1 = p.measureSplitter(parsed);
		Part part = p.createMusicalPart(tmpArray1);
		scorePartwise sp = new scorePartwise();
		sp.getParts().add(part);
		
		assertAll(
				 "heading",
			      () -> assertEquals(14, p.getPart().getPart().get(1).notes.get(2).getNotations().getTechnical().getFret() ),
			      () -> assertEquals(14, p.getPart().getPart().get(1).notes.get(3).getNotations().getTechnical().getFret() ),
			      () -> assertEquals(12, p.getPart().getPart().get(1).notes.get(4).getNotations().getTechnical().getFret() )

		);
	}
	
	@Test
	void testSingleDigitFretBasic() {
		Parser p = new Parser("SingleFretBasic.txt");
		char[][] parsed = p.getTabCharMatrix();
		int width = parsed[0].length; //gets the length of the entire first row
		ArrayList<char[][]>tmpArray1 = p.measureSplitter(parsed);
		Part part = p.createMusicalPart(tmpArray1);
		scorePartwise sp = new scorePartwise();
		sp.getParts().add(part);
		assertAll(
				 "heading",
			      () -> assertEquals(0, p.getPart().getPart().get(0).notes.get(0).getNotations().getTechnical().getFret() ),
			      () -> assertEquals(4, p.getPart().getPart().get(0).notes.get(1).getNotations().getTechnical().getFret() ),
			      () -> assertEquals(2, p.getPart().getPart().get(0).notes.get(2).getNotations().getTechnical().getFret() ),
			      () -> assertEquals(5, p.getPart().getPart().get(0).notes.get(3).getNotations().getTechnical().getFret() )

		);
	}
	
	@Test
	void testChord() {
		Parser p = new Parser("ChordBasic.txt");
		char[][] parsed = p.getTabCharMatrix();
		int width = parsed[0].length; //gets the length of the entire first row
		ArrayList<char[][]>tmpArray1 = p.measureSplitter(parsed);
		Part part = p.createMusicalPart(tmpArray1);
		scorePartwise sp = new scorePartwise();
		sp.getParts().add(part);
		assertNotNull(p.getPart().getPart().get(0).getNotes().get(1).getChord());
		assertNotNull(p.getPart().getPart().get(0).getNotes().get(2).getChord());
		assertNotNull(p.getPart().getPart().get(0).getNotes().get(3).getChord());
		assertNotNull(p.getPart().getPart().get(0).getNotes().get(4).getChord());
		assertNotNull(p.getPart().getPart().get(0).getNotes().get(5).getChord());
		
	}
	
	@Test
	void testHammerOn() {
		Parser p = new Parser("HammerAndHarmonic.txt");
		char[][] parsed = p.getTabCharMatrix();
		int width = parsed[0].length; //gets the length of the entire first row
		ArrayList<char[][]>tmpArray1 = p.measureSplitter(parsed);
		Part part = p.createMusicalPart(tmpArray1);
		scorePartwise sp = new scorePartwise();
		sp.getParts().add(part);
		
		assertNotNull(p.getPart().getPart().get(1).getNotes().get(1).getNotations().getTechnical().getHnew());
		
	}
	
	@Test
	void testHarmonic() {
		Parser p = new Parser("HammerAndHarmonic.txt");
		char[][] parsed = p.getTabCharMatrix();
		int width = parsed[0].length; //gets the length of the entire first row
		ArrayList<char[][]>tmpArray1 = p.measureSplitter(parsed);
		Part part = p.createMusicalPart(tmpArray1);
		scorePartwise sp = new scorePartwise();
		sp.getParts().add(part);
		
		assertAll(
				 "heading",
			      () -> assertNotNull(p.getPart().getPart().get(0).notes.get(0).getNotations().getTechnical().getHarmonic().getDefaultX()),
			      () -> assertNotNull(p.getPart().getPart().get(0).notes.get(1).getNotations().getTechnical().getHarmonic().getDefaultX()),
			      () -> assertNotNull(p.getPart().getPart().get(0).notes.get(2).getNotations().getTechnical().getHarmonic().getDefaultX()),
			      () -> assertNotNull(p.getPart().getPart().get(0).notes.get(4).getNotations().getTechnical().getHarmonic().getDefaultX())
		);
		
	}
	
	

}
