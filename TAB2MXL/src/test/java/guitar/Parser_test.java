package guitar;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.jupiter.api.Test;

public class Parser_test {
	
	/**
	 *Testing the type of a note. Type of a note is assigned based on 
	 *the duration of the note. 
	 */
	@Test
	void testExpectedTypeDuration() {
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

}
