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
		Parser p = new Parser("prototypeGuitarTab.txt");
		List<String> actual = p.getTabList();
		assertTrue(actual.size() > 0);
		
	}
	
	@Test
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
	
	@Test
	void testCreateRepeatBackward() {
		boolean repeatCreated = false;
		
		Parser p = new Parser("GRepeat.txt");
		char[][] parsed = p.getTabCharMatrix();
		int width = parsed[0].length; //gets the length of the entire first row
		ArrayList<char[][]>tmpArray1 = p.measureSplitter(parsed);
		Part part = p.createMusicalPart(tmpArray1);
		scorePartwise sp = new scorePartwise();
		sp.getParts().add(part);
		
		System.out.println(p.getPart().getPart().size());
		assertNotNull(p.getPart().getPart().get(0).getBarline2().getRepeat());	
	}
	
	

}
