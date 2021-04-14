package guitar;

import java.io.File;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class Main {

public static void main(String[] args) {
	
	try {
		
		Parser p = new Parser("prototypeGuitarTab.txt");
		char[][] parsed = p.getTabCharMatrix();
		int width = parsed[0].length; //gets the length of the entire first row
		ArrayList<char[][]>tmpArray1 = p.measureSplitter(parsed);

		Part part = p.createMusicalPart(tmpArray1);
		JAXBContext jc = JAXBContext.newInstance(Part.class);
		Marshaller ms = jc.createMarshaller();
		ms.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		ms.marshal(part,System.out);	
		
//		StaffTuning st = new StaffTuning(1,"A",1);
//		Key k = new Key(1);
//		Time t = new Time(4, 4);
//		Clef c = new Clef("A", 1);
//		StaffDetails sd = new StaffDetails();
//		Attributes a = new Attributes(k, t, c, sd);
//		a.setDivisions(2);
		
//		Pitch p = new Pitch ("A", 1, "A"); //
//		Slide s = new Slide("A", 1, "A"); //
//		Slur sr = new Slur(1, "A"); // 
//		Technical t = new Technical(2, 1); //
//		Chord c = new Chord();
//		Notations n = new Notations(t, sr, s);
//		Note n1 = new Note(p, 2, "hello", n);
//		
//		
//		
//		JAXBContext jc = JAXBContext.newInstance(Note.class);
//		Marshaller ms = jc.createMarshaller();
//		ms.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
//		ms.marshal(n1,System.out);	
//		
		

	}catch (JAXBException ex) {
		// TODO Auto-generated catch block
		System.out.println(""+ex.getMessage());
	}
	
	
	


}
}
