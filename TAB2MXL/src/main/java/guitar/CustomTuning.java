package guitar;

import java.util.HashMap;
import java.util.Map;

public class CustomTuning {
	Map<Integer,Pitch> tuning = new HashMap<Integer, Pitch>();

	public CustomTuning(Map<Integer, Pitch> tuning) {
		super();
		this.tuning = tuning;
	}

	public Map<Integer, Pitch> getTuning() {
		return tuning;
	}

	public void setTuning(Map<Integer, Pitch> tuning) {
		this.tuning = tuning;
	}

}
