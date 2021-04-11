package drums;

import java.io.File;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;


public class Main {

	public static void main(String[] args) {
		
		
		try {
			
			Parser p = new Parser("drumTestTab.txt");
			char[][] parsed = p.getTabCharMatrix();
			
			int width = parsed[0].length;
			ArrayList<char[][]>tmpArray1 = p.measureSplitter(parsed);
			
			//part part = p.createMusicalPart(tmpArray1);
//			Key k = new Key(0);
//			Time t = new Time(4,4);
//			Clef c = new Clef("percussion", 2);
//			Attributes a = new Attributes(k,t,c);
			
			
//			JAXBContext jc = JAXBContext.newInstance(part.class);
//			Marshaller ms = jc.createMarshaller();
//			ms.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
//			ms.marshal(part,System.out);
			
//			JAXBContext jc = JAXBContext.newInstance(Attributes.class);
//			Marshaller ms = jc.createMarshaller();
//			ms.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
//			ms.marshal(a,System.out);
			
		//	Measure m = new Measure();
			Unpitched u = new Unpitched("C", 1);
			Note n1 = new Note(u,2,"P1-I39", 1, "eigth", "up","x","0");
			
			Measure m = new Measure();
			m.getNotes().add(n1);
			part pa = new part();
			pa.getPart().add(m);
			ScorePartwise spa = new ScorePartwise();
			spa.getParts().add(pa);
			
			
			JAXBContext jc = JAXBContext.newInstance(ScorePartwise.class);
			Marshaller ms = jc.createMarshaller();
			ms.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			ms.marshal(spa,System.out);
			
			
			
		}catch (JAXBException ex) {
			System.out.println(""+ex.getMessage());
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
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


      
      //ArrayList<char[][]> testArrayList3 = new ArrayList<char[][]>();

//		
//		Parser par = new Parser("prototypeGuitarTab.txt");
//		Part part = par.createMusicalPart(testArrayList3);
//		scorePartwise sp = new scorePartwise();
//		sp.getParts().add(part);
		
		
	//	JAXBContext jc;
		//try {
			
			
			
//			jc = JAXBContext.newInstance(scorePartwise.class);
//			Marshaller letsdothis = jc.createMarshaller();
//			letsdothis.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
//			letsdothis.marshal(sp, System.out);
//			letsdothis.marshal(sp, new File("src//output//Output.xml"));
			
//			Key key = new Key(0);
//			Time time = new Time(4,4);
//			Clef clef = new Clef();
//			
//			
//			Attributes a = new Attributes(key, time, clef);
//			a.getClef().setSign("Percussion");
//			a.setDivisions(2);
//			a.getKey().setFifths(0);
//			a.getTime().setBeats(4);
//			a.getTime().setBeatType(4);
//
//			jc = JAXBContext.newInstance(Attributes.class);
//			Marshaller letsdothis = jc.createMarshaller();
//			letsdothis.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
//			letsdothis.marshal(a, System.out);
//			letsdothis.marshal(a, new File("src//output//Output.xml"));
//			
			
			//Part part = new Part();
	        //JAXBContext jc = JAXBContext.newInstance(Part.class);
	       // Marshaller ms = jc.createMarshaller();
	       // ms.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
	       // ms.marshal(part, System.out);
	     //   ms.marshal(part,new File("src//output//Output.xml"));
	

			
			
		//} catch (JAXBException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			//System.out.println(""+e.getMessage());
		//}
		
		
		

		
		
		
	}

}
