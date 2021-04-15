package drums;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "score-instrument")
@XmlAccessorType(XmlAccessType.NONE)
@XmlType(propOrder = {"id", "instrumentName"})


public class ScoreInstrument {
	
	@XmlAttribute
	String id;
	
	@XmlElement(name = "instrument-name")
	String instrumentName;
	
	public ScoreInstrument() {
		super();
		//this.id = "hello";
		//this.instrumentName = new String("Snare");
		

		


				
		
		
		
	}
	
	

	public ScoreInstrument(String id, String instrumentName) {
		super();
		System.out.println("in constructor");
		this.id = id;
		this.instrumentName = instrumentName;
	}



	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getInstrumentName() {
		return instrumentName;
	}


	public void setInstrumentName(String instrumentName) {
		this.instrumentName = instrumentName;
	}



	
	



}
