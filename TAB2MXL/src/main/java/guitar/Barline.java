package guitar;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "barline")
@XmlAccessorType(XmlAccessType.NONE)
@XmlType(propOrder= {"location", "barStyle"})
public class Barline {
	
	@XmlAttribute
	String location;
	
	@XmlElement(name = "bar-style")
	String barStyle;
	
	public Barline() {
//		location = "right";
//		barStyle = "light-heavy";
		//commented because we don't need barline for every measure only last measure
	}
	public Barline(String location, String barStyle) {
		super();
		this.location = location;
		this.barStyle = barStyle;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getBarStyle() {
		return barStyle;
	}
	public void setBarStyle(String barStyle) {
		this.barStyle = barStyle;
	}
	
	

}
