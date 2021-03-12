package test;

import guitar.Parser;
import org.junit.jupiter.api.Assertions.*;


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
	private File file = new File("C:\\Users\\maddi\\Documents\\EECS2311\\prototypeGuitarTab.txt");
	
	@BeforeEach
	public void setup() {
		p = new Parser("prototypeGuitarTab.txt");
		q = new Parser(file);
	}
	

	@Test
	public void testConstructors() {
		

		assertNotNull(p);
		assertNotNull(q);
		
		
	}
	
	@Test
	public void testGetFirstLine() {
		

		assertNotEquals(p,q);
		
	}
	
	
	@Test
	public void testThrows() {

		assertNotSame(p,q);
		
	}
	
	

}
