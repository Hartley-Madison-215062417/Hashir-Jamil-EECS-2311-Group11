package guitar;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "work")
@XmlAccessorType(XmlAccessType.NONE)
@XmlType(propOrder= {"title"})

public class Work {
	public Work() {
		super();
	}

	@XmlElement(name ="work-title")
	String title = "Untitled";

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
