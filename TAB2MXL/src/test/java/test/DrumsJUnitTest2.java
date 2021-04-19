package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import drums.Parser;


public class DrumsJUnitTest2 {
	
	
	@Test
	void testDivisions() {
		Parser p = new Parser("drumTestTab.txt");
		List<String> actual = p.getTabList();
		assertTrue(actual.size() > 0);
	}
	
//	@Test
//	void testCaller() {
//		Parser p = new Parser("drumTestTab.txt");
//		char[][] temp = p.getSplitMeasure(p.getTabCharMatrix());
//		assertNotNull(temp);
//		
//	}
	

}
