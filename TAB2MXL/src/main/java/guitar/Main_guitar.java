package guitar;

import java.io.File;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class Main_guitar {

public static void main(String[] args) {
	
	try {
		
		Parser p = new Parser("guitar_basic.txt");
		char[][] parsed = p.getTabCharMatrix();
		int width = parsed[0].length; //gets the length of the entire first row
		ArrayList<char[][]>tmpArray1 = p.measureSplitter(parsed);

		Part part = p.createMusicalPart(tmpArray1);
		scorePartwise sp = new scorePartwise();
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
