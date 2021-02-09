package tab2mxl;
import java.io.*;
import javax.xml.bind.*;

public class AttributesJAXB {
	
	public void marshall() {
		Key example_key = new Key(0,"minor");
		int example_division = 24;
		Time example_time = new Time(3);
		Clef example_clef = new Clef("G",2);
		StaffDetails example_staffdetails = new StaffDetails(6);

		try {
			Attributes att = new Attributes(example_division, example_key,example_time,example_clef,example_staffdetails);
			JAXBContext jc = JAXBContext.newInstance(Attributes.class);
			Marshaller ms = jc.createMarshaller();
			ms.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			ms.marshal(att, System.out);
			ms.marshal(att,new File("src/main/java//output//Output.xml"));
		}
		catch(Exception e){
			System.out.println(""+e.getMessage());
			
		}
	}
	}


