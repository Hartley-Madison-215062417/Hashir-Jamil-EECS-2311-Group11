package drums;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement

public class InstrumentName {
	
	@XmlAttribute
	String id;

	@XmlElement(name = "instrument-name")
	public String instrumentName;
	

	public InstrumentName() {
		super();
	}
	
	public InstrumentName(String instrumentName, String id) {
		super();
		this.instrumentName = instrumentName;
		this.id = id;
	}
	
	
	public String getInstrumentName() {
		return instrumentName;
	}

	public void setInstrumentName(String instrumentName) {
		this.instrumentName = instrumentName;
	}


	

	
}
