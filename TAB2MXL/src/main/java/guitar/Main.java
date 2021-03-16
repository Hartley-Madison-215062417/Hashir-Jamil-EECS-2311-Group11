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
        
        ArrayList<char[][]> testArrayList3 = p.measureSplitter(parsed);
                
        char[][] tmp = testArrayList3.get(0);
        
        for (int i = 0; i < tmp.length ; i++) {
            //System.out.println(p.getTabCharMatrix()[i]);
        }
        
        char[][] tmp2 = testArrayList3.get(1);
        for (int i = 0; i < tmp2.length ; i++) {
            //System.out.println(p.getTabCharMatrix()[i]);
        }
	
		Part part = p.createMusicalPart(testArrayList3);
		
		JAXBContext jc = JAXBContext.newInstance(Part.class);
		Marshaller ms = jc.createMarshaller();
		ms.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

		ms.marshal(part,new File("src//main//java//output//Output.xml"));


		File output = new File("src//main//java//output//Output.xml");
		ms.marshal(part,output);

	}catch (JAXBException ex) {
		// TODO Auto-generated catch block
		System.out.println(""+ex.getMessage());
	}
	

	}

}
