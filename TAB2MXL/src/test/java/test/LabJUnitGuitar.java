package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import guitar.Measure;
import guitar.Note;
import guitar.Parser;
import guitar.Part;
import guitar.Time;

public class LabJUnitGuitar {

	
	private Parser p1;
	private Parser p2;
	private Parser p3;
	
	private Note n1;
	private Note n2;
	private Note n3;
	private Note n4;
	
	private Time t1;
	private Time t2;
	
	private Part part;
	private Part fakePart;
	
	private List<Measure> measureList = new ArrayList<Measure>();
	private List<Note> notes = new ArrayList<Note>();
	private Measure m;
	
	
	private String sample = "--x--";
	private char[][] ca = new char[5][5];
	//ca = sample.toCharArray();
	
	@BeforeEach
	public void setUp() throws Exception {
		
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				if(j==3) {
					ca[i][j] = '1';
				}
				else {
					ca[i][j] = '-';
				}
			}
		}
		
		
		
		p1 = new Parser();
		p2 = new Parser("prototypeGuitarTab.txt");
		p3 = new Parser("prototypeGuitarTab.txt");
		
		m = p1.createMeasure(ca);
		
		n1 = new Note();
		n1.setDuration(2);
		
		n2 = new Note();
		n2.setDuration(2);
		
		n3 = new Note();
		n4 = n2;
		notes.add(n1);
		notes.add(n2);
		notes.add(n4);
		
		t1 = new Time();
		t2 = new Time(4,4);
		
		part = new Part();
		
//		m.setNotes(notes);
//		measureList.add(m);
//		
		
		
	}
	
	
	@Test
	public void testParerCreates() {
		assertNotSame(p1,p2);
		assertNotSame(p1,p3);
		assertNotSame(p2,p3);
	}
	
	@Test
	public void testNote() {
		
		assertSame(n2,n4);
		assertNotSame(n3,n2);
		assertNotSame(n1,n2);
		assertNotNull(n3);
		
	}
	
	@Test
	public void testTime() {
		
		assertNotSame(t1,t2);
		assertNotEquals(4,t1.getBeats());
		assertEquals(4,t2.getBeats());
		
	}
	
	@Test
	public void testPart() {
		assertNotNull(part);
		assertNull(fakePart);
		
	}
	
//	@Test
//	public void testNoteList() {
//		assertSame(notes.get(1), notes.get(2));
//		assertNotSame(notes.get(0),notes.get(1));
//		
//	}
	
//	@Test 
//	public void testMeasureList() {
//		assertNotNull(measureList);
//	}
	
	@Test
	public void testCreateMeasure() {
		assertNotNull(m);
	}
	
	
}
