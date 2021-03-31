package testing;

import static org.junit.jupiter.api.Assertions.assertNotSame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import drums.Parser;

public class LabJUnit {



		private Parser p1;
		private Parser p2;
		private Parser p3;
		
		@BeforeEach
		public void setUp() throws Exception {
			p1 = new Parser();
			p2 = new Parser("drumTestTab.txt");
			p3 = new Parser("drumTestTab.txt");
		}
		
		
		@Test
		public void testParerCreates() {
			assertNotSame(p1, p2);
			assertNotSame(p1, p3);
			assertNotSame(p2, p3);
		}
	

}
