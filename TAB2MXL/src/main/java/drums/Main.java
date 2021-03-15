package drums;

import java.io.File;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;


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


      
//      ArrayList<char[][]> testArrayList3 = new ArrayList<char[][]>();
//
//		
//		Parser par = new Parser("prototypeGuitarTab.txt");
//		Part part = par.createMusicalPart(testArrayList3);
//		
//		
//		scorePartwise sp = new scorePartwise();
//		sp.getParts().add(part);
		
		
		JAXBContext jc;
		try {
			
//			scorePartwise
//			jc = JAXBContext.newInstance(scorePartwise.class);
//			Marshaller letsdothis = jc.createMarshaller();
//			letsdothis.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
//			letsdothis.marshal(sp, System.out);
//			letsdothis.marshal(sp, new File("src//output//Output.xml"));
			Note n = new Note();
			n.getUnpitched().setStep("G");
			n.getUnpitched().setOctave(5);
			n.setDuration(2);
			n.getInstrumentID("P1-I43");
			n.setVoice(1);
			n.setType("eighth");
			n.setStem("up");
			n.setNotehead("x");
			
			
			
			//Part
			jc = JAXBContext.newInstance(Note.class);
			Marshaller letsdothis = jc.createMarshaller();
			letsdothis.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			letsdothis.marshal(n, System.out);
			letsdothis.marshal(n, new File("src//output//Output.xml"));
			
			
			
			
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(""+e.getMessage());
		}

		
		
		
	}

}
