package tab2mxl;
import org.junit.jupiter.api.*; 
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;


import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class AttributesJAXBTest {
	File file = new File("src/main/java//output//Output.xml");
	
	@BeforeEach
	public void setUp() {

	AttributesJAXB obj = new AttributesJAXB();
	obj.marshall();
	}
	
	@Test
	public void testRoot() throws SAXException, IOException, ParserConfigurationException {

		
		
		 DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		 DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		 Document doc = dBuilder.parse(file);
		 dBuilder = dbFactory.newDocumentBuilder();
		 doc.getDocumentElement().normalize();
		
		
		assertTrue("attributes" ==  doc.getDocumentElement().getNodeName());
		
			} 
		
		
	

	@Test
	public void testmarshallclef() throws SAXException, IOException, ParserConfigurationException {
		AttributesJAXB obj = new AttributesJAXB();
		obj.marshall();
		
		
		 DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		 DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		 Document doc = dBuilder.parse(file);
		 dBuilder = dbFactory.newDocumentBuilder();
		 doc.getDocumentElement().normalize();
		 
		 
		 NodeList list = doc.getElementsByTagName("clef");
		 Node first = list.item(0); 
		 
		 
		 assertTrue(first.getNodeName() == "clef");
	         }
	
		
	
	
	@Test
	public void testmarshalltime() throws ParserConfigurationException, SAXException, IOException {
		
		AttributesJAXB obj = new AttributesJAXB();
		obj.marshall();
		
		
		 DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		 DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		 Document doc = dBuilder.parse(file);
		 dBuilder = dbFactory.newDocumentBuilder();
		 doc.getDocumentElement().normalize();
		 
		 
		 NodeList list = doc.getElementsByTagName("time");
		 Node first = list.item(0); 
		 
		 
		 assertTrue(first.getNodeName() == "time");
		
	}
}
