package tab2mxl;

public class DrumsID {

	public String instrumentID(char [][] array) {
		String instID = " ";
		
		for (int i = 0; i<array.length; i++)
			for(int j = 0; j < array[i].length; j++) {
				char d = array [j][i];
				String c = Character.toString(d);
				if (c == "CC || C"){
					instID = "P1-I50";
				}else if(c == "R || Rd") {
					instID = "P1-I52";
				}else if(c == "HH || H") {
					instID = "P1-I43";
				}else if(c == "SD || S") {
					instID = "P1-I39";
				}else if (c == "HT") {
					instID = "P1-I51";
				}else if(c == "MT") {
					instID = "P1-I49";
				}else if (c == "T") {
					instID = "P1-I48";
				}else if (c == "BD || B") {
					instID = "P1-I36";
				}

			}
		return instID;
	}




}