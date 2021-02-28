package tab2mxl;

public class DrumsID {

	public String instrumentID(char [][] array) {
		String instID = " ";
		
		for (int i = 0; i<array.length; i++)
			for(int j = 0; j < 1; j++) {
				char d = array [i][j];
				String c = Character.toString(d);
				if (c == "C"){
					instID = "P1-I50";
				}else if(c == "R") {
					instID = "P1-I52";
				}else if(c == "H") {
					char e = array [i][2];
					String f = Character.toString(e);
					if(f == "T") {
						instID = "P1-I51";
					}else {
					instID = "P1-I43";}
				}else if(c == "S") {
					instID = "P1-I39";
				}else if(c == "M") {
					instID = "P1-I49";
				}else if (c == "T") {
					instID = "P1-I48";
				}else if (c == "B") {
					instID = "P1-I36";
				}

			}
		return instID;
	}
	





}