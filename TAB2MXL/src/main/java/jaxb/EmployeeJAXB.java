package jaxb;

import javax.xml.bind.*;


import java.io.*;

public class EmployeeJAXB {
	public void marshall() {
		
		try {
			System.out.println("test1");
			Employee emp = new Employee("A001", "Manoj", "Nasik", 50000);
			System.out.println("test2");
			
			JAXBContext jc = JAXBContext.newInstance(Employee.class);
			System.out.println("test3");
			Marshaller ma = jc.createMarshaller();
			ma.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			System.out.println("test4");
			ma.marshal(emp, System.out);
			System.out.println("test5");
			File f = new File("Employee.xml");
			ma.marshal(emp, f );
			
			
		}catch (Exception e) {
			System.out.println(""+e.getMessage());
		}
	}
	
	
}
