package guitar;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

class Main{
	
	public static void main(String[] args) {
	try {
		
//		Parser p = new Parser("prototypeGuitarTab.txt");
//        char[][] parsed = p.getTabCharMatrix();
//        
//        ArrayList<char[][]> testArrayList3 = new ArrayList<char[][]>();
//        testArrayList3.add(parsed);
//        testArrayList3.add(parsed);
//        
//        char[][] tmp = testArrayList3.get(0);
//        
//        for (int i = 0; i < tmp.length ; i++) {
//           // System.out.println(p.getTabCharMatrix()[i]);
//        }
//        
//        char[][] tmp2 = testArrayList3.get(1);
//        for (int i = 0; i < tmp2.length ; i++) {
//           // System.out.println(p.getTabCharMatrix()[i]);
//        }
//		
//		Parser parser = new Parser("prototypeGuitarTab.txt");
//		Part part = parser.createMusicalPart(testArrayList3);
//		scorePartwise sp = new scorePartwise();
//		sp.getParts().add(part);
//		
//		
//		
//		
//		JAXBContext jc = JAXBContext.newInstance(scorePartwise.class);
//		Marshaller ms = jc.createMarshaller();
//		ms.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
//		ms.marshal(sp, System.out);
//		ms.marshal(sp,new File("src//output//Output.xml"));
		
		HammerOn h = new HammerOn();
		JAXBContext jc = JAXBContext.newInstance(HammerOn.class);
		Marshaller ms = jc.createMarshaller();
		ms.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		ms.marshal(h, System.out);    

		
	}catch (JAXBException e) {
		// TODO Auto-generated catch block
		System.out.println(""+e.getMessage());
	}

	}
}

