package guitar;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "notations")
@XmlAccessorType(XmlAccessType.NONE)
@XmlType(propOrder= {"technical","slur","slide"})
public class Notations {
	
	@XmlElement
	Technical technical = new Technical();
	
	@XmlElement
	Slur slur;
	
	@XmlElement
	Slide slide;
	

	public Notations() {
		super();
	}

	public Notations(Technical technical, Slur slur, Slide slide) {
		super();
		this.technical = technical;
		this.slur = slur;
		this.slide = slide;
	}

	public Notations(Technical technical) {
		super();
		this.technical = technical;
	}

	public Technical getTechnical() {
		return technical;
	}

	public void setTechnical(Technical technical) {
		this.technical = technical;
	}
	public Slur getSlur() {
		return slur;
	}

	public void setSlur(Slur slur) {
		this.slur = slur;
	}
	

	public Slide getSlide() {
		return slide;
	}

	public void setSlide(Slide slide) {
		this.slide = slide;
	}

	
	
	
}

