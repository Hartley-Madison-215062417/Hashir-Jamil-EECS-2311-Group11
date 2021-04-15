package guitar;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.jupiter.api.Test;
import guitar.Measure;

public class Measure_test {
	
	/**
	 *Testing the type of a note. Type of a note is assigned based on 
	 *the duration of the note. 
	 */
	@Test
	void testExpectedTypeDuration1() {
		Attributes a = new Attributes();
		Time t = new Time(4, 4);
		a.setTime(t);
		a.setDivisions(4);

		Map<String, Integer> actual = new HashMap<String, Integer>();
		actual = Measure.typeTable(a);
		
		Map<String, Integer> expected = new HashMap<String, Integer>(){{
			put("whole", 16);
			put("half", 8);
			put("quarter", 4);
			put("eighth", 2);
			put("sixteenth", 1);
			
		}};
		
//		System.out.println("expected: ");
//		for(Entry<String, Integer> entry: expected.entrySet()) {
//			System.out.println(entry.getKey() + ":" + entry.getValue());
//		}
//		
//		System.out.println("actual");
//		for(Entry<String, Integer> entry: actual.entrySet()) {
//			System.out.println(entry.getKey() + ":" + entry.getValue());
//		}
		
		assertEquals(expected, actual);
		
	}
	
	@Test
	void testExpectedTypeDuration2() {
		//let the total no of dashes in a measure be 36
		Attributes a = new Attributes();
		Time t = new Time(6, 8);
		a.setTime(t);
		a.setDivisions(6);

		Map<String, Integer> actual = new HashMap<String, Integer>();
		actual = Measure.typeTable(a);
		
		Map<String, Integer> expected = new HashMap<String, Integer>(){{
			put("whole", 48);
			put("half", 24);
			put("quarter", 12);
			put("eighth", 6);
			put("sixteenth", 3);
			
		}};
		
		System.out.println("expected: ");
		for(Entry<String, Integer> entry: expected.entrySet()) {
			System.out.println(entry.getKey() + ":" + entry.getValue());
		}
		
		System.out.println("actual");
		for(Entry<String, Integer> entry: actual.entrySet()) {
			System.out.println(entry.getKey() + ":" + entry.getValue());
		}
		
		assertEquals(expected, actual);
		
	}
	
	@Test
	void testExpectedTypeDuration3() {
		//let the total no of dashes in a measure be 96
		Attributes a = new Attributes();
		Time t = new Time(2, 2);
		a.setTime(t);
		a.setDivisions(48);

		Map<String, Integer> actual = new HashMap<String, Integer>();
		actual = Measure.typeTable(a);
		
		Map<String, Integer> expected = new HashMap<String, Integer>(){{
			put("whole", 96);
			put("half", 48);
			put("quarter", 24);
			put("eighth", 12);
			put("sixteenth", 6);
			
		}};
		
		System.out.println("expected: ");
		for(Entry<String, Integer> entry: expected.entrySet()) {
			System.out.println(entry.getKey() + ":" + entry.getValue());
		}
		
		System.out.println("actual");
		for(Entry<String, Integer> entry: actual.entrySet()) {
			System.out.println(entry.getKey() + ":" + entry.getValue());
		}
		
		assertEquals(expected, actual);
		
	}
	
	
	@Test
	void testExpectedTypeDuration4() {
		//let the total no of dashes in a measure be 96
		Attributes a = new Attributes();
		Time t = new Time(6, 16);
		a.setTime(t);
		a.setDivisions(3);

		Map<String, Integer> actual = new HashMap<String, Integer>();
		actual = Measure.typeTable(a);
		
		Map<String, Integer> expected = new HashMap<String, Integer>(){{
			put("whole", 48);
			put("half", 24);
			put("quarter", 12);
			put("eighth", 6);
			put("sixteenth", 3);
			
		}};
		
		System.out.println("expected: ");
		for(Entry<String, Integer> entry: expected.entrySet()) {
			System.out.println(entry.getKey() + ":" + entry.getValue());
		}
		
		System.out.println("actual");
		for(Entry<String, Integer> entry: actual.entrySet()) {
			System.out.println(entry.getKey() + ":" + entry.getValue());
		}
		
		assertEquals(expected, actual);
		
	}
	
	@Test
	void testExpectedTypeDuration5() {
		//let the total no of dashes in a measure be 96
		Attributes a = new Attributes();
		Time t = new Time(6, 16);
		a.setTime(t);
		a.setDivisions(3);

		Map<String, Integer> actual = new HashMap<String, Integer>();
		actual = Measure.typeTable(a);
		
		Map<String, Integer> expected = new HashMap<String, Integer>(){{
			put("whole", 48);
			put("half", 24);
			put("quarter", 12);
			put("eighth", 6);
			put("sixteenth", 3);
			
		}};
		
		System.out.println("expected: ");
		for(Entry<String, Integer> entry: expected.entrySet()) {
			System.out.println(entry.getKey() + ":" + entry.getValue());
		}
		
		System.out.println("actual");
		for(Entry<String, Integer> entry: actual.entrySet()) {
			System.out.println(entry.getKey() + ":" + entry.getValue());
		}
		
		assertEquals(expected, actual);
		
	}
	
	//time signature with 1 as denom not written cause such time signatures are 
	//uncommon
	
	/*Testing guitar.Note.updateType()*/
	@Test
	void testNoteType1() {
		Measure m = new Measure();
		
		Note n = new Note();
		m.getNotes().add(n);
		
		Map<String, Integer> reference = new HashMap<String, Integer>(){{
			put("whole", 48);
			put("half", 24);
			put("quarter", 12);
			put("eighth", 6);
			put("sixteenth", 3);
			
		}};
		n.setDuration(12);
		String expected = "quarter";
		m.updateType(n, reference);
		String actual = n.getType();
		
		assertEquals(expected, actual);
	}
	
	@Test
	void testNoteType2() {
		Measure m = new Measure();
		
		Note n = new Note();
		m.getNotes().add(n);
		
		Map<String, Integer> reference = new HashMap<String, Integer>(){{
			put("whole", 48);
			put("half", 24);
			put("quarter", 12);
			put("eighth", 6);
			put("sixteenth", 3);
			
		}};
		n.setDuration(48);
		String expected = "whole";
		m.updateType(n, reference);
		String actual = n.getType();
		
		assertEquals(expected, actual);
	}
	
	@Test
	void testNoteType3() {
		Measure m = new Measure();
		
		Note n = new Note();
		m.getNotes().add(n);
		
		Map<String, Integer> reference = new HashMap<String, Integer>(){{
			put("whole", 48);
			put("half", 24);
			put("quarter", 12);
			put("eighth", 6);
			put("sixteenth", 3);
			
		}};
		n.setDuration(24);
		String expected = "half";
		m.updateType(n, reference);
		String actual = n.getType();
		
		assertEquals(expected, actual);
	}
	
	@Test
	void testNoteType4() {
		Measure m = new Measure();
		
		Note n = new Note();
		m.getNotes().add(n);
		
		Map<String, Integer> reference = new HashMap<String, Integer>(){{
			put("whole", 48);
			put("half", 24);
			put("quarter", 12);
			put("eighth", 6);
			put("sixteenth", 3);
			
		}};
		n.setDuration(6);
		String expected = "eighth";
		m.updateType(n, reference);
		String actual = n.getType();
		
		assertEquals(expected, actual);
	}
	
	@Test
	void testNoteType5() {
		Measure m = new Measure();
		
		Note n = new Note();
		m.getNotes().add(n);
		
		Map<String, Integer> reference = new HashMap<String, Integer>(){{
			put("whole", 48);
			put("half", 24);
			put("quarter", 12);
			put("eighth", 6);
			put("sixteenth", 3);
			
		}};
		n.setDuration(3);
		String expected = "sixteenth";
		m.updateType(n, reference);
		String actual = n.getType();
		
		assertEquals(expected, actual);
	}
	

}
