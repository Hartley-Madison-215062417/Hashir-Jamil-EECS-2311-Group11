package tab2mxl;

import java.io.File;
import tab2mxl.Parser;

/*
 * @Author: Madison Hartley
 * 
 * This method does not use JUnit, but rather, is a simple "print-the-array" test.
 * This is done to see exactly what is being created, and if what is created matches the original text file.
 * 
 */

@SuppressWarnings("unused")
public class ParserTest {
	
	
	 public static void main(String[] args) {
	
	Parser p = new Parser("prototypeGuitarTab.txt");
	//System.out.println(p.getTabCharMatrix());
	
	for (int i = 0; i < p.getTabCharMatrix().length; i++) {
        System.out.println(p.getTabCharMatrix()[i]);
    }
	
	Parser p2 = new Parser("prototypeGuitarTab2.txt");
	//System.out.println(p2.getTabCharMatrix());
	
	for (int i = 0; i < p2.getTabCharMatrix().length; i++) {
        System.out.println(p2.getTabCharMatrix()[i]);
    }
	
	Parser creep = new Parser("creep.txt");
    
	for (int i = 0; i < creep.getTabCharMatrix().length; i++) {
        System.out.println(creep.getTabCharMatrix()[i]);
    }
	
	Parser jimi = new Parser("AllAlongTheWatchtower.txt");
	
	for (int i = 0; i < jimi.getTabCharMatrix().length; i++) {
        System.out.println(jimi.getTabCharMatrix()[i]);
    }
	
	//System.out.println(p.getFirstLine(p.getTabCharMatrix()));
	
	
	 }
	
	

}






/*
 * Extras: @Authors: Madison Hartley and Hashir Jamil
 * 
 * 
 *     for (int i = 0; i < p.getTabCharMatrix().length; i++) {
        System.out.println(p.getTabCharMatrix()[i]);
    }

    for (int i = 0; i < p.getTabCharMatrix().length - 1; i++) {
        for (int j = 0; j < p.getTabCharMatrix()[0].length - 1; j++) {
           // System.out.println(p.getFirstMeasure(p.getFirstLine(p.getTabCharMatrix())).get(1)[j]);
        	
        }
    }
 */


