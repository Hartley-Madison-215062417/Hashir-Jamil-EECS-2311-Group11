package drums;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "voice")
@XmlAccessorType(XmlAccessType.NONE)
@XmlType(propOrder = {"voice"})
public class Voice {

	int voice;
	
	public Voice() {
		super();
	}
	
	public Voice(String id) {

		if(id == "P1-I36") {
			voice = 2;
		}else {
			voice = 1;
		}
	
	}

	public int getVoice() {
		return voice;
	}

	public void setVoice(int voice) {
		this.voice = voice;
	}
	
	
	
}
