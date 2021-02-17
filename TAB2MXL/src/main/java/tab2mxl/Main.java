package tab2mxl;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import Testing14thFeb.Customer;
import Testing14thFeb.Customers;
import Testing14thFeb.Preference;
import jaxb.EmployeeJAXB;

public class Main {

	public static void main(String[] args ) {
		
		try {			
			
			MeasureJAXB obj = new MeasureJAXB();
			obj.marshall();
			
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			System.out.println(""+e.getMessage());
		}
		
	}
	
	
	}
	
}
