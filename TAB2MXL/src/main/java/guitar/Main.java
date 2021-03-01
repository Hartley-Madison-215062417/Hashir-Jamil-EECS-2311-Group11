package guitar;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import tab2mxl.testing.Parser;



public class Main {
	
	public static void main(String[] args) {
		
		try {
		Parser parser = new Parser("src/main/java/tab2mxl/testing/prototypeGuitarTab.txt");
		Part part = parser.getMusicalPart();
		JAXBContext jc = JAXBContext.newInstance(Part.class);
		Marshaller ms = jc.createMarshaller();
		ms.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		ms.marshal(part, System.out);
		ms.marshal(part,new File("src//output//Output.xml"));
		}catch (JAXBException e) {
		// TODO Auto-generated catch block
		System.out.println(""+e.getMessage());
		}

	}
}
