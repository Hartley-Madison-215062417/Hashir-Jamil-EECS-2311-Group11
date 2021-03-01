package tab2mxl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MusicallyTest {

	@Test
	void testCheckLineStep() {
		
		char expected = 'A';
       // char actual = Musically.checkLineStep(2);
       // assertEquals(expected, actual, "The method should produce step for given line");
		
	}

	@Test
	void testCheckLineOctave() {
		
		int expected = 2;
        //int actual = Musically.checkLineOctave(1);
      //  assertEquals(expected, actual, "The method should produce octave for given line");
		
	}

	@Test
	void testIsGuitar() {
		
		boolean expected = false;
       // boolean actual = Musically.isGuitar("Drums");
     //   assertEquals(expected, actual, "The method should check if instrument is a guitar or not");
	}

}
