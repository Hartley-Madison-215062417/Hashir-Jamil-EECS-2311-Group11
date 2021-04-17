package guitar;


import java.util.Map;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name ="note")
@XmlAccessorType(XmlAccessType.NONE)
@XmlType(propOrder= {"chord","grace","pitch","duration","voice","type","notations"})

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
	

	@XmlElement
	Grace grace;
	
	
	public Chord getChord() {
		return chord;
	}

	public void setChord(Chord chord) {
		this.chord = chord;
	}
	
	public Note() {
		super();
		this.type = "eighth";
	}
	
	public Note(Pitch pitch, int duration,String type, Notations notations) {
		super();
		this.pitch = pitch;
		this.duration = duration;
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
	
	public Grace getGrace() {
		return grace;
	}

	public void setGrace(Grace grace) {
		this.grace = grace;
	}

//	public void setVoice(int voice) {
//		this.voice = voice;
//	}
//	
	public static void setDefaultStep(Note n) {

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
	
	public static void setDefaultStep(Note n, Measure m) {
		int string = n.getNotations().getTechnical().getString();		
		
		if(string == 1) {
			n.getPitch().setStep(m.getAttributes().getSd().getS1().getTuningStep());
			n.getPitch().setOctave(4);
		}
		else if(string == 2) {
			n.getPitch().setStep(m.getAttributes().getSd().getS2().getTuningStep());
			n.getPitch().setOctave(3);
		}
		else if(string == 3) {
			n.getPitch().setStep(m.getAttributes().getSd().getS3().getTuningStep());
			n.getPitch().setOctave(3);
		}
		else if(string == 4) {
			n.getPitch().setStep(m.getAttributes().getSd().getS4().getTuningStep());
			n.getPitch().setOctave(3);
		}
		else if(string == 5) {
			n.getPitch().setStep(m.getAttributes().getSd().getS5().getTuningStep());
			n.getPitch().setOctave(2);
			
		}
		else if(string == 6) {
			n.getPitch().setStep(m.getAttributes().getSd().getS6().getTuningStep());
			n.getPitch().setOctave(2);
		}
		
	}
	
		/*
		 * Updated the pitch of a given note based on fret number
		 * @para n note whose pitch needs to be updated
		 * @return note whose pitch has been updated 
		 * @pre only called if fret number is 0
		 */
		public Note updatePitch(Note n) {
			int octave; //an integer number 
			
			int fret = n.getNotations().getTechnical().getFret(); // fret has already been stored while parsing the 2D char array
			
			
			String defaultStep = n.getPitch().getStep(); // the step was set to what it would be if fret is 0 
			
			//String[] rData = new String[24]; // to store the sequence of steps
			
			/*finding the relevantData*/
			
			// define an array of string with relevant data 
			String[] allStep = {"C","C#","D","D#","E","F","F#","G","G#","A","A#","B"};
			
			int location = 0;
			
			for(int i = 0; i < allStep.length; i++) {
				if(allStep[i].equals(defaultStep)) {
					location = i + 1;
					break;
				}
			}
			
			String[] relevantData = new String[24];
			int k = 0;
			

//			System.out.println("length of allStep" + allStep.length);

			//System.out.println("length of allStep" + allStep.length);

			
			
			for (int i = location; i <= allStep.length; i++) {
				
				
//				System.out.println("The value of i is:" + i);
				
				if(i == allStep.length) {
					//System.out.println("again");
					i = 0;
					relevantData[k] = allStep[0];
					k++;
				}else {

					//System.out.println("The value of i now: " + i);
					//System.out.println("The value of k now: " + k);
					//System.out.println("Copying and pasting: " + allStep[i]);

					relevantData[k] = allStep[i];
					if(k == 23)
						break;
					else 
						k++;
				}
				
				
			}
			
			/*Setting the Step*/
						
			String actualStep = relevantData[fret-1]; // the actual step should be within the array 
			
			char cStep = actualStep.charAt(0); // steps can contain 2 chars, for example C#, here the step will be C
			
			String aStep = String.valueOf(cStep); // converting from char to string
			
			
			if (actualStep.length() == 1) // if the actual step is not a #
				n.getPitch().setStep(aStep);
			
			
			else { // if the actual step is a #
				n.getPitch().setAlter("1"); // sharps have alter of positive 1
				n.getPitch().setStep(aStep); // step will just be the char 
			}
			
			/*Setting the Octave*/
			
			int octaveCounter = n.getPitch().getOctave(); //getting the default pitch that we set 
			
			for(int i = 0; i < relevantData.length; i++) { // going through the relevant data
				if (relevantData[i] == "C") octaveCounter++; // if we reach a C, the octave increases 
				char c = relevantData[i].charAt(0);// getting the pitch step 
				String d = String.valueOf(c);
				if (d == n.getPitch().getStep() &&  fret == i+1) 
					n.getPitch().setOctave(octaveCounter);
			}
			
			
			return n;
			
		}
		
		public static void updateType(Note n, Map<String, Integer> typeTable) {
//			System.out.println("updating type");
//			System.out.println("step: " + n.getPitch().getStep());
//			System.out.println("octave: " + n.getPitch().getOctave());
			for(Map.Entry<String, Integer> entry: typeTable.entrySet()) {
				if(n.getDuration() == entry.getValue()) {
					System.out.println("The type is: " + entry.getKey());
					n.setType(entry.getKey());
				}
			}
		}
		
	

}
