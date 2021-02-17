package tab2mxl;

public class Note {


	private Pitch pitch;
	private int duration;
	private int voice;
	//private String type;
	private Notation notation;

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
	public int getVoice() {
		return voice;
	}
	public void setVoice(int voice) {
		this.voice = voice;
	}
	/*
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}*/
	public Notation getNotation() {
		return notation;
	}
	public void setNotation(Notation notations) {
		this.notation = notations;
	}
	
	
}
