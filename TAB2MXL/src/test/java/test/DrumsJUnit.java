package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import drums.Note;
import drums.Parser;
import drums.Measure;
import drums.part;
import drums.Time;

import tab2mxl.ParseDrums;

public class DrumsJUnit {

		private Parser p1;
		private Parser p2;
		private Parser p3;
		private Parser p4;
		
		private Note n1;
		private Note n2;
		private Note n3;
		private Note n4;
		
		private Time t1;
		private Time t2;
		
		private part part;
		private part fakePart;
		
		private List<Measure> measureList = new ArrayList<Measure>();
		private List<Note> notes = new ArrayList<Note>();
		private Measure m;
	
		private ArrayList<char[][]>tmpArray1 = new ArrayList<char[][]>();
		private ArrayList<char[][]>tmpArray2 = new ArrayList<char[][]>();
//		
//		private Parser p5;
//		private char[][] parsed2;
		private ArrayList<char[][]>output;
		private ArrayList<char[][]>output2;
		
		
		private File file = new File("drumTestTab.txt");
	//	private ParseDrums pardrum = new ParseDrums(file);
		
		
		
		@BeforeEach
		public void setUp() throws Exception {
			p1 = new Parser();
			p2 = new Parser("drumTestTab.txt");
			p3 = new Parser("drumTestTab.txt");
			
			
//			
//			
//			//m = p1.createMeasure(ca);
//			
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
			
			part = new part();
//			
//			
//			
//			p5 = new Parser("drumTestTab.txt");
//			parsed2 = p5.getTabCharMatrix();
//			output2 = p5.measureSplitter(parsed2);
			
			

			
		}
		
		@Test
		public void testParserConstructors() {
			assertNotSame(p1, p2);
			assertNotSame(p2, p3);
			assertNotSame(p1, p3);
		}
		
		
		@Test
		public void testParserConstructors2() {
			p4 = new Parser("AllAlongTheWatchtower.txt");
			assertNotNull(p4);
		}
		
		
		@Test
		public void testNote() {
			
			assertSame(n2,n4);
			assertNotSame(n3,n2);
			assertNotSame(n1,n2);
			assertNotNull(n2.getDuration());
			assertNotNull(n3);
			n2.setInstrumentID("P1-I45");
			assertEquals("P1-I45",n2.getInstrumentID());
			n2.setStem("up");
			assertEquals("up",n2.getStem());
			n2.setNotehead("x");
			assertEquals("x",n2.getNotehead());


			
		}
		
		
		@Test
		public void testTime() {
			
			assertNotSame(t1,t2);
			assertNotNull(t1.getBeats());
			assertNotNull(t1.getBeatType());
			assertEquals(4,t1.getBeats());
			assertEquals(4,t2.getBeats());
			t2.setBeatType(3);
			assertEquals(3,t2.getBeatType());
			
		}
		
		@Test
		public void testPart() {
			assertNotNull(part);
			assertNull(fakePart);
			
		}
		
		@Test 
		public void getTabCharMatrixTest() {
			char[][] parsed = p1.getTabCharMatrix();

			tmpArray1.add(parsed);
			tmpArray2.add(parsed);
			
			assertNotNull(tmpArray1);
			assertNotNull(tmpArray2);
			assertEquals(tmpArray1,tmpArray2);
			assertNotSame(tmpArray1,tmpArray2);

		}
		
		
		
//		@Test
//		public void TestMeasureSplitter() {
//			
//		//	output = pardrum.getTmp();
//			
//			
//			//assertNotNull(pardrum);
//			
//		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		@Test
//		public void testMeasureSplitter() {
//
//			Parser p = new Parser("drumTestTab.txt");
//			char[][] parsed = p.getTabCharMatrix();
//			ArrayList<char[][]>output = p.measureSplitter(parsed);
//			
//			assertNotNull(output);
//			assertNotEquals(output, tmpArray1);
//			
//			
//		}
//		
//		@Test
//		public void testMeasureSplitter2() {
//			
//			assertNotNull(output2);
//			//assertNotEquals(output2,tmpArray1);
////			
////			char[][] path3 = new char[2][4];
////			path3[1][1] = '|';
////			path3[1][2] = '-';
////			path3[1][3] = '-';
////			path3[1][4] = '|';
////			path3[2][1] = '|';
////			path3[2][2] = '-';
////			path3[2][3] = '-';
////			path3[2][4] = '|';
////			
////			Parser par = new Parser("|--|");
////			output = par.measureSplitter(par.getTabCharMatrix());
////			
////			Parser par2 = new Parser();
////			output2 = par2.measureSplitter(path3);
////			
////			assertNotNull(output2);
////			assertNotNull(output);
//			
//			
//		}
		
		

	

}
