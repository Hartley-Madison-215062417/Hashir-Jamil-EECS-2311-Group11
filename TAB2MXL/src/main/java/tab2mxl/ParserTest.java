package tab2mxl;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

public class ParserTest {
	
	@Test
	public void testTabToPrimitiveArray1() {
		
		Parser p = new Parser();
		String str = "e|-5-7-7-|";
		List<Character> arr = new ArrayList<Character>();
		for (int i = 0; i < str.length(); i++) {
			arr.add(i,str.charAt(i));
		}
		
	}
	
	@Test
	public void testTabToPrimitiveArray2() {
		
		Parser p = new Parser();
		String str = "";
		assertEquals(str, p.tabToPrimitiveArray(str));
		
	}
	
	@Test
	public void testTabToPrimitiveArray3() {
		
		Parser p = new Parser();
		String str = "NonsenseString23094870";
		assertEquals(str, p.tabToPrimitiveArray(str));
		
	}
	
}
