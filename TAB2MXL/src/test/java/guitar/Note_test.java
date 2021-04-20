package guitar;

import guitar.Note;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.jupiter.api.Test;
import guitar.Note;


public class Note_test {
	
	/*
	 * Testing if pitch is set accurately for a tab file with no custom tuning in it
	 */
//	@Test
//	void testPitch1() {
//		Parser p = new Parser("guitar_basic.txt");
//		char[][] parsed = p.getTabCharMatrix();
//		int width = parsed[0].length; //gets the length of the entire first row
//		ArrayList<char[][]>tmpArray1 = p.measureSplitter(parsed);
//		Part part = p.createMusicalPart(tmpArray1);
//		scorePartwise sp = new scorePartwise();
//		sp.getParts().add(part);
//		
//		assertAll(
//				 "heading",
//			      () -> assertEquals("E", p.getPart().getPart().get(0).notes.get(0).getPitch().getStep() ),
//			      () -> assertEquals("B", p.getPart().getPart().get(0).notes.get(1).getPitch().getStep() ),
//			      () -> assertEquals("E", p.getPart().getPart().get(0).notes.get(2).getPitch().getStep() ),
//			      () -> assertEquals("G", p.getPart().getPart().get(0).notes.get(3).getPitch().getStep() ),
//			      () -> assertEquals("B", p.getPart().getPart().get(0).notes.get(4).getPitch().getStep() ),
//			      () -> assertEquals("E", p.getPart().getPart().get(0).notes.get(5).getPitch().getStep() ),
//			      () -> assertEquals("B", p.getPart().getPart().get(0).notes.get(6).getPitch().getStep() )
//
//		);
//		
//	}
//	
//	/*
//	 * Testing if pitch is set accurately for a tab file with custom tuning in it
//	 */
//	@Test
//	void testPitch2() {
//		Parser p = new Parser("customtuning.txt");
//		char[][] parsed = p.getTabCharMatrix();
//		int width = parsed[0].length; //gets the length of the entire first row
//		ArrayList<char[][]>tmpArray1 = p.measureSplitter(parsed);
//		Part part = p.createMusicalPart(tmpArray1);
//		scorePartwise sp = new scorePartwise();
//		sp.getParts().add(part);
//		
//		assertAll(
//				 "heading",
//			      () -> assertEquals("E", p.getPart().getPart().get(0).notes.get(0).getPitch().getStep() ),
//			      () -> assertEquals("B", p.getPart().getPart().get(0).notes.get(1).getPitch().getStep() ),
//			      () -> assertEquals("E", p.getPart().getPart().get(0).notes.get(2).getPitch().getStep() ),
//			      () -> assertEquals("G", p.getPart().getPart().get(0).notes.get(3).getPitch().getStep() ),
//			      () -> assertEquals("B", p.getPart().getPart().get(0).notes.get(4).getPitch().getStep() ),
//			      () -> assertEquals("E", p.getPart().getPart().get(0).notes.get(5).getPitch().getStep() ),
//			      () -> assertEquals("B", p.getPart().getPart().get(0).notes.get(6).getPitch().getStep() )
//
//		);
//		
//	}
	
	@Test
	void testPitch3() {
		Parser p = new Parser("fret0.txt");
		char[][] parsed = p.getTabCharMatrix();
		int width = parsed[0].length; //gets the length of the entire first row
		ArrayList<char[][]>tmpArray1 = p.measureSplitter(parsed);
		Part part = p.createMusicalPart(tmpArray1);
		scorePartwise sp = new scorePartwise();
		sp.getParts().add(part);
		
		assertAll(
				 "heading",
			      () -> assertEquals("E", p.getPart().getPart().get(0).notes.get(0).getPitch().getStep() ),
			      () -> assertEquals("B", p.getPart().getPart().get(0).notes.get(1).getPitch().getStep() ),
			      () -> assertEquals("G", p.getPart().getPart().get(0).notes.get(2).getPitch().getStep() ),
			      () -> assertEquals("D", p.getPart().getPart().get(0).notes.get(3).getPitch().getStep() ),
			      () -> assertEquals("A", p.getPart().getPart().get(0).notes.get(4).getPitch().getStep() ),
			      () -> assertEquals("E", p.getPart().getPart().get(0).notes.get(5).getPitch().getStep() )

		);
		
	}
	
	
	
}



























