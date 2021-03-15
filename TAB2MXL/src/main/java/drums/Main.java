package drums;

import java.io.File;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import guitar.hammerOns;

public class Main {

	public static void main(String[] args) {
		
/*
 * //		JAXBContext jc = JAXBContext.newInstance(scorePartwise.class);
//		Marshaller ms = jc.createMarshaller();
//		ms.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
//		ms.marshal(sp, System.out);
//		ms.marshal(sp,new File("src//output//Output.xml"));
 * //		Parser parser = new Parser("prototypeGuitarTab.txt");
//		Part part = parser.createMusicalPart(testArrayList3);
//		scorePartwise sp = new scorePartwise();
//		sp.getParts().add(part);
 */


      
      ArrayList<char[][]> testArrayList3 = new ArrayList<char[][]>();

		
		Parser par = new Parser("prototypeGuitarTab.txt");
		Part part = par.createMusicalPart(testArrayList3);
		scorePartwise sp = new scorePartwise();
		sp.getParts.add(part);
		
		
		JAXBContext jc = JAXBContext.newInstance(scorePartwise.class);
		Marshaller letsdothis = jc.createMarshaller();
		letsdothis.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		letsdothis.marshal(sp, System.out);
		letsdothis.marshal(sp, new File("src//output//Output.xml"));
		
		
		
	}

}
