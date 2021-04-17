package guitar;

import guitar.Note;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.jupiter.api.Test;
import guitar.Note;


public class Note_test {
	
	/**
	 * Testing if the standard tuning is applied to the note
	 */
//	@Test
//	public void testStandardTuning() {
//		Note n = new Note();
//		boolean test = false;
//		
//		int i = 1;
//		while(i <= 6 && test == false) {
//			n.getNotations().getTechnical().setString(i);
//			n.updatePitch(n);
//			if(i == 6)
//				test = true;
//				
//		}
//		
//		assertTrue(test);
//		
//	}
	
	@Test
	void testPitch() {
		Note n = new Note();
		n.getNotations().getTechnical().setFret(0);
		n.setPitch(new Pitch("E", 4));
		while(n.getNotations().getTechnical().getFret() <= 8) {
			n.updatePitch(n);
			if(n.getNotations().getTechnical().getFret() <= 7)
				assertEquals(4, n.getPitch().getOctave());
			
			else if(n.getNotations().getTechnical().getFret() <= 19)
				assertEquals(5, n.getPitch().getOctave());
			
			else
				assertEquals(6, n.getPitch().getOctave());
			
			n.getNotations().getTechnical().setFret(n.getNotations().getTechnical().getFret()+1);
		}
		
	}
	
}



























