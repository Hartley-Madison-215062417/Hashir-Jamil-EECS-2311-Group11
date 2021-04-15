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
		
		scorePartwise sp = new scorePartwise();
		Part part = p.createMusicalPart(tmpArray1);
		sp.getParts().add(part);
		
		JAXBContext jc = JAXBContext.newInstance(scorePartwise.class);
		Marshaller ms = jc.createMarshaller();
		ms.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		ms.marshal(sp,System.out);	
		
	}catch (JAXBException ex) {
		// TODO Auto-generated catch block
		System.out.println(""+ex.getMessage());
	}
	
}
}
