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
		
		Parser p = new Parser("prototypeGuitarTab.txt");
        char[][] parsed = p.getTabCharMatrix();
        
        ArrayList<char[][]> testArrayList3 = new ArrayList<char[][]>();
        testArrayList3.add(parsed);
        testArrayList3.add(parsed);
        
        char[][] tmp = testArrayList3.get(0);
        
        for (int i = 0; i < tmp.length ; i++) {
            System.out.println(p.getTabCharMatrix()[i]);
        }
        
        char[][] tmp2 = testArrayList3.get(1);
        for (int i = 0; i < tmp2.length ; i++) {
            System.out.println(p.getTabCharMatrix()[i]);
        }
		
		Parser parser = new Parser("prototypeGuitarTab.txt");
		Part part = parser.createMusicalPart(testArrayList3);
        JAXBContext jc = JAXBContext.newInstance(Part.class);
		Marshaller ms = jc.createMarshaller();
		ms.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		ms.marshal(part, System.out);
		ms.marshal(part,new File("src//output//Output.xml"));
        

//		int d = 1;
//		int v = 1;
//		String t = "eighth";
//		
//        Pitch p1 = new Pitch("E", 2);
//		Technical tech1 = new Technical(6, 0);
//		Notations no1 = new Notations(tech1);
//		Note n = new Note(p1, d, v, t, no1);
//		
//        JAXBContext jc = JAXBContext.newInstance(Note.class);
//		Marshaller ms = jc.createMarshaller();
//		ms.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
//		ms.marshal(n, System.out);
//		ms.marshal(n,new File("src//output//Output.xml"));
        
		
        
        

		
	}catch (JAXBException e) {
		// TODO Auto-generated catch block
		System.out.println(""+e.getMessage());
	}

	}
}

