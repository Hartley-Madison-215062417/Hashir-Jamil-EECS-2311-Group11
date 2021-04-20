package test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import drums.Parser;

public class DrumsTest {
	
	Parser p1;
	
	@BeforeEach
	public void setUp() throws Exception {
	p1 = new Parser("drumTestTab.txt");
	
	}
	
	
	@Test
	public void test1() {
		assertNotNull(p1);
	}

	
}
