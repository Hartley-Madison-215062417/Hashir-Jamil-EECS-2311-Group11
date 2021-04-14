
package guitar;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name ="words")
@XmlAccessorType(XmlAccessType.NONE)
@XmlType(propOrder= {"relativeX","relativeY"})
public class Words {
	
	@XmlAttribute(name = "relative-x")
	String relativeX;
	
	@XmlAttribute(name = "relative-y")
	String relativeY;
	
	@XmlTransient
	String content;
	
	public String getRelativeX() {
		return relativeX;
	}
	public void setRelativeX(String relativeX) {
		this.relativeX = relativeX;
	}
	public String getRelativeY() {
		return relativeY;
	}
	public void setRelativeY(String relativeY) {
		this.relativeY = relativeY;
	}
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	

}



