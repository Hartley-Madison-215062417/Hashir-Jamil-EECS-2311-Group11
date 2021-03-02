package guitar;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name ="note")
@XmlAccessorType(XmlAccessType.NONE)
@XmlType(propOrder= {"pitch","duration","voice","type","notations","chord"})

public class Note {
	
	@XmlElement
	Pitch pitch = new Pitch();
	
	@XmlElement
	int duration;
	
	@XmlElement
	final int voice = 1;
	
	@XmlElement
	String type;
	
	@XmlElement
	Notations notations = new Notations();
	
	@XmlElement
	Chord chord;
	
	public Note() {
		super();
	}
	
	public Note(Pitch pitch, int duration, int voice, String type, Notations notations) {
		super();
		this.pitch = pitch;
		this.duration = duration;
		//this.voice = voice;
		this.type = type;
		this.notations = notations;
	}
	public Note(int s, int f) {
		// TODO Auto-generated constructor stub
	}

	public Pitch getPitch() {
		return pitch;
	}
	public void setPitch(Pitch pitch) {
		this.pitch = pitch;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Notations getNotations() {
		return notations;
	}
	public void setNotations(Notations notations) {
		this.notations = notations;
	}

	public int getVoice() {
		return voice;
	}

//	public void setVoice(int voice) {
//		this.voice = voice;
//	}
//	
	public void setDefaultStep(Note n) {

		int string = n.getNotations().getTechnical().getString();		
		
		if(string == 1) {
			n.getPitch().setStep("E");
			n.getPitch().setOctave(4);
		}
		else if(string == 2) {
			n.getPitch().setStep("B");
			n.getPitch().setOctave(3);
		}
		else if(string == 3) {
			n.getPitch().setStep("G");
			n.getPitch().setOctave(3);
		}
		else if(string == 4) {
			n.getPitch().setStep("D");
			n.getPitch().setOctave(3);
		}
		else if(string == 5) {
			n.getPitch().setStep("A");
			n.getPitch().setOctave(2);
			
		}
		else if(string == 6) {
			n.getPitch().setStep("E");
			n.getPitch().setOctave(2);
		}
		
	}
	
	//this method updates step and octave in pitch 
		public Note updatePitch(Note n) {
			int octave;
			int fret = n.getNotations().getTechnical().getFret();
			/*
			String dStep;
			dStep = Character.toString(defaultStep);
			//need to open alter tags whenever you encounter a sharp#
			String [] originalData = {"C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B", "C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B"};
			String[] relevantData = new String[24]; //specifically 24 because a guitar can have a maximum for 24 frets
			int index;
			
			for (int i =1 ; i <= 12; i++) {
				if(originalData[i] == dStep) {
					index = i;
					break;
				}
			}
			
			for (int i = j; i <=12;)
			*/// this part is supposed to generate the right list of step options 
			//automatically, but for now I'm making a database
			
			String defaultStep = n.getPitch().getStep();
			
			String[] rData = new String[24];
					
			if (n.getPitch().getStep() == "E") {
				
			String[] relevantData = {"F", "F#", "G", "G#", "A", "A#", "B", "C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B", "C", "C#", "D", "D#", "E"};
			rData = relevantData;
			
//			if (fret <= 1 && fret >= 7) {
//				octave = 4;
//				n.getPitch().setOctave(octave);
//			}
//			
//			else if (fret<= 8 && fret >= 19) {
//				octave = 5;
//				n.getPitch().setOctave(octave);
//			}
//			else if(fret<= 20 && fret >= 24) {
//				octave = 6;
//				n.getPitch().setOctave(octave);
//			}
			
			}else if (n.getPitch().getStep() == "B") {
				
			String[] relevantData = {"C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B", "C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B"};
			rData = relevantData;	
			
			}else if(n.getPitch().getStep() == "G") {
				
			String[] relevantData = {"G#", "A", "A#", "B", "C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B", "C", "C#", "D", "D#", "E", "F", "F#", "G"};
			rData = relevantData;	
			
			}else if(n.getPitch().getStep() == "D") {
				
			String[] relevantData = {"D#", "E", "F", "F#", "G", "G#", "A", "A#", "B", "C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B", "C", "C#", "D"};
			rData = relevantData;	
			
			}else if(n.getPitch().getStep() == "A") {
				
			String[] relevantData = {"A#", "B", "C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B", "C", "C#", "D", "D#", "E","F", "F#", "G", "G#", "A"};
			rData = relevantData;	
			
			}
			
						
			String actualStep = rData[fret-1];
			
			String bStep = actualStep;
			
			char cStep = bStep.charAt(0);
			
			String aStep = String.valueOf(cStep);
			
			
			if (aStep.length() == 0){
				n.getPitch().setStep(aStep);
			}
			else {
				n.getPitch().setAlter(1);
				n.getPitch().setStep(aStep);
				
			}
			
			int octaveCounter = n.getPitch().getOctave();
			for(int i = 0; i < rData.length; i++) {
				if (rData[i] == "C") octaveCounter++;
				char c = rData[i].charAt(0);
				String d = String.valueOf(c);
				if (d == n.getPitch().getStep() &&  fret == i+1)
					n.getPitch().setOctave(octaveCounter);
			}
			
//			if (defaultStep > aStep[0])
//				n.getPitch().setOctave(n.getPitch().getOctave()+1);
			
			return n;
			
		}
		
	

}
