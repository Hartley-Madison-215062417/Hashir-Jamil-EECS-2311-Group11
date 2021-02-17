package tab2mxl;

import java.io.File;

import javax.xml.bind.*;

import tab2mxl.Clef;
import tab2mxl.Division;
import tab2mxl.Key;
import tab2mxl.Note;
import tab2mxl.Parser;
import tab2mxl.StaffDetails;
import tab2mxl.Time;
import tab2mxl.Measure;

public class MeasureJAXB {
	public void marshall() {
		try {
			Note n = new Note();
			Measure msr = new Measure(n);
			JAXBContext jc = JAXBContext.newInstance(Measure.class);
			Marshaller ma = jc.createMarshaller();
			ma.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			ma.marshal(msr, System.out);
			ma.marshal(msr, new File("src\\data\\Music.xml"));
			
		}catch (Exception e) {
			System.out.println(""+e.getMessage());
		}
	}
}
