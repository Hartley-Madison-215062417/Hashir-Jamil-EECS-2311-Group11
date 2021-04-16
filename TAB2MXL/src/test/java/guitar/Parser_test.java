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

}
