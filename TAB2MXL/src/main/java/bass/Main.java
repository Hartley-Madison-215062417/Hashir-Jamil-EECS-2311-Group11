package bass;

import java.io.File;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class Main {

public static void main(String[] args) {

//	try {
//		
//		Parser p = new Parser("src/main/java/prototypeGuitarTab.txt");
//        char[][] parsed = p.getTabCharMatrix();
//        
//        ArrayList<char[][]> testArrayList3 = new ArrayList<char[][]>();
//        testArrayList3.add(parsed);
//        testArrayList3.add(parsed);
//        
//        char[][] tmp = testArrayList3.get(0);
//        
//        for (int i = 0; i < tmp.length ; i++) {
//            System.out.println(p.getTabCharMatrix()[i]);
//        }
//        
//        char[][] tmp2 = testArrayList3.get(1);
//        for (int i = 0; i < tmp2.length ; i++) {
//            System.out.println(p.getTabCharMatrix()[i]);
//        }
//		
//		Parser parser = new Parser("src/main/java/guitar/prototypeGuitarTab.txt");
//		Part part = parser.createMusicalPart(testArrayList3);
//		
//		JAXBContext jc = JAXBContext.newInstance(Part.class);
//		Marshaller ms = jc.createMarshaller();
//		ms.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
//		ms.marshal(part, System.out);
//		ms.marshal(part,new File("src//output//Output.xml"));
//        
//        
//
//		
//	}catch (JAXBException e) {
//		// TODO Auto-generated catch block
//		System.out.println(""+e.getMessage());
//	}
//

	
		
	try {
		
		Parser p = new Parser("prototypeGuitarTab.txt");
		char[][] parsed = p.getTabCharMatrix();
		
		int width = parsed[0].length; //gets the length of the entire first row
		
       
      
		ArrayList<char[][]>tmpArray1 = p.measureSplitter(parsed);

		//System.out.println("hi" + p.getTabCharMatrix()[6][0]);
		/*
		 * This will print every element in the array list.
		 */
		
		for(int i = 0; i < tmpArray1.size(); i++) {
			
			char[][] tmpPrint2 = tmpArray1.get(i);
			for(int j = 0; j < tmpPrint2.length; j++) {
				System.out.println(" ");
				for(int k = 0; k < tmpPrint2[0].length; k++) {
					System.out.print(tmpPrint2[j][k]);
				}
			}
			System.out.println(" ");
		}
		 
	//	tmpArray1.add(parsed);
		Part part = p.createMusicalPart(tmpArray1);
		
		JAXBContext jc = JAXBContext.newInstance(Part.class);
		Marshaller ms = jc.createMarshaller();
		ms.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		ms.marshal(part,System.out);
		
		
//		Parser p = new Parser("prototypeGuitarTab.txt");
//		
//        char[][] parsed = p.getTabCharMatrix();
//        
//        ArrayList<char[][]> testArrayList3 = p.measureSplitter(parsed);
//                
//        char[][] tmp = testArrayList3.get(0);
//        
//        for (int i = 0; i < tmp.length ; i++) {
//            System.out.println(p.getTabCharMatrix()[i]);
//        }
//        
//        char[][] tmp2 = testArrayList3.get(1);
//        for (int i = 0; i < tmp2.length ; i++) {
//            System.out.println(p.getTabCharMatrix()[i]);
//        }
//	
//		Part part = p.createMusicalPart(testArrayList3);
//		
//		JAXBContext jc = JAXBContext.newInstance(Part.class);
//		Marshaller ms = jc.createMarshaller();
//		ms.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
//
//		ms.marshal(part,new File("src//main//java//output//Output.xml"));
//
//
//		File output = new File("src//main//java//output//Output.xml");
//		ms.marshal(part,output);

	}catch (JAXBException ex) {
		// TODO Auto-generated catch block
		System.out.println(""+ex.getMessage());
	}
	
	
	


}
}
