package tab2mxl;


import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement(name ="measures")

@XmlTransient
@XmlAccessorType(XmlAccessType.NONE)
public class Measures {
	
	@XmlElement(name="measures", type= Measure.class)
	private List<Measure> measures;
	
	public List<Measure> getCustomers(){
		return measures;
	}
	
	public void setCustomers(List<Measure> measures) {
		this.measures = measures;
	}

}