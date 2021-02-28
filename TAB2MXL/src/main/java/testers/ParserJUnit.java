package testers;

import tab2mxl.Parser;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/*
 * @Author: Madison Hartley
 */


class ParserJUnit {
	
	
	private Parser p;
	private Parser q;
	private File file = new File("prototypeGuitarTab.txt");
	
	@BeforeAll
	public void setup() throws Exception {
		p = new Parser("prototypeGuitarTab");
		q = new Parser(file);
	}
	

	@Test
	public void testConstructors() {
		
		assertEquals(p.getTabCharMatrix()[1],q.getTabCharMatrix()[1]);
		assertEquals(q.getTabCharMatrix()[1],p.getTabCharMatrix()[1]);
		assertNotSame(p,q);
		
		
	}
	
	@Test
	public void testGetFirstLine() {
		
		
		
	}
	
	
	@Test
	public void testThrows() {
		
		
		
	}
	
	

}
